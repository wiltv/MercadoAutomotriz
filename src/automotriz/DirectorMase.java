/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automotriz;

import Interfaces.InterfazMain;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valeria
 */
public class DirectorMase extends Thread{
    private Semaphore mutex;
    
    public static volatile boolean EntregadoMase = false; 
    
    Random valorMase = new Random();
    public static volatile Integer momentoMase = 0;
    
    public DirectorMase(Semaphore mutex){
        this.mutex = mutex;
        
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                
                momentoMase = valorMase.nextInt(48);
                System.out.println(momentoMase);
                
                MercadoAutomotriz.NominaMase = MercadoAutomotriz.NominaMase + 720;
                
                if (GerenteMase.contadorEntregaMase == 0){
                    MercadoAutomotriz.GananciaMase = MercadoAutomotriz.GananciaMase + MercadoAutomotriz.Carros*350;
                    MercadoAutomotriz.GananciaBrutoMase = MercadoAutomotriz.GananciaBrutoMase - 720;
                    
                    if(MercadoAutomotriz.CarrosMase%3 == 2){
                        double SumaAccesorio = (MercadoAutomotriz.CarrosMase/3) - 0.5;
                        SumaAccesorio = Math.round(MercadoAutomotriz.CarrosMase);
                        MercadoAutomotriz.GananciaMase = MercadoAutomotriz.GananciaMase + (int)(SumaAccesorio*350);
                        MercadoAutomotriz.GananciaBrutoMase = MercadoAutomotriz.GananciaBrutoMase + (int)(SumaAccesorio*350);
                        InterfazMain.GananciasMaserati1.setText(String.valueOf((int)(SumaAccesorio*350)));
                        
                    }else{
                        double SumaAccesorio = Math.round(MercadoAutomotriz.CarrosMase);
                        MercadoAutomotriz.GananciaMase = MercadoAutomotriz.GananciaMase + (int)(SumaAccesorio*350);
                        MercadoAutomotriz.GananciaBrutoMase = MercadoAutomotriz.GananciaBrutoMase + (int)(SumaAccesorio*350);
                        InterfazMain.GananciasMaserati1.setText(String.valueOf((int)(SumaAccesorio*350)));
                    }
                    
                    System.out.println("El jefe entrega todos los carros y recibe ganancia de: " + MercadoAutomotriz.CarrosMase*350);
                    System.out.println("Su total de ingresos es " + MercadoAutomotriz.GananciaMase);   
                    
                    if (MercadoAutomotriz.DiasEntregatxt>0){
                        GerenteMase.contadorEntregaMase = MercadoAutomotriz.DiasEntregatxt;
                    }else{
                        GerenteMase.contadorEntregaMase = 30;
                    }
                    InterfazMain.estadoDirMaserati.setText("Entregando");
                    MercadoAutomotriz.CarrosMase = 0;
                    MercadoAutomotriz.CarrosAccsMase = 0;
                    InterfazMain.CantidadCarrosMaserati.setText(String.valueOf(MercadoAutomotriz.CarrosMase));
                    InterfazMain.EntregaMaserati.setText(String.valueOf(GerenteMase.contadorEntregaMase));
                    InterfazMain.BrutoMaserati.setText(String.valueOf(MercadoAutomotriz.GananciaMase));
                    
                    InterfazMain.BrutoMaserati.setText(String.valueOf(MercadoAutomotriz.GananciaBrutoMase));
                }else{
                    System.out.println("El director esta atento de entregar los carros");
                    InterfazMain.estadoDirMaserati.setText("Vigilando");
                }
                
                sleep(500);
                
                mutex.release(); //signal
                if (MercadoAutomotriz.DuracionDiatxt>0){
                   sleep(MercadoAutomotriz.DuracionDiatxt); 
                }else{
                    sleep(5000);
                }
                        
            }catch(InterruptedException ex){
                Logger.getLogger(Creador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
}
