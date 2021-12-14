/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada1_3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ada1_3.Ventanas.ManipuladorListas;
/**
 * FXML Controller class
 *
 * @author luis_
 */
public class EntradaArchivosController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
       
    @FXML
    private Button btnMaestros;

    @FXML
    private Button btnAsignaturas;

    @FXML
    private TextField txtMaestros;
    
    @FXML
    private TextField txtAsignatura;
    
    @FXML
    private Button btnAceptar;
    
    
    @FXML
    private Button btnCancelar;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    void btnMaestrosAccion(ActionEvent event) {
        
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar Archivo Maestros");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("CSV", "*.csv")
            );
            Node source = (Node) event.getSource();   
            File archivo = fileChooser.showOpenDialog(source.getScene().getWindow());
            txtMaestros.setText(archivo.getAbsolutePath());
            ManipuladorListas.ArchivoMaestros = archivo;
            Manipulador csv;
            csv = new ManipuladorCSV();
            csv.leerMaestros(archivo);
            
        }catch(Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Seleccionar Archivo Maestros");
            alerta.setContentText("No se pudo abrir el archivo");
            alerta.showAndWait(); 
        }
    }

    @FXML
    void btnAsignaturasAccion(ActionEvent event) {
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar Archivo Asignaturas");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("CSV", "*.csv")
            );
            Node source = (Node) event.getSource();   
            File archivo = fileChooser.showOpenDialog(source.getScene().getWindow());
            txtAsignatura.setText(archivo.getAbsolutePath());
            ManipuladorListas.ArchivoAsignatura = archivo;
            Manipulador csv;
            csv = new ManipuladorCSV();
            csv.leerAsignaturas(archivo);
        }catch(Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Seleccionar Archivo Asignaturas");
            alerta.setContentText("No se pudo abrir el archivo");
            alerta.showAndWait(); 
        }
    }
    
    @FXML
    void btnAceptarAccion(ActionEvent event) throws IOException {
       if(ManipuladorListas.ArchivoAsignatura != null && ManipuladorListas.ArchivoMaestros != null){
           Parent root = FXMLLoader.load(getClass().getResource("Ventanas/ListaMaestros.fxml"));
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
       }
    }

    @FXML
    void btnCancelarAccion(ActionEvent event) {
       ManipuladorListas.ArchivoAsignatura = null;
       ManipuladorListas.ArchivoMaestros = null;
       ManipuladorListas.Todasasignaturas = null;
       ManipuladorListas.maestros = null;
       txtAsignatura.setText("");
       txtMaestros.setText("");
    }
}
