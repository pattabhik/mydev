import React from 'react'

function FunctionEvent() {
    function clickFunction(){
        console.log('Function Click button clicked');
    }
    return (
        <div><button onClick={clickFunction}>Function Click</button></div>
    )
}

export default FunctionEvent;
