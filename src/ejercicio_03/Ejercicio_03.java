/*
Crear una clase llamada Alumno que mantenga información sobre las notas de
distintos alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de
tipo Integer con sus 3 notas.
En el main deberemos tener un bucle que crea un objeto Alumno. Se pide toda la
información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bluce tendremos el siguiente método en la clase Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su
nota final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método.
Dentro del método se usará la lista notas para calcular el promedio final de alumno.
Siendo este promedio final, devuelto por el método y mostrado en el main.
*/
package ejercicio_03;

import Entidades.Alumno;
import Servicios.AlumnoServicio;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class Ejercicio_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Este programa guarda las notas y nombres de alumnos y luego muestra la nota promedio de un alumno.");
        
        Scanner leer = new Scanner(System.in);
        ArrayList<Alumno> Alumnos = new ArrayList();
        ArrayList<Integer> notas;
        String nombre;
        String respuesta;
        boolean continuar=false;
        
        do{
            System.out.print("Ingrese el nombre del alumno: ");
            nombre=leer.nextLine();
            notas = new ArrayList();
            for(int i=0;i<3;i++){
                System.out.print("Ingrese la "+(i+1)+"º nota del alumno: ");
                notas.add(leer.nextInt());
            }
            
            Alumnos.add(new Alumno(nombre,notas));
            
            do{
                System.out.print("\n¿Desea agregar otro alumno?(s/n) ");
                respuesta = leer.next().toLowerCase();
                switch(respuesta){
                    case "s":
                        continuar=true;
                        break;
                    case "n":
                        continuar=false;
                        break;
                    default:
                        System.out.println("Opción no valida");
                }
            }while(!(respuesta.equals("s")||respuesta.equals("n")));
            leer.nextLine();
        }while(continuar==true);
        
        AlumnoServicio alumS = new AlumnoServicio();
        String buscar;
        
        do{
            System.out.print("\nIngrese el nombre del alumno que desea saber su nota final: ");
            buscar=leer.next();
            
            for (Alumno i : Alumnos) {
                if(i.getNombre().equals(buscar)){
                    System.out.println("La nota final del alumno "+buscar+" es "+alumS.notaFinal(i)+".");
                }
            }
            
            do{
                System.out.print("\n¿Desea calcular la nota final de otro alumno?(s/n) ");
                respuesta = leer.next().toLowerCase();
                switch(respuesta){
                    case "s":
                        continuar=true;
                        break;
                    case "n":
                        continuar=false;
                        System.out.println("Hasta prontos.");
                        break;
                    default:
                        System.out.println("Opción no valida");
                }
            }while(!(respuesta.equals("s")||respuesta.equals("n")));
            
        }while(continuar==true);
    }
    
}
