import React, { useEffect, useState } from "react"

function IntervalHookCounter() {
  const [count, setCount] = useState(0)

  useEffect(() => {
    const interval = setInterval(click, 1000)

    return () => {
      clearInterval(interval)
    }
  }, [])
  const click = () => {
    setCount(count + 1)
  }
  return <div>{count}</div>
}

export default IntervalHookCounter
