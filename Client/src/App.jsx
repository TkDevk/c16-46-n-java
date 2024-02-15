import NavBar from "./feature/components/NavBar"
//import RegisterForm from "./feature/components/forms/RegisterForm"
import SideBar from "./feature/components/SideBar"


function App() {

  return (
    <>
    <NavBar />
      <SideBar 
      isOpen={true}>
     </SideBar>   
    </>
  )
}

export default App
