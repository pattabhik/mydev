import React, { Component } from 'react'

class ConditionFC extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         isLoggedIn:false
      }
    }
  render() {
    let message = this.state.isLoggedIn?'Welcome Pattabhi':'Welcome Guest'
    return (
      <div>Welcome {this.state.isLoggedIn?'Pattabhi':'Guest'}</div>
    )
  }
}

export default ConditionFC
