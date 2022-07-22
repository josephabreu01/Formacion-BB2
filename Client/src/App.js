import React from "react";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from "./components/home/Home";
import Login from "./components/login/Login";
import ProductsList from "./components/products/ProducstList";
import ProductDetail from "./components/products/ProductDetail";

const App =()=> {

  
  return (
   <Router>
    <Routes>
      <Route exact path={"/"} element={<Login/>}/>
      <Route exact path={"/home"} element={<ProductsList/>}/>
      <Route path={"/products"} exact={true} element={<ProductsList/>}/>
      <Route path={"/products/:id"} element={<ProductDetail/>} />
    </Routes>
   </Router>
  );
}

export default App;
