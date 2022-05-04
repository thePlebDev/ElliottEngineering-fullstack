import React from "react";


import Form from "../Forms";
import TextInput from "../Forms/textInput";
import FormSubmitButton from "../Buttons/formSubmitButton";
import LoadingText from "../LoadingText";
import ErrorNotifications from "../ErrorNotification";

import useFormSubmit from "../../Hooks/useFormSubmit";
import validationSignup from "../../Utils/validationFunctions/validateSignup";
import { formLoadingStates } from "../../Utils/Constants/loadingStates";




const Signup =()=>{
    
    const {state,status,errors,handleChange,handleSubmit} = useFormSubmit(
        {startingState:{username:"",email:"",password:""}},
        {validationFunction:validationSignup},
        {loadingTextInfo:{loadingState:formLoadingStates.RESTING,message:"Signup and support"}},
        );

    return(
        <>
        <LoadingText state={status.loadingState} message={status.message}  />
            
            <Form handleSubmit={handleSubmit}>
            <ErrorNotifications errors={errors}/>   
                <TextInput type="text" placeHolder={"Username"} name="username" value={state.username} handleChange={handleChange}/>
                <TextInput type="email" placeHolder={"Email"} name="email" value={state.email} handleChange={handleChange}/>
                <TextInput type="password" placeHolder={"Password"} name="password" value={state.password} handleChange={handleChange}/>

                <FormSubmitButton text={"Sign up"} />
            </Form>
        
        </>
    )
}



export default Signup;