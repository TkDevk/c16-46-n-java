import React, { useState } from "react";
import LoginForm from "./forms/LoginForm";

const SideBar = ({ isOpen }) => {
  const [open, setOpen] = useState(isOpen);
  return (
    <aside
      className={`fixed top-0 right-0 z-40 md:w-2/5 lg:w-1/4 w-10/12 h-screen shadow-lg duration-500 p-4 transition-transform ${
        open ? "" : "translate-x-full"
      }`}
    >
      {/* CLOSE BUTTON */}
      <button
        className="absolute px-2 py-0.5 top-2 rounded-full bg-gray-200 z-10"
        onClick={() => setOpen(false)}
      >
        x
      </button>

      <h3 className="absolute w-full text-center top-3 text-gray-700 font-bold">Titulo...</h3>

      <div className="w-full h-full m-2 mt-10 p-2">
        {/* ADD CONTENT / FORM HERE */}
        <LoginForm />
      </div>
    </aside>
  );
};

export default SideBar;
