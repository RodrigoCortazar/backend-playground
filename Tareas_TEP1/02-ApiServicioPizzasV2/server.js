import express from "express"
import cors from "cors"
import path from "path";
import { fileURLToPath } from "url";
import {obtenerTodasLasPizzasAsync,obtenerPizzaPorIdAsync,pizzas, eliminarPizzaAsync, agregarPizzaAsync} from "./repositorios/pizza.repositorio.js"
import { type } from "os";


const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const PORT = 3001
const app = express()

// Motor de vistas
app.set("view engine","ejs")
app.set("views",path.join(__dirname,"views"))

// Middlewares
    //JSON
app.use(express.json())
    // Generacion de logs en consola
app.use((req,res,next)=>{
    const fechaHora = new Date().toLocaleDateString(
        "es-MX",{
            day: "2-digit",
            month: "2-digit",
            year: "numeric",
            hour: "2-digit",
            minute: "2-digit"
        }
    )
    console.log(`${req.method} ${req.url}    (${fechaHora})`)
        //\t Referer: ${req.headers.referer}
        //\t User-Agent: ${req.headers["user-agent"]}`)
    if (req.body!=undefined){
        console.log(req.body)
    }
    next()
})
    // Archivos publicos
app.use(express.static(path.join(__dirname,"public")))




// Rutas
app.get("/",(req,res)=>{
    res.render("index")
})

app.get("/api/v1/pizzas",async(req,res)=>{
    const pizza = await obtenerTodasLasPizzasAsync()
    res.status(200).json(pizza) 
})
app.get("/api/v1/pizzas/:id",async(req,res)=>{
    let id = req.params.id
    console.log(id)
    const pizzaid = await obtenerPizzaPorIdAsync(id)
    if(pizzaid==undefined){
        res.status(500).json({message:"Ninguna pizza con el id dado"})
    }
    console.log(pizzaid)
    res.status(200).json(pizzaid)
})

app.delete("/api/v1/pizzas/:id",async(req,res)=>{
    let id = req.params.id
    console.log(id)
    let pizzaid = await obtenerPizzaPorIdAsync(id)
    if(pizzaid==undefined){
        res.status(500).json({message:"Error -> El id dado no corresponde a ninguna pizza."})
    }else{
        let m = await eliminarPizzaAsync(id,pizzaid)
        res.json({message:"Elemento eliminado"})
    }
})

app.post("/api/v1/pizzas",async(req,res)=>{
    const b = req.body
    console.log("Body")
    console.log(b)
    console.log(req.body.test)
    let idp= await agregarPizzaAsync(b)
    res.json({message:`Elemento agregado con id: ${idp}`})
})

app.listen(PORT,()=>{
    console.log(`Corriendo en http://127.0.0.1:${PORT}`)
})