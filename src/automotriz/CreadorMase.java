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
public class CreadorMase extends Thread {
    
    private Semaphore mutex;
    private String parte;
    private Integer almacen;
    private float dias;
    private Integer salario;
    
    
    
    public CreadorMase(Semaphore mutex, String parte, Integer almacen, float dias, Integer salario){
        this.mutex = mutex;
        this.parte = parte;
        this.almacen = almacen;
        this.dias = dias;
        this.salario = salario;
    }
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //error
                if ("chasis".equals(parte)){
                    MercadoAutomotriz.NominaMase = MercadoAutomotriz.NominaMase + salario*24*EmpleadosMaserati.eChasisMase; 
                    MercadoAutomotriz.diasChasisMase = MercadoAutomotriz.diasChasisMase + dias*EmpleadosMaserati.eChasisMase;
                    if (MercadoAutomotriz.diasChasisMase >= 1){
                        if (AlmacenMase.ContChasisMase < almacen){
                            if (AlmacenMase.ContChasisMase + Math.round(MercadoAutomotriz.diasChasisMase) < AlmacenMase.AlmacenChasisMase){
                                 AlmacenMase.ContChasisMase = AlmacenMase.ContChasisMase + Math.round(MercadoAutomotriz.diasChasisMase);
                            }else{
                                AlmacenMase.ContChasisMase = AlmacenMase.AlmacenChasisMase;
                            }
                            System.out.println("Hay mase " + AlmacenMase.ContChasisMase + " unidades de " + parte);
                            InterfazMain.CantidadChasisMaserati.setText(String.valueOf(AlmacenMase.ContChasisMase));
                            MercadoAutomotriz.diasChasisMase = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador mase de chasis mase sigue trabajando " + MercadoAutomotriz.diasChasisMase);

                    }
                    
                    
                } else if ("carroceria".equals(parte)){
                    MercadoAutomotriz.NominaMase = MercadoAutomotriz.NominaMase + salario*24*EmpleadosMaserati.eCarroceriaMase; 
                    MercadoAutomotriz.diasCarroceriaMase = MercadoAutomotriz.diasCarroceriaMase + dias*EmpleadosMaserati.eCarroceriaMase;
                    if (MercadoAutomotriz.diasCarroceriaMase >= 1){
                        if (AlmacenMase.ContCarroceriaMase < almacen){
                            if (AlmacenMase.ContCarroceriaMase + Math.round(MercadoAutomotriz.diasCarroceriaMase) < AlmacenMase.AlmacenCarroceriaMase){
                                 AlmacenMase.ContCarroceriaMase = AlmacenMase.ContCarroceriaMase + Math.round(MercadoAutomotriz.diasCarroceriaMase);
                            }else{
                                AlmacenMase.ContCarroceriaMase = AlmacenMase.AlmacenCarroceriaMase;
                            }
                            System.out.println("Hay " + AlmacenMase.ContCarroceriaMase + " unidades de " + parte);
                            InterfazMain.CantidadCarroceriaMaserati.setText(String.valueOf(AlmacenMase.ContCarroceriaMase));
                            MercadoAutomotriz.diasCarroceriaMase = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador mase de carroceria sigue trabajando " + MercadoAutomotriz.diasCarroceriaMase);

                    }
                
                
                } else if ("motor".equals(parte)){
                    MercadoAutomotriz.NominaMase = MercadoAutomotriz.NominaMase + salario*24*EmpleadosMaserati.eMotorMase; 
                    MercadoAutomotriz.diasMotorMase = MercadoAutomotriz.diasMotorMase + dias*EmpleadosMaserati.eMotorMase;
                    if (MercadoAutomotriz.diasMotorMase >= 1){
                        if (AlmacenMase.ContMotorMase < almacen){
                            if (AlmacenMase.ContMotorMase + Math.round(MercadoAutomotriz.diasMotorMase) < AlmacenMase.AlmacenMotorMase){
                                 AlmacenMase.ContMotorMase = AlmacenMase.ContMotorMase + Math.round(MercadoAutomotriz.diasMotorMase);
                            }else{
                                AlmacenMase.ContMotorMase = AlmacenMase.AlmacenMotorMase;
                            }
                            System.out.println("Hay Mase" + AlmacenMase.ContMotorMase + " unidades de " + parte);
                            InterfazMain.CantidadMotorMaserati.setText(String.valueOf(AlmacenMase.ContMotorMase));
                            MercadoAutomotriz.diasMotorMase = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador mase de motir sigue trabajando " + MercadoAutomotriz.diasMotorMase);

                    }
                
                } else if ("ruedas".equals(parte)){
                    MercadoAutomotriz.NominaMase = MercadoAutomotriz.NominaMase + salario*24*EmpleadosMaserati.eRuedasMase; 
                    MercadoAutomotriz.diasRuedaMase = MercadoAutomotriz.diasMotorMase + dias*EmpleadosMaserati.eRuedasMase;
                    if (MercadoAutomotriz.diasRuedaMase >= 1){
                        if (AlmacenMase.ContRuedasMase < almacen){
                            if (AlmacenMase.ContRuedasMase + Math.round(MercadoAutomotriz.diasRuedaMase) < AlmacenMase.AlmacenRuedasMase){
                                 AlmacenMase.ContRuedasMase = AlmacenMase.ContRuedasMase + Math.round(MercadoAutomotriz.diasRuedaMase);
                            }else{
                                AlmacenMase.ContRuedasMase = AlmacenMase.AlmacenRuedasMase;
                            }
                            System.out.println("Hay Mase" + AlmacenMase.ContRuedasMase + " unidades de " + parte);
                            InterfazMain.CantidadRuedasMaserati.setText(String.valueOf(AlmacenMase.ContRuedasMase));
                            MercadoAutomotriz.diasRuedaMase = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador mase de ruedas sigue trabajando " + MercadoAutomotriz.diasRuedaMase);

                    }
                
                } else if ("accesorio".equals(parte)){
                    MercadoAutomotriz.NominaMase = MercadoAutomotriz.NominaMase + salario*24*EmpleadosMaserati.eAccesoriosMase; 
                    MercadoAutomotriz.diasAccesorioMase = MercadoAutomotriz.diasAccesorioMase + dias*EmpleadosMaserati.eAccesoriosMase;
                    if (MercadoAutomotriz.diasAccesorioMase >= 1){
                        if (AlmacenMase.ContAccesorioMase < almacen){
                            if (AlmacenMase.ContAccesorioMase + Math.round(MercadoAutomotriz.diasAccesorioMase) < AlmacenMase.AlmacenAccesorioMase){
                                 AlmacenMase.ContAccesorioMase = AlmacenMase.ContAccesorioMase + Math.round(MercadoAutomotriz.diasAccesorioMase);
                            }else{
                                AlmacenMase.ContAccesorioMase = AlmacenMase.AlmacenAccesorioMase;
                            }
                            System.out.println("Hay " + AlmacenMase.ContAccesorioMase + " unidades de " + parte);
                            InterfazMain.CantidadAccesoriosMaserati.setText(String.valueOf(AlmacenMase.ContAccesorioMase));
                            MercadoAutomotriz.diasAccesorioMase = 0f;}
                        else{
                            System.out.println("El almacen mase de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador mase de acesorio sigue trabajando " + MercadoAutomotriz.diasAccesorioMase);

                    }
                
                }
                
                sleep(500);
                
                mutex.release(); //signal
                sleep(5000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(CreadorMase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    
}
