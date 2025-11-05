import React, { useEffect, useState } from "react";
import SockJS from "sockjs-client";
import { Client, over } from "stompjs";

interface NotificationMessage {
  receiverName: string;
  senderName: string;
  message: string;
  type: string;
  timestamp: string;
}

let stompClient: Client | null = null;

const Notification: React.FC = () => {
  const [notifications, setNotifications] = useState<NotificationMessage[]>([]);

  useEffect(() => {
    const userId = localStorage.getItem("userId"); // Or sessionStorage

    if (!userId) return;

    const socket = new SockJS("http://localhost:8080/ws");
    stompClient = over(socket);

    stompClient.connect({}, () => {
      stompClient?.subscribe(`/topic/notify/${userId}`, (message) => {
        const newNotification: NotificationMessage = JSON.parse(message.body);
        setNotifications((prev) => [newNotification, ...prev]);
      });
    });

    return () => {
      stompClient?.disconnect(() => {
        console.log("Disconnected from WebSocket");
      });
    };
  }, []);

  return (
    <div>
      <h3>Notifications</h3>
      <ul>
        {notifications.map((n, idx) => (
          <li key={idx}>
            <strong>{n.senderName}</strong>: {n.message} <em>({n.type})</em><br />
            <small>{new Date(n.timestamp).toLocaleString()}</small>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Notification;
