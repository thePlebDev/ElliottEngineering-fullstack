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
    grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
`

const CardContainer = styled.div`
    display:flex;
    box-shadow: 0 1px 3px rgb(0 0 0 / 10%), 0 2px 2px rgb(0 0 0 / 6%), 0 0 2px rgb(0 0 0 / 7%);
    border-radius:12px;
    
    margin:20px 5px;
    flex-direction:column;
    @media only screen and (min-width: 500px) {
        width:290px;
        
      }
      @media only screen and (max-width: 320px) {
        width:280px;
        
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
const Sex = styled.div`
    font-size:25px;
    font-weight:700;

`



const CowsNCalves = ({data})=>{

    return(
        <Container>
            <GridContainer>
                {
                    data.map((item)=>{
                        return(
                            <CardContainer key={item.id}>
                                <Hr/>
                                <Title>
                                    Calf tag: {item.calfTagNumber}
                                </Title>
                                
                                <Title>
                                    Cow tag: {item.cowTagNumber}
                                </Title>
                                <Hr/>
                                <Status weight={item.weight} born={item.date}/>
                                <Hr/>
                                <Sex>{item.sex}</Sex>
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