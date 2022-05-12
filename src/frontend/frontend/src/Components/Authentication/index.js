import React,{Children} from "react";




const Authentication =({authobjs,state})=>{
    switch(state){

        case "SUCCESS":
            return authobjs.successAuth

        case "LOADING":
            return authobjs.loading

        case "FAIL":
            return authobjs.failAuth

        default:
            return <h1>DEFAULT</h1>
    }

    
}


export default Authentication