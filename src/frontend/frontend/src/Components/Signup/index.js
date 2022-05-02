import React,{useState,UseEffect} from "react";
import styled from "styled-components"
import axios from "axios";

import FormContainer from "../Forms/formContainer";
import Form from "../Forms";
import TextInput from "../Forms/textInput";
import FormSubmitButton from "../Buttons/formSubmitButton";


const TextContainer = styled.div`
    text-align:center;
    margin-top:20px;
    margin-bottom:20px;

`



const Signup =()=>{
    const [state,setState] = useState({username:"",email:"",password:""})

    //errors,handleChange,value,name,type,placeHolder

    const handleChange=(e)=>{
        const {name,value} = e.target;
        

        setState({...state,[name]:value})
        
    }

    const handleSubmit =(e)=>{
        e.preventDefault()
        axios.post('/api/v1/users/signup', state)
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
            <h1>Sign up</h1>
        </TextContainer>
            
            <Form handleSubmit={handleSubmit}>
                <TextInput type="text" placeHolder={"Username"} name="username" value={state.username} handleChange={handleChange}/>
                <TextInput type="email" placeHolder={"Email"} name="email" value={state.email} handleChange={handleChange}/>
                <TextInput type="password" placeHolder={"Password"} name="password" value={state.password} handleChange={handleChange}/>

                <FormSubmitButton text={"Sign up"} />
            </Form>
        
        </>
    )
}



export default Signup;