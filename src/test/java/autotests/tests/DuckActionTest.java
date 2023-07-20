package autotests.tests;

import autotests.clients.DuckActionsClient;
import autotests.payloads.DuckProperties;
import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;
import static com.consol.citrus.validation.DelegatingPayloadVariableExtractor.Builder.fromBody;

public class DuckActionTest extends DuckActionsClient {

    @CitrusTest
    @Test(description = "Проверка того, что уточка поплыла")
    public void successfulSwim(@Optional @CitrusResource TestCaseRunner runner) {
        DuckProperties duckProperties = new DuckProperties().color("yellow").height(10.0).material("rubber").sound("quack").wingsState("ACTIVE");

        duckCreate(runner, "yellow", "0.03", "rubber", "quack", "FIXED");
        runner.$(http().client(yellowDuckService)
                .receive()
                .response()
                .message()
                .extract(fromBody().expression("$.id", "duckId")));
        duckSwim(runner, "${duckId}");
        validateResponse(runner, "{\n" +
                "\"message\":\"I'm swimming\"\n" +
                "}");
    }


}
