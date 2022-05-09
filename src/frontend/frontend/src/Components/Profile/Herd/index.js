import React,{useEffect, useState,useRef} from "react";
import styled from "styled-components";

import CowsNCalves from "./CowsNCalves/CowsNCalves";
import AddCalf from "./CowsNCalves/addCalf";

const Container = styled.div`
    
    display:flex;
    position:relative;
    height:82.5vh;
    overflow-y:auto;
`





const Herd = ()=>{
    const [show,setShow] = useState(true)
    return(
        <Container>
           <AddCalf show={show} setShow={setShow}/>
            <CowsNCalves setShow={setShow}/>
        </Container>
    )
}


export default Herd