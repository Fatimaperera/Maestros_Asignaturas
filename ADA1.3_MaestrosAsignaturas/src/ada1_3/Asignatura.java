/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada1_3;

/**
 *
 * @author luis_
 */
public class Asignatura {
    private String Cve_Asignatura;
    private String Nombre;
    private String Licenciatura;

    public String getCve_Asignatura() {
        return Cve_Asignatura;
    }

    public void setCve_Asignatura(String Cve_Asignatura) {
        this.Cve_Asignatura = Cve_Asignatura;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getLicenciatura() {
        return Licenciatura;
    }

    public void setLicenciatura(String Licenciatura) {
        this.Licenciatura = Licenciatura;
    }

    public Asignatura(String Cve_Asignatura, String Nombre, String Licenciatura) {
        this.Cve_Asignatura = Cve_Asignatura;
        this.Nombre = Nombre;
        this.Licenciatura = Licenciatura;
    }
    public Asignatura(){
        
    }
    public String[] getStringsAsignaturas(){
        String e[] = new String[3];
        e[0] = this.Cve_Asignatura;
        e[1] = this.Licenciatura;
        e[2] = this.Nombre;
        return e;
    }
    public void setStringsAsignaturas(String[] e){
        this.Cve_Asignatura = e[0];
        this.Nombre = e[1];
        this.Licenciatura = e[2];
    }
}
