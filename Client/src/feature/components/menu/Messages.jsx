import CardMesagge from "../cards/CardMesagge"


const Messages = ()=>{
    return (
        <>
          <h3 className="absolute w-full text-center top-3 text-gray-700 font-bold">Mensajes</h3>
          <div className="w-full p-2 flex flex-col">
            <CardMesagge />
            {/* JUST FOR TESTING --> DELETE LATER */}
            <CardMesagge />
            <CardMesagge />

          </div>
          <button className="w-full absolute bottom-[10svh] bg-sky-900 text-white p-1"> Ir al Chat</button>
        </>
    )
}
export default Messages