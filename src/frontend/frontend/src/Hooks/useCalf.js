import {useState,useEffect} from "react";
import validateNewCalf from "../Utils/validationFunctions/validateNewCalf";
import axios from "axios";


const useCalf = ()=>{
    const [state,setState] = useState({calfTagNumber:"",cowTagNumber:"",weight:"",details:"",sex:""})
    const [errors,setErrors] = useState({})
    const [isSubmitting,setIsSubmitting] = useState(false)
    const authorization = localStorage.getItem("authorization");
    const userId = localStorage.getItem("userId");
    const handleSubmit = (e)=>{
        e.preventDefault();
        console.log(state)
        setErrors(validateNewCalf(state));
        setIsSubmitting(true);
    }
    const handleChange =(e)=>{
        const {name,value} = e.target;
        setState({...state,[name]:value})
    }

    useEffect(()=>{
        
        if(isSubmitting && Object.keys(errors).length === 0){

            axios.post(`/api/v1/calf/create?userId=${userId}`,state,{
                headers: {
                    'Authorization': authorization
                  }
            }).then(response=>{
                console.log(response.data)
            }).catch(error=>{
                console.log(error.response)
            })

        }else{
            setIsSubmitting(false)
        }

    },[isSubmitting,errors])




    return{
        state,
        errors,
        setState,
        handleChange,
        handleSubmit

    }
}


export default useCalf;