package de.keitocode.springbootraideriolib.service;

import de.keitocode.springbootraideriolib.RaiderioLib;
import de.keitocode.springbootraideriolib.service.interfaces.CharacterServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RaiderioService implements RaiderioLib {

    @Autowired
    private CharacterService characterService;

    public CharacterServiceInterface Character(String name) {
        return characterService.setCharacter(name);
    }

}
