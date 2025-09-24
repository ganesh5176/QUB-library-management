package part01;

public class Book {

	private String title;       // 5-40 characters
    private String author;      // 5-40 characters
    private String isbn;        // Exactly 10 digits
    private BookType type;
    private int edition;        // >= 1
    private String summary;     // 20-150 characters
    private double price;       // > £0.00

// Creating a constructor with all properties
	public Book(String title, String author, String isbn,
			BookType type, int edition, String summary, double price) {

		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.type = type;
		this.edition = edition;
		this.summary = summary;
		this.price = price;

	}

//Getter 

	public String getTitle() {
		return title;}
	
	public String getAuthor() {
		return author;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getSummary() {
		return summary;
		
	}
	public double getPrice() {
		return price;
	}

	public int getEdition() {
		return edition;
	}
	public BookType getType() {
		return type;
	}
	
	//Setters 
	
	public boolean setTitle(String title) {
		if(title.length()>5&&title.length()<40) {
			this.title = title;
			return true;
		}
		return false;
	}

	public boolean setAuthor(String author) {

		if (author.length() > 5 && author.length() < 40) {
			this.author = author;
			return true;
		}
		return false;
	}

	public boolean setIsbn(String isbn) {
		if (isbn != null && isbn.length() == 10 && isbn.matches("\\d+")) {
			this.isbn = isbn;
			
			return true;
		}
		return false;
	}

	public void setType(BookType type) {
		this.type = type;
	}

	public boolean setEdition(int edition) {
		if (edition >= 1) {
			this.edition = edition;
			return true;
		}
		return false;
	}

	public boolean setSummary(String summary) {
		if (summary != null && summary.length() >= 20 && summary.length() <= 150) {
			this.summary = summary;
			return true;
		}
		return false;
	}

	public boolean setPrice(double price) {
		if (price > 0.00) {
			this.price = price;
			return true;
		}
		return false; // Price must be positive
	}

//toString method

	@Override
	public String toString() {
		 return "Title: " + title +"\n" + 
	               "- Author: " + author +"\n"+ 
	               "- ISBN: " + isbn +"\n"+ 
	               "- Type: " + type+"\n" + 
	               "- Edition: " + edition +"\n"+ 
	               "- Summary: " + summary +"\n"+ 
	               "- Price: £" + price+"\n";
		 
	    }

}
