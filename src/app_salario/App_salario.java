/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_salario;

import java.util.Scanner;
import javax.swing.JOptionPane;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author woombat
 */
public class App_salario {

     
    public static void main(String[] args) {

        int cant_emp_asalariado, cant_emp_comision, salario, ventas;
        String nombre;
        Scanner entrada= new Scanner(System.in);
        
       
        
        System.out.println("Ingrese la cantidad de empleados asalariados:");
        cant_emp_asalariado = entrada.nextInt();
        
        System.out.println("Ingrese la cantidad de empleados por comisión:");
        cant_emp_comision = entrada.nextInt();

        
        Emp_asalariado asalariados[]= new Emp_asalariado[cant_emp_asalariado];
        Emp_comision comisionados[]= new Emp_comision[cant_emp_comision];
        

        System.out.println("Informacion de Empleados Asalariados\n");
        for(int i = 0; i < cant_emp_asalariado; i++  ){
            nombre = leer_nombre();
            salario = leer_salario(nombre);

            asalariados[i] = new Emp_asalariado(nombre,salario);
            asalariados[i].mostrarDatos();
        }  
        
        
        System.out.println("Informacion de Empleados por comision\n");
        for(int i = 0; i < cant_emp_comision; i++  ){
            nombre = leer_nombre();
            salario = leer_salario(nombre);
            ventas = leer_ventas(nombre);

            comisionados[i] = new Emp_comision(nombre,salario,ventas);
            comisionados[i].mostrarDatos();
        }
        
        guardar_txt_asalariados(asalariados);
        guardar_txt_comisionados(comisionados);
        
        System.out.println("\n\nLeyendo archivo de empleados asalariados");
        escanear_archivo("datos_asalariados.txt");

        System.out.println("\n\nLeyendo archivo de empleados por comision");        
        escanear_archivo("datos_comisionados.txt");
    }
    private static void guardar_txt_asalariados(Emp_asalariado asalariados[]){
        try {
            String ruta = "datos_asalariados.txt";
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Emp_asalariado p : asalariados){
                bw.write(p.mostrarDatos());
            }  
            
            bw.close();
            System.out.println("Archivo de empleados asalariados guardado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Archivo de empleados asalariados no guardado");
        }
    }
    
    private static void guardar_txt_comisionados(Emp_comision comisionados[]){
        try {
            String ruta = "datos_comisionados.txt";
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Emp_comision p : comisionados){
                bw.write(p.mostrarDatos());
            }  
            
            bw.close();
            System.out.println("Archivo de empleados por comision guardado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Archivo de empleados por comision no guardado");
        }
    }
    
    private static void escanear_archivo(String archivo){
        try {
            Scanner input = new Scanner(new File(archivo));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String leer_nombre(){
        String nombre = JOptionPane.showInputDialog("\nIngrese el nombre empleado");
        System.out.println("Empleado: " + nombre);
        return nombre;
    }
    
    private static int leer_salario(String nombre){
        int salario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario base de " + nombre));
        System.out.println("Sueldo: " + salario);
        return salario;
    }
    
    private static int leer_ventas(String nombre){
        int ventas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las ventas de " + nombre));
        System.out.println("ventas: " + ventas);
        return ventas;
    }
}
