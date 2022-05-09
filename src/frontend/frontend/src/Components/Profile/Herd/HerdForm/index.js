import React,{useEffect,useState} from "react";
import styled from "styled-components"



const Form = styled.form`
    display:flex;
    flex-direction:column;
`


const Input = styled.input`
border-radius: 8px;
border:1px solid rgba(0,0,0,0.6);
outline:none;
padding: 4px 10px;
width:100%;
color: rgba(0,0,0,.87);
margin-top:5px;
margin-bottom:10px;
font-size:20px;
focus:true;
border-color:${({errors})=>errors ? "red" :"rgba(0,0,0,0.7)"};
text-align:center;

`

const SubmitButton = styled.button`
   
    border:none;
    outline:none;
    background: #00a862;
    border-radius: 500px;
    box-shadow: 0 0 6px rgb(0 0 0 / 24%), 0 8px 12px rgb(0 0 0 / 14%);
    color: #fff;
    font-size: 20px;
    font-weight: 700;
    padding-top:5px;
    padding-bottom:5px;
    cursor:pointer;
`


const HerdForm =()=>{
    const [state,setState] = useState({herdName:""})

    const handleChange = (e)=>{
        const {name,value} = e.target

        setState({...state,[name]:value})
    }
    const handleSubmit = (e)=>{
        e.preventDefault();
        console.log(state)
    }


    return(
        <Form onSubmit={(e)=>handleSubmit(e)}>
            <label htmlFor="herd"/>
            
            <Input type="text" id="herd" onChange={(e) => handleChange(e)} name="herdName" placeholder="Herd Name" value={state.herdName}/>
            <SubmitButton type="save">Create Herd</SubmitButton>
        </Form>
    )
}

export default HerdForm