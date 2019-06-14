/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.DetalleOrden;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import servicio.DetalleOrdenServicio;

/**
 *
 * @author SUSANA
 */
public class CrearDetalleOrden {
    @EJB
    private DetalleOrdenServicio detalleOrdenServicio;

    public CrearDetalleOrden() {
        try {
            InitialContext ic = new InitialContext();
            detalleOrdenServicio = (DetalleOrdenServicio) ic.lookup("java:global/SistemaFacturacion/SistemaFacturacion-ejb/DetalleOrdenServicio");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
    

    

    public void crear(String codOrden, String codArticulo, String cantidad) {
        this.detalleOrdenServicio.crear(codOrden, codArticulo, cantidad);
        
    }

    
}
