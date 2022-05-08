import React from "react";
import styled from "styled-components";

const Container = styled.div`
    width:80%;
    
    position:relative;
    
    @media only screen and (min-width: 900px) {
        margin:0 auto;
        text-align:center;
        
      }
`


const CardContainer = styled.div`
display:flex;
align-items:center;
justify-content:center;
box-shadow: 0 1px 3px rgb(0 0 0 / 10%), 0 2px 2px rgb(0 0 0 / 6%), 0 0 2px rgb(0 0 0 / 7%);
border-radius:12px;
margin:20px 0px;
flex-direction:column;
padding-top:10px;
padding-bottom:10px;
transition: all 0.25s;

&:hover{
    cursor:pointer;
    transform:scale(1.1);
}

`



const HerdCard = ()=>{
    return(
        <Container>
            
            <h1>HERDS</h1>
            
            <CardContainer>
                <h1>South Field</h1>
            </CardContainer>
            <CardContainer>
                <h1>West Field</h1>
            </CardContainer>
            <CardContainer>
                <h1>North Field</h1>
            </CardContainer>
            
          
        </Container>
    )
}

export default HerdCard