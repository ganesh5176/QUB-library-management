package part2;

import part01.*;
import console.Console;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;

public class QUBLibraryUpdated {

	public static String centerTitle(String title, int lineWidth) {
		int padding = (lineWidth - title.length()) / 2;

		if (padding < 0)
			padding = 0;
		return String.format("%" + padding + "s%s", "", title);
	}

	public static void main(String[] args) {

		Library library = new Library();
		Console console = new Console(true);
		console.setVisible(true);
		console.setSize(800, 600);

		final int LINE_WIDTH = 105;
		// sizes of images after resizing
		final int IMAGE_WIDTH = 250;
		final int IMAGE_HEIGHT = 300;

		Font titleFont = new Font("Times New Roman", Font.HANGING_BASELINE, 30);
		Font menuFont = new Font("Courier New", Font.PLAIN, 18);
		Font inputFont = new Font("Calibri", Font.ITALIC, 16);
		Font discriptionFont = new Font("Calibri", Font.PLAIN, 17);
		Font discriptionFont1 = new Font("Calibri", Font.BOLD, 20);

		// These are the Preloaded books
		library.add(new LibraryBook("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780747532",
				BookType.FICTION, 1,
				"The first book in the Harry Potter series, following the adventures of a young wizard.", 10.99,
				"harry_potter.jpg"));

		library.add(new LibraryBook("To Kill a Mockingbird", "Harper Lee", "2345678901", BookType.FICTION, 1,
				"A story of racial injustice", 12.99, "mockingbird.jpg"));

		library.add(new LibraryBook("The Immortals of Meluha", "Amish Tripathi", "9789381626", BookType.FICTION, 1,
				"The first book in the Shiva Trilogy, reimagining the story of Lord Shiva.", 12.99, "meluha.jpg"));

		library.add(new LibraryBook("The Hobbit", "J.R.R. Tolkien", "9780261102", BookType.FICTION, 1,
				"A fantasy novel about the adventures of Bilbo Baggins, a hobbit who embarks on a quest.", 9.99,
				"hobbit.jpg"));

		library.add(new LibraryBook("Make It Stick", "Peter C. Brown", "9780674729", BookType.NON_FICTION, 1,
				"A book about the science of successful learning and memory retention.", 14.99, "make_it_stick.jpg"));

		boolean running = true;
		while (running) {

			console.clear();
			console.setBackground(Color.BLACK);
			console.setFont(titleFont);
			console.setColour(Color.RED);

			console.println(centerTitle("=========================================================================", LINE_WIDTH));

			console.println(centerTitle(" -- QUB Library -- ", LINE_WIDTH));
			console.println(centerTitle("=========================================================================", LINE_WIDTH));


			console.println();
			console.setColour(Color.blue);
			console.setFont(menuFont);
			console.println();
			console.println("1. List All Books");
			console.println("2. List Books by Status");
			console.println("3. Add a Book");
			console.println("4. Remove a Book");
			console.println("5. Borrow a Book");
			console.println("6. Return a Book");
			console.println("7. Display Ranked List");
			console.println("8. Exit");
			console.println();

			console.setColour(Color.ORANGE);
			console.setFont(inputFont);
			console.print("Enter your choice (1-8): ");

			try {
				int choice = Integer.parseInt(console.readLn());

				switch (choice) {

				case 1:
					// List all books with images the same size.

					console.clear();
					console.setBackground(Color.BLACK);
					console.setColour(Color.red);
					console.setFont(titleFont);

					console.println(centerTitle("-- All BOOKS --", LINE_WIDTH));
					console.println("-".repeat(150));
					console.setFont(discriptionFont1);

					for (LibraryBook book : library.list()) {

						ImageIcon originalIcon = new ImageIcon("Images/" + book.getImage());

						Image originalImage = originalIcon.getImage();
						Image resizedImage = originalImage.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT,
								Image.SCALE_SMOOTH);

						ImageIcon resizedIcon = new ImageIcon(resizedImage);
						console.setColour(Color.BLUE);
						console.println(book.toString());
						console.println();
						console.print(resizedIcon);
						console.println();
						console.println("*".repeat(100));

					}
					console.setColour(Color.ORANGE);
					console.println("Press Enter to continue:");
					console.readLn();
					break;

				case 2:

					// List of books by status adding try and catch to stop misspelling.
					console.println();
					console.setBackground(Color.BLACK);
					console.print("Enter status (AVAILABLE/ON_LOAN/WITHDRAWN): ");
					String statusInput = console.readLn().toUpperCase();
					try {
						console.setColour(Color.BLUE);
						BookStatus status = BookStatus.valueOf(statusInput);
						LibraryBook[] filtered = library.list(status);
						for (LibraryBook book : filtered) {
							console.setFont(discriptionFont);
							console.println("~~  " + book.toString());
							console.println();

						}
					} catch (Exception e) {
						console.println("Oops! '" + statusInput + "' is not a valid status. Try in capital letters");
					}
					console.setColour(Color.ORANGE);
					console.println("Press Enter to continue:");
					console.readLn();

					break;

				case 3:
					console.setBackground(Color.BLACK);
					console.setColour(Color.BLUE);
					console.print("Title: ");
					String title1 = console.readLn();
					console.print("Author: ");
					String author = console.readLn();
					console.print("ISBN: ");
					String isbn = console.readLn();
					console.print("Type (FICTION/NON_FICTION/REFERENCE): ");
					BookType type = BookType.valueOf(console.readLn().toUpperCase());
					console.print("Edition: ");
					int edition = Integer.parseInt(console.readLn());
					console.print("Summary: ");
					String summary = console.readLn();
					console.print("Price (£): ");
					double price = Double.parseDouble(console.readLn());
					console.print("Cover Image Filename: ");
					String coverImage = console.readLn();

					LibraryBook newBook = new LibraryBook(title1, author, isbn, type, edition, summary, price,
							coverImage);

					if (library.add(newBook)) {
						console.println(" Book added successfully!");
					} else {
						console.println("Failed to add. Price must be > £0.00.");
					}
					console.setColour(Color.ORANGE);
					console.println("Press Enter to continue...");
					console.readLn();
					break;

				case 4:
					console.clear();
					console.setBackground(Color.BLACK);
					console.setColour(Color.red);
					console.setFont(titleFont);
					console.println(centerTitle("~~~ ALL BOOKS ~~~", LINE_WIDTH));
					console.println();
					console.setColour(Color.BLUE);
					for (LibraryBook b : library.list()) {
						console.setFont(menuFont);
						console.print("ID: " + b.getId() + " - " + b.getTitle());
						console.print(" |Status: " + b.getStatus());
						console.println();
					}

					console.setFont(inputFont);
					console.setColour(Color.ORANGE);
					console.print("Enter book ID to remove: ");
					int removeId = Integer.parseInt(console.readLn());
					if (library.remove(removeId)) {
						console.println("Book removed Successfully!");
					} else {
						console.println("Failed to remove.");
					}

					console.println("Press Enter to continue...");
					console.readLn();
					break;

				case 5:
					console.clear();
					console.setBackground(Color.BLACK);
					console.setFont(titleFont);
					console.setColour(Color.GREEN);
					console.println(centerTitle("~~~ ALL BOOKS ~~~", LINE_WIDTH));
					console.println();

					for (LibraryBook b : library.list()) {

						console.setFont(menuFont);
						console.setColour(Color.BLUE);

						console.print("ID: " + b.getId() + " - " + b.getTitle());
						console.print(" |Status: " + b.getStatus());
						console.println();
					}
					console.setColour(Color.ORANGE);
					console.setFont(inputFont);
					console.print("Enter book ID to borrow: ");
					int borrowId = Integer.parseInt(console.readLn());
					if (library.borrowBook(borrowId)) {
						console.println("Book borrowed!");

					} else {
						console.println("Borrow failed.");
					}

					console.println("Press Enter to continue...");
					console.readLn();
					break;

				case 6:
					console.clear();
					console.setBackground(Color.BLACK);
					console.setFont(titleFont);
					console.setColour(Color.GREEN);
					console.println(centerTitle("~~~ RETURN BOOK ~~~", LINE_WIDTH));
					console.println();

					console.setFont(menuFont);
					console.setColour(Color.BLUE);
					console.println("Books on Loan:");
					console.println();

					for (LibraryBook b : library.list()) {
						if (b.getStatus() != BookStatus.AVAILABLE) {
							console.println("ID: " + b.getId() + " - " + b.getTitle());
						}
					}
					
					console.setFont(inputFont);
					console.println();
					console.setColour(Color.ORANGE);
					console.print("Enter book ID to return: ");
					int returnId = Integer.parseInt(console.readLn());
					if (library.returnBook(returnId)) {
						console.println("Book returned!");
					} else {
						console.println("Return failed.");
					}

					console.println("Press Enter to continue...");
					console.readLn();
					break;

				case 7:

					console.clear();
					console.setBackground(Color.BLACK);
					console.setFont(titleFont);
					console.setColour(Color.red);
					console.println(centerTitle("*** MOST POPULAR BOOKS ***", LINE_WIDTH));
					LibraryBook[] popularBooks = library.mostPopular();
					console.println();

					// Header
					console.setColour(Color.BLUE);
					console.setFont(discriptionFont);
					console.println("Title                          | Author |                               Loans");
					console.println("-----------------------------------------------------------------------------");
					console.setFont(discriptionFont);
					
					for (LibraryBook book : popularBooks) {
						String line = "* " + book.getTitle() + " - " + book.getAuthor() + " | " + book.getLoanCount();
						console.println(line);
					}
					console.setColour(Color.orange);
					console.println("Press Enter to continue...");
					console.readLn();
					break;

				case 8: // Exit
					console.setColour(Color.ORANGE);
					running = false;
					console.println(centerTitle("Thank you & Goodbye!", LINE_WIDTH));
					break;

				default:
					console.println("Invalid choice!");

					console.println("Press Enter to continue...");
					console.readLn();
				}

			} catch (Exception e) {
				console.println("Oops! Something went wrong.");
				console.println("Press Enter to continue...");
				console.readLn();
			}
		}

	}

}