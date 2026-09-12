console.log("script peticones.js en progreso")
const btn_solicitud = document.getElementById("btn-enviar")
const inpId = document.getElementById("inp-id")
const txa_solicitud = document.getElementById("txa_solicitud")
const txa_respuesta = document.getElementById("txa-respuesta")
const api = "/api/v1/pizzas"


const setearInputs = () => {
    let metodo = document.querySelector('input[name="metodo"]:checked').value
    switch(metodo){
        case "GET":
            inpId.disabled=true;
            txa_solicitud.disabled=true;
            break;
        case "GETID":
            inpId.disabled=false;
            txa_solicitud.disabled=true;
            break;
        case "POST":
            inpId.disabled=true;
            txa_solicitud.disabled=false;
            break;
        case "DELETE":
            inpId.disabled=false;
            txa_solicitud.disabled=true;
            break;
        case "PUT":
            inpId.disabled=false;
            txa_solicitud.disabled=false;
            break;
    }
}
document.querySelectorAll('input[name="metodo"]').forEach(e=>{
    e.addEventListener("click",setearInputs)
})






const realizarPeticion = () => {
    const metodo = document.querySelector('input[name="metodo"]:checked')
    // console.log("VAlor metodo: ",metodo.value)
    // console.log("valor:",txa_solicitud.value)
    // console.log("metodo -> realizarPeticion")
    switch(metodo.value){
        case "GETID":
            metodoGetConId();
            break;
        case "GET":
            metodoGet();
            break;
        case "POST":
            metodoPost();
            break;
        case "DELETE":
            metodoDelete();
            break;
        case "PUT":
            metodoPut();
            break;

    }


}


const metodoGet = () => {
    console.log("\tmetodo http -> get")
    fetch(api)
        .then(res=>{
            return res.json()
        })
        .then(data=>{
            
            txa_respuesta.value=JSON.stringify(data)
            
        })
}

const metodoGetConId = () => {
    console.log("\tmetodo http -> get + id")
    console.log(inpId.value)
    fetch(`${api}/${inpId.value}`)
        .then(res=>{
            return res.json()
        })
        .then(data=>{
            console.log("datos: ",data)
            txa_respuesta.value=JSON.stringify(data)
            
        })
}

const metodoPost = () => {
    console.log("post")
}

const metodoDelete = () => {
    console.log("delete")
    console.log(inpId.value)
    fetch(`${api}/${inpId.value}`, {method: "DELETE"})
        .then(res=>{
            return res.json()
        })
        .then(data=>{
            console.log("datos: ",data)
            txa_respuesta.value=JSON.stringify(data)
            
        })
}
const metodoPut = () => {
    console.log("put")
}


btn_solicitud.addEventListener("click",()=>{
    realizarPeticion()
})