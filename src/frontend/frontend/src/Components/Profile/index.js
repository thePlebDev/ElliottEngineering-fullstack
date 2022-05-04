import React,{useState,useEffect} from "react";
import styled from "styled-components";
import axios from "axios";

import Authenticated from "./authenticated";






const PersonalAccount =()=>{
    const [authenticated, setAuthenticated] = useState(false)
    const [state, setState] = useState("LOADING")

    useEffect(()=>{
        const authorization = localStorage.getItem("authorization")
        console.log(authorization)
        axios.get("/api/v1/user/auth",{},{headers:{
            "Authorization":authorization
        }})
        .then(function(){
            setState("AUTHENTICATED")
            setAuthenticated(true)
        })
        .catch(function(error){
            setState("NOTAUTHENTICATED")
            setAuthenticated(false)
        })

    },[authenticated,setAuthenticated])
    return(
        <Authenticated state={state}/>
    )
}

export default PersonalAccount