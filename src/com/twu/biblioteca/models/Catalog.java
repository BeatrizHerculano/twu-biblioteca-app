package com.twu.biblioteca.models;

import com.twu.biblioteca.repository.AssetRepository;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.LoginRepository;
import com.twu.biblioteca.repository.RentRepository;

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

    public boolean checkoutAsset(String assetTitleToCheckout) {
        Asset assetWithTitle = this.firstBookByTitle(assetTitleToCheckout);
        if(assetWithTitle != null) {
            int index = repository.getAllAssets().indexOf(assetWithTitle);
            if(!repository.getAllAssets().get(index).isAvailable()){
                return false;
            }
            repository.getAllAssets().get(index).checkout();
            Asset rentedAsset = repository.getAllAssets().get(index);
            new RentRepository().addNewRent(new Rent(LoginRepository.loggedInUser, rentedAsset));
            return true;
        }
        return false;
    }


    public String getAvailableAssetsString(){
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

    public boolean checkInAsset(String bookTitle) {
        Asset asset = this.firstBookByTitle(bookTitle);
        if(asset != null){
            int index = repository.getAllAssets().indexOf(asset);
            if(repository.getAllAssets().get(index).isAvailable()){
                return false;
            }
            Asset rentedAsset = repository.getAllAssets().get(index);
            new RentRepository().removeRent(new Rent(LoginRepository.loggedInUser, rentedAsset));
            repository.getAllAssets().get(index).checkIn();
            return true;
        }
        return false;
    }
}
