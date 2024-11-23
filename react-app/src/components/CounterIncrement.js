import React, { Component } from "react"

class CounterIncrement extends Component {
  constructor(props) {
    super(props)

    this.state = { count: 0 }
  }
  incrementCounter = () => {
    console.log("CounterIncrement.incrementCounter")
    this.setState((prevState) => {
      return { count: prevState.count + 1 }
    })
  }
  render() {
    return (
      <div>{this.props.render(this.state.count, this.incrementCounter)}</div>
    )
  }
}

export default CounterIncrement
