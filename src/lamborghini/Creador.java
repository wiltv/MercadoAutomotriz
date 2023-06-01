/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lamborghini;
    
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
                //ERROR GRAVE, SI POR EJEMPLO HAY 7/3, SE TOMAN COMO DOS Y ESE 1/3 ES COMO SI NO EXISTE
                //PAJA PEOR AUN, ANDO ES REDONDEANDO
                //OTRO ERROR, CUANDO FALTA POCO PARA QUE SE LLENE LA COSA, SI NO ES EXACTO NO SE LLENA
                if (parte == "chasis"){
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + salario*24*Empleados.eChasis; 
                    MercadoAutomotriz.diasChasis = MercadoAutomotriz.diasChasis + dias*Empleados.eChasis;
                    if (MercadoAutomotriz.diasChasis >= 1){
                        if (Almacen.ContChasis < almacen){
                            Almacen.ContChasis = Almacen.ContChasis 
                                    + Math.round(MercadoAutomotriz.diasChasis);
                            System.out.println("Hay " + Almacen.ContChasis + " unidades de " + parte);
                            InterfazMain.CantidadChasis.setText(String.valueOf(Almacen.ContChasis));
                            MercadoAutomotriz.diasChasis = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de chasis sigue trabajando " + MercadoAutomotriz.diasChasis);

                    }
                    
                    
                } else if (parte == "carroceria"){
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + salario*24*Empleados.eCarroceria; 
                    MercadoAutomotriz.diasCarroceria = MercadoAutomotriz.diasCarroceria + dias*Empleados.eCarroceria;
                    if (MercadoAutomotriz.diasCarroceria >= 1){
                        if (Almacen.ContCarroceria < almacen){
                            Almacen.ContCarroceria = Almacen.ContCarroceria 
                                    + Math.round(MercadoAutomotriz.diasCarroceria);
                            System.out.println("Hay " + Almacen.ContCarroceria + " unidades de " + parte);
                            InterfazMain.CantidadCarroceria.setText(String.valueOf(Almacen.ContCarroceria));
                            MercadoAutomotriz.diasCarroceria = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de carroceria sigue trabajando " + MercadoAutomotriz.diasCarroceria);

                    }
                
                
                } else if (parte == "motor"){
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + salario*24*Empleados.eMotor; 
                    MercadoAutomotriz.diasMotor = MercadoAutomotriz.diasMotor + dias*Empleados.eMotor;
                    if (MercadoAutomotriz.diasMotor >= 1){
                        if (Almacen.ContMotor < almacen){
                            Almacen.ContMotor = Almacen.ContMotor 
                                    + Math.round(MercadoAutomotriz.diasMotor);
                            System.out.println("Hay " + Almacen.ContMotor + " unidades de " + parte);
                            InterfazMain.CantidadMotor.setText(String.valueOf(Almacen.ContMotor));
                            MercadoAutomotriz.diasMotor = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de motir sigue trabajando " + MercadoAutomotriz.diasMotor);

                    }
                
                } else if (parte == "ruedas"){
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + salario*24*Empleados.eRuedas; 
                    MercadoAutomotriz.diasRueda = MercadoAutomotriz.diasMotor + dias*Empleados.eRuedas;
                    if (MercadoAutomotriz.diasRueda >= 1){
                        if (Almacen.ContRuedas < almacen){
                            Almacen.ContRuedas = Almacen.ContRuedas 
                                    + Math.round(MercadoAutomotriz.diasRueda);
                            System.out.println("Hay " + Almacen.ContRuedas + " unidades de " + parte);
                            InterfazMain.CantidadRuedas.setText(String.valueOf(Almacen.ContRuedas));
                            MercadoAutomotriz.diasRueda = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de ruedas sigue trabajando " + MercadoAutomotriz.diasRueda);

                    }
                
                } else if (parte == "accesorio"){
                    MercadoAutomotriz.Nomina = MercadoAutomotriz.Nomina + salario*24*Empleados.eAccesorios; 
                    MercadoAutomotriz.diasAccesorio = MercadoAutomotriz.diasAccesorio + dias*Empleados.eAccesorios;
                    if (MercadoAutomotriz.diasAccesorio >= 1){
                        if (Almacen.ContAccesorio < almacen){
                            Almacen.ContAccesorio = Almacen.ContAccesorio 
                                    + Math.round(MercadoAutomotriz.diasAccesorio);
                            System.out.println("Hay " + Almacen.ContAccesorio + " unidades de " + parte);
                            InterfazMain.CantidadAccesorios.setText(String.valueOf(Almacen.ContAccesorio));
                            MercadoAutomotriz.diasRueda = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de acesorio sigue trabajando " + MercadoAutomotriz.diasAccesorio);

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
