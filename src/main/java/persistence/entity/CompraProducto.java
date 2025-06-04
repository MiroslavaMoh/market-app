package persistence.entity;
import jakarta.persistence.*;

@Entity
@Table (name="compras_productos")
public class CompraProducto {

    @EmbeddedId
    private CompraProductoPK id;

    private Integrar cantidad;
    private Double total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name="id_compra")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto productos;

    public CompraProductoPK getId() {
        return id;
    }

    public void setId(CompraProductoPK id) {
        this.id = id;
    }

    public Integrar getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integrar cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
