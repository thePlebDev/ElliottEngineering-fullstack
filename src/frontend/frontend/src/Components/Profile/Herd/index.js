import React,{useEffect, useState,useRef} from "react";
import styled from "styled-components";

import HerdCard from "./herdCard";
import CowsNCalves from "./CowsNCalves/CowsNCalves";
import HerdModal from "./HerdModal";

const Container = styled.div`
    
    display:flex;
    position:relative;
    height:82.5vh;
    overflow-y:auto;

`
//at 900 this needs to become absolute
const AddHerd = styled.div`
    
    width:300px;
    height:82.5vh;
    overflow-y:auto;
    background-color:white;
    z-index:90;
    @media only screen and (max-width: 900px) {
        position:absolute;
        transition:all 0.25s;
        left:${({state})=>state ? "0" : "-260px"};
        
      }
`
const TabText = styled.div`
      border:2px solid red;
      position:absolute;
      right:0px;
      font-size:30px;
      @media only screen and (min-width: 900px) {
        display:none;
        
      }

`

const Herd = ()=>{
    const [clicked,setClicked] = useState(false);
    const node = useRef()

    const handleClick = (e)=>{
        if(node.current.contains(e.target)){
            
        }else{
            setClicked(false);
        }
    }

    useEffect(()=>{
        document.addEventListener("mousedown",handleClick)

        return ()=>{
            document.removeEventListener("mousedown",handleClick);
        }
    },[])
    return(
        <Container>
            <HerdModal/>
            <AddHerd state={clicked} ref={node}>
                <TabText onClick={()=>setClicked(!clicked)}>Op</TabText>
                <HerdCard/>
            </AddHerd>
            <CowsNCalves/>
        </Container>
    )
}


export default Herd