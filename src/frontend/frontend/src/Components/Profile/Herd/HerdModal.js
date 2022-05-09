import React from "react";
import styled from "styled-components";

import Form from "../../Forms";
import TextInput from "../../Forms/textInput";

const Container = styled.div`
      position:fixed;
      background-color:white;
      border:${({theme})=>"2px solid " + theme.mainColor};
      width:250px;
      right:0;
      height:90vh;
      z-index:92;
      display:flex;
      justify-content:center;

`



const HerdModal = ()=>{

    return(
        <Container>
            <h2>Add a calve</h2>

        </Container>
    )
}


export default HerdModal