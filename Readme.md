# Examen

```mermaid
sequenceDiagram
    participant Model
    box gray Controlador
    participant ObserverGasolina
    participant Controller
    end
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
    Model->>ObserverGasolina:update(Coche)
    activate ObserverGasolina
    ObserverGasolina->>View: alarmaGasolina()
    deactivate ObserverGasolina
    activate View
    View->>View:System.out.println
    deactivate View
    Model-->>Controller:Coche
    deactivate Model
    Controller-->>View:Coche
    deactivate Controller
    deactivate View
```

```mermaid
sequenceDiagram
    participant Model
    box gray Controlador
    participant ObserverGasolina
    participant Controller
    end
    participant View
    
    activate View
    View->>Controller:repostar(int metros)
    activate Controller
    Controller->>View:pedirMatricula(String)
    activate View
    View-->>Controller:String
    deactivate View
    Controller->>Model:repostar(int metros, String matricula)
    activate Model
    Model->>ObserverGasolina:update(Coche)
    activate ObserverGasolina
    ObserverGasolina->>View: alarmaGasolina()
    deactivate ObserverGasolina
    activate View
    View->>View:System.out.println
    deactivate View
    Model-->>Controller:Coche
    deactivate Model
    Controller-->>View:Coche
    deactivate Controller
    deactivate View
```

### Explicaciones:
* La clase ObserverGasolina es una clase que solo tiene un metodo `update` que recibe un coche
 y compreuba si ese coche tiene una cantidad de gasolina inferior a 10 que es una constante en 
 la clase ObserverGasolina. Si es menor llama a una alarma en la View si no no hace nada
* Tambien solucione un problema en el controller en el que las funciones avanzar y repostar
enviaban el mensaje incorrecto al preguntar por la matricula del coche



### Imagenes del funcionamiento:
![observerFunciona.png](img/observerFunciona.png)  
![ObserverFuncionRepostar.png](img/ObserverFuncionRepostar.png)
# Examen-Anterior
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