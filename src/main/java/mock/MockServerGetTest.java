package mock;


import org.mockserver.client.server.MockServerClient;
import org.mockserver.junit.MockServerRule;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import org.junit.Rule;
import org.junit.Test;

public class MockServerGetTest {

    @Rule
    MockServerRule server = new MockServerRule(this, 5000);

    public static void main(String[] args) throws InterruptedException {

        MockServerClient mockClient = new MockServerClient("localhost", 5000);
        String expected = "{ message: 'incorrect username and password combination' }";
        mockClient.when(
                request()
                        .withPath("/hello/John")
                        .withMethod("GET")
//                        .withHeader(new Header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN))
//                        .withQueryStringParameter(new Parameter("my-token", "12345"))
        ).respond(
                response()
                        .withStatusCode(200)
                        .withBody(expected)
        );
        Thread.sleep(1000*100);
    }
}
