/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamborghini;
import Interfaces.InterfazMain;
import java.io.*;

/**
 *
 * @author Valeria
 */
public class Leetxt {
    
    public static int leertxt(){
      System.out.println("ENTRAAA");
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      Integer cont = 0;
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("C:\\algo.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
            cont = cont +1;
            if (cont == 1){
                MercadoAutomotriz.DuracionDiatxt = Integer.parseInt(linea);
            }
            else if (cont == 2){
                Gerente.contadorEntrega = Integer.parseInt(linea);
                GerenteMase.contadorEntregaMase = Integer.parseInt(linea);
                MercadoAutomotriz.DiasEntregatxt = Integer.parseInt(linea);
                InterfazMain.EstandarLamborghini.setText(String.valueOf(GerenteMase.contadorEntregaMase));
                InterfazMain.EntregaMaserati.setText(String.valueOf(GerenteMase.contadorEntregaMase));
            }else if(cont == 3){
                EmpleadosLamborghini.eChasis = Integer.parseInt(linea);
                EmpleadosMaserati.eChasisMase = Integer.parseInt(linea);
                MercadoAutomotriz.Chasistxt = Integer.parseInt(linea);
                InterfazMain.eChasisLamborghini.setText(String.valueOf(EmpleadosLamborghini.eChasis));
                InterfazMain.eChasisMaserati.setText(String.valueOf(EmpleadosMaserati.eChasisMase));
            }else if(cont == 4){
                EmpleadosLamborghini.eCarroceria = Integer.parseInt(linea);
                EmpleadosMaserati.eCarroceriaMase = Integer.parseInt(linea);
                MercadoAutomotriz.Carroceriatxt = Integer.parseInt(linea);
                System.out.println(MercadoAutomotriz.Carroceriatxt);
                InterfazMain.eCarroceriaLamborghini.setText(String.valueOf(MercadoAutomotriz.Carroceriatxt));
                InterfazMain.eCarroceriaMaserati.setText(String.valueOf(MercadoAutomotriz.Carroceriatxt));
            }else if(cont == 5){
                EmpleadosLamborghini.eMotor = Integer.parseInt(linea);
                System.out.println(linea);
                EmpleadosMaserati.eMotorMase = Integer.parseInt(linea);
                MercadoAutomotriz.Motortxt = Integer.parseInt(linea);
                InterfazMain.eMotorLamborghini.setText(String.valueOf(MercadoAutomotriz.Motortxt));
                InterfazMain.eMotorMaserati.setText(String.valueOf(MercadoAutomotriz.Motortxt));
            }else if(cont == 6){
                EmpleadosLamborghini.eRuedas = Integer.parseInt(linea);
                EmpleadosMaserati.eRuedasMase = Integer.parseInt(linea);
                MercadoAutomotriz.Ruedastxt = Integer.parseInt(linea);
                InterfazMain.CantidadRuedasLamborghini.setText(String.valueOf(MercadoAutomotriz.Ruedastxt));
                InterfazMain.CantidadRuedasMaserati.setText(String.valueOf(MercadoAutomotriz.Ruedastxt));
            }else if(cont == 7){
                EmpleadosLamborghini.eAccesorios = Integer.parseInt(linea);
                EmpleadosMaserati.eAccesoriosMase = Integer.parseInt(linea);
                MercadoAutomotriz.Accesoriostxt = Integer.parseInt(linea);
                InterfazMain.eCarroceriaLamborghini.setText(String.valueOf(MercadoAutomotriz.Accesoriostxt));
                InterfazMain.eAccesoriosMaserati.setText(String.valueOf(MercadoAutomotriz.Accesoriostxt));
            }else if(cont == 8){
                EmpleadosLamborghini.eEnsamblador = Integer.parseInt(linea);
                EmpleadosMaserati.eEnsambladorMase = Integer.parseInt(linea);
                MercadoAutomotriz.Ensabladortxt = Integer.parseInt(linea);
                InterfazMain.eEnsambladorLamborghini.setText(String.valueOf(MercadoAutomotriz.Ensabladortxt));
                InterfazMain.eEnsambladorMaserati.setText(String.valueOf(MercadoAutomotriz.Ensabladortxt));
            }
      
           
      }}
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }return 0;
   }
}

