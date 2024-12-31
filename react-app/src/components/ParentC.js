import React, { Component } from 'react'
import ChildC from './ChildC'

class ParentC extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         first:'Parent'
      }
      this.greetParent = this.greetParent.bind(this)
    }
    greetParent(childVal){
        alert(`Hello ${this.state.first} from ${childVal}`)
    }
  render() {
    return (
      <ChildC greetParent={this.greetParent}/>
    )
  }
}

export default ParentC
