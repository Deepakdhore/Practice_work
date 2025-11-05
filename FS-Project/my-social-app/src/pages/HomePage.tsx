// src/pages/HomePage.tsx
import LeftPanel from '../components/LeftPanel/LeftPanel';
import SearchBar from '../components/SearchBar/SearchBar';
import InfiniteFeed from '../components/InfiniteFeed/InfiniteFeed';
import NotificationPanel from '../components/NotificationPanel/NotificationPanel';
import { useNavigate } from 'react-router-dom';
import '../styles/HomePage.css'; 

export default function HomePage() {
  const nav = useNavigate();
  return (
    <div className="content">
      <LeftPanel onCreate={() => nav('/create-post')} />
      <section className="section-mid">
        <SearchBar />
        <InfiniteFeed />
      </section>
      <NotificationPanel />
    </div>
  );
}
