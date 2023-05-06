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
public class CreadorChasis extends Thread {
    
    private Semaphore mutex;
    private String parte;
    private Integer almacen;
    private float dias;
    
    public static volatile float diasChasis = 0f;
    
    public CreadorChasis(Semaphore mutex, String parte, Integer almacen, float dias){
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
                MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + 240; //240 porque son 10$ 24 horas, eso se multiplcica pot el numero de empleados
                diasChasis = diasChasis + dias;
                if (diasChasis >= 1){
                    if (MercadoAutomotriz2.ContChasis < almacen){
                        MercadoAutomotriz2.ContChasis = MercadoAutomotriz2.ContChasis 
                                + Math.round(diasChasis);
                        System.out.println("Hay " + MercadoAutomotriz2.ContChasis + " unidades de " + parte);
                        diasChasis = 0f;}
                    else{
                        System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                    }
                }else{
                    System.out.println("El creador de chasis sigue trabajando " + diasChasis);
                    
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
