import { useState } from "react";

export const useHome = () => {

  const [isRegisterOpen, setRegisterOpen] = useState(false)
  const [sidebarVisible, setSidebarVisible] = useState(false);

  // FORMULARIO VISIBLE
  const handlerOpenSidebar = () => {
    setSidebarVisible(true);
  };

  const handlerCloseSideBar = () => {
    setSidebarVisible(false);
    setRegisterOpen(false)
  };

  const handlerRegisterOpen = () => {
    setRegisterOpen(true)
  }

  const handlerRegisterClose = () => {
    setRegisterOpen(false)
  }

  return {
    sidebarVisible,
    isRegisterOpen,
    handlerOpenSidebar,
    handlerCloseSideBar,
    handlerRegisterOpen,
    handlerRegisterClose
  };
};
