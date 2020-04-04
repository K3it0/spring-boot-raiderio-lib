package de.keitocode.springbootraideriolib.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
* TODO 1: Add all getters and setters;  
* TODO 2:  Add Guild and Gear properties
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RaiderioCharacter {
    
    private String name;

    private String race;

    @JsonAlias("class")
    private String characterClass;

    private String active_spec_name;

    private String active_spec_role;

    private String gender;

    private String faction;

    private String achievement_points;

    private String honorable_kills;

    private String thumbnail_url;

    private String region;

    private String realm;

    private String profile_url;

    private String profile_banner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getActiveSpecName() {
        return active_spec_name;
    }

    public String getActiveSpecRole() {
        return active_spec_role;
    }

    public String getGender() {
        return gender;
    }

    public String getFaction() {
        return faction;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

}