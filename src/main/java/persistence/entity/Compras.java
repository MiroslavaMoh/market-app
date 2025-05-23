package persistence.entity;
import jakarta.persistence.*;

@Entity
@Table(name="compras")
public class Compras {
    @Id
    //valor unico autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column (name='id_producto')
    private Integer id_compra;
    private String id_cliente;
    private LocalDateTime fecha;
    private String medio_pago;
    private String comentario;
    private Boolean estado;

}
