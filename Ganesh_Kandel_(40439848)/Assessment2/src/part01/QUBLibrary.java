package part01;

import java.util.Scanner;

public class QUBLibrary {
	public static void main(String[] arges) {
		Library library = new Library();
		Scanner Scanner = new Scanner(System.in);
		boolean running = true;
	
	
	library.add(new LibraryBook("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780747532743", BookType.FICTION, 1, "The first book in the Harry Potter series, following the adventures of a young wizard.", 10.99, "harry_potter.jpg"));
	library.add(new LibraryBook("To Kill a Mockingbird", "Harper Lee", "2345678901", BookType.FICTION, 1, "A story of racial injustice", 12.99, "mockingbird.jpg"));
	library.add(new LibraryBook("The Immortals of Meluha","Amish Tripathi","9789381626349", BookType.FICTION,1,"The first book in the Shiva Trilogy, reimagining the story of Lord Shiva.", 12.99,"meluha.jpg"));
	library.add(new LibraryBook("The Hobbit", "J.R.R. Tolkien","9780261102217", BookType.FICTION, 1, "A fantasy novel about the adventures of Bilbo Baggins, a hobbit who embarks on a quest.", 9.99, "hobbit.jpg"));
	library.add(new LibraryBook("Make It Stick", "Peter C. Brown", "9780674729018", BookType.NON_FICTION, 1,"A book about the science of successful learning and memory retention.", 14.99,"make_it_stick.jpg"));

	while (running) {
        System.out.println("\n++ QUB Library Management System ++");
        System.out.println();
        System.out.println("1. List All Books");
        System.out.println("2. List Books by Status");
        System.out.println("3. Add a Book");
        System.out.println("4. Remove a Book");
        System.out.println("5. Borrow a Book");
        System.out.println("6. Return a Book");
        System.out.println("7. Display Ranked List");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
        int choice = Scanner.nextInt();
        Scanner.nextLine(); 
        
        
     
        switch (choice) {
        case 1:  
			LibraryBook[] allBooks = library.list();
			for (LibraryBook book : allBooks) {
				System.out.println(book);
			}
			break;

		case 2: // List of the books by status and deals with misspelling
		
		    System.out.print("Enter status (AVAILABLE, ON_LOAN, WITHDRAWN): ");
		    String statusInput = Scanner.nextLine().toUpperCase();
		    // Basic status validation
		    BookStatus status;
		    if (statusInput.equals("AVAILABLE")) {
		        status = BookStatus.AVAILABLE;
		    } else if (statusInput.equals("ON_LOAN")) {
		        status = BookStatus.ON_LOAN;
		    } else if (statusInput.equals("WITHDRAWN")) {
		        status = BookStatus.WITHDRAWN;
		    } else {
		        System.out.println("Invalid status!");
		        break;
		    }
		    
		    LibraryBook[] filteredBooks = library.list(status);
		    for (LibraryBook book : filteredBooks) {
		        System.out.println(book);
		    }
		    break;
		    
        case 3: 

			System.out.print("Enter title: ");
			String title = Scanner.nextLine();
			System.out.print("Enter author: ");
			String author = Scanner.nextLine();
			System.out.print("Enter ISBN: ");
			String isbn = Scanner.nextLine();
			System.out.print("Enter type (FICTION, NON_FICTION, REFERENCE ");
			BookType type = BookType.valueOf(Scanner.nextLine().toUpperCase());
			System.out.print("Enter edition: ");
			String editionInput = Scanner.nextLine();
			int edition = Integer.parseInt(editionInput);

			System.out.print("Enter price: ");
			String priceInput = Scanner.nextLine();
			double price = Double.parseDouble(priceInput);
			System.out.print("Enter summary: ");
			String summary = Scanner.nextLine();
			System.out.print("Enter cover image filename: ");
			String coverImage = Scanner.nextLine();
			

			LibraryBook newBook = new LibraryBook(title, author, isbn, type, edition, summary, price, coverImage);

			if (library.add(newBook)) {
				System.out.println("Book added successfully!");
			} else {
				System.out.println("Failed to add book. Price must be > £0.00.");

			}
			break;

		case 4:
			System.out.print("Enter book ID to remove: ");
			int removeId = Scanner.nextInt();
			if (library.remove(removeId)) {
				System.out.println("Book removed successfully!");
			} else {
				System.out.println("Failed to remove book. It may be on loan or does not exist.");
			}
			break;

        case 5: 
            System.out.print("Enter book ID to borrow: ");
            int borrowId = Scanner.nextInt();
            if (library.borrowBook(borrowId)) {
                System.out.println("Book borrowed Successfully!");
            } else {
                System.out.println("Failed to borrow book. Sorry, It may not be available.");
            }
            break;
            
        case 6: 
            System.out.print("Enter book ID to return: ");
            int returnId = Scanner.nextInt();
            if (library.returnBook(returnId)) {
                System.out.println("/n Book returned Successfully!");
            } else {
                System.out.println("Failed to return book. Sorry, It may not be on loan.");
            }
            break;
            
        case 7:
			LibraryBook[] popularBooks = library.mostPopular();
			for (LibraryBook book : popularBooks) {
				System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Loan Count: "
						+ book.getLoanCount());
			}

			break;
			
        case 8 :
        	running = false;
			System.out.println("Exiting the system. Goodbye and thank you! ");
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
        
			}
		}
	Scanner.close();
	}
	}
