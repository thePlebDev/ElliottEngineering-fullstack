import React,{useState} from "react";
import styled from "styled-components";

import CheckBoxContainer from "./CheckBoxContainer"

const Container = styled.div`
    height:100%;
    background-color:white;
    width:250px;
    box-shadow: 0 0 6px rgb(0 0 0 / 24%), 0 8px 12px rgb(0 0 0 / 14%);
    border-radius:8px;
    position:absolute;
    transition:all 0.25s;
    left:${({state})=>state ? 0 :"-280px"};
    z-index:50;

`
const SubContainer = styled.div`
    
    position:realtive;
    diplay:flex;
    justify-content:center;
    text-align:center;
`
const Input = styled.input`
border-radius: 8px;
border:1px solid rgba(0,0,0,0.6);
outline:none;
padding: 12px 16px;
width:90%;
color: rgba(0,0,0,.87);
margin-top:5px;
margin-bottom:10px;
font-size:20px;
focus:true;
border-color:${({errors})=>errors ? "red" :"rgba(0,0,0,0.7)"};

`
const Button = styled.button`
    outline:none;
    background: #00a862;
    border-radius: 500px;
    box-shadow: 0 0 6px rgb(0 0 0 / 24%), 0 8px 12px rgb(0 0 0 / 14%);
    color: #fff;
    font-size: 20px;
    font-weight: 700;
    line-height: 1.2;
    overflow: hidden;
    border:none;
    padding: 10px 5px;
    width:100px;
    cursor:pointer;
`
const CancelButton = styled(Button)`
    background:rgb(211, 47, 47);


`


const ButtonContainer = styled.div`
    width:90%;
    margin:10px auto;
    display:flex;
    justify-content:space-around;

`





const AddCalf = ({show,setShow})=>{
    const [state,setState] = useState({calfTag:"",cowTag:"",weight:"",details:"",sex:""})
    const handleSubmit = (e)=>{
        e.preventDefault();
        console.log(state)
    }
    const handleChange =(e)=>{
        const {name,value} = e.target;
        setState({...state,[name]:value})
    }

    return(
        <Container state={show}>
            <SubContainer>
            <h1>Add Calf</h1>
            <form onSubmit={(e)=> handleSubmit(e)}>
                <Input placeholder="Calf tag number" type="text" onChange={(e)=> handleChange(e)} value={state.calfTag} name="calfTag"/>
                <Input placeholder="Cow tag number" type="text" onChange={(e)=> handleChange(e)} value={state.cowTag} name="cowTag"/>
                <Input placeholder="Birth weight /lbs" type="number" onChange={(e)=> handleChange(e)} value={state.weight} name="weight"/>
                <CheckBoxContainer setSharedState={setState} sharedState={state}/>
                
                <Input placeholder="Details" onChange={(e)=> handleChange(e)} value={state.details} name="details"/>
                <ButtonContainer>
                    <Button typ="submit">Save</Button>
                    <CancelButton typ="submit" onClick={()=>setShow(false)}>Cancel</CancelButton>

                </ButtonContainer>
            </form>
            </SubContainer>
        </Container>
        
    )
}

export default AddCalf