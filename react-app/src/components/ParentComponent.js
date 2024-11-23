import React, { Component } from "react"
import MemoFuncComp from "./MemoFuncComp"

class ParentComponent extends Component {
  constructor(props) {
    super(props)

    this.state = {
      name: "Pattabhi",
    }
  }
  render() {
    return (
      <div>
        ParentComponent
        <MemoFuncComp name={this.props.name} />
      </div>
    )
  }
}

export default ParentComponent
