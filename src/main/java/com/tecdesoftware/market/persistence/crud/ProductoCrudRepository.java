package com.tecdesoftware.market.persistence.crud;

import com.tecdesoftware.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//importar optional
import java.util.Optional;

@Repository
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //Optional<Producto> findByNombre(String nombre);

    //Query method - select * from producto where id_categoria = 5  order by ASC
    List <Producto> findByIdCategoriaOrderByAsc(int idCategoria);

    //
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado (int cantidadStock, boolean estado);

}
