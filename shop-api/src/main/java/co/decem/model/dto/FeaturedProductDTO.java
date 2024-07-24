package co.decem.model.dto;


import co.decem.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeaturedProductDTO {

    private Long id;
    private Product product;
    private String pictureUrl;
    private String description;
    
}
