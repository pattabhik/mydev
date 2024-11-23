import React, { useEffect, useState } from "react"
import axios from "axios"
function GetDataHook() {
  const [movies, updateData] = useState([])
  const [errorRsp, updateErrorResponse] = useState("")
  //1. get the data from axios site
  //2. display them
  useEffect(() => {
    axios
      .get("https://reactnative.dev/movies.json")
      .then((response) => {
        console.log(response)
        updateData(response.data.movies)
      })
      .catch((error) => {
        updateErrorResponse(error)
        console.log(error)
      })
  })
  return (
    <div>
      <ul>
        {movies.length > 0
          ? movies.map((movie) => (
              <li key={movie.id}>
                {movie.title}, release in {movie.releaseYear}
              </li>
            ))
          : "There are no moviews"}
      </ul>
      {errorRsp}
    </div>
  )
}

export default GetDataHook
