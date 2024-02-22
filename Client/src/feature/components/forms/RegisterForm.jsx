import { useContext, useState } from "react";
import { IoCloseCircleOutline } from "react-icons/io5";
import { HomeContext } from "../../../context/HomeContext";

const RegisterForm = () => {
  // taken from context
  const { isRegisterOpen, handlerRegisterClose } = useContext(HomeContext);

  const [inputName, setInputName] = useState("");
  const [inputLastName, setInputLastName] = useState("");
  const [inputEmail, setInputEmail] = useState("");

  //    const [inputLocation, setInputLocation] = useState('');
  const onSubmit = (e) => {
    if (inputName && inputEmail && inputLastName) {
      e.preventDefault();
      setInputName("");
      setInputEmail("");
      setInputLastName("");
    } else {
      alert("Por favor introduce la informacion requerida");
    }
  };

  const handleName = (e) => {
    setInputName(e.target.value);
  };

  const handleEmail = (e) => {
    setInputEmail(e.target.value);
  };
  const handleLastName = (e) => {
    setInputLastName(e.target.value);
  };

  return (
    <div
      className={`w-full h-full flex items-center justify-center fixed top-0 left-0 z-30 ${
        !isRegisterOpen && "collapse"
      }`}
    >
      <form
        onSubmit={onSubmit}
        className="w-3/4 py-4 bg-white border border-neutral-400 shadow-lg shadow-neutral-400 flex flex-col
        lg:p-4 gap-4 bg-#fff rounded r-0 z-30 overflow-y-auto"
      >
        <IoCloseCircleOutline
          onClick={handlerRegisterClose}
          style={{ fontSize: "1.8rem", cursor: "pointer" }}
          className="mx-4"
        />

        <section className="flex flex-wrap lg:mb-6">
          <article className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label
              className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
              htmlFor="grid-first-name"
            >
              Nombre
            </label>

            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
              id="grid-first-name"
              placeholder="Nombre..."
              type="text"
              value={inputName}
              onChange={handleName}
            />
            <p className="text-red-500 text-xs italic">
              Por favor llena este espacio.
            </p>
          </article>
          <article className="w-full md:w-1/2 px-3">
            <label
              className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
              htmlFor="grid-last-name"
            >
              Apellido
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="grid-last-name"
              placeholder="Apellido..."
              type="text"
              value={inputLastName}
              onChange={handleLastName}
            />
          </article>
        </section>
        <section className="flex flex-wrap lg:mb-6">
          <article className="w-full px-3">
            <label
              className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
              htmlFor="grid-password"
            >
              Email
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              id="grid-password"
              name="email"
              placeholder="Email..."
              type="text"
              value={inputEmail}
              onChange={handleEmail}
            />
            <p className="text-gray-600 text-xs italic">Introduce tu email</p>
          </article>
        </section>
        <section className="flex flex-wrap lg:mb-6">
          <article className="w-full px-3">
            <label
              className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
              htmlFor="grid-password"
            >
              Contraseña
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
              type="password"
              placeholder="******************"
            />
            <p className="text-gray-600 text-xs italic">
              Digita una contraseña
            </p>
          </article>
        </section>
        <section className="flex flex-wrap mb-2 justify-between w-full">
          <article className="w-full md:w-1/3 px-3 mb-6 md:mb-0">
            <article className="relative ">
              <select
                className="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                id="grid-state"
              >
                <option>Argentina</option>
                <option>Colombia</option>
                <option>Peru</option>
              </select>
              <article className="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
                <svg
                  className="fill-current h-4 w-4"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 20 20"
                >
                  <path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
                </svg>
              </article>
            </article>
          </article>
          <article className="lg:right-0 mx-4">
            <button className="p-3 bg-sky-500 text-white rounded md:h-12">
              Registrarse
            </button>
          </article>
        </section>
      </form>
    </div>
  );
};

export default RegisterForm;

/**
 <form 
           onSubmit={onSubmit}
           className="fixed self-end h-screen top-10 right-[40%] flex flex-col gap-4 bg-stone-200 rounded r-0 top-12vh p-4 z-70">
              <section>
                  <label htmlFor="name"></label>
                  <input 
                  name="name"
                  placeholder="Name..."
                  className="p-4 rounded"
                  type="text" 
                  value={inputName}
                  onChange={handleName}
                  />
              </section>
              <section>
                  <label htmlFor="email"></label>
                  <input 
                  name="email"
                  placeholder="Email..."
                  className="p-4 rounded"
                  type="text" 
                  value={inputEmail}
                  onChange={handleEmail}
                  />
              </section>
              <section>
                  <label htmlFor="location"></label>
                  <input 
                  name="location"
                  placeholder="City..."
                  className="p-4 rounded"
                  type="text" 
                  value={inputLocation}
                  onChange={handleLocation}
                  />
              </section>
              <button
              className="p-4 border-none bg-cyan-800 self-center decoration-white text-white"
              > Submit 
              </button>
           </form>

 */
