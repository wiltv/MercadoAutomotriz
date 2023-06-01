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
                if ("chasis".equals(parte)){
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + salario*24*EmpleadosLamborghini.eChasis; 
                    MercadoAutomotriz.diasChasis = MercadoAutomotriz.diasChasis + dias*EmpleadosLamborghini.eChasis;
                    if (MercadoAutomotriz.diasChasis >= 1){
                        if (Almacen.ContChasis < almacen){
                            if (Almacen.ContChasis + Math.round(MercadoAutomotriz.diasChasis) < Almacen.AlmacenChasis){
                                 Almacen.ContChasis = Almacen.ContChasis + Math.round(MercadoAutomotriz.diasChasis);
                            }else{
                                Almacen.ContChasis = Almacen.AlmacenChasis;
                            }
                            System.out.println("Hay " + Almacen.ContChasis + " unidades de " + parte);
                            InterfazMain.CantidadChasisLamborghini.setText(String.valueOf(Almacen.ContChasis));
                            MercadoAutomotriz.diasChasis = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de chasis sigue trabajando " + MercadoAutomotriz.diasChasis);

                    }
                    
                    
                } else if ("carroceria".equals(parte)){
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + salario*24*EmpleadosLamborghini.eCarroceria; 
                    MercadoAutomotriz.diasCarroceria = MercadoAutomotriz.diasCarroceria + dias*EmpleadosLamborghini.eCarroceria;
                    if (MercadoAutomotriz.diasCarroceria >= 1){
                       if (Almacen.ContCarroceria < almacen){
                            if (Almacen.ContCarroceria + Math.round(MercadoAutomotriz.diasCarroceria) < Almacen.AlmacenCarroceria){
                                 Almacen.ContCarroceria = Almacen.ContCarroceria + Math.round(MercadoAutomotriz.diasCarroceria);
                            }else{
                                Almacen.ContCarroceria = Almacen.AlmacenCarroceria;
                            }
                            System.out.println("Hay " + Almacen.ContCarroceria + " unidades de " + parte);
                            InterfazMain.CantidadCarroceriaLamborghini.setText(String.valueOf(Almacen.ContCarroceria));
                            MercadoAutomotriz.diasCarroceria = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de carroceria sigue trabajando " + MercadoAutomotriz.diasCarroceria);

                    }
                
                
                } else if ("motor".equals(parte)){
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + salario*24*EmpleadosLamborghini.eMotor; 
                    MercadoAutomotriz.diasMotor = MercadoAutomotriz.diasMotor + dias*EmpleadosLamborghini.eMotor;
                    if (MercadoAutomotriz.diasMotor >= 1){
                        if (Almacen.ContMotor < almacen){
                            if (Almacen.ContMotor + Math.round(MercadoAutomotriz.diasMotor) < Almacen.AlmacenMotor){
                                 Almacen.ContMotor = Almacen.ContMotor + Math.round(MercadoAutomotriz.diasMotor);
                            }else{
                                Almacen.ContMotor = Almacen.AlmacenMotor;
                            }
                            System.out.println("Hay " + Almacen.ContMotor + " unidades de " + parte);
                            InterfazMain.CantidadMotorLamborghini.setText(String.valueOf(Almacen.ContMotor));
                            MercadoAutomotriz.diasMotor = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de motir sigue trabajando " + MercadoAutomotriz.diasMotor);

                    }
                
                } else if ("ruedas".equals(parte)){
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + salario*24*EmpleadosLamborghini.eRuedas; 
                    MercadoAutomotriz.diasRueda = MercadoAutomotriz.diasMotor + dias*EmpleadosLamborghini.eRuedas;
                    if (MercadoAutomotriz.diasRueda >= 1){
                        if (Almacen.ContRuedas < almacen){
                            if (Almacen.ContRuedas + Math.round(MercadoAutomotriz.diasRueda) < Almacen.AlmacenRuedas){
                                 Almacen.ContRuedas = Almacen.ContRuedas + Math.round(MercadoAutomotriz.diasRueda);
                            }else{
                                Almacen.ContRuedas = Almacen.AlmacenRuedas;
                            }
                            System.out.println("Hay " + Almacen.ContRuedas + " unidades de " + parte);
                            InterfazMain.CantidadRuedasLamborghini.setText(String.valueOf(Almacen.ContRuedas));
                            MercadoAutomotriz.diasRueda = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de ruedas sigue trabajando " + MercadoAutomotriz.diasRueda);

                    }
                
                } else if ("accesorio".equals(parte)){
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + salario*24*EmpleadosLamborghini.eAccesorios; 
                    MercadoAutomotriz.diasAccesorio = MercadoAutomotriz.diasAccesorio + dias*EmpleadosLamborghini.eAccesorios;
                    if (MercadoAutomotriz.diasAccesorio >= 1){
                        if (Almacen.ContAccesorio < almacen){
                            if (Almacen.ContAccesorio + Math.round(MercadoAutomotriz.diasAccesorio) < Almacen.AlmacenAccesorio){
                                 Almacen.ContAccesorio = Almacen.ContAccesorio + Math.round(MercadoAutomotriz.diasAccesorio);
                            }else{
                                Almacen.ContAccesorio = Almacen.AlmacenAccesorio;
                            }
                            System.out.println("Hay " + Almacen.ContAccesorio + " unidades de " + parte);
                            InterfazMain.CantidadAccesoriosLamborghini.setText(String.valueOf(Almacen.ContAccesorio));
                            MercadoAutomotriz.diasAccesorio = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de acesorio sigue trabajando " + MercadoAutomotriz.diasAccesorio);

                    }
                
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
