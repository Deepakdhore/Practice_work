// src/pages/RegisterPage.tsx
import React, { useState } from "react";
import axios from "axios";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";
import "./RegisterForm.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Button, Form, FormGroup, Input, Label } from "reactstrap";

const RegisterPage: React.FC = () => {
  const [username, setUsername] = useState("");
  const [fullName, setFullName] = useState("");
  const [bio, setBio] = useState("");
  const [interests, setInterests] = useState<string[]>([]);
  const navigate = useNavigate();

  // ✅ Handle checkbox selection
  const handleInterestChange = (interest: string) => {
    setInterests((prev) =>
      prev.includes(interest)
        ? prev.filter((i) => i !== interest)
        : [...prev, interest]
    );
  };

  const handleRegister = async () => {
    if (!username.trim()) {
      toast.warn("Username is required");
      return;
    }
    if (!fullName.trim()) {
      toast.warn("Full name is required");
      return;
    }

    try {
      await axios.post("http://localhost:8080/api/users", {
        username,
        fullName,
        bio,
        profileImageUrl: "",
        interests,
      });
      toast.info(username+" "+fullName+" "+bio+" "+interests);
      toast.success("Registration successful!");
      navigate("/login");
    } catch (err: any) {
      if (err.response?.status === 409) {
        toast.error("Username already exists. Try logging in.");
        navigate("/login");
      } else {
        toast.error("Something went wrong. Please try again.");
        console.error(err);
      }
    }
  };

  function handleLogin(event: MouseEvent<HTMLButtonElement, MouseEvent>): void {
    navigate("/login");
  }

  return (
    <div className="register-page">
      <h2>-------Register-------</h2>

      <Form className="newForm">
        <FormGroup>
          <Label for="username">Username</Label>
          <Input
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            placeholder="Enter a unique username"
            type="text"
          />
        </FormGroup>

        <FormGroup>
          <Label for="fullName">Full Name</Label>
          <Input
            id="fullName"
            value={fullName}
            onChange={(e) => setFullName(e.target.value)}
            placeholder="Enter your full name"
            type="text"
          />
        </FormGroup>

        <FormGroup className="interestsFormGroup">
          <Label>Select Interests :</Label>
          <FormGroup check inline>
            <Input
              type="checkbox"
              value="Music"
              checked={interests.includes("Music")}
              onChange={() => handleInterestChange("Music")}
            />
            <Label check>Music</Label>
          </FormGroup>

          <FormGroup check inline>
            <Input
              type="checkbox"
              value="Sports"
              checked={interests.includes("Sports")}
              onChange={() => handleInterestChange("Sports")}
            />
            <Label check>Sports</Label>
          </FormGroup>

          <FormGroup check inline>
            <Input
              type="checkbox"
              value="Tech"
              checked={interests.includes("Tech")}
              onChange={() => handleInterestChange("Tech")}
            />
            <Label check>Tech</Label>
          </FormGroup>

          <FormGroup check inline>
            <Input
              type="checkbox"
              value="Editing"
              checked={interests.includes("Editing")}
              onChange={() => handleInterestChange("Editing")}
            />
            <Label check>Editing</Label>
          </FormGroup>
           <FormGroup check inline>
            <Input
              type="checkbox"
              value="Meme"
              checked={interests.includes("Meme")}
              onChange={() => handleInterestChange("Meme")}
            />
            <Label check>Meme</Label>
          </FormGroup>
        </FormGroup>

        <FormGroup>
          <Label for="bio">Bio (optional)</Label>
          <Input
            id="bio"
            type="textarea"
            value={bio}
            onChange={(e) => setBio(e.target.value)}
            placeholder="I am a singer, sportsman, or developer"
          />
        </FormGroup>

        <FormGroup>
          <Label for="profileImage">Profile Image (not implemented)</Label>
          <Input id="profileImage" name="file" type="file" disabled />
        </FormGroup>

        <Button onClick={handleRegister}>Register</Button>
        <Button onClick={handleLogin}>Login</Button>
      </Form>
    </div>
  );
};

export default RegisterPage;
