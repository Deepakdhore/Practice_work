// src/components/Toast/Toast.ts
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const Toast = {
  success: (message: string) => {
    toast.success(message, {
      position: "top-right",
      autoClose: 1000,
      pauseOnHover: true,
      draggable: true,
    });
  },
  error: (message: string, p0: { username: any; }) => {
    toast.error(message, {
      position: "top-right",
      autoClose: 1000,
      pauseOnHover: true,
      draggable: true,
    });
  },
  info: (message: string) => {
    toast.info(message, {
      position: "top-right",
      autoClose: 1000,
      pauseOnHover: true,
      draggable: true,
    });
  },
  warning: (message: string) => {
    toast.warning(message, {
      position: "top-right",
      autoClose: 1000,
      pauseOnHover: true,
      draggable: true,
    });
  },
};

export default Toast;
