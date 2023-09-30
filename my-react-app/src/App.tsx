import axios from "axios"
import { useEffect } from "react"

function App() {
    useEffect(()=>{
      axios.get("http://localhost:8085/categories").then(resp=>{
        console.log('resp = ' + resp.data)
      }

      );
    },[])

  return (
    <>
      <h1>Головна сторінка</h1>
    </>
  )
}

export default App
