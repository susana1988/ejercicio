/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SUSANA
 */
@Entity
@Table(name = "detalle_orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleOrden.findAll", query = "SELECT d FROM DetalleOrden d")
    , @NamedQuery(name = "DetalleOrden.findByIdDetalle", query = "SELECT d FROM DetalleOrden d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "DetalleOrden.findByCantidadDetalle", query = "SELECT d FROM DetalleOrden d WHERE d.cantidadDetalle = :cantidadDetalle")})
public class DetalleOrden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_detalle")
    private Integer idDetalle;
    @Column(name = "cantidad_detalle")
    private Integer cantidadDetalle;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne(optional = false)
    private Articulo idArticulo;
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden")
    @ManyToOne(optional = false)
    private Orden idOrden;

    public DetalleOrden() {
    }

    public DetalleOrden(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getCantidadDetalle() {
        return cantidadDetalle;
    }

    public void setCantidadDetalle(Integer cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Orden getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Orden idOrden) {
        this.idOrden = idOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOrden)) {
            return false;
        }
        DetalleOrden other = (DetalleOrden) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetalleOrden[ idDetalle=" + idDetalle + " ]";
    }
    
}
