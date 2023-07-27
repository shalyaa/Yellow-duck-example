package autotests.clients;

import autotests.BaseTest;
import com.consol.citrus.TestCaseRunner;
import io.qameta.allure.Step;

public class DuckActionsClient extends BaseTest {

    @Step("Ёндпоинт, заставл€ющий уточку плыть")
    public void duckSwim(TestCaseRunner runner, String id) {
        sendGetRequest(runner, yellowDuckService, "/api/duck/action/swim", "id", id);
    }

    @Step("Ёндпоинт дл€ создани€ уточки")
    public void duckCreate(TestCaseRunner runner, Object payload) {
        sendPostRequest(runner, yellowDuckService, "/api/duck/create", payload);
    }

    @Step("¬алидаци€ полученного ответа")
    public void validateResponse1(TestCaseRunner runner, String response) {
        validateResponse(runner, response);
    }
}

