
package ProyectoFinal;

import java.util.LinkedList;
import java.util.Scanner;

public class Inventario {
    
   Scanner teclado = new Scanner(System.in);
   
   LinkedList<ProductoInventario>pro=new LinkedList<>();
   
   LinkedList<FacturaInventario>fac=new LinkedList<>();
   
   String codigo, nombre,descripcion, nombreFactura,estadoFactura;
   int numFactura,cantFactura,acum,stock;
   double precio,precioFactura, subtotalFactura,ivaFactura,totalFactura, costos, ganancia;
    
    
   ProductoInventario primero;
   ProductoInventario ultimo;
   
   FacturaInventario primeroA;
   FacturaInventario ultimoA;
   
   
   public Inventario(){
       
       primero = null;
       ultimo = null;
       
       primeroA = null;
       ultimoA = null;
       }
    
     
    
   public void InsertarProducto(){
       
       System.out.print(" Ingresar el código que lleva el producto: ");
       codigo= teclado.next();
       System.out.print(" Nombre del producto: ");
       nombre= teclado.next();
       System.out.print(" Descripcion del producto: ");
       descripcion= teclado.next();
       System.out.print(" Stock: ");
       stock= teclado.nextInt();
       System.out.print(" Costo del producto: ");
       costos=teclado.nextDouble();
       
       if(costos <=100){
           ganancia=costos*0.20;
           precio=costos+ganancia;
           
           System.out.print("\n La ganancia es un valor de:$ " + ganancia); 
           System.out.print("\n El precio de venta en público es un valor de:$ " + precio);  
       }else if(costos > 100){
           ganancia= costos*0.15;
           precio=costos+ganancia;
           System.out.print("\n La ganancia es un valor de:$ " + ganancia); 
           System.out.print("\n El precio de venta en público es es un valor de:$ " + precio);  
       }
       pro.add(new ProductoInventario(codigo,nombre,descripcion,stock,precio));
       ProductoInventario nuevoProducto= new ProductoInventario(codigo,nombre,descripcion,stock,precio);
                        
       if(primero == null){
           primero = nuevoProducto;
           ultimo = nuevoProducto;
            primero.siguiente = primero;
       } else{
           ultimo.siguiente = nuevoProducto;
           nuevoProducto.siguiente = primero;
           ultimo = nuevoProducto;
       }
       System.out.println("\n Producto ha sido ingresado correctamente\n");
         
       }
   
   public void BuscarProducto(){
       ProductoInventario actualProducto= new ProductoInventario(codigo,nombre,descripcion,stock,precio);
      
        actualProducto = primero;
        boolean encontrado = false;
        System.out.print(" Ingresar el dato del producto que desea buscar: ");
        String codigoBuscado = teclado.next();
        if(primero != null){
            do{
                if(actualProducto.getCodigo().contains(codigoBuscado)){
                System.out.println("\n Producto con el dato (" + codigoBuscado + ") Encontrado\n");
                    System.out.println("Nombre producto: "+ actualProducto.getNombre());
                    System.out.println("Descripcion del producto: "+actualProducto.getDescripcion());
                    System.out.println("Precio: "+actualProducto.getPrecio());
               
                encontrado = true;
            }
                actualProducto = actualProducto.siguiente;
            }while(actualProducto != primero && encontrado != true);
            
            if(!encontrado){
                System.out.println("\n Producto no ha sido encontrado\n");
            }
        } else{
            System.out.println("\n La lista se encuentra vacia");
        }
   }
   
   public void MostrarProducto(){
        ProductoInventario actualProducto= new ProductoInventario(codigo,nombre,descripcion,stock,precio);
        actualProducto = primero;
        if(primero != null){
            
          do{
                
                    System.out.println("Codigo "+ actualProducto.getCodigo());
                    System.out.println("Nombre producto: "+ actualProducto.getNombre());
                    System.out.println("Descripcion: "+actualProducto.getDescripcion());
                    System.out.println("Precio: "+actualProducto.getPrecio());
                    System.out.println("\n");
                
            
                actualProducto = actualProducto.siguiente;
            }while(actualProducto != primero );
            
        }else {
            System.out.println("Lista se encuentra vacia:");
        }
 }
   
