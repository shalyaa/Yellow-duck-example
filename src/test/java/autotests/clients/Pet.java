package autotests.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.lang.reflect.Array;
import java.util.List;

@Getter //получение значения свойств
@Setter //установка значения свойств
@Accessors(fluent = true) //создание методов доступа (геттеров и сеттеров)

public class Pet {

    @JsonProperty
    private int id;

    @JsonProperty
    private CategoryPet category;

    @JsonProperty
    private String name;

    @JsonProperty
    private List<String> photoUrls;

    @JsonProperty
    private List<Tag> tags;

    @JsonProperty
    private String status;

    public void setCategory(CategoryPet category) {
        this.category = category;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
