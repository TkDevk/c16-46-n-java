import React from "react";
import { useHome } from "../hooks/useHome";
import { HomeContext } from "./HomeContext";

const HomeProvider = ({ children }) => {
  const { sidebarVisible, handlerOpenSidebar, handlerCloseSideBar } = useHome();

  return (
    <HomeContext.Provider
      value={{
        sidebarVisible,
        handlerOpenSidebar,
        handlerCloseSideBar,
      }}
    >
      {children}
    </HomeContext.Provider>
  );
};

export default HomeProvider;
