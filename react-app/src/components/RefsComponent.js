import React, { Component } from "react"

class RefsComponent extends Component {
  constructor(props) {
    super(props)

    this.ref = React.createRef()
  }
  componentDidMount() {
    this.ref.current.focus()
  }
  render() {
    return (
      <div>
        RefsComponent
        <input type="text" ref={this.ref} />
      </div>
    )
  }
}

export default RefsComponent
