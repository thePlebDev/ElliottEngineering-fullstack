import {useEffect,useState} from "react";
import axios from "axios";

const useAuthentication =()=>{
    const [authState, setAuthState] = useState("FAIL")

    useEffect(()=>{
        const authorization = localStorage.getItem("authorization");
        if(authorization !== null){
            axios.post("/api/v1/users/profile",{},{headers:{
                "Authorization":authorization
            }})
            .then(function(response){
                console.log(response.data)
                setAuthState("SUCCESS")
                
            })
            .catch(function(error){
                setAuthState("FAIL")
                
            })

        }else{
            setAuthState("FAIL")
        }
        
    },[])
    


    return{

        authState
    }
}


export default useAuthentication