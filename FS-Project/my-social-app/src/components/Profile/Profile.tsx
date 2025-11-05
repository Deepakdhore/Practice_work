import React, { useEffect, useState } from "react";
import "./Profile.css";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import Toast from "../Toast/Toast";
import MediaManager2 from "../MediaManager/MediaManager2";
import {
  Card,
  CardBody,
  CardGroup,
  CardImg,
  CardSubtitle,
  CardText,
  CardTitle,
} from "reactstrap";

interface PostDTO {
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
interface Comment {
  commentId: number;
  text: string;
  username: string;
  commentedAt: string;
}

export const Profile: React.FC = () => {
  const { username } = useParams<{ username: string }>();
  const navigate = useNavigate();
  const [user, setUser] = useState<any>(null);
  const [posts, setPosts] = useState<PostDTO[]>([]);
  const [imageUrl, setImageUrl] = useState("");
  const [postImageUrl, setPostImageUrl] = useState("");
  const [bio, setBio] = useState("");
  const [editing, setEditing] = useState(false);
  const [file, setFile] = useState<File | null>(null);
  const [preview, setPreview] = useState<string | null>(null);
  const [selectedPost, setSelectedPost] = useState<PostDTO>();
  const [showModal, setShowModal] = useState(false);

  useEffect(() => {
    const fetchUserAndMedia = async () => {
      try {
        const userRes = await axios.get(
          `http://localhost:8080/api/users/${username}`
        );
        const userData = userRes.data;
        const postRes = await axios.get(
          `http://localhost:8080/api/posts/user/${username}`
        );
        const postData = postRes.data;

        if (postData) {
          setPosts(postData);
          console.log();
          console.log(postData);
        }
        if (userData) {
          console.log("userdata");
          console.log(userData);
        }
        setUser(userData);
        //setPostImageUrl(postData[])
        setBio(userData.bio || "");

        if (userData.profileImageUrl) {
          Toast.info("adding profile image");
          setImageUrl(userData.profileImageUrl);
          console.log("this is profileimage url" + userData.profileImageUrl);
        } else {
          Toast.info("failed t fetch profile image , set new image");
        }
        Toast.success("User loaded" + userData.bio);
      } catch (error) {
        Toast.error("Error loading user" + error);
        console.error(error);
      }
    };

    if (username) fetchUserAndMedia();
  }, [username]);

  // const handleImageClick = (post: any) => {
  //   setSelectedPost(post);
  //   setShowModal(true);
  // };

  // const handleCloseModal = () => {
  //   setShowModal(false);
  //   setSelectedPost(null);
  // };

  const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const f = e.target.files?.[0];
    if (f) {
      setFile(f);
      setPreview(URL.createObjectURL(f)); // optionally show preview
      console.log("preview profile" + f);
    }
  };

  const handleUploadClick = async () => {
    if (!file) {
      Toast.info("file");
      return;
    }
    const formData = new FormData();
    formData.append("file", file);
    console.log(formData);
    console.log(user);
    const uploadedUrl = await MediaManager2({
      formData,
      type: "profile",
      userData: user,
    });
    if (uploadedUrl) {
      setImageUrl(uploadedUrl);
      Toast.success("profile uploaded");
      const userUpdate = await axios.put(
        `http://localhost:8080/api/users/${user.username}/profileImage`,
        { profileImageUrl: uploadedUrl }
      );
      if (userUpdate) {
        console.log("succsess user updated ");
        Toast.success("USER UPDATED");
      } else {
        console.log("Error" + uploadedUrl);
        Toast.error("User not updated");
      }
    } else {
      setImageUrl("");
      setPreview(null);
      Toast.error("did not recive url");
    }
  };

  const handleBioSave = async () => {
    try {
      const res = await axios.put(
        `http://localhost:8080/api/users/${username}/bio`,
        {
          bio,
        }
      );
      Toast.success("Bio updated" + res);
      setBio(res.data);
      console.log(res.toString);
      setEditing(false);
    } catch (err) {
      console.error(err);
      Toast.error("Failed to update bio");
    }
  };

  return (
    <div className="profile-page-wrapper">
      <div className="profile-header">
        <div className="banner">
          <div className="right">
            <div className="avatar-circle">
              <label htmlFor="profile-image-upload">
                <img src={preview || imageUrl} className="preview" alt="➕" />
              </label>
              <input
                id="profile-image-upload"
                type="file"
                accept="image/*"
                hidden
                onChange={handleFileChange} // correct
              />
            </div>

            <div className="upload-profile">
              <button className="upload-button" onClick={handleUploadClick}>
                Upload
              </button>
            </div>
          </div>

          {/* ✅ Bio Section */}
          <div className="bio-text">
            {editing ? (
              <>
                <textarea
                  value={bio}
                  onChange={(e) => setBio(e.target.value)}
                />
                <button onClick={handleBioSave}>✅</button>
              </>
            ) : (
              <>
                <p>{bio || "No bio added yet."}</p>
                <button onClick={() => setEditing(true)}>✒️</button>
              </>
            )}
          </div>
        </div>
      </div>

      {/* Bottom Section */}
      <div className="bottomPanel">
        <div className="profile-sidebar">
          <button onClick={() => navigate("/create-post")}>➕</button>
          <button onClick={() => navigate("/home")}>🏠</button>
        </div>

        <div className="card-group-wrapper">
          {posts.map((post, i) => (
            <Card
              key={post.postId || i}
              className="post-card"
              onClick={() => setSelectedPost(post)}
            >
              <CardImg
                alt={`Post ${i}`}
                src={post.imageUrl}
                top
                width="100%"
                className="post-card-img"
              />
              <CardBody>
                <CardTitle tag="h5">{"post Title"}</CardTitle>
                <CardSubtitle className="mb-2 text-muted" tag="h6">
                  {"Post Topic"}
                </CardSubtitle>
                <CardText className="truncate-text">{post.content}</CardText>
              </CardBody>
            </Card>
          ))}
        </div>

        {selectedPost && (
  <div className="modal-overlay" onClick={() => setSelectedPost(null)}>
    <div className="modal-card" onClick={(e) => e.stopPropagation()}>
      <Card className="selected-post-card">
        <CardImg
          alt="Selected Post"
          src={selectedPost.imageUrl}
          top
          className="modal-image"
        />
        <CardBody className="selected-post-body">
          <CardTitle tag="h5" className="modal-post-title">Post</CardTitle>
          <CardSubtitle className="text-muted modal-category" tag="h6">
            #{selectedPost.category}
          </CardSubtitle>
          <CardText className="modal-content-text">
            {selectedPost.content}
          </CardText>

          <div className="comment-section">
            <h6 className="comment-heading">Comments</h6>
            <div className="comment-body-scrollable">
              {selectedPost.comments.map((c) => (
                <div className="comment" key={c.commentId}>
                  <CardText>
                    <span>@{c.username}</span> {c.text}
                  </CardText>
                </div>
              ))}
            </div>
          </div>
        </CardBody>
      </Card>
    </div>
  </div>
)}

      </div>
    </div>
  );
};
