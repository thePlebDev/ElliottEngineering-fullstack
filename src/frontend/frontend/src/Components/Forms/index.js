import React from "react";
import styled from "styled-components"

import FormContainer from "./formContainer";

const FormSubContainer = styled.form`
    display:flex;
    flex-direction:column;  
    

`

 


const Form = ({handleSubmit,children})=>{
    return(
        <FormContainer>
            <FormSubContainer onSubmit={(e)=> handleSubmit(e)}>
            {children}
            </FormSubContainer>
        </FormContainer>
        

    )

}

export default Form