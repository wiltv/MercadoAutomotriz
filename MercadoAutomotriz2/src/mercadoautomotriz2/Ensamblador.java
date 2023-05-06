/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercadoautomotriz2;

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
                    if (MercadoAutomotriz2.ContChasis >=2 && MercadoAutomotriz2.ContMotor >= 6
                            && MercadoAutomotriz2.ContCarroceria >= 1 && MercadoAutomotriz2.ContRuedas >= 5){


                        MercadoAutomotriz2.ContChasis = MercadoAutomotriz2.ContChasis -2;
                        MercadoAutomotriz2.ContMotor = MercadoAutomotriz2.ContMotor - 6;
                        MercadoAutomotriz2.ContCarroceria = MercadoAutomotriz2.ContCarroceria - 1;
                        MercadoAutomotriz2.ContRuedas = MercadoAutomotriz2.ContRuedas - 5;
                        MercadoAutomotriz2.Carros = MercadoAutomotriz2.Carros + 1;

                        if(MercadoAutomotriz2.Carros %4 == 0){
                            MercadoAutomotriz2.ContAccesorio = MercadoAutomotriz2.ContAccesorio - 1;
                            System.out.println("Hay " + MercadoAutomotriz2.Carros + " carros, este viene con accesorio");
                        }else{
                           System.out.println("Hay " + MercadoAutomotriz2.Carros + " carros"); 
                        }
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
                Logger.getLogger(CreadorChasis.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
}
