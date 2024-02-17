import { FcHome } from "react-icons/fc";
import { PiCalendarDuotone } from "react-icons/pi";
import { MdOutlineNotificationsActive } from "react-icons/md";
import { BiMessageRoundedDots } from "react-icons/bi";
import { BsPersonCircle } from "react-icons/bs";
import { CgMenuRound } from "react-icons/cg";
import { Link } from "react-router-dom";
import { useContext } from "react";
import { HomeContext } from "../../context/HomeContext";

const sizeFont = "1.5rem";

const navItems = [
  {
    icon: <PiCalendarDuotone style={{ fontSize: sizeFont }} />,
    name: "calendar",
  },
  {
    icon: <MdOutlineNotificationsActive style={{ fontSize: sizeFont }} />,
    name: "notifications",
  },
  {
    icon: <BiMessageRoundedDots style={{ fontSize: sizeFont }} />,
    name: "messages",
  },
  {
    icon: <CgMenuRound style={{ fontSize: sizeFont }} />,
    name: "settings",
  },
  {
    icon: <BsPersonCircle style={{ fontSize: sizeFont }} />,
    name: "login",
  },
];

const NavBar = () => {
  const { handlerOpenSidebar } = useContext(HomeContext);

  return (
    <>
      <nav
        className={`absolute top-0 justify-between right-0 w-full h-12vh flex p-3 pr-3 pl-5 z-60`}
      >
        <section className="flex items-center">
          <a href="./" className="flex">
            <picture>
              <FcHome style={{ fontSize: "1.5rem" }} />
            </picture>
            <h1 className="md:text-xl">
              <span className={`invisible md:visible top-5 pl-4`}>
                TUVIVIENDA.com
              </span>
            </h1>
          </a>
        </section>
        <section className="flex items-center rounded-full gap-4 justify-center">
          {navItems.map((item) => {
            return (
              <Link
                to={`/${item.name}`}
                className="cursor-pointer"
                name={item.name}
                onClick={handlerOpenSidebar}
              >
                <picture>{item.icon}</picture>
              </Link>
            );
          })}
        </section>
      </nav>
    </>
  );
};

export default NavBar;
