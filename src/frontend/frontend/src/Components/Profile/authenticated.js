import React from "react";
import styled from "styled-components";

import LoggedIn from "./loggedIn";
import NotLoggedIn from "./notLoggedIn";
import Loading from "./loading"


const Container = styled.div`
    
  
    
    text-align:center;

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