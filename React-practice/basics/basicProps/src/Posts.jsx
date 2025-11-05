import { useState, useEffect } from "react";

export default function Posts() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    const res= fetch("https://jsonplaceholder.typicode.com/posts");
    res.then(response =>{
        response.json()
        console.log("response", response);
    }
  },[])
  // TODO: useEffect to fetch posts

  return (
    <div>
      <h1>Posts</h1>
      <ul>
        {/* {posts.map((post, index) => (
          <li key={index}>{post}</li>
        ))} */}
      </ul>
    </div>
  );
}
