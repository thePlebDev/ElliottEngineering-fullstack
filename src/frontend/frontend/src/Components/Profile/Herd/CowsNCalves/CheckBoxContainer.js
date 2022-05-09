import React,{useState} from "react";
import styled from "styled-components";

const CheckBox = styled.input`
    border:2px solid blue;
    cursor:pointer;
    height:20px;
    width:20px;
    accent-color:${({theme})=>theme.mainColor};

`
const Container = styled.div`
    
    margin:10px auto;
    width:90%;
    display:flex;
    justify-content:space-between;
    align-items:center;

`

const Text = styled.label`
    font-size:20px;
    margin-left:5px;
    margin-right:5px;
`



const CheckBoxContainer =({setSharedState,sharedState})=>{
    const [state,setState] = useState({sex:"Bull"})

    const handleClick =(e)=>{
        const {name,value} = e.target
        setSharedState({...sharedState,[name]:value})
        
    }

    return(
        <Container>
            <div>
                <Text htmlFor="bull">Bull</Text>
                <CheckBox id="bull" type="radio" name="sex" value="Bull" onChange={(e)=> handleClick(e)}/>
            </div>
                    
            <div>
                <CheckBox id="heifer" type="radio" name="sex" value="Heifer" onChange={(e)=> handleClick(e)} />
                <Text htmlFor="heifer">Heifer</Text>
            </div>
        </Container>

    )
}


export default CheckBoxContainer