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
public class SemaforoLamborguini extends Thread {
    
    private Integer unidad;
    private Semaphore mutex;
    private String parte;
    
    public SemaforoLamborguini(Integer valor, Semaphore mutex, String parte){
        this.unidad = valor;
        this.mutex = mutex;
        this.parte = parte;
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                System.out.println("Hay " + unidad + " unidades de " + parte);
                unidad = unidad +1;
                sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(SemaforoLamborguini.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    
}
