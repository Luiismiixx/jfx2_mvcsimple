package es.etg.prog.mvc.controller;

import java.io.IOException;

import es.etg.prog.mvc.App;
import es.etg.prog.mvc.model.Acceso;
import es.etg.prog.mvc.model.Alumno;
import es.etg.prog.mvc.model.Instituto;
import es.etg.prog.mvc.model.InstitutoFactory;
import es.etg.prog.mvc.view.FichaViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InstitutoController extends Application{

    // Referencia a la interfaz gráfica para cargarla
    private final static String VIEW_MAIN = "view/fichaView.fxml";
    private static Scene scene;

    //Lógica de negocio (modelo)
    private static Instituto model;

    
    // Este método se llama al ejecutar lanzar la aplicación
    // Carga la pantalla inicial
    // Carga el modelo
    @Override
    public void start(Stage stage) throws IOException {

        //Inicializo el modelo
        model = InstitutoFactory.obtener(Acceso.MOCK);

        //Cargo la vista
        stage.setScene(cargarVista(VIEW_MAIN));
        stage.show();
    }

    private Scene cargarVista(String ficheroView) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ficheroView));
        Parent root = (Parent)fxmlLoader.load();  

        //Obtengo el controlador de la vista para pasarle una referencia al controlador - MVC:
        FichaViewController viewController = fxmlLoader.<FichaViewController>getController();
        viewController.setInstitutoController(this);
        Scene scene = new Scene(root); 
        
        return scene;
    }

    


    //Métodos de acceso al modelo

    public Alumno crearAlumno(String nombre, String apellidos){

        Alumno al = new Alumno(nombre, apellidos);
        model.matricular(al);

        return al;
    }


    public void listarAlumnos(){
        model.listarAlumnos();
    }
    
}
