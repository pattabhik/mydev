import React from "react";
//way 1
/* const DestructingFunProps = ({name1, name2}) => {
    return <h2>Hello {name1}, {name2} </h2>
} */

//way 2
const DestructingFunProps = (props) => {
    const {name1,name2} = props
    return <h2>Hello {name1} {name2}</h2>
}
export default DestructingFunProps;
