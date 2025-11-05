import React, { useEffect, useState } from "react";
import "./OtherUserProfile.css";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import Toast from "../Toast/Toast";
import MediaManager2 from "../MediaManager/MediaManager2";
import { Button, Card, CardBody, CardGroup, CardImg, CardSubtitle, CardText, CardTitle } from "reactstrap";

import { toast } from "react-toastify";
interface PostDTO {
  id: number;
  content: string;
  imageUrl: string;
  createdAt: string;
  username: string;
}
export const OtherUserProfile: React.FC = () => {
     const currUsername = localStorage.getItem("username");
  const { username } = useParams<{ username: string }>();
  const navigate = useNavigate();
  const [user, setUser] = useState<any>(null);
  const [currUser, setCurrUser] = useState<any>(null);
  const [posts, setPosts] = useState<PostDTO[]>([]);
  const [follow,setFollow] = useState(false);
  const [imageUrl, setImageUrl] = useState("");
  const [postImageUrl, setPostImageUrl] = useState("");
  const [bio, setBio] = useState("");
  const [editing, setEditing] = useState(false);
  const [file, setFile] = useState<File | null>(null);
  const [preview, setPreview] = useState<string | null>(null);
  const [selectedPost, setSelectedPost] = useState(null);
    
  useEffect(() => {
    const fetchUserAndMedia = async () => {
      try {
        const userRes = await axios.get(
          `http://localhost:8080/api/users/${username}`
        );
        const userData = userRes.data;
        const currUserRes = await axios.get(
          `http://localhost:8080/api/users/${currUsername}`
        );
        const currUserData = currUserRes.data;
        
        const postRes = await axios.get(
          `http://localhost:8080/api/posts/user/${username}`
        );
        const postData = postRes.data;

        setPosts(postData);
        setUser(userData);
        setCurrUser(currUserData);
        console.log(userData);
        console.log(username+"="+userData.id+" "+currUsername+"="+currUserData.id);
        console.log("Setting post data " + postData);
        //setPostImageUrl(postData[])
        setBio(userData.bio || "");

        if (userData.profileImageUrl) {
          Toast.info("adding profile image");
          setImageUrl(userData.profileImageUrl);
          console.log("this is profileimage url" + userData.profileImageUrl);
        } else {
            Toast.info("failed t fetch profile image , set new image");
        }
        Toast.success("User loaded" + userData.bio+"the current username: "+currUsername+"\n the Other Profile UserName: "+username);
      } catch (error) {
        Toast.error("Error loading user" + error);
        console.error(error);
      }
    };

    if (username) fetchUserAndMedia();
  }, [username]);

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

    // function handleFollowClick(event: MouseEvent<HTMLButtonElement, MouseEvent>): void {
    //     throw new Error("Function not implemented.");
    // }
    //    //  @PutMapping("/folllow/{followerUserId}/{userId}")
    const handleFollowClick = async () => {
        try {
            const res= await axios.put(`http://localhost:8080/api/users/folllow/${currUser.id}/${user.id}`);
            Toast.success("Successfully followed "+username);

        } catch (error) {
          console.log("unable to follow "+error);
          Toast.error("unable to follow ",error);  
        }
        
    }
        

  return (
    <div className="profile-page-wrapper">
      <div className="profile-header">
        <div className="banner">
          <div className="right">
            <div className="avatar-circle">
              <label htmlFor="profile-image-upload">
                <img src={preview || imageUrl} className="preview" alt="➕" />
              </label>
            </div>

            <div className="upload-profile">
              <label htmlFor="username">
                <p>{username}</p>
              </label>
              <Button className="Follow-button" onClick={handleFollowClick}>
                Follow
              </Button>
              <Button className="Unfollow-button" onClick={handleFollowClick}>
                Unfollow
              </Button>
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

        {/* <div className="profile-post-grid">
          {posts.map((post, i) => (
            <div className="post-holder" key={post.id || i}>
              <div className="postImage">
                <img src={post.imageUrl} alt={`Post ${i}`} />
              </div>
            </div>
          ))}
        </div> */}
         <div className="card-group-wrapper">
        {posts.map((post, i) => (
          <Card
            key={post.id || i}
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
              <CardText className="truncate-text">
                {post.content}
              </CardText>
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
               width="100%"
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
