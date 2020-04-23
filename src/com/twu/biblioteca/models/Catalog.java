package com.twu.biblioteca.models;

import com.twu.biblioteca.repository.AssetRepository;
import com.twu.biblioteca.repository.BookRepository;

import java.util.ArrayList;

public class Catalog {
    AssetRepository repository;

    public Catalog(AssetRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Asset> getAvailableAssets() {
        ArrayList<Asset> availableAssets = new ArrayList<Asset>();
        for (Asset asset : repository.getAllAssets()) {
            if(asset.isAvailable()){
                availableAssets.add(asset);
            }
        }
        return availableAssets;
    }

    public boolean checkoutAssets(String assetTitleToCheckout) {
        Asset assetWithTitle = this.firstBookByTitle(assetTitleToCheckout);
        if(assetWithTitle != null) {
            int index = repository.getAllAssets().indexOf(assetWithTitle);
            if(!repository.getAllAssets().get(index).isAvailable()){
                return false;
            }
            repository.getAllAssets().get(index).checkout();
            return true;
        }
        return false;
    }


    public String getAvailableBooksString(){
        String availableAssetsString = "";
        ArrayList<Asset> availableAssets = this.getAvailableAssets();
        for (Asset asset: availableAssets){
            availableAssetsString += asset.toString() + "\n";
        }
        return availableAssetsString;
    }

    private Asset firstBookByTitle(String title){
        ArrayList<Asset> assetsWithTitle = new ArrayList<Asset>();
        for (Asset asset : repository.getAllAssets()) {
            if(asset.getTitle().equals(title)){
                assetsWithTitle.add(asset);
            }
        }
        if(assetsWithTitle.size() > 0){
            return assetsWithTitle.get(0);
        }else{
            return null;
        }
    }

    public boolean checkInBook(String bookTitle) {
        Asset asset = this.firstBookByTitle(bookTitle);
        if(asset != null){
            int index = repository.getAllAssets().indexOf(asset);
            if(repository.getAllAssets().get(index).isAvailable()){
                return false;
            }
            repository.getAllAssets().get(index).checkIn();
            return true;
        }
        return false;
    }
}
