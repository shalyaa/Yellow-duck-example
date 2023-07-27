package autotests.clients;

import autotests.BaseTest;
import com.consol.citrus.TestCaseRunner;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;

import static com.consol.citrus.actions.ExecuteSQLAction.Builder.sql;
import static com.consol.citrus.container.FinallySequence.Builder.doFinally;

public class DuckControllerClient extends BaseTest {

    @Step("�������� ��� �������� ������")
    public void duckCreate(TestCaseRunner runner, Object payload) {
        sendPostRequest(runner, yellowDuckService, "/api/duck/create", payload);
    }


    @Step("�������� ������ ����� ��")
    public void duckDelete(TestCaseRunner runner) {
        runner.$(doFinally()
                .actions(runner.$(sql(db)
                        .statement("DELETE FROM DUCK WHERE ID=${duckId}"))));
    }

    @Step("��������� ����������� ������")
    public void validateResponse(TestCaseRunner runner, String expectedPayload) {
        validateResponse(runner, yellowDuckService, HttpStatus.OK, expectedPayload);
    }
}
