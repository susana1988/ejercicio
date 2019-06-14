/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Orden;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import servicio.OrdenServicio;

/**
 *
 * @author SUSANA
 */
public class CrearOrden {
  
    @EJB
    private OrdenServicio ordenServicio;

    public CrearOrden() {
        try {
            InitialContext ic = new InitialContext();
            ordenServicio = (OrdenServicio) ic.lookup("java:global/SistemaFacturacion/SistemaFacturacion-ejb/OrdenServicio");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void crear(String codCliente, Date fecha) {
        this.ordenServicio.crear(codCliente,fecha);
        
    }

    public List<Orden> listar() {
        return this.ordenServicio.listarTodos();
    }

    public Orden buscarOrden(Integer codigoOrden) {
        return this.ordenServicio.buscarPorPK(codigoOrden);
    }

}
