import React from 'react'

export default function Greeting(props) {
  return (
    props.isLoggedIn ?
      <div>Greeting</div> :
      <div>Please Log In</div>
  );
}

