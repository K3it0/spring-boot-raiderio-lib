package de.keitocode.springbootraideriolib;

import de.keitocode.springbootraideriolib.model.RaiderioCharacter;
import de.keitocode.springbootraideriolib.service.interfaces.CharacterService;

public interface RaiderioLib {
    public CharacterService Character(RaiderioCharacter character);
    public CharacterService Character(String region, String realm, String name);

}