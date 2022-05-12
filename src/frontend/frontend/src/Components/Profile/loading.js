import React from "react";
import styled from "styled-components";


const Container = styled.div`
    width:80%;
    margin:50px auto;
    text-align:center;
    color: ${({theme})=>theme.mainColor};
    opacity:0.8;
    @media only screen and (min-width: 600px) {
        font-size:35px;
      }
    

`


const Loading = ()=>{

    return(
        <Container>
            <h1>LOADING...</h1>
        </Container>
        
    )
}

export default Loading;