   public void EliminarProducto(){
       ProductoInventario actualProducto= new ProductoInventario(codigo,nombre,descripcion,stock,precio);
        actualProducto = primero;
        ProductoInventario anteriorProducto= new ProductoInventario(codigo,nombre,descripcion,stock,precio);
        anteriorProducto = null;
        
        System.out.print(" Ingresar el dato del producto que desea buscar: ");
        String codigoBuscado = teclado.next();
        if(primero != null){
       
        boolean encontrado = false;
        
        
        if(primero != null){
            do{
                if(actualProducto.getCodigo().contains(codigoBuscado)){
                System.out.print("\n Producto con el dato (" + codigoBuscado + ") Encontrado\n");
                    
                if(actualProducto == primero){
                    primero = primero.siguiente;
                    ultimo.siguiente = primero;
                } else if(actualProducto == ultimo){
                    anteriorProducto.siguiente = primero;
                    ultimo = anteriorProducto;
                } else{
                    anteriorProducto.siguiente = actualProducto.siguiente;
                }
                    System.out.println("\n Producto ha sido eliminado correctamente \n");
                    encontrado = true;
                }
                    anteriorProducto = actualProducto;
                    actualProducto = actualProducto.siguiente;
            }while(actualProducto != primero && encontrado != true);
            
            if(!encontrado){
                System.out.println("\n Producto no ha sido encontrado\n");
            }
        } else{
            System.out.println("\n La lista se encuentra Vacia");
        }
    }   
}    
   
   public void emitirFactura(){
       
        ProductoInventario actualProducto= new ProductoInventario(codigo,nombre,descripcion,stock,precio);
        actualProducto = primero;
        String codigoBuscado;
        boolean encontrado = false;
        int respuesta;
        
                 System.out.print(" Ingresar el número de factura: ");
                 numFactura = teclado.nextInt();
                 estadoFactura = "Activo";
        
                System.out.print("Ingresar código : ");
                codigoBuscado= teclado.next();
                teclado.nextLine();
                
                if(primero != null){
                    
                    do{    
                    
                 if(actualProducto.getCodigo().contains(codigoBuscado)){
                
                precioFactura=actualProducto.getPrecio();
                     System.out.println("El precio del producto es un valor de:" + precioFactura );
                     
                stock=actualProducto.getStock();
                     System.out.println("El stock es de:" + stock );
                     
                    System.out.println("Ingresar la cantidad: ");
                    cantFactura= teclado.nextInt();
                    
                    subtotalFactura= precioFactura*cantFactura;
                    ivaFactura=subtotalFactura*0.12;
                    totalFactura=subtotalFactura+ivaFactura;
                    
               
                fac.add(new FacturaInventario(numFactura,estadoFactura,nombreFactura,precioFactura,stock,cantFactura,subtotalFactura,ivaFactura,totalFactura));
                FacturaInventario nuevoFactura = new FacturaInventario(numFactura,estadoFactura,nombreFactura,precioFactura,stock,cantFactura,subtotalFactura,ivaFactura,totalFactura);
            
                if(primeroA== null){
                      primeroA= nuevoFactura;
                      ultimoA=nuevoFactura;
                      primeroA.siguiente= primeroA;
                        } else{
                    ultimoA.siguiente = nuevoFactura;
                    nuevoFactura.siguiente= primeroA;
                    ultimoA = nuevoFactura;
                } 
                    System.out.println("Ingresado");
                    encontrado= true;
                 }      
                actualProducto= actualProducto.siguiente;
                }while (actualProducto != primero && encontrado !=true);
        }
                if(!encontrado){
                    System.out.println("Producto no ha sido encontrado");
   }
                                  
} 
    
