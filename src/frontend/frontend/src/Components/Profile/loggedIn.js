import React from 'react'
import styled from "styled-components";
import { useNavigate } from "react-router-dom";

import Herd from './Herd';


const Container = styled.div`
    
 

`
const SearchContainer = styled.div`
    border:2px solid blue;
    display:flex;
    flex-direction:columns;
    align-items:center;
    justify-content:center;
`

const SuperContainer =styled.div`
    

`


const LoggedIn = ()=>{
    const navigate = useNavigate();

    const handleClick = ()=>{
        navigate("/calveWeb") //CREATE THE COMPONENT
    }
    return(
        <SuperContainer>
            
            <Container>
                <h1>Profile</h1>
                <h2>Products available to you</h2>
                <button onClick={(()=>handleClick())}>Calving Tracker Web</button>
                
            </Container>
         </SuperContainer>

    )

}

export default LoggedIn;