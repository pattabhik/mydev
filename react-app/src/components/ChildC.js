import React, { Component } from 'react'

function ChildC(props) {
    return (
      <div><button onClick={()=>props.greetParent('Child')}>Greet Parent</button></div>
    )
}

export default ChildC;
