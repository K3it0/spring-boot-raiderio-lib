package de.keitocode.springbootraideriolib.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import de.keitocode.springbootraideriolib.model.RaiderioCharacter;
import de.keitocode.springbootraideriolib.service.interfaces.CharacterService;

class CharacterServiceImpl implements CharacterService {

    private final String URI_PATH = "/characters/profile";

    private WebClient raiderioClient;

    private MultiValueMap<String, String> queryParams;

    private Set<String> fieldsSet;

    public CharacterServiceImpl(String region, String realm, String name) {

        this.raiderioClient = WebClient.create("https://raider.io/api/v1");
        this.queryParams = new LinkedMultiValueMap<>();
        this.fieldsSet = new LinkedHashSet<>();

        queryParams.add("region", region);
        queryParams.add("realm", realm);
        queryParams.add("name", name);
    }

    public CharacterServiceImpl(RaiderioCharacter character) {

        this.raiderioClient = WebClient.create("https://raider.io/api/v1");
        this.queryParams = new LinkedMultiValueMap<>();
        this.fieldsSet = new LinkedHashSet<>();

        queryParams.add("region", character.getRegion());
        queryParams.add("realm", character.getRealm());
        queryParams.add("name", character.getName());
    }

    public CharacterServiceImpl(String baseUrl, RaiderioCharacter character) {

        this.raiderioClient = WebClient.create(baseUrl);
        this.queryParams = new LinkedMultiValueMap<>();
        this.fieldsSet = new LinkedHashSet<>();

        queryParams.add("region", character.getRegion());
        queryParams.add("realm", character.getRealm());
        queryParams.add("name", character.getName());
    }


    @Override
    public CharacterService getGear() {
        fieldsSet.add("gear");
        return this;
    }

    @Override
    public CharacterService getGuild() {
        fieldsSet.add("guild");
        return this;
    }

    @Override
    public RaiderioCharacter get() {

        addFieldsToQueryParam();

        return raiderioClient.get()
            .uri(UriBuilder -> UriBuilder
                .path(URI_PATH)
                .queryParams(queryParams)
                .build())
            .retrieve()
            .bodyToMono(RaiderioCharacter.class)
            .block();
    }

    private void addFieldsToQueryParam() {
        if (fieldsSet.isEmpty()) {
            return;
        }
        queryParams.addAll("fields", getFieldListFromFieldSet());
    }

    private List<String> getFieldListFromFieldSet() {
        List<String> fieldsList = new ArrayList<String>();
        fieldsList.addAll(fieldsSet);
        return fieldsList;
    }

}