   public void consultarFactura(){
       FacturaInventario actualFactura= new FacturaInventario(numFactura,estadoFactura,nombreFactura,precioFactura,stock,cantFactura,subtotalFactura,ivaFactura,totalFactura);
      
        actualFactura = primeroA;
        boolean encontrado=false;
        
        System.out.print(" Ingresar el numero de factura que desea a buscar: ");
        int codigoBuscado= teclado.nextInt();
        if(primeroA !=null){
            do{
                if(actualFactura.getNumFactura()==codigoBuscado){
                    
                    System.out.println("factura con el codigo:  "+codigoBuscado+ "  Encontrado" );
                    System.out.println("Numero factura: "+actualFactura.getNumFactura());
                    System.out.println("Estado factura: "+actualFactura.getEstadoFactura());
                    System.out.println("Precio Compra: "+ actualFactura.getPrecioFactura());
                    System.out.println("Cantidad Producto: "+actualFactura.getCantFactura());
                    System.out.println("subtotal factura: "+ actualFactura.getSubtotalFactura());
                    System.out.println("iva compra: "+actualFactura.getIvaFactura());
                    System.out.println("Total compra: "+actualFactura.getTotalFactura());
                    System.out.println("\n");
                    
                    encontrado=true;
                 }    
                actualFactura= actualFactura.siguiente;
                
            }while(actualFactura != primeroA);
                
                   
                if(!encontrado){
                    System.out.println("Factura no existe");
                }
                      
         }else {
            System.out.println("Lista se encuentra vacia");
        }
   } 

       
    public void mostrarFactura(){
       FacturaInventario actualFactura= new FacturaInventario(numFactura,estadoFactura,nombreFactura,precioFactura,stock,cantFactura,subtotalFactura,ivaFactura,totalFactura);
      
        actualFactura = primeroA;
        
        if(primeroA !=null){
            do{
                
                    System.out.println("Numero factura: "+actualFactura.getNumFactura());
                    System.out.println("Estado factura: "+actualFactura.getEstadoFactura());
                    System.out.println("Precio Compra: "+ actualFactura.getPrecioFactura());
                    System.out.println("Cantidad Producto: "+actualFactura.getCantFactura());
                    System.out.println("subtotal factura"+ actualFactura.getSubtotalFactura());
                    System.out.println("iva compra: "+actualFactura.getIvaFactura());
                    System.out.println("Total compra: "+actualFactura.getTotalFactura());
                    System.out.println("\n");
                    
                     
                   actualFactura= actualFactura.siguiente;
                     
            }while(actualFactura != primeroA);
                              
         }else {
            System.out.println("Lista se encuentra vacia");
    }
}
    
   public void anularFactura(){
        FacturaInventario actualFactura= new FacturaInventario(numFactura,estadoFactura,nombreFactura,precioFactura,stock,cantFactura,subtotalFactura,ivaFactura,totalFactura);
        actualFactura = primeroA;
       FacturaInventario anteriorFactura= new FacturaInventario(numFactura,estadoFactura,nombreFactura,precioFactura,stock,cantFactura,subtotalFactura,ivaFactura,totalFactura);
        anteriorFactura = null;
      
        boolean encontrado = false;
        System.out.print(" Ingresar el numero de factura que desea anular: ");
        int codigoBuscado = teclado.nextInt();
        
        if(primeroA !=null){
            do{
                if(actualFactura.getNumFactura()==codigoBuscado){
                    System.out.println("Digitar lo anulado");
                    estadoFactura= teclado.next();
                    precioFactura=0.0;
                    subtotalFactura=0.0;
                    ivaFactura=0.0;
                    totalFactura=0.0;
                    
                    actualFactura.setEstadoFactura(estadoFactura);
                    actualFactura.setPrecioFactura(precioFactura);
                    actualFactura.setSubtotalFactura(subtotalFactura);
                    actualFactura.setIvaFactura(ivaFactura);
                    actualFactura.setTotalFactura(totalFactura);
                    System.out.println("Factura ha sido anulada");
                    encontrado = true;
                }
                actualFactura= actualFactura.siguiente;
         
           }while(actualFactura !=primeroA && encontrado != true);
        
        if(!encontrado){
            System.out.println("factura no existe");
        }
        
        }else {
            System.out.println("Lista se encuentra vacia");
        }   
   } 
   
 }
