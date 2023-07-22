package autotests;

import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.MessageType;
import com.consol.citrus.message.builder.ObjectMappingPayloadBuilder;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;

@ContextConfiguration(classes = {EndpointConfig.class})
public class BaseTest extends TestNGCitrusSpringSupport {

    @Autowired
    protected HttpClient yellowDuckService;

    protected void sendGetRequest(TestCaseRunner runner, HttpClient URL, String path, String queName, String queValue) {
        runner.$(http()
                .client(URL)
                .send()
                .get(path)
                .queryParam(queName, queValue));
    }

    protected void sendGetRequest(TestCaseRunner runner, HttpClient URL, String path) {
        runner.$(http()
                .client(URL)
                .send()
                .get(path));
    }

    protected void sendPostRequest(TestCaseRunner runner, HttpClient URL, String path, Object payload) {
        runner.$(http().client(URL)
                .send()
                .post(path)
                .message().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new ObjectMappingPayloadBuilder(payload, new ObjectMapper())));
    }

    protected void sendPostRequest(TestCaseRunner runner, HttpClient URL, String path, String payload) {
        runner.$(http().client(URL)
                .send()
                .post(path)
                .message().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(payload));
    }

    protected void validateResponse(TestCaseRunner runner, HttpClient URL, HttpStatus status, String expectedResponse) {
        runner.$(http().client(URL)
                .receive()
                .response(status)
                .message().type(MessageType.JSON)
                .body(new ClassPathResource(expectedResponse)));
    }

    protected void validateResponse(TestCaseRunner runner, HttpClient URL, HttpStatus status, Object expectedResponse) {
        runner.$(http().client(URL)
                .receive()
                .response(status)
                .message().type(MessageType.JSON)
                .body(new ObjectMappingPayloadBuilder(expectedResponse, new ObjectMapper())));
    }

    protected void validateResponse(TestCaseRunner runner, String expectedResponse) {
        runner.$(http()
                .client(yellowDuckService)
                .receive()
                .response(HttpStatus.OK)
                .message().type(MessageType.JSON)
                .body(expectedResponse));
    }

}