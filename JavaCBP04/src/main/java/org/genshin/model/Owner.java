package org.genshin.model;

public class Owner {
    public Owner(String hash, String username, Profile profile, int id) {
        this.hash = hash;
        this.username = username;
        this.profile = profile;
        this.id = id;
    }

    private String hash;
    private String username;
    private Profile profile;
    private int id;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
