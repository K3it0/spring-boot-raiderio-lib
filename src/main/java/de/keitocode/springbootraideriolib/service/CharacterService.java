package de.keitocode.springbootraideriolib.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import de.keitocode.springbootraideriolib.service.interfaces.CharacterServiceInterface;

@Service("characterService")
public class CharacterService implements CharacterServiceInterface {

    private final String URI_PATH = "/characters/profile";

    @Autowired
    private WebClient raiderioClient;

    MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    Set<String> fieldsSet = new LinkedHashSet<>();


    public CharacterServiceInterface setCharacter(String name) {
        queryParams.add("region", "eu");
        queryParams.add("realm", "Blackrock");
        queryParams.add("name", name);
        return this;
    }

    @Override
    public String get() {

        addFieldsToQueryParam();

        return raiderioClient.get()
            .uri(UriBuilder -> UriBuilder
                .path(URI_PATH)
                .queryParams(queryParams)
                .build())
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }

    @Override
    public CharacterServiceInterface getGear() {
        fieldsSet.add("gear");
        return this;
    }

    @Override
    public CharacterServiceInterface getGuild() {
        fieldsSet.add("guild");
        return this;
    }

    private List<String> getFieldListFromFieldSet() {
        List<String> fieldsList = new ArrayList<String>();
        fieldsList.addAll(fieldsSet);
        return fieldsList;
    }

    private void addFieldsToQueryParam() {
        if (fieldsSet.isEmpty()) {
            return;
        }
        queryParams.addAll("fields", getFieldListFromFieldSet());
    }



}