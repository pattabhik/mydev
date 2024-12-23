import React, { Component } from "react"

class ErrorBoundary extends Component {
  constructor(props) {
    super(props)

    this.state = {
      hasError: false,
    }
  }
  static getDerivedStateFromError(error) {
    console.log("getDerivedStateFromError")
    return { hasError: true }
  }
  componentDidCatch(error, info) {
    console.log(error)
    console.log(info)
  }
  render() {
    if (this.state.hasError) {
      return <div>Something went wrong</div>
    }
    return this.props.children
  }
}

export default ErrorBoundary
