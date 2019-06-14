/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBean;

import controller.CrearArticulo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author SUSANA
 */
@ManagedBean
@SessionScoped

public class ArticuloBK {
    
    private CrearArticulo crearArticulo;
    private String nombre;
    private String precio;
    private String mensaje;

    public CrearArticulo getCrearArticulo() {
        return crearArticulo;
    }

    public void setCrearArticulo(CrearArticulo crearArticulo) {
        this.crearArticulo = crearArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    

    public ArticuloBK() {
        
        crearArticulo=new CrearArticulo();
        
        
    }
    
    public void crearArticulo(){
        this.crearArticulo.crear(nombre, precio);
    }
    
    
    
}
