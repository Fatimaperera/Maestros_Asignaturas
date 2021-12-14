/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada1_3;
import java.io.*;
/**
 *
 * @author luis_
 */
public interface Manipulador {
    public void leerMaestros(File Archivo);
    public void leerAsignaturas(File Archivo);
    public void escribirAsignaturas(File archivo);
}
