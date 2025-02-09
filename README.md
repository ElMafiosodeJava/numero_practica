# Práctica Servidor - Cliente en Java

Este proyecto implementa una arquitectura cliente-servidor en Java utilizando hilos para manejar múltiples conexiones.

## 📁 Estructura del Proyecto

```
PRÁCTICA_SERVIDOR/
├── numero_practica/
│   ├── .vscode/                # Configuración de VS Code
│   ├── bin/                    # Archivos compilados
│   ├── lib/                    # Dependencias del proyecto
│   ├── src/                    # Código fuente
│   │   ├── net/salesianos/
│   │   │   ├── client/         # Código relacionado con el cliente
│   │   │   │   ├── threads/    # Manejadores de hilos del cliente
│   │   │   │   │   ├── ServerListener.java
│   │   │   │   ├── ClientApp.java
│   │   │   ├── server/         # Código relacionado con el servidor
│   │   │   │   ├── threads/    # Manejadores de hilos del servidor
│   │   │   │   │   ├── ClientHandler.java
│   │   │   │   ├── ServerApp.java
│   │   │   ├── utils/          # Utilidades adicionales
├── .gitattributes              # Configuración de Git
├── .gitignore                  # Archivos ignorados por Git
├── LICENSE                     # Licencia del proyecto
├── README.md                   # Documentación del proyecto
├── numero_practica.zip         # Archivo comprimido del proyecto
```

### 🔧 Compilación y Ejecución

#### 1️⃣ Compilar el Proyecto
```sh
javac -d bin -sourcepath src src/net/salesianos/server/ServerApp.java
javac -d bin -sourcepath src src/net/salesianos/client/ClientApp.java
```

#### 2️⃣ Ejecutar el Servidor
```sh
java -cp bin net.salesianos.server.ServerApp
```

#### 3️⃣ Ejecutar el Cliente
```sh
java -cp bin net.salesianos.client.ClientApp
```

## 🛠️ Funcionalidades
- Manejo de múltiples clientes simultáneamente utilizando **hilos**.
- Comunicación entre cliente y servidor a través de **sockets**.
- Modularización del código en paquetes para mejor organización.
- Posibilidad de ampliar la funcionalidad agregando nuevas clases en `utils/`.

## 📜 Licencia
Este proyecto está licenciado bajo la licencia The unlicense. Consulta el archivo `LICENSE` para más detalles.

## 👨‍💻 Autor
Desarrollado por [ElMafiosodeJava](https://github.com/ElMafiosodeJava). ¡Siéntete libre de contribuir! 🚀
