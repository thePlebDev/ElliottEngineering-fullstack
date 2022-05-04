function validationSignup(state){
    const errors ={}

    if(!state.username){
        errors.username ="Please enter a username"
    }
    if(!state.password){
        errors.password = "Please enter a password";
    }
    if(!state.email){
        errors.email = "Please enter a email";
    }
    return errors
}



export default validationSignup