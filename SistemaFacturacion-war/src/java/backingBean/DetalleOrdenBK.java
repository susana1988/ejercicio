/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBean;

import controller.CrearDetalleOrden;
import entities.DetalleOrden;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author SUSANA
 */

@ManagedBean
@SessionScoped
public class DetalleOrdenBK {
    
    private CrearDetalleOrden crearDetalleOrden;
    private String orden;
    private String articulo;
    private String cantidad;
    private List<DetalleOrden> ldetalleOrdenes;
    
    private String mensaje;

    public CrearDetalleOrden getCrearDetalleOrden() {
        return crearDetalleOrden;
    }

    public void setCrearDetalleOrden(CrearDetalleOrden crearDetalleOrden) {
        this.crearDetalleOrden = crearDetalleOrden;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public List<DetalleOrden> getLdetalleOrdenes() {
        return ldetalleOrdenes;
    }

    public void setLdetalleOrdenes(List<DetalleOrden> ldetalleOrdenes) {
        this.ldetalleOrdenes = ldetalleOrdenes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    

    
    
    public DetalleOrdenBK() {
        crearDetalleOrden=new CrearDetalleOrden();
        
    }
    
    public void crearDetalleOrden(){
        crearDetalleOrden.crear(orden, articulo, cantidad);
    }
    
    
    
}
