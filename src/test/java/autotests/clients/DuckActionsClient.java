package autotests.clients;

import autotests.BaseTest;
import com.consol.citrus.TestCaseRunner;
import io.qameta.allure.Step;

public class DuckActionsClient extends BaseTest {

    @Step("��������, ������������ ������ �����")
    public void duckSwim(TestCaseRunner runner, String id) {
        sendGetRequest(runner, yellowDuckService, "/api/duck/action/swim", "id", id);
    }

    @Step("�������� ��� �������� ������")
    public void duckCreate(TestCaseRunner runner, Object payload) {
        sendPostRequest(runner, yellowDuckService, "/api/duck/create", payload);
    }

    @Step("��������� ����������� ������")
    public void validateResponse1(TestCaseRunner runner, String response) {
        validateResponse(runner, response);
    }
}

