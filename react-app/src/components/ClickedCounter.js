import React, { Component } from "react"
import withCounter from "./withCounter"

class ClickedCounter extends Component {
  render() {
    const { count, incrementCounter } = this.props
    return (
      <div>
        <button onClick={incrementCounter}>Clicked {count} times</button>
      </div>
    )
  }
}

export default withCounter(ClickedCounter)
