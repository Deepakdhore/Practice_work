// src/components/NotificationPanel/NotificationPanel.tsx
import React from 'react';
import './NotificationPanel.css';
import NotificationClient from '../NotificationClient/NotificationClient';

export default function NotificationPanel() {
  return (
    <section className="section-right">
      <div className="notification-section">
        <div className="bell">
          <button>🔔</button>
        </div>
        <div className="notification">
         <NotificationClient></NotificationClient>
        </div>
      </div>
    </section>
  );
}
