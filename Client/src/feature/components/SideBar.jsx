import React, { useState } from "react";

const SideBar = ({ isOpen }) => {
  const [open, setOpen] = useState(isOpen);
  return (
    <aside
      className={`fixed top-0 right-0 z-40 md:w-2/5 lg:w-1/4 w-10/12 h-screen bg-gray-300 duration-500 p-4 transition-transform ${
        open ? "" : "translate-x-full"
      }`}
    >
      {/* CLOSE BUTTON */}
      <button
        className="absolute p-2 top-2 rounded-full bg-gray-400"
        onClick={() => setOpen(false)}
      >
        x
      </button>

      <h3 className="absolute w-full text-center top-2">Default Title</h3>

      <div className="w-full h-full m-2 p-2">
        {/* ADD CONTENT / FORM HERE */}
      </div>
    </aside>
  );
};

export default SideBar;
