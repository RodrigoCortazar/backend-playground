const express = require("express");
const path = require("path");


const PORT = 3001;
const app = express();

app.use
app.set("views",path.join(__dirname,"views"));
app.set("view engine","ejs");

app.get("/",(req,res)=>{
    res.render("index",{port:PORT})
});

app.get("/api/v1/pizzas",(req,res)=>{
    const j = [
        {
            id:1,
            nombre:"Pepperoni"
        },
        {
            id:2,
            nombre:"Napolitana"
        },
        {
            id:3,
            nombre:"Hawaiana"
        },
        {
            id:4,
            nombre:"Cuatro Quesos"
        }
    ];
    res.status(200).json(j);
});


app.get("/api/v1/tamanios",(req,res)=>{
    const j = [
        {
            tamanio:"Individual",
            rebanadas:"4"
        },
        {
            tamanio:"Mediana",
            rebanadas:"6"
        },
        {
            tamanio:"Grande",
            rebanadas:"8"
        },
        {
            tamanio:"Familiar",
            rebanadas:"12"
        }
    ]
    res.status(200).json(j)
});


app.get("/api/v1/bebidas",()=>{
    const j = [
        {
            id:1,
            nombre: "Boing Mango",
            tamaño:"600ml"
        },
        {
            id:2,
            nombre: "Coca Cola",
            tamaño:"600ml"
        },
        {
            id:3,
            nombre: "Pepsi",
            tamaño:"600ml"
        },
    ]
    res.status(200).json(j)
});

app.listen(PORT,()=>{
    console.log(`Escuchando en el puerto ${PORT}`)
});