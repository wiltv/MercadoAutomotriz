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
 * @author wiltsson
 */
public class Ensamblador extends Thread{
    private Semaphore mutex;
    private float dias;
    
    public static volatile float diasEnsamblador = 0f;
    
    public Ensamblador(Semaphore mutex, float dias){
        this.mutex = mutex;
        this.dias = dias;
        
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + 600*EmpleadosLamborghini.eEnsamblador;
                MercadoAutomotriz.Ganancia = MercadoAutomotriz.Ganancia - 600*EmpleadosLamborghini.eEnsamblador;
                MercadoAutomotriz.GananciaBruto = MercadoAutomotriz.GananciaBruto - 600*EmpleadosLamborghini.eEnsamblador;
                diasEnsamblador = diasEnsamblador + dias*EmpleadosLamborghini.eEnsamblador;
                if(diasEnsamblador>=1){
                    if (Almacen.ContChasis >=2 && Almacen.ContMotor >= 6
                            && Almacen.ContCarroceria >= 1 && Almacen.ContRuedas >= 5){


                        Almacen.ContChasis = Almacen.ContChasis -2;
                        Almacen.ContMotor = Almacen.ContMotor - 6;
                        Almacen.ContCarroceria = Almacen.ContCarroceria - 1;
                        Almacen.ContRuedas = Almacen.ContRuedas - 5;
                        MercadoAutomotriz.Carros = MercadoAutomotriz.Carros + 1;
                           
                        if(MercadoAutomotriz.Carros %4 == 0 && MercadoAutomotriz.Carros!=0){
                            Almacen.ContAccesorio = Almacen.ContAccesorio - 1;
                            //MercadoAutomotriz.CarrosAccs = MercadoAutomotriz.CarrosAccs + 1;
                            System.out.println("Hay " + MercadoAutomotriz.Carros + " carros, este viene con accesorio");
                            
                            InterfazMain.CantidadAccesoriosLamborghini.setText(String.valueOf(Almacen.ContAccesorio));
                            System.out.println(Math.round(MercadoAutomotriz.Carros/4));
                            InterfazMain.AccsLamborghini.setText(String.valueOf(Math.round(MercadoAutomotriz.Carros/4)));       
                        }else{
                           
                           System.out.println("Hay " + MercadoAutomotriz.Carros + " carros"); 
                           InterfazMain.CantidadCarrosLamborghini.setText(String.valueOf(MercadoAutomotriz.Carros));
                        }
                        
                        Integer estandar = MercadoAutomotriz.Carros - Math.round(MercadoAutomotriz.Carros/4);
                        InterfazMain.EstandarLamborghini.setText(String.valueOf(estandar));
                        InterfazMain.CantidadCarrosLamborghini.setText(String.valueOf(MercadoAutomotriz.Carros));
                        InterfazMain.CantidadChasisLamborghini.setText(String.valueOf(Almacen.ContChasis));
                        InterfazMain.CantidadCarroceriaLamborghini.setText(String.valueOf(Almacen.ContCarroceria));
                        InterfazMain.CantidadMotorLamborghini.setText(String.valueOf(Almacen.ContMotor));
                        InterfazMain.CantidadRuedasLamborghini.setText(String.valueOf(Almacen.ContRuedas));
                        
                        diasEnsamblador = 0f;
                    }else{
                        System.out.println("No hay suficientes piezas, el ensamblador espera");       
                    }
                }else{
                    System.out.println("El ensamblador sigue trabajando " + diasEnsamblador);
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
