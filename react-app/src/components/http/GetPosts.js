import React, { Component } from 'react'
import axios from 'axios'
class GetPosts extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         posts:[],
         errorMessage:''
      }
    }
    componentDidMount(){
        axios.get("https://jsonplaceholder.typicode.com/posts").then(response=>{
            console.log(response)
            response = null
            this.setState({posts:response.data})
        }).catch(error=>{
            console.log(error)
        this.setState({errorMessage:error.message})
        })
        
    }
  render() {
    const {posts, errorMessage} = this.state
    return (
      <div>{posts.length>0?posts.map(data=>{return <h1 key={data.id}>ID: {data.userId}, title: {data.title}</h1>}):errorMessage.length>0?<h1>{errorMessage}</h1>:'There are no Posts'}</div>
    )
  }
}

export default GetPosts
