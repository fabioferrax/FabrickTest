package it.fabrick.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TestApi {


	private static String API_INTERROGATION_PATH = "/gbs-banking-service/interrogation";
	private static String API_DISPOSITIVE_PATH = "/gbs-banking-service/dispositive";
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
    public void testStateInterrogation() throws Exception {
        ResponseEntity<String> responseEntity = restTemplate.exchange(
        		"http://localhost:" + port + API_INTERROGATION_PATH + "/testState", 
        		HttpMethod.GET, 
        		null,
        		String.class);
        String result = responseEntity.getBody();
        assertThat(result).contains("API-ON");
    }

	@Test
    public void testStateDispositive() throws Exception {
        ResponseEntity<String> responseEntity = restTemplate.exchange(
        		"http://localhost:" + port + API_DISPOSITIVE_PATH + "/testState", 
        		HttpMethod.GET, 
        		null,
        		String.class);
        String result = responseEntity.getBody();
        assertThat(result).contains("API-ON");
    }
}
