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
        @Mapping(target = "purchaseId", source = "idCompra"),
        @Mapping(target = "clientId", source = "idCliente"),
        @Mapping(target = "comment", source = "comentario"),
        @Mapping(target = "date", source = "fecha"),
        @Mapping(target = "items", source = "productos"), //items error
        @Mapping(target = "state", source = "estado"),
        @Mapping(target = "paymentMethod", source = "medioPago")
})




Purchase toPurchase(Compras compra);
List<Purchase> toPurchases(List<Compras> compras);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente", ignore = true),
            @Mapping(target = "idCliente", source = "clientId"),
            @Mapping(target = "productos", source = "items")//items error
    })
    Compras toCompra(Purchase purchase);

}
