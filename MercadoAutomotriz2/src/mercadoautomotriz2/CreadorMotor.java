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
public class CreadorMotor extends Thread {
    
    private Semaphore mutex;
    private String parte;
    private Integer almacen;
    private float dias;
    
    public static volatile float diasMotor = 0f;
    
    public CreadorMotor(Semaphore mutex, String parte, Integer almacen,float dias){
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
                MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + 480;
                diasMotor = diasMotor + dias;
                if (diasMotor >= 1){
                    if (MercadoAutomotriz2.ContMotor < almacen){
                    MercadoAutomotriz2.ContMotor = MercadoAutomotriz2.ContMotor +Math.round(diasMotor);
                    System.out.println("Hay " + MercadoAutomotriz2.ContMotor + " unidades de " + parte);
                    diasMotor = 0f;}
                    else{
                        System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                    }
                }else{
                    System.out.println("El creador de motor sigue trabajando " + diasMotor);
                } 
               
                
                sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(CreadorMotor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    
}
