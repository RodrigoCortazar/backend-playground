import { getAnimales } from "./api/animales.api.js";
const elementos = await getAnimales()
const btnPerro=document.getElementById("btnPerro")
const btnGato=document.getElementById("btnGato")
const btnConejo=document.getElementById("btnConejo")
const parrafo=document.getElementById("p-animal")
const img=document.getElementById("img-animal")
btnPerro.addEventListener("click",()=>{
    console.log("btn-perro")
    for(let valor of elementos){
        if (valor.nombre=="Perro"){
            let descripcion=valor.descripcion;
            parrafo.innerText=descripcion;
            img.setAttribute("src","http://127.0.0.1:3000/"+valor.url_imagen)
            break;
        }
    }

    
})

btnGato.addEventListener("click",()=>{
    console.log("btn-perro")
    for(let valor of elementos){
        if (valor.nombre=="Gato"){
            let descripcion=valor.descripcion;
            parrafo.innerText=descripcion;
            img.setAttribute("src","http://127.0.0.1:3000/"+valor.url_imagen)
            break;
        }
    }

    
})

btnConejo.addEventListener("click",()=>{
    console.log("btn-conejo")
    for(let valor of elementos){
        if (valor.nombre=="Conejo"){
            let descripcion=valor.descripcion;
            parrafo.innerText=descripcion;
            img.setAttribute("src","http://127.0.0.1:3000/"+valor.url_imagen)
            break;
        }
    }

    
})