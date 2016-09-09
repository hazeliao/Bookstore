package fi.haagahelia.shan.domain;

import javax.validation.constraints.NotNull;

public class Book {
	
	@NotNull
	private String title, author, isbn;
	private int year;
	private double price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "bookInfo [title=" + title + ", author=" + author + ", isbn="
				+ isbn + ", year=" + year + ", price=" + price + "]";
	}
	
	

}
