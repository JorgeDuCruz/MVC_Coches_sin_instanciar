# Examen

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    activate View
    View->>Controller:avanzar(int metros)
    activate Controller
    Controller->>View:pedirMatricula(String)
    activate View
    View-->>Controller:String
    deactivate View
    
    
    Controller->>Model:avanzar(int metros, String matricula)
    activate Model
    Model-->>Controller:Coche
    deactivate Model
    Controller-->>View:Coche
    deactivate Controller
    deactivate View
```

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    activate View
    View->>Controller:repostar(int litros)
    activate Controller
    Controller->>View:pedirMatricula(String)
    activate View
    View-->>Controller:String
    deactivate View
    
    
    Controller->>Model:repostar(int litros, String matricula)
    activate Model
    Model-->>Controller:Coche
    deactivate Model
    Controller-->>View:Coche
    deactivate Controller
    deactivate View
```

## Con respecto del pseudocódigo previsto:  
* Se ha cambiado los parametros de la funcion de la **View** para mostrar la gasolina de un coche de 
solo recibir la gasolina a recibir tambien la matrícula de ese coche para mejorar el mensaje final.
* El cambio anterior supùso que para poder enviar estos 2 datos la **View** debiera recibir el coche entero
para seleccionar estos datos y enviarlo lo que genero en cascada que todas las demas funciones 
cambien el tipo de dato que retornan. 
* El siguiente cambio con respecto al pseudocódigo ocurre en la clase **Model**, en la funcion para avanzar.
Esto ya que al plantearlo en pseudocódigo pense en usar la misma funcion que modifica la gasolina
para avanzar y para repostar pero como avanzar necesita los datos del coche para calcular la gasolina
consumida se volvia mucho más intuitivo y facil cambiar la gasolina directamente desde la misma funcion.
* Cambio en el menu de la clase **View** añadiendo una opcion para mostrar la gasolina de un coche
por separado para facilitar comprobar la gasolina de un coche en cualquier momento 

# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra


```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    participant App
    App->>View:menu()
    activate View
    View->>Controller:subirVelocidad()
    activate Controller
    Controller->>View:pedirMatricula(String)
    activate View
    View-->>Controller:String
    deactivate View
    Controller->>View:pedirVelocidad(String)
    activate View
    View-->>Controller:int
    deactivate View
    Controller->>Model:CambiarVelocidad(int)
    activate Model
    Model-->>Controller:int
    deactivate Model
    Controller-->>View:String
    deactivate Controller
    deactivate View
```

Crear coche:
```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    participant App
    App->>View:menu()
    activate View
    View->>Controller:crearCoche()
    activate Controller
    Controller->>View:pedirModelo(String)
    activate View
    View-->>Controller:String
    deactivate View
    Controller->>View:pedirVelocidad(String)
    activate View
    View-->>Controller:String
    deactivate View
    Controller->>Model:crearCoche(String,String)
    activate Model
    Model-->>Controller:Coche
    deactivate Model
    Controller-->>View:String
    deactivate Controller
    deactivate View
```