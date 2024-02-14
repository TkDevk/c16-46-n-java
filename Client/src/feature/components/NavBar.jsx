import { FcHome } from "react-icons/fc";
import { PiCalendarDuotone } from "react-icons/pi";
import { MdOutlineNotificationsActive } from "react-icons/md";
import { BiMessageRoundedDots } from "react-icons/bi";
import { BsPersonCircle } from "react-icons/bs";
import { CgMenuRound } from "react-icons/cg";

const NavBar = () => {
  return (
    <>
      <nav>
        <section className="left">
          
          <h1 className="title">
            <a href="">
                <picture 
                style={{bottom:'-3px'}}
                >
                <FcHome 
                style={{fontSize:'2.5rem'}}/>                
                </picture>
                <span
                >TUVIVIENDA.com</span>
            </a>
          </h1>
        </section>
        <section className="right">
          <picture>
            <PiCalendarDuotone style={{fontSize:'2rem'}}/>
          </picture>
          <picture>
            <MdOutlineNotificationsActive style={{fontSize:'2rem'}}/>
          </picture>
          <picture>
            <BiMessageRoundedDots style={{fontSize:'2rem'}}/>
          </picture>
          <picture>
            <CgMenuRound style={{fontSize:'2rem'}}/>
          </picture>
          <picture>
            <BsPersonCircle style={{fontSize:'2rem'}}/>
          </picture>
        </section>
      </nav>
    </>
  );
};

export default NavBar;
