import React,{useEffect, useState,useRef} from "react";
import styled from "styled-components";

import LoadingCalves from "./LoadingCalves";
import AddCalf from "./CowsNCalves/addCalf";

const Container = styled.div`
    
    display:flex;
    position:relative;
    height:82.5vh;
    overflow-y:auto;
`





const Herd = ()=>{
    const [show,setShow] = useState(false)
    const [loading,setLoading] = useState(false)
    return(
        <Container>
            
           <AddCalf show={show} setShow={setShow}/>
           
            <LoadingCalves setShow={setShow}/>
        </Container>
    )
}


export default Herd