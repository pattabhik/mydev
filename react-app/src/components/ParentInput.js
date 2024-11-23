import React, { Component } from "react"
import Input from "./Input"

class ParentInput extends Component {
  constructor(props) {
    super(props)

    this.inputRef = React.createRef()
  }
  clickHandler = () => {
    this.inputRef.current.focus()
  }
  render() {
    return (
      <div>
        <Input ref={this.inputRef} />
        <button onClick={this.clickHandler}>Focus Input</button>
      </div>
    )
  }
}

export default ParentInput
