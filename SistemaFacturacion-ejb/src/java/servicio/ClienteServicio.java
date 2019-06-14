/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.ClienteFacade;
import entities.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author SUSANA
 */

@Stateless
@LocalBean
public class ClienteServicio {
    @EJB
    private ClienteFacade clienteDAO;
    
    public List<Cliente> listarTodos(){
        return this.clienteDAO.findAll();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(String nombre,String apellido) {
        if (!nombre.equals("")) {
            Cliente cliente = new Cliente();
            cliente.setNombreCliente(nombre);
            cliente.setApellidoCliente(apellido);
            
           
            try {
                clienteDAO.create(cliente);
            } catch (Exception ex) {
                throw new RuntimeException("El cliente no ha sido creado.");
            }
        } else {
            throw new RuntimeException("El  cliente no es valido.");
        }
    }
    
    public Cliente buscarPorPK(Integer pk) {
        return this.clienteDAO.find(pk);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificar(String codigo, String nombre,String apellido) {
       
         if (!codigo.equals("") && !nombre.equals("") && !apellido.equals("")) {
             Cliente cliente = new Cliente();
             cliente.setIdCliente(Integer.parseInt(codigo));
             cliente.setNombreCliente(nombre);
             cliente.setApellidoCliente(apellido);
             
            try {
                this.clienteDAO.create(cliente);
               
            } catch (Exception ex) {
                throw new RuntimeException("El Cliente no ha sido modificado.");
            }
        } else {
            throw new RuntimeException("El  Cliente no es valido.");
        }
        
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Integer pk) {
        Cliente cliente = clienteDAO.find(pk);
        this.clienteDAO.remove(cliente);
    }

    
    
}
