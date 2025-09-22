package es.etg.prog.mvc.view;

import es.etg.prog.mvc.controller.InstitutoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class FichaViewController {

    @FXML
    private Button btnCrear;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtNombre;

    //InstitutoController -> Controlador principal de la aplicación (para llamarlo)
    protected InstitutoController institutoController;

    public void setInstitutoController(InstitutoController controller){
        this.institutoController = controller;
    }

    @FXML
    void crear(ActionEvent event) {
        final String MSG_TITLE =  "Error en el formulario";
        final String MSG_CONTENT = "Todos los campos son obligatorios";

        if(camposRellenos()){
            institutoController.crearAlumno(txtNombre.getText(), txtApellidos.getText());
        }else{
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle(MSG_TITLE);
            alerta.setContentText(MSG_CONTENT);
            alerta.show();
        }

    }

    //Prueba Listar 
    void listar(ActionEvent event){
        institutoController.listarAlumnos();
    }

    private boolean camposRellenos(){
        return campoRelleno(this.txtApellidos) && campoRelleno(this.txtNombre);
    }

    private boolean campoRelleno(TextField campo){
        boolean relleno = false;
        if(campo!=null && !"".equals(campo.getText().trim())){
            relleno = true;
        }
        return relleno;
    }

}
