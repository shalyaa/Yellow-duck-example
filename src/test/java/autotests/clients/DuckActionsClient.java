package autotests.clients;

import autotests.EndpointConfig;
import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;

@ContextConfiguration(classes = {EndpointConfig.class})

public class DuckActionsClient extends TestNGCitrusSpringSupport {

    @Autowired
    protected HttpClient yellowDuckService;

    @Description("Эндпоинт, засвляющий уточку плыть")
    public void duckSwim(TestCaseRunner runner, String id) {
        runner.$(http()
                .client(yellowDuckService)
                .send()
                .get("/api/duck/action/swim")
                .queryParam("id", id)
                .message().contentType(MediaType.APPLICATION_JSON_VALUE));
    }
}

