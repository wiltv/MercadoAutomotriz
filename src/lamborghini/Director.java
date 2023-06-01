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
import java.util.Random;
/**
 *
 * @author wiltsson
 */
public class Director extends Thread{
    private Semaphore mutex;
    
    public static volatile boolean Entregado = false; 
    Random valor = new Random();
    public static volatile Integer momento = 0;
    
    public Director(Semaphore mutex){
        this.mutex = mutex;
        
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                
                momento = valor.nextInt(48);
                System.out.println(momento);
                
                MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + 720;
                
                if (Gerente.contadorEntrega == 0){
                    MercadoAutomotriz.Ganancia = MercadoAutomotriz.Ganancia + MercadoAutomotriz.Carros*400;
                    
                    if(MercadoAutomotriz.Carros%4 >= 2){
                        double SumaAccesorio = (MercadoAutomotriz.Carros/4) - 0.5;
                        SumaAccesorio = Math.round(MercadoAutomotriz.Carros);
                        MercadoAutomotriz.Ganancia = MercadoAutomotriz.Ganancia + (int)(SumaAccesorio*350);
                        
                    }else{
                        double SumaAccesorio = Math.round(MercadoAutomotriz.Carros);
                        MercadoAutomotriz.Ganancia = MercadoAutomotriz.Ganancia + (int)(SumaAccesorio*350);
                    }
                    
                    System.out.println("El jefe entrega todos los carros y recibe ganancia de: " + MercadoAutomotriz.Carros*400);
                    System.out.println("Su total de ingresos es " + MercadoAutomotriz.Ganancia);   
                    if (MercadoAutomotriz.DiasEntregatxt>0){
                        Gerente.contadorEntrega = MercadoAutomotriz.DiasEntregatxt;
                    }else{
                        Gerente.contadorEntrega = 30;
                    }
                    
                    MercadoAutomotriz.Carros = 0;
                    InterfazMain.CantidadCarrosLamborghini.setText(String.valueOf(MercadoAutomotriz.Carros));
                    InterfazMain.EntregaLamborghini.setText(String.valueOf(Gerente.contadorEntrega));
                    InterfazMain.GananciasLamborghini.setText(String.valueOf(MercadoAutomotriz.Ganancia));
                }else{
                    System.out.println("El director esta atento de entregar los carros");
                }
                
                sleep(500);
                
                mutex.release(); //signal
                sleep(5000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(Creador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
}
