const API_URL="http://127.0.0.1:3000/animales";

export async function getAnimales(){
    const response = await fetch(API_URL);
    return response.json();
}