import React, { Component } from "react";

class DestructingClassProps extends Component{
    render(){
        const {name1, name2} = this.props
        //const {state1, state2}=this.state
        return <h2>DestructingClassProps {name1} {name2}</h2>
    }
}

export default DestructingClassProps;
