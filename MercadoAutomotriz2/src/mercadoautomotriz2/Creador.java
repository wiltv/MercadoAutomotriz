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
public class Creador extends Thread {
    
    private Semaphore mutex;
    private String parte;
    private Integer almacen;
    private float dias;
    private Integer salario;
    
    
    
    public Creador(Semaphore mutex, String parte, Integer almacen, float dias, Integer salario){
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
                mutex.acquire(); //wait
                
                if (parte == "chasis"){
                    MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + salario*24; //240 porque son 10$ 24 horas, eso se multiplcica pot el numero de empleados
                    MercadoAutomotriz2.diasChasis = MercadoAutomotriz2.diasChasis + dias;
                    if (MercadoAutomotriz2.diasChasis >= 1){
                        if (Almacen.ContChasis < almacen){
                            Almacen.ContChasis = Almacen.ContChasis 
                                    + Math.round(MercadoAutomotriz2.diasChasis);
                            System.out.println("Hay " + Almacen.ContChasis + " unidades de " + parte);
                            MercadoAutomotriz2.diasChasis = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de chasis sigue trabajando " + MercadoAutomotriz2.diasChasis);

                    }
                    
                    
                } else if (parte == "carroceria"){
                    MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + salario*24; //240 porque son 10$ 24 horas, eso se multiplcica pot el numero de empleados
                    MercadoAutomotriz2.diasCarroceria = MercadoAutomotriz2.diasCarroceria + dias;
                    if (MercadoAutomotriz2.diasCarroceria >= 1){
                        if (Almacen.ContCarroceria < almacen){
                            Almacen.ContCarroceria = Almacen.ContCarroceria 
                                    + Math.round(MercadoAutomotriz2.diasCarroceria);
                            System.out.println("Hay " + Almacen.ContCarroceria + " unidades de " + parte);
                            MercadoAutomotriz2.diasCarroceria = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de carroceria sigue trabajando " + MercadoAutomotriz2.diasCarroceria);

                    }
                
                
                } else if (parte == "motor"){
                    MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + salario*24; //240 porque son 10$ 24 horas, eso se multiplcica pot el numero de empleados
                    MercadoAutomotriz2.diasMotor = MercadoAutomotriz2.diasMotor + dias;
                    if (MercadoAutomotriz2.diasMotor >= 1){
                        if (Almacen.ContMotor < almacen){
                            Almacen.ContMotor = Almacen.ContMotor 
                                    + Math.round(MercadoAutomotriz2.diasMotor);
                            System.out.println("Hay " + Almacen.ContMotor + " unidades de " + parte);
                            MercadoAutomotriz2.diasMotor = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de motir sigue trabajando " + MercadoAutomotriz2.diasMotor);

                    }
                
                } else if (parte == "ruedas"){
                    MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + salario*24; //240 porque son 10$ 24 horas, eso se multiplcica pot el numero de empleados
                    MercadoAutomotriz2.diasRueda = MercadoAutomotriz2.diasMotor + dias;
                    if (MercadoAutomotriz2.diasRueda >= 1){
                        if (Almacen.ContRuedas < almacen){
                            Almacen.ContRuedas = Almacen.ContRuedas 
                                    + Math.round(MercadoAutomotriz2.diasRueda);
                            System.out.println("Hay " + Almacen.ContRuedas + " unidades de " + parte);
                            MercadoAutomotriz2.diasRueda = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de ruedas sigue trabajando " + MercadoAutomotriz2.diasRueda);

                    }
                
                } else if (parte == "accesorio"){
                    MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + salario*24; //240 porque son 10$ 24 horas, eso se multiplcica pot el numero de empleados
                    MercadoAutomotriz2.diasAccesorio = MercadoAutomotriz2.diasAccesorio + dias;
                    if (MercadoAutomotriz2.diasAccesorio >= 1){
                        if (Almacen.ContAccesorio < almacen){
                            Almacen.ContAccesorio = Almacen.ContAccesorio 
                                    + Math.round(MercadoAutomotriz2.diasAccesorio);
                            System.out.println("Hay " + Almacen.ContAccesorio + " unidades de " + parte);
                            MercadoAutomotriz2.diasRueda = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de acesorio sigue trabajando " + MercadoAutomotriz2.diasAccesorio);

                    }
                
                }
                
                
               
                
                sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                        
            }catch(InterruptedException ex){
                Logger.getLogger(Creador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    
}
