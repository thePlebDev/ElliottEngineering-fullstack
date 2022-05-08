import React from 'react'
import styled from "styled-components";

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
    return(
        <SuperContainer>
            <SearchContainer>
                <h2>SEARCH BAR</h2>
            </SearchContainer>
            <Container>
                <Herd></Herd>
                
            </Container>
         </SuperContainer>

    )

}

export default LoggedIn;