import React, { useEffect, useState } from "react";
import "./ShapePicker.css";
import {
  Circle as CircleIcon,
  Pentagon,
  RectangleHorizontal,
  Square,
  Star,
  Triangle,
} from "lucide-react";
import { toast } from "react-toastify";
import Shapes from "../shapes/Shapes";

function ShapePicker() {
  const [shapes, setShapes] = useState([]); // Store all drawn shapes

  const addShape = (type) => {
    const newShape = {
      id: Date.now(), // unique id for each shape
      type,
      x: window.innerWidth / 2,
      y: window.innerHeight / 2,
    };
    setShapes((prev) => [...prev, newShape]);
    toast(`Added ${type}`);
  };

  useEffect(() => {
    console.log("Current shapes:", shapes);
  }, [shapes]);

  return (
    <div>
      <div className="Frame">
        <div className="circle" onClick={() => addShape("circle")}>
          <CircleIcon />
        </div>
        <div className="square" onClick={() => addShape("square")}>
          <Square />
        </div>
        <div className="triangle" onClick={() => addShape("triangle")}>
          <Triangle />
        </div>
        <div className="pentagon" onClick={() => addShape("pentagon")}>
          <Pentagon />
        </div>
        <div className="rectangle" onClick={() => addShape("rectangle")}>
          <RectangleHorizontal />
        </div>
        <div className="star" onClick={() => addShape("star")}>
          <Star />
        </div>
      </div>

      {/* Pass all shapes to the canvas */}
      <Shapes shapes={shapes} setShapes={setShapes} />
    </div>
  );
}

export default ShapePicker;
