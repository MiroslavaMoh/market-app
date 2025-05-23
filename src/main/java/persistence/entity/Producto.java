package persistence.entity;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="productos")
public class Producto {
    @Id //llave primaria
    //valor unico autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column (name='id_producto')
    private Integer id_producto;
    private String nombre;
    private Integer id_categoria;
    private String codigo_barras;
    private Double precio_venta;
    private Integer cantidad_stock;
    private Boolean estado;

}
