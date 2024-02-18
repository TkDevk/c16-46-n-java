import NavBar from "./feature/components/NavBar";
//import RegisterForm from "./feature/components/forms/RegisterForm"
import SideBar from "./feature/components/SideBar";
import SearchBar from "./feature/components/SearchBar";

function App() {

  return (
    <div className="w-full h-full flex flex-col">
      <div className="w-full">
        <NavBar />
        <SideBar />
      </div>

      <div className="w-full mt-20">
        <SearchBar />
      </div>
    </div>
  );
}

export default App;
