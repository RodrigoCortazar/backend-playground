const btnObtPizzas = document.getElementById("btn-get-pizzas");
const btnObtPById = document.getElementById("btn-get-pizzas-id");
const formPizzaById =document.getElementById("form-id");
const contenedorPizzas = document.getElementById("pizza-container");
const inp_id = document.getElementById("inp-id");
const contenedorPizzaId = document.getElementById("pizza-container-id");
const apiRutaBase = "http://127.0.0.1:8080/api/v1/pizzas";


btnObtPizzas.addEventListener("click",async ()=>{
    contenedorPizzas.innerHTML="";
    const response = await fetch(apiRutaBase+"/getall");
    const jsonR = await response.json();
    for(let elemento of jsonR){
        const div = document.createElement("div");
        div.classList.add("tarjeta-pizza")
        div.innerHTML=`
        <h2>${elemento.nombre} - ${elemento.tamanio} </h2>
        <p>ID: ${elemento.id}</p>
        <p>Precio: ${elemento.precio}</p>
        <p>Descripcion: ${elemento.descripcion}</p>
        `;
        contenedorPizzas.appendChild(div);
    }
})


formPizzaById.addEventListener("submit",(event)=>{
    event.preventDefault()
})

btnObtPById.addEventListener("click", async()=>{
    console.log("Metodo getbyid")
    const response = await fetch(apiRutaBase+`/getbyid/${inp_id.value}`);
    if(response.status!=302){
        console.log("Id invalido")
        contenedorPizzaId.style.display="none";
        ip_id.value="Id invalido"
        return;
    }else{
        const rjson = await response.json();
        contenedorPizzaId.style.display="inline-block";
        contenedorPizzaId.innerHTML = `
                <h2>${rjson.nombre} - ${rjson.tamanio}</h2>
                <p>ID: ${rjson.id}</p>
                <p>Precio:${rjson.precio}</p>
                <p>Descripcion: ${rjson.descripcion}</p>
        `;


    }

})