import React from "react";
import styled from "styled-components";


import Status from "./status";
import ButtonContainer from "./ButtonContainer";

const Container = styled.div`
    
    width:100%;
    text-align:center;
    overflow-y:auto;
`
const GridContainer = styled.div`
    padding:10px;
    display:grid;
    justify-items:center;
    grid-template-columns: repeat(auto-fit, minmax(340px, 1fr));
`

const CardContainer = styled.div`
    display:flex;
    
    box-shadow: 0 1px 3px rgb(0 0 0 / 10%), 0 2px 2px rgb(0 0 0 / 6%), 0 0 2px rgb(0 0 0 / 7%);
    border-radius:12px;
    width:250px;
    
    margin:20px 5px;
    flex-direction:column;
    @media only screen and (min-width: 500px) {
        width:350px;
        
      }
      @media only screen and (max-width: 900px) {
        
        height:500px;
      }
`
const Title = styled.div`
    width:90%;
    margin:0 auto;
    color: #888;
    font-size:25px;
    font-weight: 600;
    letter-spacing: 1px;
    text-align:start;


`
const Hr = styled.hr`
    background-color:${({theme})=>theme.mainColor};
    margin:15px auto;
    height:2px;
    border-radius:12px;
    width:90%;
    opacity: 0.6;
    z-index:1;
`
const DetailText = styled.div`
    text-align: center;
    padding:0 5px;
    font-size: 18px;
`
//need to add calves
const cowDeatils = [
    {
        id:0,
        cowTagNumber:"asdf",
        calfTagNumber:"fdsa94",
        status:"open",
        details:"need to sell",

        
    },
    {
        id:1,
        cowTagNumber:"asdf",
        calfTagNumber:"gjkfkf93",
        status:"pregnant",
        details:"waiting",
        
    },
    {
        id:2,
        cowTagNumber:"asdf",
        calfTagNumber:"fdsa9",
        status:"calved",
        details:"needs more grain",
        
    },
    {
        id:3,
        cowTagNumber:"234hg99nvfj",
        calfTagNumber:"fdsa8",
        status:"calved",
        details:"needs more grain",

    }
    
    
]

const CowsNCalves = ()=>{

    return(
        <Container>
            <h1>Calves</h1>
            <button>Add Calf</button>
            <GridContainer>
                {
                    cowDeatils.map((item)=>{
                        return(
                            <CardContainer key={item.id}>
                                <Hr/>
                                <Title>
                                    Calf id: {item.calfTagNumber}
                                </Title>
                                
                                <Title>
                                    Cow id: {item.cowTagNumber}
                                </Title>
                                <Hr/>
                                <Status/>
                                <Hr/>
                                <DetailText>{item.details}</DetailText>
                                <Hr/>
                                <ButtonContainer/>
                            </CardContainer>
                        )
                    })
                }

            </GridContainer>    
        </Container>
    )
}


export default CowsNCalves