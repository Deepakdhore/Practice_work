// src/components/LeftPanel/LeftPanel.tsx
import React, { useEffect, useState } from 'react';
import './LeftPanel.css';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Toast from '../Toast/Toast';

interface Props {
  onCreate: () => void;
}

const LeftPanel: React.FC<Props> = ({ onCreate }) => {
  const [imageUrl,setImageUrl] =useState("");
  const [user,setUser]=useState("");
  const navigate = useNavigate(); // ✅ Now inside the component
  const username = localStorage.getItem("username");

  const goToProfile = () => {
    if (username) {
      navigate(`/profile/${username}`);
    }
  };

  useEffect(()=>{
    const fetchUserAndMedia=async()=>{
      try{
        const userRes = await axios.get(
          `http://localhost:8080/api/users/${username}`
        );
        const userData = userRes.data;
        setUser(userData);
         if (userData.profileImageUrl) {
                  Toast.info("adding profile image");
                  setImageUrl(userData.profileImageUrl);
                  console.log("this is profileimage url"+user.profileImageUrl)
                } else {
                  Toast.info("failed t fetch profile image , set new image");
                }
   } catch (error) {
        Toast.error("Error loading user" + error);
        console.error(error);
      }
    };
    if(username) fetchUserAndMedia();
  },[username]);

  return (
    <section className="section-left">
      <div className="logo-section">
        <div className="profile-logo" onClick={goToProfile}>
          <img src={imageUrl} alt="😎" />
        </div>
      </div>
      <div className="nav-section">
        <div className="nav-bar">
          <div className="upload">
            <button className="post-button" onClick={onCreate}>➕</button>
          </div>
        </div>
      </div>
    </section>
  );
};

export default LeftPanel;
