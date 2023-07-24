package autotests.clients;

import autotests.BaseTest;
import com.consol.citrus.TestCaseRunner;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;

public class DuckControllerClient extends BaseTest {

    @Description("Эндпоинт для создания уточки")
    public void duckCreate(TestCaseRunner runner, Object payload) {
        sendPostRequest(runner, yellowDuckService, "/api/duck/create", payload);
    }

    @Description("Валидация полученного ответа")
    public void validateResponse(TestCaseRunner runner, String expectedPayload) {
        validateResponse(runner, yellowDuckService, HttpStatus.OK, expectedPayload);
    }
}
