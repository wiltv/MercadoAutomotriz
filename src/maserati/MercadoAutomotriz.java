/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maserati;

import java.util.concurrent.Semaphore;
import Interfaces.InterfazMain;
/**
 *
 * @author valeria
 */
public class MercadoAutomotriz {

    /**
     * @param args the command line arguments
     */
    public static volatile Integer Carros = 0;
    public static volatile Integer Nomina = 0;
    public static volatile Integer Ganancia = 0;
    
    
    public static volatile float diasChasis = 0f;
    public static volatile float diasCarroceria = 0f;
    public static volatile float diasMotor = 0f;
    public static volatile float diasRueda = 0f;
    public static volatile float diasAccesorio = 0f;
    
    public static volatile Integer Empleados = 19;
    
        
    public static void main(String[] args) {
        
        InterfazMain interfaz = new InterfazMain();
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);
        
        Semaphore mainMutex = new Semaphore(1);
        
        Creador chasis = new Creador(mainMutex, "chasis",Almacen.AlmacenChasis,0.25f,10);
        Creador carroceria = new Creador(mainMutex, "carroceria",Almacen.AlmacenCarroceria,0.25f,13);
        Creador motor = new Creador(mainMutex, "motor",Almacen.AlmacenMotor,1f,20);
        Creador ruedas = new Creador(mainMutex, "ruedas",Almacen.AlmacenRuedas,5f,8);
        Creador accesorio = new Creador(mainMutex, "accesorio",Almacen.AlmacenAccesorio,0.5f,17);
        Ensamblador ensamblador = new Ensamblador(mainMutex,0.5f);
        Gerente gerente = new Gerente(mainMutex);
        Director director = new Director(mainMutex);
        
        chasis.start();
        carroceria.start();
        motor.start();
        ruedas.start();
        accesorio.start();
        ensamblador.start();
        gerente.start();
        director.start();
        
        
    }
    
}


//ERRORES: 
//  1.Cuando ensamblador toma piezas, el limite de la capacidad aumenta (ver porque no disminuye)