import React,{useEffect, useState} from "react";
import axios from "axios";
import styled from "styled-components";

import Conditional from "./conditional";

const Container = styled.div`
    width:100%;
    
`
const ButtonContainer = styled.div`
    width:100%;
    
    text-align:center;
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
    padding: 5px 10px;
    width:150px;
    cursor:pointer;
`


const LoadingCalves = ({setShow})=>{
    const [state,setState] = useState("LOADING")
    const [data,setData] = useState()

    
    useEffect(()=>{
        axios.get('/api/v1/calf/getAll?userId=1',{
            headers: {
                'Authorization': 'eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImJvYiJ9.o02kj8FxnbS88T5aZpu862XQXvkXzPAfHTJKwP9dfUk'
              }
        }).then(response=>{
            if(response.data.length >0){
                setState("SUCCESSCALVES")
                setData(response.data)
            }else{
                setState("SUCCESSNOCALVES")
            }
        }).catch(error=>{
            console.log(error.response)
        })

    },[])

    return(
        <Container>
            <ButtonContainer>
                <h1>Calves</h1>
                <Button onClick={()=>setShow(true)}>Add Calf</Button>
            </ButtonContainer>

            <Conditional state={state} data={data}/>
            
        </Container>

    )
}


export default LoadingCalves