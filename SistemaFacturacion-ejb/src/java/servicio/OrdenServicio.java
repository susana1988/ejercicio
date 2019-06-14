/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.ClienteFacade;
import dao.OrdenFacade;
import entities.Cliente;
import entities.Orden;
import java.util.Date;
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

public class OrdenServicio {
    @EJB
    private OrdenFacade ordenDAO;
    @EJB
    private ClienteFacade clienteDAO;
    
    
    public List<Orden> listarTodos(){
        return this.ordenDAO.findAll();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(String codCliente, Date fecha) {
        if (!codCliente.equals("") && !fecha.equals("")) {
            Orden orden=new Orden();
            orden.setFechaOrden(fecha);
            
            try {
                Cliente cliente = clienteDAO.find(Integer.parseInt(codCliente));
                if (cliente != null) {
                    orden.setIdCliente(cliente);
                } else {
                    throw new RuntimeException("Cliente no encontrado.");
                }
            } catch (Exception ex) {
                throw new RuntimeException("Cliente no encontrado.");
            }


            try {
               ordenDAO.create(orden);
            } catch (Exception ex) {
                throw new RuntimeException("La orden no ha sido creada.");
            }
        } else {
            throw new RuntimeException("La orden no es valida.");
        }
    }
    
    public Orden buscarPorPK(Integer pk) {
        return this.ordenDAO.find(pk);
    }
    
}
