import React, { Component } from "react"

class IntervalClassCounter extends Component {
  constructor(props) {
    super(props)

    this.state = {
      count: 0,
    }
  }
  componentDidMount() {
    console.log("Component did mount")
    this.interval = setInterval(this.click, 1000)
  }
  componentWillUnmount() {
    console.log("Component unmounted")
    clearInterval(this.interval)
  }
  click = () => {
    this.setState({ count: this.state.count + 1 })
  }
  render() {
    return <div>{this.state.count}</div>
  }
}

export default IntervalClassCounter
