/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.ArticuloFacade;
import entities.Articulo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBs;
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

public class ArticuloServicio {
    
    @EJB
    private ArticuloFacade articuloDAO;
    
    public List<Articulo> listarTodos(){
    return this.articuloDAO.findAll();
}
    
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(String nombre,String cantidad) {
        if (!nombre.equals("")) {
            Articulo articulo = new Articulo();
            articulo.setNombreArticulo(nombre);
            articulo.setPrecioArticulo(Double.parseDouble(cantidad));
            
           
            try {
                articuloDAO.create(articulo);
            } catch (Exception ex) {
                throw new RuntimeException("El articulo no ha sido creado.");
            }
        } else {
            throw new RuntimeException("El  articulo no es valido.");
        }
    }
    
    
    public Articulo buscarPorPK(Integer pk) {
        return this.articuloDAO.find(pk);
    }
    
}
