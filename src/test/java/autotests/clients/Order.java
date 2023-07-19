package autotests.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter //получение значения свойств
@Setter //установка значения свойств
@Accessors(fluent = true) //создание методов доступа (геттеров и сеттеров)

public class Order {

    @JsonProperty
    private int id;

    @JsonProperty
    private int petId;

    @JsonProperty
    private int quantity;

    @JsonProperty
    private String shipDate;

    @JsonProperty
    private String status;

    @JsonProperty
    private boolean complete;


}
