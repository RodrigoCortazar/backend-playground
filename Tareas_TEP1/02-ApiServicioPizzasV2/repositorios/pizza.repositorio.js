// Esta es la capa donde se persisten los datos

// Simulacion retardo:
let sleep = (ms) => new Promise((resolve)=>setTimeout(resolve,ms))
let contadorId=4
export let pizzas = [
    {id:1,nombre:"Hawaina",descripcion:"Jamon y piña"},
    {id:2,nombre:"Pepperoni",descripcion:"Pepperoni y tomate"},
    {id:3,nombre:"Mexicana",descripcion:"Tomate, frijoles, ..."},
    {id:4,nombre:"CUartaPizzas",descripcion:"Datos 4taaa"},
]
/**
 * Retorna una lista de las pizzas
 * @returns []
 */
export async function obtenerTodasLasPizzasAsync(){
    await sleep()
    return pizzas
}


export async function obtenerPizzaPorIdAsync(id){
    const pizza = pizzas.find(x=>x.id==id)
    return pizza
}


export async function agregarPizzaAsync(pizza){
    await sleep(1000)
    contadorId=contadorId+1
    pizza["id"]= contadorId
    pizzas.push(pizza)
    return  contadorId
}


export async function actualizarPizzaAsync(id,pizza){
    console.log(`Funcion actualizaPizzaAsync`)
    const index = pizzas.findIndex(x=>x.id==id)
    if(index==-1){
        return undefined
    }
    pizzas[index].nombre = pizza.nombre
    pizzas[index].descripcion = pizza.descripcion
    return pizzas[index]
}

export async function eliminarPizzaAsync(id,pizza){
    const index = pizzas.findIndex(x=>x.id==id)
    pizzas.splice(index,1)
}