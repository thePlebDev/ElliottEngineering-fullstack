import React from "react";


import Form from "../Forms";
import TextInput from "../Forms/textInput";
import FormSubmitButton from "../Buttons/formSubmitButton";
import LoadingText from "../LoadingText";
import ErrorNotifications from "../ErrorNotification";

import useLogin from "../../Hooks/useLogin";





const Login =()=>{

    const {state,handleChange,errors,handleSubmit,status} = useLogin()
  


    return(
        <>
            <LoadingText state={status.loadingState} message={status.message}  />
            <Form handleSubmit={handleSubmit}>
                <ErrorNotifications errors={errors}/> 
                <TextInput type="text" placeHolder={"Username"} name="username" value={state.username} handleChange={handleChange}/>
                <TextInput type="password" placeHolder={"Password"} name="password" value={state.password} handleChange={handleChange}/>
                <FormSubmitButton  text="Login"/>
            </Form>
        
        </>
    )
}


export default Login;