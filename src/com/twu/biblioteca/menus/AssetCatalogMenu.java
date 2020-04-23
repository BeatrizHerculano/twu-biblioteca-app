package com.twu.biblioteca.menus;

import com.twu.biblioteca.models.Action;
import com.twu.biblioteca.models.Catalog;
import com.twu.biblioteca.repository.AssetRepository;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class AssetCatalogMenu extends ActionMenu implements Action {
    PrintStream printStream;
    AssetRepository repository;
    public AssetCatalogMenu(PrintStream printStream, AssetRepository repository){
        super(printStream, new ArrayList<Action>());
        this.actions = new ArrayList<Action>(Arrays.asList(  new CheckoutAsset(printStream, repository), new CheckInAsset(printStream, repository)));
        this.printStream = printStream;
        this.repository = repository;
    }
    @Override
    public String getInitialMessage() {
        Catalog catalog = new Catalog(repository);
        return "This is the available "+repository.getAssetTypeName()+" catalog:\n" + catalog.getAvailableAssetsString();
    }

    @Override
    public void execute(){
        this.startMenu();
    }

    @Override
    public String getDisplayMessage() {
        return "List of "+ repository.getAssetTypeName()+"s";
    }
}
