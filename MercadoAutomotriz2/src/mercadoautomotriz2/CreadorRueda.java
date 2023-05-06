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
public class CreadorRueda extends Thread {
    
    private Semaphore mutex;
    private String parte;
    private Integer almacen;
    private float dias;
    
    public static volatile float diasRueda = 0f;
    
    public CreadorRueda(Semaphore mutex, String parte, Integer almacen,float dias){
        this.mutex = mutex;
        this.parte = parte;
        this.almacen = almacen;
        this.dias = dias;
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                diasRueda = diasRueda + dias;
                if (diasRueda >=1)  {
                    if (MercadoAutomotriz2.ContRuedas < almacen){
                        MercadoAutomotriz2.ContRuedas = MercadoAutomotriz2.ContRuedas +Math.round(diasRueda);
                        System.out.println("Hay " + MercadoAutomotriz2.ContRuedas + " unidades de " + parte);
                    diasRueda = 0f;}
                    else{
                        System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                    } 
                }else{
                    System.out.println("El creador de rueda sigue trabajando " + diasRueda);
                }
               
               
                
                sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(CreadorRueda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    
}
