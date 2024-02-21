import { useReducer, useState } from "react";
import { usersReducer } from "../reducers/usersReducer";

const initialPost = []

const initialUserData = {
  id: 0,
  username: "",
  email: "",
  password: ""
}

const initialError = {}

export const useHome = () => {

  const [user, dispatch] = useReducer(usersReducer, initialUserData);

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
