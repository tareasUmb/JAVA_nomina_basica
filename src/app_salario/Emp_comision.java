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
public class Emp_comision extends Persona{
    
    private final double ventas;
    private double abono_ventas;
                
    public Emp_comision(String nombre, double salario, double ventas) {
        super(nombre, salario);
        this.ventas = ventas;
        saldo_Neto();
    }
    
    private void saldo_Neto(){
        abono_ventas = ventas * 0.2;
        salario_neto = salario + abono_ventas;
    }
    
    public String mostrarDatos(){
        return "\nNombre: "+ nombre + "\n"
                + "Salario bruto: "+salario+"\n"
                + "Ventas: "+ventas+"\n"
                + "Abono 20% de ventas: "+ abono_ventas+"\n"
                + "Salario neto: "+ salario_neto+"\n";
    }
}
