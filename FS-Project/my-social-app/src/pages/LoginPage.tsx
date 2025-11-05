// src/pages/LoginPage.tsx
import { useState } from 'react';
import Login from '../components/Login/Login';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import axios from "axios";
import "../styles/LoginPAge.css"
export default function LoginPage() {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");

  const handleLogin = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/users/${username}`);
      const data = response.data;
      console.log("the response data")
      console.log(data);

      if (data && data.username) {
        localStorage.setItem("username", data.username);
        localStorage.setItem("userId", data.id);
        toast.success("Login Successful!");
        navigate("/home"); // go to HomePage
      } else {
        toast.error("User not found!");
      }
    } catch (error) {
      toast.error("Login failed. Please try again.");
      console.error(error);
    }
  };

  return (
    <div className="login-page">

      <Login
        username={username}
        setUsername={setUsername}
        onLogin={handleLogin}
      />
    </div>
  );
}
