/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_salario;

/**
 *
 * @author woombat
 */
public class Emp_asalariado extends Persona{
    private final int alimentacion = 100000,
                      transporte = 106454;
    
    public double pension,
                  salud,
                  parafiscales;
            
    
    public Emp_asalariado(String nombre, double salario) {
        super(nombre, salario);
        saldo_Neto();
    }
    
    private void saldo_Neto(){
        parafiscales = salario * 0.09;//sena 2%,ICBF 3%,Caja de compensación 4%
        salud = salario * 0.04;
        pension = salario * 0.04;
        salario_neto = salario + alimentacion + transporte - salud - parafiscales - pension;
    }
    
    public String mostrarDatos(){
        return "\n\nNombre: "+ nombre + "\n"
                + "Salario bruto: "+salario+"\n"
                + "Abono alimentación: "+ alimentacion+"\n"
                + "Abono transporte: "+ transporte+"\n"
                + "Descuento pension: -"+ pension+"\n"
                + "Descuento salud: -"+ salud+"\n"
                + "Descuento parafiscales: -"+ parafiscales+"\n"
                + "Salario neto: "+ salario_neto+"\n";
    }
    
}
