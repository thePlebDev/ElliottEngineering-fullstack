import React,{useState,useEffect} from "react";
import styled from "styled-components";

import Authentication from "../Authentication";
import Herd from "../Profile/Herd";
import Loading from "../Profile/loading";
import NotLoggedIn from "../Profile/notLoggedIn";
import useAuthentication from "../../Hooks/useAuthentication";
import authenticationStates from "../../Utils/Constants/authenticationStates";




const CalvingTrackerWeb =()=>{ 
    //THIS NEEDS TO MAKE A REQUEST TO THE BACKEND TO AUTHENTICATE AND DISPLAY ACCORDINGLY
    const {authState} = useAuthentication();
    
    
    const authObjs={successAuth:<Herd/>,loading:<Loading/>,failAuth:<NotLoggedIn/>}

    

    return(
        <Authentication state={"SUCCESS"} authobjs={authObjs}/>
    )
}

export default CalvingTrackerWeb