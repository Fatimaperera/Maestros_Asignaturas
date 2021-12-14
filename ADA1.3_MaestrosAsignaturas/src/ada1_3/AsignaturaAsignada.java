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
public class AsignaturaAsignada extends Asignatura{
    private String Cve_Empleado;
    
    public AsignaturaAsignada(){
        
    }
    public AsignaturaAsignada(String Cve_Asignatura, String Nombre, String Licenciatura, String Cve_Empleado) {
        super(Cve_Asignatura, Nombre, Licenciatura);
        this.Cve_Empleado = Cve_Empleado;
    }
    public AsignaturaAsignada(Asignatura asignatura, String Cve_Empleado){
        super(asignatura.getCve_Asignatura(),asignatura.getNombre(),asignatura.getLicenciatura());
        this.Cve_Empleado = Cve_Empleado;
    }
    public AsignaturaAsignada(Asignatura asignatura){
        super(asignatura.getCve_Asignatura(),asignatura.getNombre(),asignatura.getLicenciatura());
    }
    public String getCve_Empleado() {
        return Cve_Empleado;
    }

    public void setCve_Empleado(String Cve_Empleado) {
        this.Cve_Empleado = Cve_Empleado;
    }
    
    public String[] getRelacionAsignaturas(){
        String e[] = new String[2];
        e[0] = this.Cve_Empleado;
        e[1] = this.getCve_Asignatura();
        
        return e;
    }
}
