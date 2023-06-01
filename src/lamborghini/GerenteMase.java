/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lamborghini;

import maserati.*;
import Interfaces.InterfazMain;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valeria
 */
public class GerenteMase extends Thread{
    private Semaphore mutex;
    
    public static volatile Integer contadorEntregaMase = 30; //El jefe entrega y desde esa clase tengo que volver esto 30
    public static volatile Integer atrapadoMase = 0;
    public static volatile Integer descuentoMase = 0;
    
    public GerenteMase(Semaphore mutex){
        this.mutex = mutex;
        
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                if (contadorEntregaMase > 0){
                    contadorEntregaMase = contadorEntregaMase - 1;
                    System.out.println("El gerente notifica que quedan " + contadorEntregaMase + " dias para la entrega");
                    InterfazMain.EntregaMaserati.setText(String.valueOf(contadorEntregaMase));
                }else{
                    System.out.println("El gerente notifica que ya se pueden entregar los carros al director");
                }
                
                
                MercadoAutomotriz.NominaMase = MercadoAutomotriz.NominaMase + 480;
                System.out.println("El gerente ha registrado " + MercadoAutomotriz.NominaMase + " pagos en nomina");
                InterfazMain.SalariosMaserati.setText(String.valueOf(MercadoAutomotriz.NominaMase));
                
                if (DirectorMase.momentoMase < 36 && DirectorMase.momentoMase%2==1){
                    System.out.println("Pillado");
                    MercadoAutomotriz.NominaMase = MercadoAutomotriz.NominaMase - 50;
                    InterfazMain.SalariosMaserati.setText(String.valueOf(MercadoAutomotriz.NominaMase));
                    
                }else{
                    System.out.println("Laborando");}
                
                
                sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(Creador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
}
