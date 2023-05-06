/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercadoautomotriz2;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wiltsson
 */
public class Director extends Thread{
    private Semaphore mutex;
    
    public static volatile boolean Entregado = false; 
    
    public Director(Semaphore mutex){
        this.mutex = mutex;
        
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                
                MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + 720;
                
                if (Gerente.contadorEntrega == 0){
                    MercadoAutomotriz2.Ganancia = MercadoAutomotriz2.Ganancia + MercadoAutomotriz2.Carros*400;
                    System.out.println("El jefe entrega todos los carros y recibe ganancia de: " + MercadoAutomotriz2.Carros*400);
                    System.out.println("Su total de ingresos es " + MercadoAutomotriz2.Ganancia);      
                    Gerente.contadorEntrega = 30;
                    MercadoAutomotriz2.Carros = 0;
                }else{
                    System.out.println("El director esta atento de entregar los carros");
                }
                
                sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(CreadorCarroceria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
}
