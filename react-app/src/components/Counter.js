import React, { Component } from "react";

class Counter extends Component {
    constructor() {
        super()
        this.state = { counterVal: 0 }
        console.log('Counter constructor')
    }
    increment() {
        this.setState({ counterVal: this.state.counterVal + 1 })
    }
    render() {
        return        (
            <div>
                <h2>Count {this.state.counterVal}  </h2> <br />
                <button onClick={() => this.increment()}>Increment</button>
            </div>
        )
    }
}

export default Counter;
