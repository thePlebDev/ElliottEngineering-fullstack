import React from "react";
import styled from "styled-components";

const Container = styled.div`
   
    width:90%;
    margin:0 auto;
    display:flex;
    align-items:center;
    justify-content:space-between;
    padding:10px;
`
const Button1 = styled.button`
    outline:none;
    background: #00a862;
    border-radius: 8px;
    box-shadow: 0 0 6px rgb(0 0 0 / 24%), 0 8px 12px rgb(0 0 0 / 14%);
    color: #fff;
    font-size: 25px;
    font-weight: 700;
    border:none;
    padding: 10px 5px;
    width:90px;
    cursor:pointer;

`
const Button2 = styled(Button1)`
    background-color:rgb(211, 47, 47);
`


const ButtonContainer = () =>{

    return(
        <Container>
            <Button2>Delete</Button2>
            <Button1>Edit</Button1>
        </Container>
    )
}

export default ButtonContainer