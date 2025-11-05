// src/components/Login/Login.tsx
import React from 'react';
import './Login.css';

interface Props {
  username: string;
  setUsername: (value: string) => void;
  onLogin: () => void;
}

const Login: React.FC<Props> = ({ username, setUsername, onLogin }) => {
  return (
    <div className="login-container">
      <h2>Login</h2>
      <input
        type="text"
        placeholder="Enter your username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <button onClick={onLogin}>Login</button>
    </div>
  );
};

export default Login;
