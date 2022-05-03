import React from "react"
import {Routes , Route} from "react-router-dom"

import Home from "../Home"
import Navigation from "../Navigation"
import Signup from "../Signup"
import Login from "../Login"



const App =()=>{
    return(
        <>
            <Navigation/>
            <Routes>
                <Route path="/" exact element={<Home />} />
                <Route path="/signup" exact element={<Signup />} />
                <Route path="/login" exact element={<Login />} />
                <Route path="*" element={<Home />} />
            </Routes>
        </>
    )
}



export default App