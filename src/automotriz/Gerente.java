/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automotriz;

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
    
    public static volatile Integer contadorEntrega = 30; 
    public static volatile Integer atrapado = 0;
    public static volatile Integer descuento = 0;
    public static volatile String estado = "activo";
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
                    InterfazMain.EntregaLamborghini.setText(String.valueOf(contadorEntrega));
                }else{
                    System.out.println("El gerente notifica que ya se pueden entregar los carros al director");
                }
                
                MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + 480;
                System.out.println("El gerente ha registrado " + MercadoAutomotriz.Nomina + " pagos en nomina");
                InterfazMain.GananciasLamborghini.setText(String.valueOf(MercadoAutomotriz.Nomina));
                
                if (Director.momento < 36 && Director.momento%2==1){
                    System.out.println("Pillado");
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina - 50;
                    MercadoAutomotriz.Pillado = MercadoAutomotriz.Pillado +1;
                    InterfazMain.FaltasGerenteLamborghini1.setText(String.valueOf(MercadoAutomotriz.Pillado));
                    InterfazMain.GananciasLamborghini.setText(String.valueOf(MercadoAutomotriz.Nomina));
                    estado = "Procrastinando";
                    InterfazMain.estadoGerLamborghini.setText(String.valueOf(estado));
                    MercadoAutomotriz.Descontado = MercadoAutomotriz.Descontado +50;
                    InterfazMain.SalarioPerdidoLamborghini.setText(String.valueOf(MercadoAutomotriz.Descontado));
                    
                }else{
                    estado = "Laborando";
                    InterfazMain.estadoGerLamborghini.setText(String.valueOf(estado));
                    System.out.println("Laborando");}
                
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
