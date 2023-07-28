package autotests.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter //получение значения свойств
@Setter //установка значения свойств
@Accessors(fluent = true) //создание методов доступа (геттеров и сеттеров)

public class CategoryPet {

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;
}
