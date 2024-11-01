package org.genshin.model;

public class Profile {
    public Profile(String bio, int level, int signup_state, String avatar) {
        this.bio = bio;
        this.level = level;
        this.signup_state = signup_state;
        this.avatar = avatar;
    }

    private String bio;
    private int level;
    private int signup_state;
    private String avatar;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSignup_state() {
        return signup_state;
    }

    public void setSignup_state(int signup_state) {
        this.signup_state = signup_state;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
