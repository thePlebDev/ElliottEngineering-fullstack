import React from "react"
import {Routes , Route} from "react-router-dom"

import Home from "../Home"
import Navigation from "../Navigation"
import Signup from "../Signup"
import Login from "../Login"
import About from "../About"
import Products from "../Products"
import Profile from "../Profile"
import RoadMap from "../Roadmap"
import CalvingTrackerWeb from "../CalvingTrackerWeb"



const App =()=>{
    return(
        <>
            <Navigation/>
            <Routes>
                <Route path="/" exact element={<Home />} />
                <Route path="/signup" exact element={<Signup />} />
                <Route path="/Products" exact element={<Products/>} />
                <Route path="/roadmap" exact element={<RoadMap/>} />
                <Route path="/profile" exact element={<Profile/>} />
                <Route path="/calveWeb" exact element={<CalvingTrackerWeb/>} />
                <Route path="/login" exact element={<Login />} />
                <Route path="/about" exact element={<About />} />
                <Route path="*" element={<Home />} />
            </Routes>
        </>
    )
}



export default App