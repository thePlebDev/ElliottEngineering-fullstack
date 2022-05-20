import React,{useEffect} from "react";
import styled from "styled-components";
import * as SockJS from 'sockjs-client';
import {Stomp} from '@stomp/stompjs';

const Container = styled.div`
    
    text-align:center;
`
const Text = styled.h1`
    padding:10px;
    border:2px solid red;
    width:80%;
    margin:0 auto;
    cursor:pointer;
`


const TestingSocket =()=>{
    const socket = new SockJS('/gs-guide-websocket');
    const stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame){
        console.log("CONNECTED:" + frame);
        stompClient.subscribe("/testing/subscribe",function(greeting){
            console.log(greeting.body);
        });
    });

    

    const handleClick=()=>{
        socket.send("ANOTHER ON")

    }

    return(
        <Container>
            <Text>Testing Socket</Text>
        </Container>
    )
}


export default TestingSocket