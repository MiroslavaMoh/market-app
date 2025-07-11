package com.tecdesoftware.market.persistence.mapper;

import com.tecdesoftware.market.domain.PurchaseItem;
import com.tecdesoftware.market.persistence.entity.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "Spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
    @Mapping(target = "quantity", source = "cantidad"),
    @Mapping(target = "productId", source = "id.idProducto"),
    @Mapping(target = "active", source = "estado"),
    //Total no se mapea porque se mepeo en otro
    })

    PurchaseItem toPurchaseItem(CompraProducto producto);

    @InheritInverseConfiguration  //invertir proceso
    @Mappings({
    @Mapping(target = "id.idCompra", ignore = true),
    @Mapping(target = "compra", ignore = true),
    @Mapping(target = "producto", ignore = true),
    })
    CompraProducto toCompraProducto(PurchaseItem item); //invertir proceso

}
