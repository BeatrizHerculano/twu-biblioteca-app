package com.twu.biblioteca.repository;

import com.twu.biblioteca.models.Asset;
import com.twu.biblioteca.models.Rent;
import com.twu.biblioteca.models.User;

import java.util.ArrayList;

public class RentRepository {
    public static ArrayList<Rent> rents = new ArrayList<Rent>();

    public void addNewRent(Rent newRent){
        rents.add(newRent);
    }

    public void removeRent(Rent rentToRemove){
        User userToRemoveRent = rentToRemove.getUser();
        Asset assetToRemove = rentToRemove.getAsset();
        int index= -1;
        int toRemove = -1;
        for (Rent rent : rents) {
            index++;
            if (rent.getUser().getUsername().equals(userToRemoveRent.getUsername()) &&
                assetToRemove.toString().equals(rent.getAsset().toString())
            ){
                toRemove = index;
            }
        }

        rents.remove(toRemove);
    }
}
