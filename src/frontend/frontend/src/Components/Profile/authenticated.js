import React from "react";
import styled from "styled-components";

import LoggedIn from "./loggedIn";
import NotLoggedIn from "./notLoggedIn";
import Loading from "./loading"


const Container = styled.div`
    
    width:80%;
    margin:2rem auto;
    text-align:center;

    box-shadow: 0 2px 4px rgb(0 0 0 / 7%), 0 4px 5px rgb(0 0 0 / 6%), 0 1px 10px rgb(0 0 0 / 10%);
`





const Authenticated =({state})=>{
    let authComponent;

    if(state === "LOADING"){
        authComponent = <Loading/>
    }
    else if(state === "AUTHENTICATED"){
        authComponent = <LoggedIn/>
    }else if(state === "NOTAUTHENTICATED"){
        authComponent = <NotLoggedIn/>
    }
    return(
        <Container>
            {
               authComponent
            }
            
        </Container>
    )

}

export default Authenticated