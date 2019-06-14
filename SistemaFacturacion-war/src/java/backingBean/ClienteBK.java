/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBean;

import controller.CrearCliente;
import entities.Cliente;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SUSANA
 */

@ManagedBean()

@ViewScoped

public class ClienteBK {
    
    private CrearCliente crearCliente;
    private Integer codigoCliente;
    private String nombre;
    private String apellido;
    private List<Cliente> lclientes;
    private String mensaje;

    public CrearCliente getCrearCliente() {
        return crearCliente;
    }

    public void setCrearCliente(CrearCliente crearCliente) {
        this.crearCliente = crearCliente;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Cliente> getLclientes() {
        return lclientes;
    }

    public void setLclientes(List<Cliente> lclientes) {
        this.lclientes = lclientes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
    
    
    
    
    public ClienteBK() {
        crearCliente=new CrearCliente();
    }
    
    public void crear(){
        this.crearCliente.crear(nombre, apellido);
    }
    
    public void buscarCliente() throws IOException{
        Cliente cli=this.crearCliente.buscarCliente(codigoCliente);
        codigoCliente=cli.getIdCliente();
        nombre=cli.getNombreCliente();
        apellido=cli.getApellidoCliente();
        
    }
    
    public void modificar(){
        this.crearCliente.modificar(codigoCliente.toString(), nombre, apellido);
    }
    
   
    
    public void eliminar(Integer pk){
        this.crearCliente.borrar(pk);
                      
    }
}
