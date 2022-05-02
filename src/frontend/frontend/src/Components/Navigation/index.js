import React,{useState} from 'react'

import Header from "../Header";
import MobileNavigation from "../MobileNavigation";

//<MobileNavigation clicked={clicked}/> 

const Navigation = ()=>{
    const [clicked,setClicked] = useState(false)

    return(
        <>
            <Header clicked={clicked} setClicked={setClicked}/>
            
        </>
    )
}

export default Navigation