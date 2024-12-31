import React from 'react'
import DisplayPersion from './DisplayPersion'

function ListIteration() {
    const persons = [
        { id:1,name: 'Pattabhi', age: 41, profession: 'Private Employee' }, { id:2,name: 'Sravani', age: 31, profession: 'House Wife' },
        { id:3,name: 'Janaki Ramu', age: 12, profession: 'Student' }, { id:4,name: 'Juhitha', age: 9, profession: 'Student' }
    ]
    const personsDisplay = persons.map((person, indx)=><DisplayPersion key={indx} indx={indx} person={person}/> )
    return (
        <ui>{personsDisplay}</ui>
    )
}

export default ListIteration
