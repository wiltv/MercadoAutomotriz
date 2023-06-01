/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maserati;

import Interfaces.InterfazMain;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valeria
 */
public class Ensamblador extends Thread{
    private Semaphore mutex;
    private float dias;
    
    public static volatile float diasEnsamblador = 0f;
    
    public Ensamblador(Semaphore mutex, float dias){
        this.mutex = mutex;
        this.dias = dias;
        
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + 600*EmpleadosMaserati.eEnsamblador;
                diasEnsamblador = diasEnsamblador + dias*EmpleadosMaserati.eEnsamblador;
                if(diasEnsamblador>=1){
                    if (Almacen.ContChasis >=1 && Almacen.ContMotor >= 2
                            && Almacen.ContCarroceria >= 1 && Almacen.ContRuedas >= 4){


                        Almacen.ContChasis = Almacen.ContChasis -1;
                        Almacen.ContMotor = Almacen.ContMotor - 2;
                        Almacen.ContCarroceria = Almacen.ContCarroceria - 1;
                        Almacen.ContRuedas = Almacen.ContRuedas - 4;
                        MercadoAutomotriz.Carros = MercadoAutomotriz.Carros + 1;
                           
                        if(MercadoAutomotriz.Carros %3 == 0){
                            Almacen.ContAccesorio = Almacen.ContAccesorio - 3;
                            System.out.println("Hay " + MercadoAutomotriz.Carros + " carros, este viene con accesorio");
                            InterfazMain.CantidadAccesoriosLamborghini.setText(String.valueOf(Almacen.ContAccesorio));
                        }else{
                           System.out.println("Hay " + MercadoAutomotriz.Carros + " carros"); 
                        }
                        InterfazMain.CantidadChasisLamborghini.setText(String.valueOf(Almacen.ContChasis));
                        InterfazMain.CantidadCarroceriaLamborghini.setText(String.valueOf(Almacen.ContCarroceria));
                        InterfazMain.CantidadMotorLamborghini.setText(String.valueOf(Almacen.ContMotor));
                        InterfazMain.CantidadRuedasLamborghini.setText(String.valueOf(Almacen.ContRuedas));
                        InterfazMain.CantidadCarrosLamborghini.setText(String.valueOf(MercadoAutomotriz.Carros));
                        diasEnsamblador = 0f;
                    }else{
                        System.out.println("No hay suficientes piezas, el ensamblador espera");       
                    }
                }else{
                    System.out.println("El ensamblador sigue trabajando " + diasEnsamblador);
                }   
                
                
                
               sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(Creador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
}
