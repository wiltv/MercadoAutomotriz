/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automotriz;

import Interfaces.InterfazMain;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valeria
 */
public class EnsambladorMase extends Thread{
    private Semaphore mutex;
    private float dias;
    
    public static volatile float diasEnsambladorMase = 0f;
    
    public EnsambladorMase(Semaphore mutex, float dias){
        this.mutex = mutex;
        this.dias = dias;
        
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                MercadoAutomotriz.NominaMase = MercadoAutomotriz.NominaMase + 600*EmpleadosMaserati.eEnsambladorMase;
                MercadoAutomotriz.GananciaBrutoMase = MercadoAutomotriz.GananciaBrutoMase - 600*EmpleadosMaserati.eEnsambladorMase;
                diasEnsambladorMase = diasEnsambladorMase + dias*EmpleadosMaserati.eEnsambladorMase;
                if(diasEnsambladorMase>=1){
                    if (AlmacenMase.ContChasisMase >=1 && AlmacenMase.ContMotorMase >= 2
                            && AlmacenMase.ContCarroceriaMase >= 1 && AlmacenMase.ContRuedasMase >= 4){


                        AlmacenMase.ContChasisMase = AlmacenMase.ContChasisMase -1;
                        AlmacenMase.ContMotorMase = AlmacenMase.ContMotorMase - 2;
                        AlmacenMase.ContCarroceriaMase = AlmacenMase.ContCarroceriaMase - 1;
                        AlmacenMase.ContRuedasMase = AlmacenMase.ContRuedasMase - 4;
                        MercadoAutomotriz.CarrosMase = MercadoAutomotriz.CarrosMase + 1;
                        
                           
                        if(MercadoAutomotriz.CarrosMase %3 == 0 && MercadoAutomotriz.CarrosMase!=0){
                            
                            AlmacenMase.ContAccesorioMase = AlmacenMase.ContAccesorioMase - 3;
                            System.out.println("Hay " + MercadoAutomotriz.CarrosMase + " carros, este viene con accesorio");
                            InterfazMain.CantidadAccesoriosMaserati.setText(String.valueOf(AlmacenMase.ContAccesorioMase));
                            //MercadoAutomotriz.CarrosAccsMase = MercadoAutomotriz.CarrosAccsMase +1;
                            InterfazMain.AccsMaserati.setText(String.valueOf(MercadoAutomotriz.CarrosMase/3));
                        }else{
                            System.out.println("Hay " + MercadoAutomotriz.CarrosMase + " carros"); 
                            
                            InterfazMain.CantidadCarrosMaserati.setText(String.valueOf(MercadoAutomotriz.CarrosMase));
                        }
                        Integer estandar = MercadoAutomotriz.CarrosMase - Math.round(MercadoAutomotriz.CarrosMase/4);
                        InterfazMain.AccsMaserati1.setText(String.valueOf(estandar));
                        InterfazMain.CantidadCarrosMaserati.setText(String.valueOf(MercadoAutomotriz.CarrosMase));
                        InterfazMain.CantidadChasisMaserati.setText(String.valueOf(AlmacenMase.ContChasisMase));
                        InterfazMain.CantidadCarroceriaMaserati.setText(String.valueOf(AlmacenMase.ContCarroceriaMase));
                        InterfazMain.CantidadMotorMaserati.setText(String.valueOf(AlmacenMase.ContMotorMase));
                        InterfazMain.CantidadRuedasMaserati.setText(String.valueOf(AlmacenMase.ContRuedasMase));
                        diasEnsambladorMase = 0f;
                    }else{
                        System.out.println("No hay suficientes piezas, el ensamblador espera");       
                    }
                }else{
                    System.out.println("El ensamblador sigue trabajando " + diasEnsambladorMase);
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
