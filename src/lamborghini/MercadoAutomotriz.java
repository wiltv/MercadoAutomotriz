/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lamborghini;

import java.util.concurrent.Semaphore;
import Interfaces.InterfazMain;
/**
 *
 * @author wiltsson
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
    
    public static volatile Integer Empleados = 16;
    
    public static volatile Integer CarrosMase = 0;
    public static volatile Integer NominaMase = 0;
    public static volatile Integer GananciaMase = 0;
    
    
    public static volatile float diasChasisMase = 0f;
    public static volatile float diasCarroceriaMase = 0f;
    public static volatile float diasMotorMase = 0f;
    public static volatile float diasRuedaMase = 0f;
    public static volatile float diasAccesorioMase = 0f;
    
    public static volatile Integer EmpleadosMase = 13;
        
    public static void main(String[] args) {
        
        InterfazMain interfaz = new InterfazMain();
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);
        
        Semaphore mainMutexLambo = new Semaphore(1);
        Semaphore mainMutexMase = new Semaphore(1);
        
        Creador chasis = new Creador(mainMutexLambo, "chasis",Almacen.AlmacenChasis,0.25f,10);
        Creador carroceria = new Creador(mainMutexLambo, "carroceria",Almacen.AlmacenCarroceria,0.25f,13);
        Creador motor = new Creador(mainMutexLambo, "motor",Almacen.AlmacenMotor,1f,20);
        Creador ruedas = new Creador(mainMutexLambo, "ruedas",Almacen.AlmacenRuedas,5f,8);
        Creador accesorio = new Creador(mainMutexLambo, "accesorio",Almacen.AlmacenAccesorio,0.5f,17);
        Ensamblador ensamblador = new Ensamblador(mainMutexLambo,0.5f);
        Gerente gerente = new Gerente(mainMutexLambo);
        Director director = new Director(mainMutexLambo);
        
        CreadorMase chasisM = new CreadorMase(mainMutexMase, "chasis",AlmacenMase.AlmacenChasisMase,0.334f,10);
        CreadorMase carroceriaM = new CreadorMase(mainMutexMase, "carroceria",AlmacenMase.AlmacenCarroceriaMase,0.334f,13);
        CreadorMase motorM = new CreadorMase(mainMutexLambo, "motor",AlmacenMase.AlmacenMotorMase,2f,20);
        CreadorMase ruedasM = new CreadorMase(mainMutexMase, "ruedas",AlmacenMase.AlmacenRuedasMase,3f,8);
        CreadorMase accesorioM = new CreadorMase(mainMutexLambo, "accesorio",AlmacenMase.AlmacenAccesorioMase,10.334f,17);
        EnsambladorMase ensambladorM = new EnsambladorMase(mainMutexMase,0.5f);
        GerenteMase gerenteM = new GerenteMase(mainMutexMase);
        DirectorMase directorM = new DirectorMase(mainMutexMase);
        
        chasis.start();
        carroceria.start();
        motor.start();
        ruedas.start();
        accesorio.start();
        ensamblador.start();
        gerente.start();
        director.start();
        
        
        
        chasisM.start();
        carroceriaM.start();
        motorM.start();
        ruedasM.start();
        accesorioM.start();
        ensambladorM.start();
        gerenteM.start();
        directorM.start();
        
        
        
    }
    
}


//ERRORES: 
//  1.Cuando ensamblador toma piezas, el limite de la capacidad aumenta (ver porque no disminuye)