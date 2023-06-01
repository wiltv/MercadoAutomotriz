/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lamborghini;

import Interfaces.InterfazMain;
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
    
    public static volatile Integer contadorEntrega = 30; //El jefe entrega y desde esa clase tengo que volver esto 30
    
    public Gerente(Semaphore mutex){
        this.mutex = mutex;
        
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                if (contadorEntrega > 0){
                    contadorEntrega = contadorEntrega - 1;
                    System.out.println("El gerente notifica que quedan " + contadorEntrega + " dias para la entrega");
                    InterfazMain.Entrega.setText(String.valueOf(contadorEntrega));
                }else{
                    System.out.println("El gerente notifica que ya se pueden entregar los carros al director");
                }
                
                
                MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + 480;
                System.out.println("El gerente ha registrado " + MercadoAutomotriz.Nomina + " pagos en nomina");
                InterfazMain.Salarios.setText(String.valueOf(MercadoAutomotriz.Nomina));
                
                sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(Creador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
}
