package com.twu.biblioteca.models;

import com.twu.biblioteca.Global;

import java.util.ArrayList;
import java.util.Collection;

public class Catalog {


    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        for (Book book : Global.books) {
            if(book.isAvailable()){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public boolean checkoutBook(String bookTitleToCheckout) {
        if(Global.books.contains(bookTitleToCheckout)) {
            int index = Global.books.indexOf(bookTitleToCheckout);
            if(!Global.books.get(index).isAvailable()){
                return false;
            }
            Global.books.get(index).checkout();
            return true;
        }
        return false;
    }

    public String getAvailableBooksString(){
        String availableBooksString = "";
        ArrayList<Book> availableBooks = this.getAvailableBooks();
        for (Book book: availableBooks){
            availableBooksString += book.toString() + "\n";
        }
        return availableBooksString;
    }
}
