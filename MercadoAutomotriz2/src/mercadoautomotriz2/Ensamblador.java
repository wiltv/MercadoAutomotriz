/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercadoautomotriz2;

import Interfaces.InterfazMain;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wiltsson
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
                diasEnsamblador = diasEnsamblador + dias;
                if(diasEnsamblador>=1){
                    if (Almacen.ContChasis >=2 && Almacen.ContMotor >= 6
                            && Almacen.ContCarroceria >= 1 && Almacen.ContRuedas >= 5){


                        Almacen.ContChasis = Almacen.ContChasis -2;
                        Almacen.ContMotor = Almacen.ContMotor - 6;
                        Almacen.ContCarroceria = Almacen.ContCarroceria - 1;
                        Almacen.ContRuedas = Almacen.ContRuedas - 5;
                        MercadoAutomotriz2.Carros = MercadoAutomotriz2.Carros + 1;

                        if(MercadoAutomotriz2.Carros %4 == 0){
                            Almacen.ContAccesorio = Almacen.ContAccesorio - 1;
                            System.out.println("Hay " + MercadoAutomotriz2.Carros + " carros, este viene con accesorio");
                        }else{
                           System.out.println("Hay " + MercadoAutomotriz2.Carros + " carros"); 
                        }
                        InterfazMain.CantidadCarros.setText(String.valueOf(MercadoAutomotriz2.Carros));
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
