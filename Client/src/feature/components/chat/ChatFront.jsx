import { GrSend } from "react-icons/gr";
import { IoMdClose } from "react-icons/io";
import { FaRegWindowMinimize } from "react-icons/fa";
import { FiSearch } from "react-icons/fi";
import { SlPaperClip } from "react-icons/sl";
import { FaCameraRetro } from "react-icons/fa";
import { MdInsertEmoticon } from "react-icons/md";


const ChatFront = () => {
  return (
    <section className=" absolute flex p-2 top-[8svh] w-full ">
      <aside className=" absolute left-0 w-2/5 p-2 ">
        <h2 className=" top-0">Chats</h2>
        <section className="flex top-10 left-0 p-2">
          <input
          type="text"
          placeholder="Buscar..."/>
          <FiSearch />
        </section>
        
        <ul className="relative w-1/2 p-1 ">
          <li 
          className="" style={{border:'black 1px solid'}}>A</li>
          <li 
          className="" style={{border:'black 1px solid'}}>B</li>
          <li 
          className="" style={{border:'black 1px solid'}}>C</li>
          <li 
          className="5" style={{border:'black 1px solid'}}>D</li>
        </ul>
      </aside>
      <section className="absolute w-2/3 flex flex-col right-0 p-2">
        <section className="bg-sky-900 top-0 absolute flex justify-between p-2 w-2/3">
          <FaRegWindowMinimize className="cursor-pointer" />
          <IoMdClose className="cursor-pointer" />
        </section>
        <section className="h-[50svh] bg-white w-2/3">
          <article className="h-4 bg-green-400 transform rotate-45 origin-bottom-right rounded-sm">
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Numquam
            temporibus eaque ab quibusdam delectus ea aspernatur inventore
            reiciendis quasi cum voluptas accusantium, sint, nesciunt velit unde
            tempora sed odit excepturi?
          </article>
          <article className="h-4 bg-blue-400 transform rotate-45 origin-top-left rounded-sm">
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti
            quam eveniet quaerat veniam nam quo aperiam magnam consequuntur
            voluptas vel repellendus provident facere nesciunt perferendis ipsum
            neque facilis, dolores excepturi!</p>
          </article>
        </section>
        <section className="bg-stone-100 flex w-2/3 p-2">
          <input 
          className="bg-stone-200 p-2 bottom-0 outline-none flex-1 rounded" 
          type="text" 
          placeholder="... " 
          />
          <section className="absolute flex right-1/2 self-center gap-5">          
            <SlPaperClip className="cursor-pointer"/>
            <FaCameraRetro className="cursor-pointer"/>
            <MdInsertEmoticon className="cursor-pointer"/>

          </section>

          <button className="gap-x-0.5 justify-center rounded flex bg-sky-900 w-[8svw] p-2 text-white" type="submit">
            Enviar
            <GrSend style={{ color: "#fff", alignSelf:'center' }} />
          </button>
        </section>
      </section>
    </section>
  );
};

export default ChatFront;
