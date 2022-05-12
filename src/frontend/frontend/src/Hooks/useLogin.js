import {useState,useEffect} from "react";
import axios from "axios";
import loginValidation from "../Utils/validationFunctions/loginValidation";

import { formLoadingStates } from "../Utils/Constants/loadingStates";
import { useNavigate } from "react-router-dom";



const useLogin =()=>{
    const [state,setState] = useState({username:"",password:""})
    const [errors,setErrors] = useState({})
    const [isSubmitting,setIsSubmitting] = useState(false)
    const [status,setStatus] = useState({loadingState:formLoadingStates.RESTING,message:"Login"})
    const navigate = useNavigate();
    


    const handleChange=(e)=>{
        const {name,value} = e.target;
        setState({...state,[name]:value})
        
    }
    const handleSubmit =(e)=>{
        e.preventDefault();
        setErrors(loginValidation(state))
        setIsSubmitting(true);
        
    }
    useEffect(()=>{
        if(isSubmitting && Object.keys(errors).length === 0){
            setStatus({loadingState:formLoadingStates.LOADING,message:"Loading"})
            axios.post("/api/v1/users/login",{},{headers:state})
            .then((response)=>{
                setStatus({loadingState:formLoadingStates.SUCCESS,message:response.data})
                const jwtToken =response.headers.authorization
                const userIdToken =response.headers.userid
                console.log(jwtToken)
                console.log(userIdToken)
                localStorage.setItem("authorization",jwtToken)
                localStorage.setItem("userId",userIdToken)
                navigate("/profile")
            })
            .catch((error)=>{
                setStatus({loadingState:formLoadingStates.FAIL,message:"Error please try again"})
                console.log(error.response)
            })
            
        }
        setIsSubmitting(false)

    },[isSubmitting])



    return{
        state,
        status,
        errors,
        handleChange,
        handleSubmit
    }

}


export default useLogin