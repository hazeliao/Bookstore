package fi.haagahelia.shan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String title, author, isbn;
	private int year;
	private double price;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryId")
	private Category category;
	public Book ()	{}	
	
	public Book (String title, String author, String isbn, int year, double price){			
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}
	
	public Book ( String author, String title, String isbn, int year, Category category){		
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.year = year;
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
