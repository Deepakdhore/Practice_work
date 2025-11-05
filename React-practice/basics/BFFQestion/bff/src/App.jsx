// This is a React Quiz from BFE.dev

import * as React from 'react'
import { useState } from 'react'
// import { screen, fireEvent } from '@testing-library/dom'

export default function App() {
  const [state, setState] = useState(0)
  const onClick = () => {
    console.log('handler')
    setState(state => state + 1)
    console.log('handler ' + state)
  }
  console.log('render ' + state)
  return <div>
    <button onClick={onClick}>click me</button>
  </div>
}



// (async function () {
//   const action = await screen.findByText('click me')
//   fireEvent.click(action);
// })()

