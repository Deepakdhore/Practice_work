import React, { useRef, useEffect, useState } from "react";
import {
  Stage,
  Layer,
  Circle,
  Rect,
  RegularPolygon,
  Star as StarShape,
  Transformer,
} from "react-konva";

function Shapes({ shapes, setShapes }) {
  const [selectedId, setSelectedId] = useState(null);
  const trRef = useRef();
  const shapeRefs = useRef({}); // store refs for all shapes

  useEffect(() => {
    const transformer = trRef.current;
    if (!transformer) return;

    const selectedNode = shapeRefs.current[selectedId];
    if (selectedNode) {
      transformer.nodes([selectedNode]);
      transformer.getLayer().batchDraw();
    } else {
      transformer.nodes([]);
      transformer.getLayer().batchDraw();
    }
  }, [selectedId, shapes]);

  const handleDragEnd = (id, e) => {
    const updated = shapes.map((shape) =>
      shape.id === id
        ? { ...shape, x: e.target.x(), y: e.target.y() }
        : shape
    );
    setShapes(updated);
  };

  return (
    <Stage
      width={window.innerWidth}
      height={window.innerHeight - 200}
      style={{ background: "#f5f5f5" }}
      onMouseDown={(e) => {
        // Deselect when clicking empty space
        if (e.target === e.target.getStage()) {
          setSelectedId(null);
        }
      }}
    >
      <Layer>
        {shapes.map((shape) => {
          const commonProps = {
            key: shape.id,
            id: shape.id,
            x: shape.x,
            y: shape.y,
            fill:"green",
            
            draggable: true,
            onClick: () => setSelectedId(shape.id),
            onTap: () => setSelectedId(shape.id),
            onDragEnd: (e) => handleDragEnd(shape.id, e),
            ref: (node) => (shapeRefs.current[shape.id] = node),
          };

          switch (shape.type) {
            case "circle":
              return <Circle {...commonProps} radius={50}  />;
            case "rectangle":
              return (
                
                <Rect
                  {...commonProps}
                  width={120}
                  height={60}
                  offsetX={60}
                  offsetY={30}
                />
              );
            case "square":
              return (
                <Rect
                  {...commonProps}
                  width={100}
                  height={100}
                  offsetX={50}
                  offsetY={50}
                />
              );
            case "triangle":
              return (
                <RegularPolygon
                  {...commonProps}
                  sides={3}
                  radius={60}
                 
                />
              );
            case "pentagon":
              return (
                <RegularPolygon
                  {...commonProps}
                  sides={5}
                  radius={60}
                 
                />
              );
            case "star":
              return (
                <StarShape
                  {...commonProps}
                  numPoints={5}
                  innerRadius={40}
                  outerRadius={60}
                  
                />
              );
            default:
              return null;
          }
        })}
        {/* ✅ Transformer attaches dynamically */}
        <Transformer
          ref={trRef}
          rotateEnabled={true}
          resizeEnabled={true}
          enabledAnchors={[
            "top-left",
            "top-right",
            "bottom-left",
            "bottom-right",
          ]}
          anchorSize={8}
          borderStroke="blue"
        />
      </Layer>
    </Stage>
  );
}

export default Shapes;
