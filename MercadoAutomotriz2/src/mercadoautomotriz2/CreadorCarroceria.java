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
    private float dias;
    
    public static volatile float diasCarroceria = 0f;
    
    public CreadorCarroceria(Semaphore mutex, String parte, Integer almacen, float dias){
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
                diasCarroceria = diasCarroceria + dias;
                MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + 312;
                 if (diasCarroceria >= 1){
                    if (MercadoAutomotriz2.ContCarroceria < almacen){
                    MercadoAutomotriz2.ContCarroceria = MercadoAutomotriz2.ContCarroceria +Math.round(diasCarroceria);
                    System.out.println("Hay " + MercadoAutomotriz2.ContCarroceria + " unidades de " + parte);
                    diasCarroceria = 0f;}
                    else{
                        System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                    }
                }else{
                    System.out.println("El creador de carroceria sigue trabajando " + diasCarroceria);
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
