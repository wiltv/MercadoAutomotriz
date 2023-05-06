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
public class CreadorCarroceria extends Thread {
    
    private Semaphore mutex;
    private String parte;
    private Integer almacen;
    
    public CreadorCarroceria(Semaphore mutex, String parte, Integer almacen){
        this.mutex = mutex;
        this.parte = parte;
        this.almacen = almacen;
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                if (MercadoAutomotriz2.ContCarroceria < almacen){
                MercadoAutomotriz2.ContCarroceria = MercadoAutomotriz2.ContCarroceria +1;
                System.out.println("Hay " + MercadoAutomotriz2.ContCarroceria + " unidades de " + parte);}
                else{
                    System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
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
