/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import servicio.ClienteServicio;

/**
 *
 * @author SUSANA
 */
public class CrearCliente {
    
     @EJB
    private ClienteServicio clienteServicio;

    public CrearCliente() {
        try {
            InitialContext ic = new InitialContext();
            clienteServicio = (ClienteServicio) ic.lookup("java:global/SistemaFacturacion/SistemaFacturacion-ejb/ClienteServicio");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void crear(String nombre, String apellido) {
        this.clienteServicio.crear(nombre,apellido);
    }

    public List<Cliente> listar() {
        return this.clienteServicio.listarTodos();
    }

    public Cliente buscarCliente(Integer codigoCliente) {
        return this.clienteServicio.buscarPorPK(codigoCliente);
    }

    public void modificar(String codigo, String nombre,String apellido) {

        this.clienteServicio.modificar(codigo, nombre,apellido);
    }
    
    

    public void borrar(Integer codigoCliente) {
        this.clienteServicio.eliminar(codigoCliente);
    }
    
}
