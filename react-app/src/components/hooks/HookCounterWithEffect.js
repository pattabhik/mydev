import React, { useEffect, useState } from "react"

function HookCounterWithEffect() {
  const [count, setCount] = useState(0)
  useEffect(() => {
    document.title = `Increment ${count} times`
  })

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>
        Increment {count} times
      </button>
    </div>
  )
}

export default HookCounterWithEffect
