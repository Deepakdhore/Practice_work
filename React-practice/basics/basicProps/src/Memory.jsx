import React, { useState } from "react";

// Expensive calculation (fake delay)
function expensiveCalculation(num) {
  console.log("Calculating...");
  let total = 0;
  for (let i = 0; i < 100000000; i++) {
    total += num;
  }
  return total;
}

// Child showing a name
function NameDisplay({ name }) {
  console.log("NameDisplay rendered");
  return <h2>Name: {name}</h2>;
}

// Child showing a button
function IncrementButton({ onClick }) {
  console.log("IncrementButton rendered");
  return <button onClick={onClick}>Increment</button>;
}

export default function Memory() {
  const [count, setCount] = useState(0);
  const [name, setName] = useState("Deepak");

  const total = expensiveCalculation(count); // recalculates every render

  return (
    <div>
      <NameDisplay name={name} />
      <IncrementButton onClick={() => setCount(count + 1)} />
      <button onClick={() => setName("Reddy")}>Change Name</button>
      <p>Count: {count}</p>
      <p>Total: {total}</p>
    </div>
  );
}
