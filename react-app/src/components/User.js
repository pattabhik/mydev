import React, { Component } from "react"

class User extends Component {
  render() {
    const { name } = this.props
    return <div>{name(false)}</div>
  }
}

export default User
