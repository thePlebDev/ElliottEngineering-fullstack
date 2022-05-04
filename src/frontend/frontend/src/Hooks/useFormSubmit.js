import {useState,useEffect} from "react";
import axios from "axios";


import { formLoadingStates } from "../Utils/Constants/loadingStates";




const useFormSubmit =(initialState,validate,loadingState)=>{
    const [state,setState] = useState(initialState.startingState)
    const [errors,setErrors] = useState({})
    const [isSubmitting, setIsSubmitting] = useState(false)
    const [status,setStatus] = useState(loadingState.loadingTextInfo)


    const handleChange=(e)=>{
        const {name,value} = e.target;
        setState({...state,[name]:value})
        
    }

    const handleSubmit =(e)=>{
        e.preventDefault()
        setIsSubmitting(true)
        setErrors(validate.validationFunction(state))
        
    }

    useEffect(()=>{
        if(isSubmitting && Object.keys(errors).length === 0){
            setStatus({loadingState:formLoadingStates.LOADING,message:"Loading"})
            axios.post('/api/v1/users/signup',state)
        .then((response)=>{
            setStatus({loadingState:formLoadingStates.SUCCESS,message:response.data})
            
        })
        .catch((error)=>{
            setStatus({loadingState:formLoadingStates.FAIL,message:"Error please try again"})
            
        })
        }
        setIsSubmitting(false);

    },[isSubmitting,errors])


    return{
        state,
        errors,
        status,
        handleChange,
        handleSubmit

    }
}


export default useFormSubmit