package com.tecdesoftware.market.persistence.mapper;

import com.tecdesoftware.market.domain.Purchase;
import com.tecdesoftware.market.persistence.entity.Compras;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring", uses ={PurchaseItemMapper.class})
public interface PurchaseMapper {
@Mappings({
        @Mapping(target = "purchaseID", source = "id_compra"),
        @Mapping(target = "clientID", source = "id_cliente"),
        @Mapping(target = "comment", source = "comentario"),
        @Mapping(target = "date", source = "fecha"),
        @Mapping(target = "item", source = "productos"),
        @Mapping(target = "state", source = "estado"),
        @Mapping(target = "paymentMethod", source = "medio_pago")
})

Purchase toPurchase(Compras compra);
List<Purchase> toPurchases(List<Compras> compras);

    @InheritInverseConfiguration  //invertir proceso
    @Mapping (target = "cliente", ignore = true)
    Compras toCompra (Purchase purchase);

}
