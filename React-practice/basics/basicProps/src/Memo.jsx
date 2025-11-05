import React, { useState } from 'react'
import PropTypes from 'prop-types'

const [count,setCount] = useState(0);

function expensiveCalculation(){
    for (let index = 0; index < 1000000; index++) {
        setCount((prev)=>prev+1);
    }



}

function Memo(props) {
  return (
    <div>
        {count}
    </div>

  )
}

export default Memo
