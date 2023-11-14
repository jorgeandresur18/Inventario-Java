
package ProyectoFinal;

import java.util.Scanner;

public class ProyectoFinal {
    
    public static void main(String[] args){
    Scanner teclado= new Scanner (System.in);
    Inventario l= new Inventario();
    ProyectoFinal p=new ProyectoFinal();
       int opc;
     
    do {
            System.out.println(" --------------------------");
            System.out.println("        Menú de Opciones   ");
            System.out.println(" --------------------------");
            System.out.println(" 1. Manejo de producto     ");
            System.out.println(" 2. Manejo de factura      ");
            System.out.println(" 3. Salir                  ");
            System.out.println(" --------------------------");
            System.out.print("Escoja una opción que desee: ");
             opc = teclado.nextInt();
            
            switch (opc) {
                case 1:
                  do {
            System.out.println(" -----------------------------");
            System.out.println("   Menú de opciones Producto  ");
            System.out.println(" -----------------------------");
            System.out.println(" 1. Ingresar     4. Eliminar  ");
            System.out.println(" 2. Consultar    5. Salir     ");
            System.out.println(" 3. Mostrar                   ");
            System.out.println(" -----------------------------");
            System.out.print("Escoja una opción que desee: ");
            opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    
                    l.InsertarProducto();
                    break;
                case 2:
                    
                    l.BuscarProducto();
                    break;
                case 3:
                    
                    l.MostrarProducto();
                   break;
                case 4:
                    
                    l.EliminarProducto();
                    break;
                case 5:
                    System.out.println("\n\n Programa ha culminado \n");
                    break;
                default:
                    System.out.println("\n\n Opcion incorrecta \n");
                    break;
            }

        } while (opc != 5);

                    break;
                case 2:
                    
                 do {
            System.out.println(" -------------------------------");
            System.out.println("     Menú de opciones Factura   ");
            System.out.println(" -------------------------------");
            System.out.println(" 1. Emitir       4. Anular      ");
            System.out.println(" 2. Consultar    5. Salir       ");
            System.out.println(" 3. Mostrar                     ");
            System.out.println(" -------------------------------");
            System.out.print("Escoja una opción que desee: ");
            opc = teclado.nextInt();
            switch (opc) {
                case 1:
                   
                    l.emitirFactura();
                    break;
                case 2:
                    
                    l.consultarFactura();
                    break;
                case 3:
                    
                    l.mostrarFactura();
                   break;
                case 4:
                   
                    l.anularFactura();
                    break;
                case 5:
                    System.out.println("\n\n Programa ha culminado \n");
                    break;
                default:
                    System.out.println("\n\n Opcion incorrecta \n");
                    break;
            }

        } while (opc != 5);
     
                    break;
                
                case 3:
                    System.out.println("\n\n Programa ha culminado \n");
                    break;
                default:
                    System.out.println("\n\n Opcion incorrecta \n");
                    break;
            }

        } while (opc != 3);
    }
   
 }
    
  

