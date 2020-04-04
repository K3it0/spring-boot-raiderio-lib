package de.keitocode.springbootraideriolib.service;

import de.keitocode.springbootraideriolib.RaiderioLib;
import de.keitocode.springbootraideriolib.model.RaiderioCharacter;
import de.keitocode.springbootraideriolib.service.interfaces.CharacterService;

import org.springframework.stereotype.Service;


@Service
public class RaiderioService implements RaiderioLib {

    public CharacterService Character(RaiderioCharacter character) {
        CharacterServiceImpl characterService = new CharacterServiceImpl(character);
        return characterService;
    }

    public CharacterService Character(String region, String realm, String name) {
        CharacterServiceImpl characterService = new CharacterServiceImpl(region, realm, name);
        return characterService;
    }

}
