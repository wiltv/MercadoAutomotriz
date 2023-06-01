/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercadoautomotriz2;
    
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
                    MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + salario*24*Empleados.eChasis; 
                    MercadoAutomotriz2.diasChasis = MercadoAutomotriz2.diasChasis + dias*Empleados.eChasis;
                    if (MercadoAutomotriz2.diasChasis >= 1){
                        if (Almacen.ContChasis < almacen){
                            Almacen.ContChasis = Almacen.ContChasis 
                                    + Math.round(MercadoAutomotriz2.diasChasis);
                            System.out.println("Hay " + Almacen.ContChasis + " unidades de " + parte);
                            InterfazMain.CantidadChasis.setText(String.valueOf(Almacen.ContChasis));
                            MercadoAutomotriz2.diasChasis = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de chasis sigue trabajando " + MercadoAutomotriz2.diasChasis);

                    }
                    
                    
                } else if (parte == "carroceria"){
                    MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + salario*24*Empleados.eCarroceria; 
                    MercadoAutomotriz2.diasCarroceria = MercadoAutomotriz2.diasCarroceria + dias*Empleados.eCarroceria;
                    if (MercadoAutomotriz2.diasCarroceria >= 1){
                        if (Almacen.ContCarroceria < almacen){
                            Almacen.ContCarroceria = Almacen.ContCarroceria 
                                    + Math.round(MercadoAutomotriz2.diasCarroceria);
                            System.out.println("Hay " + Almacen.ContCarroceria + " unidades de " + parte);
                            InterfazMain.CantidadCarroceria.setText(String.valueOf(Almacen.ContCarroceria));
                            MercadoAutomotriz2.diasCarroceria = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de carroceria sigue trabajando " + MercadoAutomotriz2.diasCarroceria);

                    }
                
                
                } else if (parte == "motor"){
                    MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + salario*24*Empleados.eMotor; 
                    MercadoAutomotriz2.diasMotor = MercadoAutomotriz2.diasMotor + dias*Empleados.eMotor;
                    if (MercadoAutomotriz2.diasMotor >= 1){
                        if (Almacen.ContMotor < almacen){
                            Almacen.ContMotor = Almacen.ContMotor 
                                    + Math.round(MercadoAutomotriz2.diasMotor);
                            System.out.println("Hay " + Almacen.ContMotor + " unidades de " + parte);
                            InterfazMain.CantidadMotor.setText(String.valueOf(Almacen.ContMotor));
                            MercadoAutomotriz2.diasMotor = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de motir sigue trabajando " + MercadoAutomotriz2.diasMotor);

                    }
                
                } else if (parte == "ruedas"){
                    MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + salario*24*Empleados.eRuedas; 
                    MercadoAutomotriz2.diasRueda = MercadoAutomotriz2.diasMotor + dias*Empleados.eRuedas;
                    if (MercadoAutomotriz2.diasRueda >= 1){
                        if (Almacen.ContRuedas < almacen){
                            Almacen.ContRuedas = Almacen.ContRuedas 
                                    + Math.round(MercadoAutomotriz2.diasRueda);
                            System.out.println("Hay " + Almacen.ContRuedas + " unidades de " + parte);
                            InterfazMain.CantidadRuedas.setText(String.valueOf(Almacen.ContRuedas));
                            MercadoAutomotriz2.diasRueda = 0f;}
                        else{
                            System.out.println("El almacen de " + parte + " de capacidad " + almacen + " esta lleno" );
                        }
                    }else{
                        System.out.println("El creador de ruedas sigue trabajando " + MercadoAutomotriz2.diasRueda);

                    }
                
                } else if (parte == "accesorio"){
                    MercadoAutomotriz2.Nomina = MercadoAutomotriz2.Nomina + salario*24*Empleados.eAccesorios; 
                    MercadoAutomotriz2.diasAccesorio = MercadoAutomotriz2.diasAccesorio + dias*Empleados.eAccesorios;
                    if (MercadoAutomotriz2.diasAccesorio >= 1){
                        if (Almacen.ContAccesorio < almacen){
                            Almacen.ContAccesorio = Almacen.ContAccesorio 
                                    + Math.round(MercadoAutomotriz2.diasAccesorio);
                            System.out.println("Hay " + Almacen.ContAccesorio + " unidades de " + parte);
                            InterfazMain.CantidadAccesorios.setText(String.valueOf(Almacen.ContAccesorio));
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
