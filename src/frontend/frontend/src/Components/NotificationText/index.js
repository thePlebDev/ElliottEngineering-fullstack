import React from "react";
import styled from 'styled-components';

const Container = styled.div`
    margin:10px 2px;
    font-size:20px;
    color:red;
    display:${({errors})=> errors ? "none": "block"};
    
`

const NotificationText = ({errors})=>{
    const showErrors = Object.keys(errors).length === 0


    return(
        <Container state={errors} >
            Enter red areas
        </Container>
    )
}

export default NotificationText