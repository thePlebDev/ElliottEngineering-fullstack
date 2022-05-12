import React from "react";

import Loading from "./loading";
import NotCalvesFound from "./noCalvesFound";
import CowsNCalves from "../CowsNCalves/CowsNCalves";




const Conditional=({state,data})=>{

    switch(state){
        case "LOADING":
            return <Loading/>
        
        case "SUCCESSCALVES":
            return <CowsNCalves data={data}/>

        case "SUCCESSNOCALVES":
            return <NotCalvesFound/>

        case "ERROR":
            return <h1>THERE WAS AN ERROR</h1>

        default:
            return <h1>DEFAULT</h1>
    }
}

export default Conditional