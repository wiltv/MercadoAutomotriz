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
public class CreadorAccesorio extends Thread {
    
    private Semaphore mutex;
    private String parte;
    private Integer almacen;
    private float dias;
    
    public static volatile float diasAccesorio = 0f;
    
    public CreadorAccesorio(Semaphore mutex, String parte, Integer almacen, float dias){
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
                diasAccesorio = diasAccesorio + dias;
                MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + 408;
                if (diasAccesorio >= 1){
                    if (MercadoAutomotriz2.ContAccesorio < almacen){
                    MercadoAutomotriz2.ContAccesorio = MercadoAutomotriz2.ContAccesorio +Math.round(diasAccesorio);
                    System.out.println("Hay " + MercadoAutomotriz2.ContAccesorio + " unidades de " + parte);
                    diasAccesorio = 0;}
                    else{
                        System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                    }
                }else{
                    System.out.println("El creador de accesorio sigue trabajando " + diasAccesorio);
                }
               
                
                sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(CreadorAccesorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    
}
