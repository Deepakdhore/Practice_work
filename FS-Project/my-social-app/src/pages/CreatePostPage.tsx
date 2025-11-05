// src/pages/CreatePostPage.tsx
import PostCreation from '../components/PostCreation/PostCreation';
import { useNavigate } from 'react-router-dom';

export default function CreatePostPage() {
  const nav = useNavigate();
  return (
    <div>
      <button onClick={() => nav(-1)}>← Back</button>
      <PostCreation />
    </div>
  );
}
