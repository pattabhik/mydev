import React, { Component } from 'react'

export class ClassEvent extends Component {
    clickButton(){
        console.log('ClassEvent clickButton clicked')
    }
  render() {
    return (
      <div><button onClick={this.clickButton}>Class Click</button></div>
    )
  }
}

export default ClassEvent;
