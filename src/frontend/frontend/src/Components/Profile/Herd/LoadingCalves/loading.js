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




const Loading =()=>{

    return(
        <Container>
                <h1>Loading...</h1>
        </Container>
    )
}


export default Loading;