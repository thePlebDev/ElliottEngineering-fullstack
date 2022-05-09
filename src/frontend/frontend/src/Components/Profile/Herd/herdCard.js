import React from "react";
import styled from "styled-components";

import HerdForm from "./HerdForm";

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

const herdNames= [{id:0,name:"South Field"},{id:1,name:"Nord Field"}]

const HerdCard = ()=>{
    return(
        <Container>
            
            <h1>HERDS</h1>
            <HerdForm/>
            
            {
                herdNames.map((item)=>{
                    return (
                        <CardContainer key={item.id}><h2>{item.name}</h2></CardContainer>
                    )
                })
            }
            
          
        </Container>
    )
}

export default HerdCard