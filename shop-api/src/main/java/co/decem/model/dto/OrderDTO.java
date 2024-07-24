package co.decem.model.dto;

import java.util.List;

import co.decem.model.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private int salesDate;
    private int totalAmmount;
    private PaymentMethod paymentMethod;
    private List<OrderLineDTO> orderLines;
}
