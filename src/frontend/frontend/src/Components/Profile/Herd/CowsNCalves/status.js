import React from "react";
import styled from "styled-components";


const Container = styled.div`

    width:90%;
    margin:0 auto;

`
const StatusContainer = styled.div`
    display:flex;
    justify-content:space-between;


`
const CheckBox = styled.input`
    border:2px solid blue;

    height:20px;
    width:20px;
    accent-color:${({theme})=>theme.mainColor};

`


const Text = styled.span`
    font-size:25px;
    

`


const Status = ()=>{
    return(
        <Container>
            <StatusContainer>
                <div>Birth Weight: <Text>900lbs</Text></div>
                <div>Born: <Text>22/08/24</Text></div>
            </StatusContainer> 
        </Container>
    )
}

export default Status