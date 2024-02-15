
import { FcHome } from "react-icons/fc";
import { PiCalendarDuotone } from "react-icons/pi";
import { MdOutlineNotificationsActive } from "react-icons/md";
import { BiMessageRoundedDots } from "react-icons/bi";
import { BsPersonCircle } from "react-icons/bs";
import { CgMenuRound } from "react-icons/cg";
import {Link} from 'react-router-dom'

const NavBar = () => {

  return (
    <>
      <nav className={`absolute top-0 w-full h-12vh flex p-3 pr-3 pl-5 justify-between z-60`}>
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
          <Link to="/calendar">
            <picture>
              <PiCalendarDuotone style={{fontSize:'2rem', cursor:'pointer'}}/>
            </picture>
          </Link>
          <Link to="/notifications" name={'notifications'}>
            <picture>
              <MdOutlineNotificationsActive style={{fontSize:'2rem', cursor:'pointer'}}/>
            </picture>
          </Link>
          <Link to="/messages" name={'messages'}>
            <picture>
              <BiMessageRoundedDots style={{fontSize:'2rem', cursor:'pointer'}}/>
            </picture>
          </Link>
          <Link to="/settings" name={'settings'}>
            <picture>
              <CgMenuRound style={{fontSize:'2rem', cursor:'pointer'}}/>
            </picture>
          </Link>
          <Link to="/login" name={'login'}>
            <picture>
              <BsPersonCircle style={{fontSize:'2rem', cursor:'pointer'}}/>
            </picture>
          </Link>
        </section>
      </nav>
    </>
  );
};

export default NavBar;
