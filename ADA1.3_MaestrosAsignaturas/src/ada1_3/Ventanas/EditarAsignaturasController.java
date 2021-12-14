/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada1_3.Ventanas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import ada1_3.Maestro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import java.util.List;
import ada1_3.Asignatura;
import ada1_3.AsignaturaAsignada;
import ada1_3.Ventanas.ManipuladorListas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author luis_
 */
public class EditarAsignaturasController implements Initializable {
    private Maestro maestroVentana;
    public List<Asignatura> listaSeleccionadas;
    private ManipuladorListas manipulador;
    @FXML
    private Label lblMaestro;
    
    @FXML
    private TableView<Asignatura> tabla1;

    @FXML
    private TableColumn<AsignaturaAsignada, String> colum4;

    @FXML
    private Button btnGuardarAccion;

    @FXML
    private TableColumn<Asignatura, String> colum2;

    @FXML
    private TableColumn<Asignatura, String> colum3;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<Asignatura, String> colum1;

    @FXML
    private Button btnAgregar;

    @FXML
    private TableView<AsignaturaAsignada> tabla2;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.maestroVentana = ManipuladorListas.maestroSeleccionado;
        lblMaestro.setText(this.maestroVentana.getName());
        manipulador = new ManipuladorListas();
        
        colum1.setCellValueFactory(new PropertyValueFactory<Asignatura,String>("Cve_Asignatura"));
        colum2.setCellValueFactory(new PropertyValueFactory<Asignatura,String>("Nombre"));
        colum3.setCellValueFactory(new PropertyValueFactory<Asignatura,String>("Licenciatura"));
        colum4.setCellValueFactory(new PropertyValueFactory<AsignaturaAsignada,String>("Cve_Asignatura"));
        
        tabla1.getColumns().setAll(colum1,colum2,colum3);
        tabla2.getColumns().setAll(colum4);
        actualizarTabla();
    }    
    public void actualizarTabla(){
        try{
            if(ManipuladorListas.asignaturasLibres.isEmpty() == false){
                ObservableList<Asignatura> e = FXCollections.observableList(this.manipulador.getAsignaturasLibres());
                if(e.size() > 0){
                    tabla1.setItems(e);
                }else{
                    tabla1.getItems().clear();
                }
            }else{
                tabla1.getItems().clear();
            }

            if(ManipuladorListas.listaAsignaturas.isEmpty() == false){
                ObservableList<AsignaturaAsignada> r = FXCollections.observableList(this.manipulador.getAsignaturasAsignadas(this.maestroVentana.getCve_Empleado()));
                if(r.size() > 0){
                    tabla2.setItems(r);
                }else{
                    tabla2.getItems().clear();
                }
            }else{
                tabla2.getItems().clear();
            }
            tabla1.refresh();
            tabla2.refresh();
        }catch(Exception e){
            
        }
    }
    @FXML
    void btnAgregarAccion(ActionEvent event) {
        try{
            List<Asignatura> e = tabla1.getSelectionModel().getSelectedItems();
            e.forEach((Asignatura elemento)->{
                this.manipulador.asignarAsignatura(this.maestroVentana.getCve_Empleado(), elemento.getCve_Asignatura());
            });
        }catch(Exception e){
        }
        
        actualizarTabla();
    }

    @FXML
    void btnEliminarAccion(ActionEvent event) {
        try{
            List<AsignaturaAsignada> e = tabla2.getSelectionModel().getSelectedItems();
            e.forEach((Asignatura elemento)->{
                this.manipulador.regresarAsignatura(this.maestroVentana.getCve_Empleado(), elemento.getCve_Asignatura());

            });
        }catch(Exception e){
        }
        actualizarTabla();
    }

    @FXML
    void btnGuardarAccion(ActionEvent event) {

    }
}
