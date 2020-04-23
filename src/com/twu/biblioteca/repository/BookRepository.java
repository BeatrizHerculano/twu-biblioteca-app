package com.twu.biblioteca.repository;

import com.twu.biblioteca.models.Asset;
import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class BookRepository implements AssetRepository{
    public static ArrayList<Asset> books = new ArrayList<Asset>(Arrays.asList(new Book("To kill a Mockingbird", "Harper Lee", "1960", 1)));

    @Override
    public ArrayList<Asset> getAllAssets() {
        return books;
    }

    @Override
    public String getAssetTypeName() {
        return "book";
    }
}
