import React,{useState} from "react";
import styled from "styled-components";
import axios from "axios";

import Form from "../Forms";
import TextInput from "../Forms/textInput";
import FormSubmitButton from "../Buttons/formSubmitButton";


const TextContainer = styled.div`
    text-align:center;
    margin-top:20px;
    margin-bottom:20px;

`



const Login =()=>{
    const [state,setState] = useState({username:"",password:""})

    const handleChange=(e)=>{
        const {name,value} = e.target;
        setState({...state,[name]:value})
        
    }
    const handleSubmit =(e)=>{
        e.preventDefault()
        axios.post("/api/v1/users/login",{},{headers:state})
        .then((response)=>{
            console.log(response)
        })
        .catch((error)=>{
            console.log(error)
        })
    }


    return(
        <>
            <TextContainer>
                <h1>Login</h1>
            </TextContainer>
            <Form handleSubmit={handleSubmit}>
                <TextInput type="text" placeHolder={"Username"} name="username" value={state.username} handleChange={handleChange}/>
                <TextInput type="password" placeHolder={"Password"} name="password" value={state.password} handleChange={handleChange}/>
                <FormSubmitButton  text="Login"/>
            </Form>
        
        </>
    )
}


export default Login;