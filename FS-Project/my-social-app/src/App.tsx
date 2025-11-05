// src/App.tsx
import { Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage';
import CreatePostPage from './pages/CreatePostPage';
import LoginPage from './pages/LoginPage';
import ProfilePage from './pages/ProfilePage';
import RegisterPage from './pages/RegisterPage';
import MediaManager from './pages/MedaiManager';
import OtherProfilePage  from './pages/OtherProfilePage';
export default function App() {
  
  return (
    <Routes>
      <Route path="/" element={<RegisterPage/>}/>
      <Route path="/login" element={<LoginPage />} />
      <Route path="/home" element={<HomePage />} />
      <Route path="/create-post" element={<CreatePostPage />} />
      <Route path="/profile/:username" element={<ProfilePage/>} />
      <Route path="/upload" element={<MediaManager/>}/>
      <Route path="/OtherUserProfile/:username" element={<OtherProfilePage/>}/>
    </Routes>
  );
}
