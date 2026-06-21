import app from "./src/app.js"

app.listen(80,()=>{
    console.log("Servidor corriendo en el puerto 3000")
    console.log("Ubicacion del proyecto:\n\t"+process.cwd())
})