/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada1_3;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ada1_3.Ventanas.ManipuladorListas;
/**
 *
 * @author luis_
 */
public class Maestro {
    private String Cve_Empleado;
    private String Apellido1;
    private String Apellido2;
    private String Nombres;
    private Button button;
    
    public String getCve_Empleado() {
        return Cve_Empleado;
    }

    public void setCve_Empleado(String Cve_Empleado) {
        this.Cve_Empleado = Cve_Empleado;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }
    
    public Maestro(String Cve_Empleado, String Apellido1, String Apellido2, String Nombres) {
        this.Cve_Empleado = Cve_Empleado;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.Nombres = Nombres;
        
        
        this.button = new Button();
        this.button.setText("Editar");
        this.button.setPrefWidth(75);
        this.button.setPrefHeight(10);
        this.button.setOnAction(event->{
            Parent root;
            try {
                ManipuladorListas.maestroSeleccionado = this;
                root = FXMLLoader.load(getClass().getResource("Ventanas/EditarAsignaturas.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
            } 
        });
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
    
    public String[] getStringsMaestro(){
        String e[] = new String[4];
        e[0] = this.Cve_Empleado;
        e[1] = this.Apellido1;
        e[2] = this.Apellido2;
        e[3] = this.Nombres;
        
        return e;
    }
    
    public void setStringsMaestro(String[] e){
        this.Cve_Empleado = e[0];
        this.Apellido1 = e[1];
        this.Apellido2 = e[2];
        this.Nombres = e[3];
    }
    
    public String getName(){
        return(this.Nombres + " " + this.Apellido1 + " " + this.Apellido2);
    }
}
