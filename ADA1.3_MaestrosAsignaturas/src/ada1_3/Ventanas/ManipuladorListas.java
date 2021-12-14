/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada1_3.Ventanas;

import ada1_3.AsignaturaAsignada;
import ada1_3.Asignatura;
import ada1_3.Maestro;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author luis_
 */
public class ManipuladorListas {
    public static Maestro maestroSeleccionado;
    
    public static List<AsignaturaAsignada> listaAsignaturas;
    public static List<Asignatura> asignaturasLibres;
    public static Asignatura tempAsig;
    public static Asignatura tempAsig3;
    public static AsignaturaAsignada tempAsig2;
    
    public static File ArchivoMaestros;
    public static File ArchivoAsignatura;
    
    public static List<Asignatura> Todasasignaturas;
    public static List<Maestro> maestros;

    public List<AsignaturaAsignada> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(List<AsignaturaAsignada> listaAsignaturas) {
        ManipuladorListas.listaAsignaturas = listaAsignaturas;
    }

    public List<Asignatura> getAsignaturasLibres() {
        return asignaturasLibres;
    }

    public void setAsignaturasLibres(List<Asignatura> asignaturasLibres) {
        ManipuladorListas.asignaturasLibres = asignaturasLibres;
    }

    public File getArchivoMaestros() {
        return ArchivoMaestros;
    }

    public void setArchivoMaestros(File ArchivoMaestros) {
        ManipuladorListas.ArchivoMaestros = ArchivoMaestros;
    }

    public static File getArchivoAsignatura() {
        return ArchivoAsignatura;
    }

    public static void setArchivoAsignatura(File ArchivoAsignatura) {
        ManipuladorListas.ArchivoAsignatura = ArchivoAsignatura;
    }

    public List<Asignatura> getTodasasignaturas() {
        return Todasasignaturas;
    }

    public void setTodasasignaturas(List<Asignatura> Todasasignaturas) {
        ManipuladorListas.Todasasignaturas = Todasasignaturas;
    }
    
    public List<AsignaturaAsignada> getAsignaturasAsignadas(String Cve_Empleado){
        List<AsignaturaAsignada> e = new ArrayList<>();
        ManipuladorListas.listaAsignaturas.forEach((AsignaturaAsignada elemento)->{
            if(elemento.getCve_Empleado().equals(Cve_Empleado)){
                e.add(elemento);
            }
        });
        return e;
    }
    public static List<AsignaturaAsignada> getAsignaturasAsignadas(){
        return ManipuladorListas.listaAsignaturas;
    }
    public void asignarAsignatura(String Cve_Empleado,String Cve_Asignatura){
        tempAsig = null;
        tempAsig = new Asignatura();
        
        ManipuladorListas.asignaturasLibres.forEach(elemento->{
            if(elemento.getCve_Asignatura().equals(Cve_Asignatura)){
                tempAsig = elemento;
            }
        });
        ManipuladorListas.listaAsignaturas.add(new AsignaturaAsignada(tempAsig,Cve_Empleado));
        ManipuladorListas.asignaturasLibres.remove(tempAsig);
        
        tempAsig = null;
        tempAsig = new Asignatura();
    }
    public void regresarAsignatura(String Cve_Empleado,String Cve_Asignatura){
        ManipuladorListas.Todasasignaturas.forEach((Asignatura elemento)->{
            if(elemento.getCve_Asignatura().equals(Cve_Asignatura)){
                tempAsig = elemento;
            }
        });
        ManipuladorListas.asignaturasLibres.add(tempAsig);
        
        ManipuladorListas.listaAsignaturas.forEach((AsignaturaAsignada elemento)->{ 
            if(elemento.getCve_Asignatura().equals(Cve_Asignatura)){
                tempAsig2 = elemento;
            }
        });
        ManipuladorListas.listaAsignaturas.remove(tempAsig2);
        tempAsig = null;
        tempAsig = new Asignatura();
        tempAsig2 = null;
        tempAsig = new AsignaturaAsignada();
    }
    
}
