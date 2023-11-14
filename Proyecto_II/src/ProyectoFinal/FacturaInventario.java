
package ProyectoFinal;
import java.util.Comparator;

public class FacturaInventario {
    
   String nombreFactura, estadoFactura;
   int numFactura, cantFactura, acum,stock;
   double precioFactura,subtotalFactura,ivaFactura,totalFactura;
   FacturaInventario siguiente;

    public FacturaInventario(String nombreFactura, String estadoFactura, int numFactura, int cantFactura, int acum, double precioFactura,int stock, double subtotalFactura, double ivaFactura, double totalFactura) {
        this.nombreFactura = nombreFactura;
        this.estadoFactura = estadoFactura;
        this.numFactura = numFactura;
        this.cantFactura = cantFactura;
        this.acum = acum;
        this.precioFactura = precioFactura;
        this.stock=stock;
        this.subtotalFactura = subtotalFactura;
        this.ivaFactura = ivaFactura;
        this.totalFactura = totalFactura;
    }

    FacturaInventario(int numFactura, String estadoFactura, String nombreFactura, double precioFactura,int stock, int cantFactura, double subtotalFactura, double ivaFactura, double totalFactura) {
        this.nombreFactura = nombreFactura;
        this.estadoFactura = estadoFactura;
        this.numFactura = numFactura;
        this.cantFactura = cantFactura;
        this.precioFactura = precioFactura;
        this.stock=stock;
        this.subtotalFactura = subtotalFactura;
        this.ivaFactura = ivaFactura;
        this.totalFactura = totalFactura;
    }
    

    public String getNombreFactura() {
        return nombreFactura;
    }

    public void setNombreFactura(String nombreFactura) {
        this.nombreFactura = nombreFactura;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public int getCantFactura() {
        return cantFactura;
    }

    public void setCantFactura(int cantFactura) {
        this.cantFactura = cantFactura;
    }

    public int getAcum() {
        return acum;
    }

    public void setAcum(int acum) {
        this.acum = acum;
    }

    public double getPrecioFactura() {
        return precioFactura;
    }

    public void setPrecioFactura(double precioFactura) {
        this.precioFactura = precioFactura;
    }

    public double getSubtotalFactura() {
        return subtotalFactura;
    }

    public void setSubtotalFactura(double subtotalFactura) {
        this.subtotalFactura = subtotalFactura;
    }

    public double getIvaFactura() {
        return ivaFactura;
    }

    public void setIvaFactura(double ivaFactura) {
        this.ivaFactura = ivaFactura;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
   
    
}
