package it.fabrick.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.fabrick.rest.controller.DispositiveController;
import it.fabrick.rest.controller.InterrogazioneController;
import it.fabrick.services.DispositiveService;
import it.fabrick.services.InterrogazioniService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationContext {

	@Autowired
	private InterrogazioniService interrogazioneService;
	@Autowired
	private DispositiveService dispositiveService;


	@Autowired
	private InterrogazioneController interrogazioneController;
	@Autowired
	private DispositiveController dispositiveController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(interrogazioneService).isNotNull();
		assertThat(dispositiveService).isNotNull();
		assertThat(interrogazioneController).isNotNull();
		assertThat(dispositiveController).isNotNull();
	}
}
