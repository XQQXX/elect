package com.elect.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private int id;
    private String author;
    private String publishing;
    private long publish_time;
    private String word_number;
    private String which_edtion;
    private String total_page;
    private int print_time;
    private String print_number;
    private String isbn;
    private String author_summary;
    private String catalogue;
    //注入product
    private Product product;

    public Book() {
    }

    public Book(int id, String author, String publishing, long publish_time, String word_number, String which_edtion, String total_page, int print_time, String print_number, String isbn, String author_summary, String catalogue) {
        this.id = id;
        this.author = author;
        this.publishing = publishing;
        this.publish_time = publish_time;
        this.word_number = word_number;
        this.which_edtion = which_edtion;
        this.total_page = total_page;
        this.print_time = print_time;
        this.print_number = print_number;
        this.isbn = isbn;
        this.author_summary = author_summary;
        this.catalogue = catalogue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public long getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(long publish_time) {
        this.publish_time = publish_time;
    }

    public String getWord_number() {
        return word_number;
    }

    public void setWord_number(String word_number) {
        this.word_number = word_number;
    }

    public String getWhich_edtion() {
        return which_edtion;
    }

    public void setWhich_edtion(String which_edtion) {
        this.which_edtion = which_edtion;
    }

    public String getTotal_page() {
        return total_page;
    }

    public void setTotal_page(String total_page) {
        this.total_page = total_page;
    }

    public int getPrint_time() {
        return print_time;
    }

    public void setPrint_time(int print_time) {
        this.print_time = print_time;
    }

    public String getPrint_number() {
        return print_number;
    }

    public void setPrint_number(String print_number) {
        this.print_number = print_number;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor_summary() {
        return author_summary;
    }

    public void setAuthor_summary(String author_summary) {
        this.author_summary = author_summary;
    }

    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", publishing='" + publishing + '\'' +
                ", publish_time=" + publish_time +
                ", word_number='" + word_number + '\'' +
                ", which_edtion='" + which_edtion + '\'' +
                ", total_page='" + total_page + '\'' +
                ", print_time=" + print_time +
                ", print_number='" + print_number + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author_summary='" + author_summary + '\'' +
                ", catalogue='" + catalogue + '\'' +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (publish_time != book.publish_time) return false;
        if (print_time != book.print_time) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (publishing != null ? !publishing.equals(book.publishing) : book.publishing != null) return false;
        if (word_number != null ? !word_number.equals(book.word_number) : book.word_number != null) return false;
        if (which_edtion != null ? !which_edtion.equals(book.which_edtion) : book.which_edtion != null) return false;
        if (total_page != null ? !total_page.equals(book.total_page) : book.total_page != null) return false;
        if (print_number != null ? !print_number.equals(book.print_number) : book.print_number != null) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (author_summary != null ? !author_summary.equals(book.author_summary) : book.author_summary != null)
            return false;
        if (catalogue != null ? !catalogue.equals(book.catalogue) : book.catalogue != null) return false;
        return product != null ? product.equals(book.product) : book.product == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publishing != null ? publishing.hashCode() : 0);
        result = 31 * result + (int) (publish_time ^ (publish_time >>> 32));
        result = 31 * result + (word_number != null ? word_number.hashCode() : 0);
        result = 31 * result + (which_edtion != null ? which_edtion.hashCode() : 0);
        result = 31 * result + (total_page != null ? total_page.hashCode() : 0);
        result = 31 * result + print_time;
        result = 31 * result + (print_number != null ? print_number.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (author_summary != null ? author_summary.hashCode() : 0);
        result = 31 * result + (catalogue != null ? catalogue.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
