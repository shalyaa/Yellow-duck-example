package autotests.clients;

import autotests.BaseTest;
import com.consol.citrus.TestCaseRunner;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;

public class DuckActionsClient extends BaseTest {

    @Description("Эндпоинт, заставляющий уточку плыть")
    public void duckSwim(TestCaseRunner runner, String id) {
        sendGetRequest(runner, yellowDuckService, "/api/duck/action/swim", "id", id);
    }

    @Description("Эндпоинт для создания уточки")
    public void duckCreate(TestCaseRunner runner, String color, String height, String material, String sound, String wingsState) {
        sendPostRequest(runner, yellowDuckService, "/api/duck/create", "{\n" +
                "  \"color\": \"" + color + "\",\n" +
                "  \"height\": " + height + ",\n" +
                "  \"material\": \"" + material + "\",\n" +
                "  \"sound\": \"" + sound + "\",\n" +
                "  \"wingsState\": \"" + wingsState + "\"\n" +
                "}");
    }

    @Description("Валидация полученного ответа")
    public void validateResponse(TestCaseRunner runner, String response) {
        validateResponse(runner, yellowDuckService, HttpStatus.OK, response);
    }
}

