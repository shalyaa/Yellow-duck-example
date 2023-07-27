package autotests.tests;

import autotests.clients.DuckActionsClient;
import autotests.payloads.DuckProperties;
import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;


@Epic("�������� ����� � �������� ����")
@Feature("duck-service-1.0.1")
public class DuckActionTest extends DuckActionsClient {

    @Description("�������� ����, ��� ������ �������")
    @CitrusTest
    @Test(description = "��������������")
    public void successfulSwim(@Optional @CitrusResource TestCaseRunner runner) {
        DuckProperties duckProperties = new DuckProperties().color("yellow").height(0.05).material("rubber").sound("quack").wingsState("ACTIVE");

        duckCreate(runner, duckProperties);
        extractPath(runner, "$.id", "duckId");
        duckSwim(runner, "${duckId}");
        validateResponse1(runner, "{\n" +
                "  \"message\": \"Paws are not found ((((\"\n" +
                "}");
    }


}
