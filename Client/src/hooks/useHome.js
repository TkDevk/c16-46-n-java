import { useState } from "react";

export const useHome = () => {
  const [sidebarVisible, setSidebarVisible] = useState(false);

  // FORMULARIO VISIBLE
  const handlerOpenSidebar = () => {
    setSidebarVisible(true);
  };

  const handlerCloseSideBar = () => {
    setSidebarVisible(false);
  };

  return {
    sidebarVisible,
    handlerOpenSidebar,
    handlerCloseSideBar
  };
};
