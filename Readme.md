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