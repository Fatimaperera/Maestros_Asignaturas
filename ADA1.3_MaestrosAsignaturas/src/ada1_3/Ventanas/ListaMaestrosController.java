/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada1_3.Ventanas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableCell;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import ada1_3.Maestro;
import ada1_3.Manipulador;
import ada1_3.ManipuladorCSV;
import java.io.File;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author luis_
 */
public class ListaMaestrosController implements Initializable {

    @FXML
    private TableView<Maestro> tabla1;

    @FXML
    private TableColumn<Maestro,String> ColumApellido2;

    @FXML
    private TableColumn<Maestro,String> ColumApellido1;

    @FXML
    private TableColumn<Maestro,String> columCve;

    @FXML
    private TableColumn<Maestro,String> columNombres;
    
    @FXML
    private TableColumn<Maestro, Button> btn;
    
    @FXML
    private Button btnExportar;
    
    @FXML
    void btnExportarAccion(ActionEvent event) {
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar como");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("CSV", "*.csv")
            );
            Node source = (Node) event.getSource();   
            File archivo = fileChooser.showSaveDialog(source.getScene().getWindow());
            Manipulador csv;
            csv = new ManipuladorCSV();
            csv.escribirAsignaturas(archivo);
        }catch(Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Guardar Archivo");
            alerta.setContentText("No se guardó ningún archivo");
            alerta.showAndWait(); 
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Maestro> e = FXCollections.observableList(ManipuladorListas.maestros);
        ColumApellido1.setCellValueFactory(new PropertyValueFactory<Maestro,String>("Apellido1"));
        ColumApellido2.setCellValueFactory(new PropertyValueFactory<Maestro,String>("Apellido2"));
        columCve.setCellValueFactory(new PropertyValueFactory<Maestro,String>("Cve_Empleado"));
        columNombres.setCellValueFactory(new PropertyValueFactory<Maestro,String>("Nombres"));
        btn.setCellValueFactory(new PropertyValueFactory<Maestro,Button>("button"));
        tabla1.getColumns().setAll(columCve,ColumApellido1,ColumApellido2,columNombres,btn);
        tabla1.setItems(e);
    }    
    
}
