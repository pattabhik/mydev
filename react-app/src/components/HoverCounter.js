import React, { Component } from "react"
import withCounter from "./withCounter"

class HoverCounter extends Component {
  render() {
    const { count, incrementCounter } = this.props
    return (
      <div>
        <button onMouseOver={incrementCounter}>
          {this.props.name} Mouse over {count} times
        </button>
      </div>
    )
  }
}

export default withCounter(HoverCounter)
