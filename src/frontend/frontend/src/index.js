import React from "react";
import {createRoot} from "react-dom/client"
import { BrowserRouter as Router } from "react-router-dom";
import { ThemeProvider } from "styled-components";

import GlobalStyle from "./Styles/globalStyles";

import theme from "./Styles/theme";


import App from "./Components/App";

const root = createRoot(document.getElementById("root"))

root.render(
    <Router>
        <GlobalStyle/>
        <ThemeProvider theme={theme}>  
                <App/>
        </ThemeProvider>
    </Router>
    )