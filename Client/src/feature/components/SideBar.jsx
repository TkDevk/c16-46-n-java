import React, { useContext, useEffect, useState } from "react";
import { IoCloseCircleOutline } from "react-icons/io5";
import LoginForm from "./forms/LoginForm";
import { Route, Routes } from "react-router-dom"

import PropTypes from "prop-types"
import Calendar from "./Calendar";
import Notifications from "./Notifications";
import Messages from "./Messages";
import Settings from "./Settings";
import { HomeContext } from "../../context/HomeContext";
import RegisterForm from "./forms/RegisterForm";

const SideBar = () => {
  const {sidebarVisible, handlerCloseSideBar} = useContext(HomeContext);

  return (
    <aside
      className={`fixed z-10 bg-white top-[10vh] right-0 z-40 md:w-2/5 lg:w-1/4 w-10/12 h-screen shadow-lg duration-500 p-4 transition-transform ${
        sidebarVisible ? "" : "translate-x-full"
      }`}
    >
      {/* CLOSE BUTTON */}
      <button
        className="absolute top-2 rounded-full bg-gray-200 z-10"
        onClick={handlerCloseSideBar}
      >
        <IoCloseCircleOutline style={{fontSize:'1.5rem', zIndex:'0'}}/>
      </button>

      

      <div className="w-full h-full m-2 mt-10 p-2">
        {/* ADD CONTENT / FORM HERE */}
        <Routes>
           <Route path="/login" element={<LoginForm />} />
           <Route path="/register" element={<RegisterForm />}/>
           <Route path="/calendar" element={<Calendar />} />
           <Route path="/notifications" element={<Notifications />} />
           <Route path="/messages" element={<Messages />} />
           <Route path="/settings" element={<Settings />}/>
        </Routes>
      </div>
    </aside>
  );
};

SideBar.propTypes = {
  isOpen: PropTypes.any,
}

export default SideBar;
