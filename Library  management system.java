import java.util.Scanner;
import java.util.ArrayList;

class Book {
	
	String name;
	String author;
	boolean isIssued;
	
	Book(String name, String author) {
		
		this.name = name;
		this.author = author;
		this.isIssued = false;
	
	}

}

class BookServiceLibrary {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Book> books = new ArrayList<>();
	
	void MethodToActivate() {
		
		while(true) {
		
		System.out.println("\n____WELCOME____");
		
		System.out.println("1- add books");
		System.out.println("2- veiw books");
		System.out.println("3- issue book");
		System.out.println("4- return issue book");
		System.out.println("5- Exit");
		
		System.out.print("\nEnter your choice#: ");
		int choice = sc.nextInt();
		
		sc.nextLine();
			
			switch(choice) {
			
				case 1:
					addBooks();
					break;
				
				case 2:
					veiwBooks();
					break;
					
				case 3:
				    issueBook();	
					break;
					
				case 4:
					returnIssueBook();
					break;
					
				case 5:
					System.out.println("tanks for using our program");
					return;
			}
		
		}
		
	}
	
	void addBooks() {
		
		System.out.println("\n\n==== Add book ====");
		
		System.out.println("Enter the author name: ");
		String author = sc.nextLine();
		
		System.out.println("\nEnter the book name: ");
		String name = sc.nextLine();
		
		books.add(new Book(name, author));
		System.out.println("the book is added successfully!!! (:");
		
	}
	
	void veiwBooks() {
		
		System.out.println("\n\n==== Veiw book ====");
		System.out.println("name | author | isTaken");
		System.out.println("_____|________|________");
		
		if (books.isEmpty()) {
			System.out.println("No book is added yet!!! ):");
			
		}else {
			for(Book b : books) {
		   	System.out.println(b.name + " | " + b.author + " | " + b.isIssued);
		
			}
			
		}
			
	}
	
	void issueBook() {
		System.out.println("\n\n==== Issue book ====");
		
		System.out.println("You want a book or you want to give it to someone? ");
		String userChoice = sc.nextLine();
		
		switch(userChoice) {
			
			case "I want book":
				System.out.println("\nEnter the book name: ");
				String Bookname = sc.nextLine();
				
				boolean found = false;
						
				for(Book bo : books) {
					if (bo.name.equals(Bookname)) {
						
						if (bo.isIssued == false) {
							bo.isIssued = true;
 						   System.out.println(Bookname + " book is successfully given!!! (:");
						
						}else {
							System.out.println("the book is already taken");
						
						}
					found = true;
					break;				
				}
				}
				
				if (found == false) {
					System.out.println("book not found!!!");
				}
				break;
				
			
			case "I want to give book":
				System.out.println("\nto whom you want to give!!");
				String nameToGive = sc.nextLine();
				
				sc.nextLine();
				
				System.out.println("\nok so which kind of book you want to give " + nameToGive);
				String BookNameToGive = sc.nextLine();
				
				boolean found2 = false;
				
				for(Book boo : books) {
					if (boo.name.equals(BookNameToGive)) {
						
						if (boo.isIssued == false) {
							boo.isIssued = true;
 						   System.out.println(BookNameToGive + " book is successfully given to " + nameToGive);
						
						}else {
							System.out.println("the book is already taken");
						
						}
					found = true;
					break;
				}
				}
				
				if (found2 == false) {
					System.out.println("book not found!!!");
				}
				break;		 
		}
		
	}
	
	void returnIssueBook() {
		System.out.println("\n\n==== Return book ====");
		
		System.out.println("Enter the book name you want to return: ");
		String returnBookName = sc.nextLine();
		
		boolean taken = false;
		
		for(Book bk : books) {
			if(bk.name.equals(returnBookName)) {
			   
			   if(bk.isIssued == true) {
					bk.isIssued = false;
					System.out.println(returnBookName + " book is successfully returned!!! (:");
				
			   }else {
			   	System.out.println("you did\'nt taked yet!!!");
			   
			   }
			   
		    }
		    
		}
			
	}		

}

class Main {
	public static void main(String[] args) {
		BookServiceLibrary obj = new BookServiceLibrary();
		obj.MethodToActivate();
		
	}
	
}
