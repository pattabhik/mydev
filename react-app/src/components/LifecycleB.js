import React, { Component } from 'react'

export class LifecycleB extends Component {
    constructor(){
        console.log('LifecycleB constructor')
    }
    static getDerivedStateFromProps(props, state){
        console.log('LifecycleB getDerivedStateFromProps')
    }
    componentDidMount(){
        console.log('LifecycleB componentDidMount')
    }
  render() {
    console.log('LifecycleB render 1')
    return (
      <div>LifecycleB</div>
    )
    console.log('LifecycleB render 2')
  }
}

export default LifecycleB
