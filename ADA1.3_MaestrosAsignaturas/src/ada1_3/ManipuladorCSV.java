/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada1_3;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.*;
import ada1_3.Ventanas.ManipuladorListas;
import com.opencsv.CSVWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author luis_
 */
public class ManipuladorCSV implements Manipulador{
    @Override
    public void leerMaestros(File archivo){
        List<Maestro> maestros = new ArrayList<Maestro>();
        try{
            Stream<String> streamFile = Files.lines(archivo.toPath());
            maestros = streamFile.map(linea-> linea.split(",")).map(arreglo->{
                Maestro mae = new Maestro(arreglo[0],arreglo[1],arreglo[2],arreglo[3]);
                return mae;
            }).collect(Collectors.toList());
            if("Nombres".equals(maestros.get(0).getNombres()) || "nombres".equals(maestros.get(0).getNombres()) ||
               "Nombre".equals(maestros.get(0).getNombres()) || "nombre".equals(maestros.get(0).getNombres())){
                maestros.remove(0);
            }
        }catch(IOException e){
            System.out.println("Error Manipulador: " + e.getMessage());
        }
        ManipuladorListas.maestros = maestros;
    }
    @Override
    public void leerAsignaturas(File archivo){
        List<Asignatura> asignaturas = new ArrayList<Asignatura>();
        try{
            Stream<String> streamFile = Files.lines(archivo.toPath());
            asignaturas = streamFile.map(linea-> linea.split(",")).map(arreglo->{
                Asignatura mae = new Asignatura(arreglo[0],arreglo[1],arreglo[2]);
                return mae;
            }).collect(Collectors.toList());
            if("Nombre".equals(asignaturas.get(0).getNombre()) || "nombre".equals(asignaturas.get(0).getNombre()) ||
               "Nombres".equals(asignaturas.get(0).getNombre()) || "nombres".equals(asignaturas.get(0).getNombre())){
                asignaturas.remove(0);
            }
        }catch(IOException e){
            System.out.println("Error Manipulador: " + e.getMessage());
            
        }
        ManipuladorListas.Todasasignaturas = new ArrayList<>();
        ManipuladorListas.Todasasignaturas.addAll(asignaturas);
        
        ManipuladorListas.asignaturasLibres = new ArrayList<>();
        ManipuladorListas.asignaturasLibres.addAll(asignaturas);
        
        ManipuladorListas.listaAsignaturas = new ArrayList<>();
    }
    @Override
    public void escribirAsignaturas(File archivo){
        List<String[]> salida;
        salida = new ArrayList<String[]>();
        ManipuladorListas.listaAsignaturas.forEach(elemento->salida.add(elemento.getRelacionAsignaturas()));
        
        CSVWriter writer;
        try {
            writer = new CSVWriter(new FileWriter(archivo));
            writer.writeAll(salida);
            writer.close();
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setTitle("Exportar CSV");
            alerta.setContentText("Se guardó el archivo: " + archivo.getName());
            alerta.showAndWait();
        } catch (IOException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Exportar CSV");
            alerta.setContentText("No se pudo exportar el archivo: " + ex.getMessage());
            alerta.showAndWait();
        }
    }
}
