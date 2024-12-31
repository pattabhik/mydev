import React from 'react'

function DisplayPersion({person, indx}) {
  return (
    <li>{indx} I am {person.name}, age is {person.age} and profession is {person.profession}</li>
  )
}

export default DisplayPersion
