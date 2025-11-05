import React, { useEffect, useRef } from 'react'
import ReactFlow, {
  useNodesState,
  useEdgesState,
  MiniMap,
  Controls,
  Background,
} from "reactflow";
import "reactflow/dist/style.css";
import "./Testing.css"
import * as d3 from "d3";

const initialNodes = [
  { id: "a", data: { label: "A" }, position: { x: 0, y: 0 } },
  { id: "b", data: { label: "B" }, position: { x: 0, y: 0 } },
  { id: "c", data: { label: "C" }, position: { x: 0, y: 0 } },
  { id: "d", data: { label: "D" }, position: { x: 0, y: 0 } },
  { id: "e", data: { label: "E" }, position: { x: 0, y: 0 } },
  { id: "f", data: { label: "F" }, position: { x: 0, y: 0 } },
];

const initialEdges = [
  { id: "e1", source: "a", target: "b" },
  { id: "e2", source: "b", target: "c" },
  { id: "e3", source: "c", target: "d" },
];
function Testing() {
const [nodes,setNodes,onNodesChange] = useNodesState(initialNodes);
const [edges,setEdges,onEdgesChange] =useEdgesState(initialEdges);
// key parts only (not full file)
const simNodesRef = useRef([]);
const simulationRef = useRef(null);

const width = 800;
  const height = 600;

useEffect(() => {
  simNodesRef.current = nodes.map(n => ({ ...n, x: n.position.x, y: n.position.y }));
  const simLinks = edges.map(e => ({ source: e.source, target: e.target }));

  const sim = d3.forceSimulation(simNodesRef.current)
    .force("link", d3.forceLink(simLinks).id(d => d.id).distance(100))
    .force("charge", d3.forceManyBody().strength(-120))
    .force("center", d3.forceCenter(width/2, height/2))
    .on("tick", () => {
      setNodes(nds => nds.map(n => {
        const sn = simNodesRef.current.find(s => s.id === n.id);
        return { ...n, position: { x: sn.x, y: sn.y } };
      }));
    });

  simulationRef.current = sim;
  return () => sim.stop();
}, [edges, nodes.length /*or other deps*/, ]);



return (
    <div className="flow-container" style={{width:"100%",height: "100vh"}}>
      <ReactFlow
        nodes={nodes}
        edges={edges}
        onNodesChange={onNodesChange}
        onEdgesChange={onEdgesChange}
        fitView
      >
        <MiniMap/>
        <Controls/>
        <Background/>
      </ReactFlow>
    </div>
  )
}

export default Testing