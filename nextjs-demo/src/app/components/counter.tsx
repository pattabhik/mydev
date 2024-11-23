import { count } from "console";
import React from "react";

export const Counter = ()=>{
    console.log("Counter component");
    const [count, setCount] = userState(0);
    return (
        <button onClick={()=> setCount(count+1)}}> Clicked {count} times</button>
    );
    }
}