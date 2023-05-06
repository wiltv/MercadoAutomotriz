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
public class Gerente extends Thread{
    private Semaphore mutex;
    
    public Gerente(Semaphore mutex){
        this.mutex = mutex;
        
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                
                MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + 480;
                         
                System.out.println("El gerente ha registrado " + MercadoAutomotriz2.Nomina + " pagos en nomina");
                
                sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(CreadorCarroceria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
}
