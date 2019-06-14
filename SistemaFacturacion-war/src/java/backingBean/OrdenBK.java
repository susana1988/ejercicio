/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBean;

import controller.CrearOrden;
import entities.Orden;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author SUSANA
 */

@ManagedBean
@SessionScoped
public class OrdenBK {
    
    private CrearOrden crearOrden;
   // private Integer codigoOrden;
    private String cliente;
    private Date fecha;
    
    private List<Orden> lordenes;
    
    private String mensaje;

    public CrearOrden getCrearOrden() {
        return crearOrden;
    }

    public void setCrearOrden(CrearOrden crearOrden) {
        this.crearOrden = crearOrden;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Orden> getLordenes() {
        return lordenes;
    }

    public void setLordenes(List<Orden> lordenes) {
        this.lordenes = lordenes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    

    public OrdenBK() {
        
        crearOrden=new CrearOrden();
    }
    
     public void crear() {
        this.crearOrden.crear(cliente, fecha);
    }
    
    
    
}
