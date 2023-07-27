package autotests.tests;

import autotests.clients.DuckActionsClient;
import autotests.payloads.DuckProperties;
import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class DuckActionTest extends DuckActionsClient {

    @CitrusTest
    @Test(description = "Проверка того, что уточка поплыла")
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
