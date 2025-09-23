### Implementacion de Listar

He implementado el boton listar de esta manera

- En el archivo **FichaViewController.java** : 

```java
    @FXML 
    private Button btnListar;

    //Prueba Listar 
    @FXML
    void listar(ActionEvent event){
        institutoController.listarAlumnos();
    }
```

- En el archivo **InstitutoController.java** :

```java
    public void listarAlumnos(){
    model.listarAlumnos();
    }
```

> He estado debugeando el código y funciona pero no devuelve nada a la vista

---

### Dudas

Te comento algunas dudas que me han surgido

- Porque el archivo **FichaViewController.java** se llama asi y no **FichaView.java**
- En **App.java** para que sirve esta instancia 
  ```java
    //Instancio el controlador
    InstitutoController controller = new InstitutoController();
  ```
- En **InstitutoFactory.java** no termino de entender este código
  ```java
    public static Instituto obtener(){
        return obtener(Acceso.MOCK);
    }

    public static Instituto obtener(Acceso acceso){
        if(instituto == null){
        inicializar(acceso);
        }

        return instituto;
    }
    ```
- En **InstitutoController.java** no comprendo este código 
  ```java
        private Scene cargarVista(String ficheroView) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ficheroView));
        Parent root = (Parent)fxmlLoader.load();  

        //Obtengo el controlador de la vista para pasarle una referencia al controlador - MVC:
        FichaViewController viewController = fxmlLoader.<FichaViewController>getController();
        viewController.setInstitutoController(this);
        Scene scene = new Scene(root); 
        
        return scene;
    }
  ```