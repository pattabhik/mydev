import React, { Component } from "react";

class ClassStateC extends Component{
    constructor(){
        super()
        this.state={message:'ClassStateC initial state'}
    }
    changeState(){
        this.setState({message:'ClassStateC state has been changed'})
    }
    render(){
        return (<h2>
            {this.state.message}<br/>
            <button onClick={()=>this.changeState()}>Change State</button>
        </h2>
        )
    }
}

export default ClassStateC;
