package de.keitocode.springbootraideriolib;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CharacterServiceTests {

	@Autowired
	private RaiderioLib raiderioLib;

	@Test
	void defaultRequest() {
		assertThat(raiderioLib.Character("Sudox").get()).isNotNull();
	}

	@SpringBootApplication
  	static class TestConfiguration {
		  
  	}

}
