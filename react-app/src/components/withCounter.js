import React from "react"

const withCounter = (WrapperComponent) => {
  class WithCounterComponent extends React.Component {
    constructor(props) {
      super(props)

      this.state = { count: 0 }
    }
    incrementCounter = () => {
      this.setState((prevState) => {
        return { count: prevState.count + 1 }
      })
    }
    render() {
      console.log(this.props.name)
      //spread operator
      return (
        <WrapperComponent
          count={this.state.count}
          incrementCounter={this.incrementCounter}
          {...this.props}
        />
      )
    }
  }
  return WithCounterComponent
}
export default withCounter
