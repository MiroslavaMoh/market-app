package com.tecdesoftware.market.persistence.crud;

import com.tecdesoftware.market.persistence.entity.Compras;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compras,Integer> {

   Optional<List<Compras>> findByIdCliente(String idCliente);

}
