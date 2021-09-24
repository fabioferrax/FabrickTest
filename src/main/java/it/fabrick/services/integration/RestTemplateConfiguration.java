package it.fabrick.services.integration;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import it.fabrick.utils.LoggingRequestInterceptor;


@Configuration
public class RestTemplateConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(RestTemplateConfiguration.class);


	@Value("${be.defaultRestTemplate.connectionTimeout:0}")
	private Integer connectionTimeout;
	@Value("${be.defaultRestTemplate.readTimeout:0}")
	private Integer readTimeout;

	@Bean(("defaultRestTemplate"))
	public RestTemplate defaultRestTemplate() {
		logger.info("Set Timeout for defaultRestTemplate: " + connectionTimeout + " - " + readTimeout);
		return getRestTemplate(connectionTimeout, readTimeout);
	}


	private RestTemplate getRestTemplate(Integer connectionTimeout, Integer readTimeout) {
		SimpleClientHttpRequestFactory simpleHttpFactory = new SimpleClientHttpRequestFactory();
		if((connectionTimeout != null && connectionTimeout > 0) || (readTimeout != null && readTimeout > 0)){
			if(connectionTimeout != null && connectionTimeout > 0) {
				simpleHttpFactory.setConnectTimeout(connectionTimeout);
			}
			if(readTimeout != null && readTimeout > 0) {
				simpleHttpFactory.setReadTimeout(readTimeout);
			}
		}
		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(simpleHttpFactory));
		//RestTemplate restTemplate = builder.build();
		
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new LoggingRequestInterceptor());
		restTemplate.setInterceptors(interceptors);
		return restTemplate;

	}
}
