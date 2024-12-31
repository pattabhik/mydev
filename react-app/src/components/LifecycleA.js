import React, { Component } from 'react'

class LifecycleA extends Component {
    constructor(){
        super()
        console.log('LifecycleA constructor')
    }
    static getDerivedStateFromProps(props, state){
        console.log('LifecycleA getDerivedStateFromProps')
    }
    componentDidMount(){
        console.log('LifecycleA componentDidMount')
    }
  render() {
    console.log('LifecycleA render 1')
    return (
      <div>LifecycleA</div>
      
    )
    
  }
}

export default LifecycleA
