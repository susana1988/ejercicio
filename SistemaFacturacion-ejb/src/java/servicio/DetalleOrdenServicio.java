/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.ArticuloFacade;
import dao.DetalleOrdenFacade;
import dao.OrdenFacade;
import entities.Articulo;
import entities.DetalleOrden;
import entities.Orden;
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

public class DetalleOrdenServicio {
    
    @EJB
    private DetalleOrdenFacade detalleOrdenDAO;
    
    @EJB
    private OrdenFacade ordenDAO;
    
    @EJB
    private ArticuloFacade articuloDAO;
    
    public List<DetalleOrden> listarTodos(){
        return this.detalleOrdenDAO.findAll();
    }
            
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(String codOrden, String codArticulo,String cantidad) {
        if (!codOrden.equals("") && !codArticulo.equals("") && !cantidad.equals("")) {
            DetalleOrden detalleOrden=new DetalleOrden();
            
            detalleOrden.setIdDetalle(Integer.parseInt(cantidad));
            
            
            try {
                Orden orden = ordenDAO.find(Integer.parseInt(codOrden));
                if (orden != null) {
                    detalleOrden.setIdOrden(orden);
                } else {
                    throw new RuntimeException("Orden no encontrada.");
                }
            } catch (Exception ex) {
                throw new RuntimeException("Orden no encontrada.");
            }
            
            try {
                Articulo articulo = articuloDAO.find(Integer.parseInt(codArticulo));
                if (articulo != null) {
                    detalleOrden.setIdArticulo(articulo);
                } else {
                    throw new RuntimeException("Artículo no encontrado.");
                }
            } catch (Exception ex) {
                throw new RuntimeException("Artículo no encontrado.");
            }


            try {
                detalleOrdenDAO.create(detalleOrden);
               
            } catch (Exception ex) {
                throw new RuntimeException("El Detalle de la orden no ha sido creado.");
            }
        } else {
            throw new RuntimeException("El Detalle de la orden no es valido.");
        }
    }
    
    public DetalleOrden buscarPorPK(Integer pk) {
        return this.detalleOrdenDAO.find(pk);
    }
    
}
