import React,{useState,useEffect} from "react";
import styled from "styled-components";
import axios from "axios";

import Authenticated from "./authenticated";






const PersonalAccount =()=>{
    const [authenticated, setAuthenticated] = useState(false)
    const [state, setState] = useState("LOADING")

    // useEffect(()=>{
    //     const authorization = sessionStorage.authorization
    //     axios.get("/api/v1/user/auth",{headers:{
    //         "Authorization":authorization
    //     }})
    //     .then(function(){
    //         setAuthenticated(true)
    //     })
    //     .catch(function(error){
    //         setAuthenticated(false)
    //     })

    // },[authenticated,setAuthenticated])
    return(
        <Authenticated state={state}/>
    )
}

export default PersonalAccount