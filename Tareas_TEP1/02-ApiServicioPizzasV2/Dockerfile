# Imagen base de Node.js
FROM node:20

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar archivos de dependencias
COPY package*.json ./

# Instalar dependencias
RUN npm install

# Copiar el resto del proyecto
COPY . .

# Puerto que utiliza la aplicación
EXPOSE 3001

# Iniciar servidor
CMD ["node", "server.js"]