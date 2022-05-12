function validateNewCalf(state){
    const errors ={};

    if(!state.calfTagNumber){
        errors.calfTagNumber ="Please enter the calf tag number"
    }
    if(!state.cowTagNumber){
        errors.cowTagNumber = "Please enter the cow tag number";
    }
    if(!state.weight){
        errors.weight = "Please enter the calf weight";
    }
    if(!state.sex){
        errors.sex = "Please click heifer or bull";
    }

    return errors
}


export default validateNewCalf