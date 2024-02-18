import React from "react";
import { useHome } from "../hooks/useHome";
import { HomeContext } from "./HomeContext";

const HomeProvider = ({ children }) => {
  const {
    sidebarVisible,
    isRegisterOpen,
    handlerOpenSidebar,
    handlerCloseSideBar,
    handlerRegisterOpen,
    handlerRegisterClose,
  } = useHome();

  return (
    <HomeContext.Provider
      value={{
        sidebarVisible,
        isRegisterOpen,
        handlerOpenSidebar,
        handlerCloseSideBar,
        handlerRegisterOpen,
        handlerRegisterClose,
      }}
    >
      {children}
    </HomeContext.Provider>
  );
};

export default HomeProvider;
