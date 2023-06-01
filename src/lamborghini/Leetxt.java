/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamborghini;
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
            if (cont == 2){
                System.out.println(linea);
                System.out.println(Gerente.contadorEntrega);
                Gerente.contadorEntrega = Integer.parseInt(linea);
                GerenteMase.contadorEntregaMase = Integer.parseInt(linea);
                MercadoAutomotriz.DiasEntregatxt = Integer.parseInt(linea);
                System.out.println(Gerente.contadorEntrega);
             }else if(cont == 3){
                System.out.println("ok");
      }
      
            System.out.println(linea);
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

