// src/components/InfiniteFeed/InfiniteFeed.tsx
import React, { useEffect, useRef, useState } from "react";
import { Collapse, Button, Card, CardBody, CardTitle, CardSubtitle, CardText } from "reactstrap";

import "./InfiniteFeed.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";

interface Comment {
  commentId: number;
  text: string;
  username: string;
  commentedAt: string;
}

interface FeedPost {
  postId: number;
  content: string;
  imageUrl: string;
  category: string;
  createdAt: string;
  authorUsername: string;
  likesCount: number;
  comments: Comment[];
  userId: number;
}

export default function InfiniteFeed() {
  const [posts, setPosts] = useState<FeedPost[]>([]);
  const [interests, setInterests] = useState<string[]>([]);
  const [commentInputs, setCommentInputs] = useState<Record<number, string>>(
    {}
  );
  const loader = useRef<HTMLDivElement>(null);
  const username = localStorage.getItem("username")!;
  const [userId,setUserID] = useState<any>();
  const [openComments, setOpenComments] = useState<Record<number, boolean>>({});
  const navigate = useNavigate(); // ✅ Now inside the component
  
  // 1) Fetch user interests
  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/users/${username}`)
      .then((res) => {
        setInterests(res.data.interests || []);
        console.log(res.data);
        setUserID(res.data.id);
        console.log(res.data.id);
      })
      .catch(console.error);
  }, [username]);

  // 2) Load posts by category (infinite scroll)
  const loadMore = async () => {
    for (const category of interests) {
      try {
        const res = await axios.get<FeedPost[]>(
          `http://localhost:8080/api/posts/category/${category}/feed`
        );
        setPosts((prev) => [...prev, ...res.data]);
        console.log(posts);
      } catch (err) {
        console.error("Failed to load posts for", category, err);
      }
    }
  };

  useEffect(() => {
    if (!interests.length) return;
    loadMore();
    const obs = new IntersectionObserver(
      (entries) => {
        if (entries[0].isIntersecting) loadMore();
      },
      { rootMargin: "100px" }
    );
    if (loader.current) obs.observe(loader.current);
    return () => obs.disconnect();
  }, [interests]);

  // 3) Handle like
  const handleLike = async (postId: number) => {
    
    try {
      await axios.post(`http://localhost:8080/api/like/${userId}/${postId}`);
      setPosts(
        posts.map((p) =>
          p.postId === postId ? { ...p, likesCount: p.likesCount + 1 } : p
        )
      );
    } catch (err) {
      console.error("Failed to like post", postId, err);
    }
  };

  // 4) Handle add comment
  const handleAddComment = async (postId: number) => {
    const text = commentInputs[postId]?.trim();
    if (!text) return;
    try {
      const res = await axios.post<Comment>(
        `http://localhost:8080/api/comments/${postId}/${userId}`,
        { comment: text }
      );
      setPosts(
        posts.map((p) =>
          p.postId === postId
            ? { ...p, comments: [...p.comments, res.data] }
            : p
        )
      );
      setCommentInputs({ ...commentInputs, [postId]: "" });
    } catch (err) {
      console.error("Failed to add comment", postId, err);
    }
  };

  const toggleComments = (postId: number) => {
    setOpenComments((prev) => ({
      ...prev,
      [postId]: !prev[postId],
    }));
  };

 
  const handlePostProfile= async (post: FeedPost)=>{
    
    const res= await axios.get(`http://localhost:8080/api/users/userId/${post.userId}`);
    console.log(res);
    navigate(`/OtherUserprofile/${res.data.username}`);
  }
    
  

return (
  <section className="feed-section">
    <div className="feeds d-flex flex-wrap justify-content-center gap-4">
      {posts.map((post) => (
        <Card
          key={post.postId}
          style={{ width: "40rem", boxShadow: "0 4px 10px rgba(0,0,0,0.1)" }}
        >
          <img
            alt={post.content}
            src={post.imageUrl}
            style={{ height: "350px", objectFit: "cover" }}
            onClick={()=>handlePostProfile(post)}
          />
          <CardBody>
            {/* <CardTitle tag="h5">{{('http://localhost:8080/api/users/${post.userId}').data.username} || "Anonymous"}</CardTitle>
            <CardSubtitle className="mb-2 text-muted" tag="h6">
              Post ID: {post.postId}
            </CardSubtitle> */}
            <CardText>{post.content}</CardText>
            <div className="reactions d-flex justify-content-between">
              <Button color="warning" onClick={() => handleLike(post.postId)}>
                ❤️ {post.likesCount}
              </Button>
              <Button
                color="primary"
                onClick={() => toggleComments(post.postId)}
              >
                💬 {post.comments.length}
              </Button>
            </div>

            <Collapse isOpen={openComments[post.postId] || false}>
              <Card className="comment-card mt-3">
                <CardBody>
                  <div className="comment-list">
                    {post.comments.map((c) => (
                      <div className="comment mb-1" key={c.commentId}>
                        <span>@{c.username}</span><text> __</text> {c.text}
                      </div>
                    ))}
                  </div>
                  <div className="add-comment mt-2 d-flex">
                    <input
                      type="text"
                      className="form-control me-2"
                      placeholder="Write a comment..."
                      value={commentInputs[post.postId] || ""}
                      onChange={(e) =>
                        setCommentInputs({
                          ...commentInputs,
                          [post.postId]: e.target.value,
                        })
                      }
                      onKeyDown={(e) =>
                        e.key === "Enter" && handleAddComment(post.postId)
                      }
                    />
                    <Button
                      color="primary"
                      onClick={() => handleAddComment(post.postId)}
                    >
                      Post
                    </Button>
                  </div>
                </CardBody>
              </Card>
            </Collapse>
          </CardBody>
        </Card>
      ))}
      <div ref={loader} className="loading text-muted">
        Loading…
      </div>
    </div>
  </section>
);
}
