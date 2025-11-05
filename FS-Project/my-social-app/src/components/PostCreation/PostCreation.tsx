// src/components/PostCreation/PostCreation.tsx
import React, { useEffect, useState } from "react";
import "./PostCreation.css";
import axios from "axios";
import Toast from "../Toast/Toast";
import { toast } from "react-toastify";
import MediaManager2 from "../MediaManager/MediaManager2";
import { useNavigate } from "react-router-dom";
import { FormGroup, Input, Label } from "reactstrap";

export default function PostCreation() {
  const [imageUrl, setImageUrl] = useState("");
  const [musicName, setMusicName] = useState("");
  const [filter, setFilter] = useState("none");
  const [description, setDescription] = useState("");
  const username = localStorage.getItem("username");
  const [user, setUser] = useState<any>(null);
  const [profileImageUrl, setProfileImageUrl] = useState("");
  const [file, setFile] = useState<File | null>(null);
  const [category, setCategory] = useState("");
  const navigate = useNavigate();

  /////////////////////////////////////laoding user data////////////////////////////////
  useEffect(() => {
    const fetchUserAndMedia = async () => {
      try {
        const userRes = await axios.get(
          `http://localhost:8080/api/users/${username}`
        );
        const userData = userRes.data;
        setUser(userData);
        setProfileImageUrl(userData.profileImageUrl);
        Toast.success("loaded user details");
      } catch (error) {
        Toast.error("error laoding user details" + error);
        console.log("error loading user data" + error);
      }
    };
    if (username) fetchUserAndMedia();
  }, [username]);

  /////////////////////////////////////laoding user data////////////////////////////////

  const handleImageUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];

    if (file) {
      setImageUrl(URL.createObjectURL(file));
      setFile(file);
    }
  };
  const handleAudioUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (file) setMusicName(file.name);
  };
  const applyFilter = (f: string) => setFilter(f);
  const resetPost = () => {
    setImageUrl("");
    setMusicName("");
    setDescription("");
    setFilter("none");
  };

  /////////////////////////////uploading media(post) ////////////////////

  const handlePostUploadClick = async () => {
    if (!file) {
      toast.info("select a file to upload");
      return;
    }
    const formData = new FormData();
    formData.append("content", description);
    formData.append("category", category);
    formData.append("mediaType", "Image");
    formData.append("file", file);
    console.log(formData);
    console.log(user);

     try {
    const response = await axios.post(
      `http://localhost:8080/api/posts/${username}/with-media`, // Replace with your actual gateway or service port
      formData,
      {
        headers: {
          "Content-Type": "multipart/form-data"
        }
      }
    );
    
    console.log("Post created:", response.data);
    toast.success("Post created")
    navigate(`/profile/${username}`);
  } catch (error) {
    console.error("Error creating post:", error);
    toast.error("Something went wrong check consle"+error);
  }
    
      
  };
  /////////////////////////////uploading media(post) ////////////////////

  return (
    <div className="page-wrapper">
      <div className="toolbar">
        <input
          type="file"
          id="audio-upload"
          accept="audio/*"
          onChange={handleAudioUpload}
          hidden
        />
        <label htmlFor="audio-upload" className="icon">
          🎵
        </label>
        <button className="icon" onClick={() => applyFilter("grayscale(100%)")}>
          🧪
        </button>
        <button className="icon" onClick={resetPost}>
          ❌
        </button>
      </div>

      <div className="upload-section">
        <div className="upload-card">
          <label htmlFor="image-upload">
            {imageUrl ? (
              <img src={imageUrl} className="preview" style={{ filter }} />
            ) : (
              <div className="upload-placeholder">
                <div className="plus">+</div>
                <div className="text">Upload Media</div>
              </div>
            )}
          </label>
          <input
            id="image-upload"
            type="file"
            accept="image/*"
            hidden
            onChange={handleImageUpload}
          />
        </div>
        <div className="catagory">
          <FormGroup tag="fieldset">
            <legend>Select post Category</legend>
            <div className="radioInputForm">
              <FormGroup check>
                <Input
                  name="category"
                  type="radio"
                  value="sports"
                  checked={category === "sports"}
                  onChange={(e) => setCategory(e.target.value)}
                />
                <Label check>Sports</Label>
              </FormGroup>
              <FormGroup check>
                <Input
                  name="category"
                  type="radio"
                  value="editing"
                  checked={category === "editing"}
                  onChange={(e) => setCategory(e.target.value)}
                />
                <Label check>Editing</Label>
              </FormGroup>
              <FormGroup check>
                <Input
                  name="category"
                  type="radio"
                  value="music"
                  checked={category === "music"}
                  onChange={(e) => setCategory(e.target.value)}
                />
                <Label check>Music</Label>
              </FormGroup>
              <FormGroup check>
                <Input
                  name="category"
                  type="radio"
                  value="tech"
                  checked={category === "tech"}
                  onChange={(e) => setCategory(e.target.value)}
                />
                <Label check>Tech</Label>
              </FormGroup>
              <FormGroup check>
                <Input
                  name="category"
                  type="radio"
                  value="meme"
                  checked={category === "meme"}
                  onChange={(e) => setCategory(e.target.value)}
                />
                <Label check>Meme</Label>
              </FormGroup>
            </div>
          </FormGroup>
        </div>
        <div className="description-card">
          <textarea
            placeholder="Description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
        </div>

        <div className="submit-button">
          <button
            className="post-button"
            type="button"
            onClick={handlePostUploadClick}
          >
            Post!!
          </button>
        </div>
      </div>

      {musicName && <p className="music-info">🎵 {musicName}</p>}
    </div>
  );
}
