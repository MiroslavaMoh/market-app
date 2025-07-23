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
    //@Mapping(target = "producto", ignore = true),
    @Mapping(target = "producto", expression = "java(mapToProducto(item.getProductId()))")
    })
    CompraProducto toCompraProducto(PurchaseItem item); //invertir proceso

    // Método auxiliar para evitar el error de producto null
    default com.tecdesoftware.market.persistence.entity.Producto mapToProducto(int idProducto) {
        com.tecdesoftware.market.persistence.entity.Producto producto = new com.tecdesoftware.market.persistence.entity.Producto();
        producto.setIdProducto(idProducto);
        return producto;
    }

}
