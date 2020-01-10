package ink.chebotarium.api.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private long id;
    private String productName;
    private String description;
    private String photo; //todo
}
