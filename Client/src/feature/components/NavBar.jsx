
import { FcHome } from "react-icons/fc";
import { PiCalendarDuotone } from "react-icons/pi";
import { MdOutlineNotificationsActive } from "react-icons/md";
import { BiMessageRoundedDots } from "react-icons/bi";
import { BsPersonCircle } from "react-icons/bs";
import { CgMenuRound } from "react-icons/cg";

const NavBar = () => {
  return (
    <>
      <nav className={`absolute top-0 w-full h-12vh flex p-3 pr-5 pl-5 justify-between`}>
        <section className="flex">
          <h1 className="flex text-xl">
            <a href="./">
                <picture 
                >
                <FcHome 
                style={{fontSize:'2.5rem'}}/>                
                </picture>
                <span className={`absolute top-5 pl-12`}
                >TUVIVIENDA.com</span>
            </a>
          </h1>
        </section>
        <section className="flex p-2 border border-black rounded-full
        gap-4
        ">
          <picture >
            <PiCalendarDuotone style={{fontSize:'2rem', cursor:'pointer'}}/>
          </picture>
          <picture>
            <MdOutlineNotificationsActive style={{fontSize:'2rem', cursor:'pointer'}}/>
          </picture>
          <picture>
            <BiMessageRoundedDots style={{fontSize:'2rem', cursor:'pointer'}}/>
          </picture>
          <picture>
            <CgMenuRound style={{fontSize:'2rem', cursor:'pointer'}}/>
          </picture>
          <picture>
            <BsPersonCircle style={{fontSize:'2rem', cursor:'pointer'}}/>
          </picture>
        </section>
      </nav>
    </>
  );
};

export default NavBar;
