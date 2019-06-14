/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Articulo;
import entities.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import servicio.ArticuloServicio;
import servicio.ClienteServicio;

/**
 *
 * @author SUSANA
 */
public class CrearArticulo {
     @EJB
    private ArticuloServicio articuloServicio;

    public CrearArticulo() {
        try {
            InitialContext ic = new InitialContext();
            articuloServicio = (ArticuloServicio) ic.lookup("java:global/SistemaFacturacion/SistemaFacturacion-ejb/ArticuloServicio");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void crear(String nombre, String precio) {
        this.articuloServicio.crear(nombre,precio);
    }

    public List<Articulo> listar() {
        return this.articuloServicio.listarTodos();
    }

    
}
