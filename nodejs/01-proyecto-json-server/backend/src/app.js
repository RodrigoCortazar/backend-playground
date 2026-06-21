import express from "express";
import path from "path"
const app = express();

// Servir carpeta de archivos estaticos
app.use(express.static(path.join(process.cwd(), "public")));
app.get("/",(req,res)=>{
    res.sendFile(path.join(process.cwd(),"public","index.html"))
})


export default app;
