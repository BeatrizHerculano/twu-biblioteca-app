package com.twu.biblioteca.repository;

import com.twu.biblioteca.models.Asset;
import com.twu.biblioteca.models.Movie;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieRepository implements AssetRepository{
    public static ArrayList<Asset> movies = new ArrayList<Asset>(Arrays.asList( new Movie("Atomic Blonde", "David Leitch", "2017", 10, 1)));

    @Override
    public ArrayList<Asset> getAllAssets() {
        return movies;
    }

    @Override
    public String getAssetTypeName() {
        return "movie";
    }
}
