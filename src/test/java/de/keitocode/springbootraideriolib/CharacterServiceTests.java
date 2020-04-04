package de.keitocode.springbootraideriolib;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.keitocode.springbootraideriolib.model.RaiderioCharacter;

@SpringBootTest
class CharacterServiceTests {

	@Autowired
	private RaiderioLib raiderioLib;

	private RaiderioCharacter testCharacter;

	@BeforeEach
	public void setUp() {
		this.testCharacter = new RaiderioCharacter();
		testCharacter.setRegion("eu");
		testCharacter.setRealm("Blackrock");
		testCharacter.setName("Sudox");
	}

	@Test
	void shouldRequestDefaultCharacter() {
		
		// Act
		RaiderioCharacter characterResponse = 
			raiderioLib.Character(testCharacter).get();

		// Assert
		assertThat(characterResponse).isNotNull();
		assertEquals(testCharacter.getName(), characterResponse.getName());
	}

	@Test
	void shouldRequestCharacterWithGear() {

		// Act
		RaiderioCharacter characterResponse = 
			raiderioLib.Character(testCharacter).getGear().get();

		// Assert
		assertThat(characterResponse).isNotNull();
		assertEquals(testCharacter.getName(), characterResponse.getName());
	}

	@Test
	void shouldRequestCharacterWithGuild() {

		// Act
		RaiderioCharacter characterResponse = 
			raiderioLib.Character(testCharacter).getGuild().get();
		
		// Assert
		assertThat(characterResponse).isNotNull();
		assertEquals(testCharacter.getName(), characterResponse.getName());
	}

}
