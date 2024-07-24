package co.decem.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import co.decem.model.Order;
import co.decem.model.OrderLine;
import co.decem.model.Product;

public class DTOMapper {

    public static OrderDTO mapToOrderDTO(Order order) {
        if (order == null) {
            return null;
        }

        List<OrderLineDTO> orderLineDTOs = order.getOrderLines()
                .stream()
                .map(DTOMapper::mapToOrderLineDTO)
                .collect(Collectors.toList());

        return new OrderDTO(
                order.getId(),
                order.getSalesDate(),
                order.getTotalAmmount(),
                order.getPaymentMethod(),
                orderLineDTOs
        );
    }

    private static OrderLineDTO mapToOrderLineDTO(OrderLine orderLine) {
        if (orderLine == null) {
            return null;
        }

        ProductDTO productDTO = mapToProductDTO(orderLine.getProduct());

        return new OrderLineDTO(
                orderLine.getId(),
                orderLine.getQuantity(),
                orderLine.getPrice(),
                productDTO
        );
    }

    private static ProductDTO mapToProductDTO(Product product) {
        if (product == null) {
            return null;
        }
        
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
