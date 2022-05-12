import React from "react";
import styled from "styled-components";

const Container = styled.div`
    height:90%;
    display:flex;
    align-items:center;
    justify-content:center;
    font-size:30px;
    color:#00a862;
    opacity:0.7;
    


`

const NotCalvesFound = ()=>{

    return(
        <Container>
            <h1>No calves found</h1>
        </Container>
    )
}


export default NotCalvesFound