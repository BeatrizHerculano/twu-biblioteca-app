package com.twu.biblioteca.models;

import com.twu.biblioteca.repository.BookRepository;

import java.util.ArrayList;

public class Catalog {


    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        for (Book book : BookRepository.books) {
            if(book.isAvailable()){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public boolean checkoutBook(String bookTitleToCheckout) {
        Book bookWithTitle = this.firstBookByTitle(bookTitleToCheckout);
        if(bookWithTitle != null) {
            int index = BookRepository.books.indexOf(bookWithTitle);
            if(!BookRepository.books.get(index).isAvailable()){
                return false;
            }
            BookRepository.books.get(index).checkout();
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

    private Book firstBookByTitle(String title){
        ArrayList<Book> booksWithTitle = new ArrayList<Book>();
        for (Book book : BookRepository.books) {
            if(book.getTitle().equals(title)){
                booksWithTitle.add(book);
            }
        }
        if(booksWithTitle.size() > 0){
            return booksWithTitle.get(0);
        }else{
            return null;
        }
    }

    public boolean checkInBook(String bookTitle) {
        Book book = this.firstBookByTitle(bookTitle);
        if(book != null){
            int index = BookRepository.books.indexOf(book);
            if(BookRepository.books.get(index).isAvailable()){
                return false;
            }
            BookRepository.books.get(index).checkIn();
            return true;
        }
        return false;
    }
}
