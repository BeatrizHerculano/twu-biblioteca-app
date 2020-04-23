package com.twu.biblioteca.models;

public class Rent {
    User user;
    Asset asset;

    public Rent(User user, Asset asset) {
        this.user = user;
        this.asset = asset;
    }

    public User getUser() {
        return user;
    }

    public Asset getAsset() {
        return asset;
    }

    @Override
    public String toString() {
        return asset.toString() + " ["+user.toString()+"]";
    }
}
