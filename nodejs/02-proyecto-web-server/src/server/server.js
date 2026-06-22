//Configuracion del servidor
const express = require("express")
const path = require("path")
const { start } = require("repl")



const startServer=(options) =>{
    const {port,public_path="public"} = options
    console.log(`Funcion startServer(port:${port}, public_path:${public_path})`)


    const app = express()
    // Para póder usar middlewares  se usa use
    app.use(express.static(public_path)) // Contenido statico

    app.get("/",(req,res)=>{
        const indexPath = path.join(__dirname+`../../../${public_path}/index.html`)
        res.sendFile(indexPath);
    })

    app.listen(port,()=>{
        console.log(`Servidor corriendo en el puerto ${port}: http://localhost:${port}/`)
    });

}


module.exports = {
    startServer
}