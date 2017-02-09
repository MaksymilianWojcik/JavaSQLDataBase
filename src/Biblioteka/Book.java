package Biblioteka;

public class Book {

	private String title;
	private String author;
	private int publishedYear;

	public Book(String title, String author, int publishedYear) {
		super();
		this.title = title;
		this.author = author;
		this.publishedYear = publishedYear;
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

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

}
