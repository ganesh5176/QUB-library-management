package part01;

import java.util.ArrayList;

public class Library {
	private ArrayList<LibraryBook> books = new ArrayList<>();

	// Borrow a book
	public boolean borrowBook(int id) {
		LibraryBook book = search(id);
		return book != null && book.checkout();
	}

	// Return a book
	public boolean returnBook(int id) {
	    LibraryBook book = search(id);
	    if (book == null) {
	        System.out.println("Book not found!");
	        return false;
	    }
	    if (book.checkIn()) {
	        System.out.println("Book returned successfully!");
	        return true;
	    } else {
	        System.out.println("Failed to return book. It may not be on loan.");
	        return false;
	    }
	}
	
	// list all books
	public LibraryBook[] list() {
		return books.toArray(new LibraryBook[0]);
	}

	// List books by status
	public LibraryBook[] list(BookStatus status) {
		ArrayList<LibraryBook> filteredBooks = new ArrayList<>();
		for (LibraryBook book : books) {
			if (book.getStatus() == status) {
				filteredBooks.add(book);
			}
		}
		return filteredBooks.toArray(new LibraryBook[0]);
	}

// Get most popular books 
	
	public LibraryBook[]mostPopular() {
	ArrayList<LibraryBook> sortedBooks = new ArrayList<>(books);

	for(
	int i = 0;i<sortedBooks.size()-1;i++)
	{
		for (int j = 0; j < sortedBooks.size() - i - 1; j++) {
			// Handles element comparisons in each pass
			int currentCount = sortedBooks.get(j).getLoanCount();
			int nextCount = sortedBooks.get(j + 1).getLoanCount();

			if (currentCount < nextCount) {
				LibraryBook temp = sortedBooks.get(j);
				sortedBooks.set(j, sortedBooks.get(j + 1));
				sortedBooks.set(j + 1, temp);

			}

		}
	}
	return sortedBooks.toArray(new LibraryBook[0]);

}
	//To find the book by ID
	public LibraryBook search(int id) {
		for (LibraryBook book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	// Add a book
	public boolean add(LibraryBook book) {
		if (book.getPrice() > 0.00) {
			books.add(book);
			return true;
		}
		return false;
	}

	// Remove a book from the library
	public boolean remove(int id) {
		for (LibraryBook book : books) {
			if (book.getId() == id && book.getStatus() != BookStatus.ON_LOAN) {
				book.setStatus(BookStatus.WITHDRAWN);
				books.remove(book);
				return true;
			}
		}
		return false;
	}

}
