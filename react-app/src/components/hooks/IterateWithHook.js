import React, { useState } from "react"

function IterateWithHook() {
  const [items, updateItems] = useState([])
  const addItem = () => {
    updateItems([
      ...items,
      { id: items.length, value: Math.floor(Math.random() * 10) + 1 },
    ])
  }
  return (
    <div>
      <button onClick={addItem}> Add Item </button>
      <ul>
        {items.map((itm) => (
          <li key={itm.id}>{itm.value}</li>
        ))}
      </ul>
    </div>
  )
}

export default IterateWithHook
