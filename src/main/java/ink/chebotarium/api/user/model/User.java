package ink.chebotarium.api.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private long id;
    private String username;
}
