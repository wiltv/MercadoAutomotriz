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
    public static void main(String[] args) {
        
        
        Semaphore mainMutex = new Semaphore(1);
        Integer ContChasis = 0;
        Integer ContCarroceria = 0;
        Integer ContMotor = 0;
        Integer ContRuedas = 0;
        Integer AlmacenChasis = 25;
        Integer AlmacenCarroceria = 20;
        Integer AlmacenMotor = 55;
        Integer AlmacenRuedas = 35;
        SemaforoLamborguini chasis = new SemaforoLamborguini(ContChasis,mainMutex, "chasis",AlmacenChasis);
        SemaforoLamborguini carroceria = new SemaforoLamborguini(ContCarroceria,mainMutex, "carroceria",AlmacenCarroceria);
        SemaforoLamborguini motor = new SemaforoLamborguini(ContMotor,mainMutex, "motor",AlmacenMotor);
        SemaforoLamborguini ruedas = new SemaforoLamborguini(ContRuedas,mainMutex, "ruedas",AlmacenRuedas);
        
        chasis.start();
        carroceria.start();
        motor.start();
        ruedas.start();
        
        
    }
    
}