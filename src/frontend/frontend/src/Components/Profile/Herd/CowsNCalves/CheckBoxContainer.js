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
    color:${({errors})=> errors ? "red": ""};
`



const CheckBoxContainer =({setSharedState,sharedState,errors})=>{
    const [state,setState] = useState({sex:"Bull"})

    const handleClick =(e)=>{
        const {name,value} = e.target
        setSharedState({...sharedState,[name]:value})
        
    }

    return(
        <Container>
            <div>
                <Text htmlFor="bull" errors={errors}>Bull</Text>
                <CheckBox id="bull" type="radio" name="sex" value="BULL" onChange={(e)=> handleClick(e)}/>
            </div>
                    
            <div>
                <CheckBox id="heifer" type="radio"  name="sex" value="HEIFER" onChange={(e)=> handleClick(e)} />
                <Text htmlFor="heifer" errors={errors}>Heifer</Text>
            </div>
        </Container>

    )
}


export default CheckBoxContainer