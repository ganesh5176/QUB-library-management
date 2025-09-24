package part01;

public class LibraryBook extends Book implements Lendable {
	private static int nextId = 1;
	private int id;
	private BookStatus status;
	private String image;
	private int loanCount;

	// Constructor
	public LibraryBook(String title, String author, String isbn, BookType type, int edition, String summary,
			double price, String coverImage) {
		super(title, author, isbn, type, edition, summary, price);
		this.id = nextId++; 
		this.status = BookStatus.AVAILABLE;
		this.image = coverImage;
		this.loanCount = 0;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLoanCount() {
		return loanCount;
	}

	public void setLoanCount(int loanCount) {
		this.loanCount = loanCount;
	}

	

	
	public String toString() {
		return super.toString() + ", ID: " + id + ", Status: " + status + ", Image: " + image + ", Loan Count: "
				+ loanCount;
	}

	// Implement Lendable interface methods

	
	public boolean checkout() {
		if (status == BookStatus.AVAILABLE) {
			status = BookStatus.ON_LOAN;
			loanCount++;
			return true;
		}
		return false;
	}

	
	public boolean checkIn() {
		if (status == BookStatus.ON_LOAN) {
			status = BookStatus.AVAILABLE;
			return true;
		}
		return false;
	}

}
