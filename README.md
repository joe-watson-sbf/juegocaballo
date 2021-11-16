# Juego de Caballos

- Build with:

      Gradle, Java 11
      
# Peticiones


- Crear Juego : 
  
  **Method:** POST
  
  *uri:* http://localhost:8080//juego/createGame
  
  **Json Format:**
  
        {
          "jinetes": [
              {
                  "nombre": "Joe Watson SBF",
                  "colorCaballo": "Black and White"
              },
              {
                  "nombre": "Beycker",
                  "colorCaballo": "Gray"
              },
              {
                  "nombre": "Juan",
                  "colorCaballo": "BLACK"
              },
              {
                  "nombre": "Camilo",
                  "colorCaballo": "Black and White"
              },
              {
                  "nombre": "John",
                  "colorCaballo": "Black and White"
              }

          ],
          "kilometros": 20
      }


- Iniciar Juego : Con WebSocket
  
  *uri:* ws://localhost:8080/startGame 
  
    Solo envie el id del juego como mensaje
        
        
  *Ejemplo en POSTMAN* :
  
  ![image](https://user-images.githubusercontent.com/49710538/142034072-4c08f0fb-fc44-4b9f-813c-e0804e3eec5d.png)

  
  
  
