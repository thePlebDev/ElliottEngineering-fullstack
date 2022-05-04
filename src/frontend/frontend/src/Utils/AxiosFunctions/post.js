import axios from "axios";



const axiosPost=(location,body,headerState)=>{
    axios.post(location,body,{headers:headerState})

}




export {axiosPost}