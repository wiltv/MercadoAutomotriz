/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mercadoautomotriz2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author wiltsson
 */
public class MercadoAutomotriz2 {

    /**
     * @param args the command line arguments
     */
    public static volatile Integer ContChasis = 0;
    public static volatile Integer ContCarroceria = 0;
    public static volatile Integer ContMotor = 0;
    public static volatile Integer ContRuedas = 0;
    public static volatile Integer ContAccesorio = 0;
    public static volatile Integer Carros = 0;
    public static Integer AlmacenChasis = 25;
    public static Integer AlmacenCarroceria = 20;
    public static Integer AlmacenMotor = 55;
    public static Integer AlmacenRuedas = 35;
    public static Integer AlmacenAccesorio = 10;
        
    public static void main(String[] args) {
        
        
        Semaphore mainMutex = new Semaphore(1);
        
        CreadorChasis chasis = new CreadorChasis(mainMutex, "chasis",AlmacenChasis,0.25f);
        CreadorCarroceria carroceria = new CreadorCarroceria(mainMutex, "carroceria",AlmacenCarroceria,0.25f);
        CreadorMotor motor = new CreadorMotor(mainMutex, "motor",AlmacenMotor,1f);
        CreadorRueda ruedas = new CreadorRueda(mainMutex, "ruedas",AlmacenRuedas,5f);
        CreadorAccesorio accesorio = new CreadorAccesorio(mainMutex, "accesorio",AlmacenAccesorio,0.5f);
        Ensamblador ensamblador = new Ensamblador(mainMutex);
        
        chasis.start();
        carroceria.start();
        motor.start();
        ruedas.start();
        accesorio.start();
        ensamblador.start();
        
        
    }
    
}
