function loginValidation(state){
    const errors = {}

    if(!state.username){
        errors.username = "Please enter username";
    }
    if(!state.password){
        errors.password = "Please enter password";
    }

    return errors
}


export default loginValidation;