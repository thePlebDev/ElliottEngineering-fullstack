import React,{useState,useEffect} from "react";
import styled from "styled-components";
import axios from "axios";

import Authenticated from "./authenticated";
import LoggedIn from "./loggedIn";






const PersonalAccount =()=>{
    const [authenticated, setAuthenticated] = useState(false)
    const [state, setState] = useState("LOADING")

    useEffect(()=>{
        const authorization = localStorage.getItem("authorization")
        
        axios.post("/api/v1/users/profile",{},{headers:{
            "Authorization":authorization
        }})
        .then(function(response){
            console.log(response.data)
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