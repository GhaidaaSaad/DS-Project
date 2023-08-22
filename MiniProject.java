import java.util.Scanner;

class Book {
	private String	nameLibrary, authorLibrary, numberLibrary;
	
	public Book(String namebook, String authorname, String numberbook) {
		this.nameLibrary = namebook;
		this.authorLibrary = authorname;
		this.numberLibrary = numberbook;
	}
	public Book() {
	}
	
	public String getNameLibrary() {
		return nameLibrary;
	}

	public void setNameLibrary(String nameLibrary) {
		this.nameLibrary = nameLibrary;
	}

	public String getAuthorLibrary() {
		return authorLibrary;
	}
	public void setAuthorLibrary(String authorLibrary) {
		this.authorLibrary = authorLibrary;
	}

	public String getNumberLibrary() {
		return numberLibrary;
	}

	public void setNumberLibrary(String numberLibrary) {
		this.numberLibrary = numberLibrary;
	}
	public String toString() {
		return "Book ==>\n nameLibrary of Book:" + nameLibrary + " authorLibrary  of Book:" + authorLibrary + " numberLibrary of Book:"
				+ numberLibrary + "]";
	}
	
}

 class BookOperation {
	static int size=0;

	 private class Node {
		 Book info; 
	     Node next; // reference variable Node type
		public Book getInfo() {
			return info;
		}
		public void setInfo(Book info) {
			this.info = info;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}

	 }
	 Node top;
	 public static int getSize() {
		return size;
	}
	public static void setSize(int size) {
		BookOperation.size= size;
	}
	public Node getTop() {
		return top;
	}
	public void setTop(Node top) {
		this.top = top;
	}
	BookOperation() { this.top = null;
	 }
	public void sortListLibrary()
	{
		// Node current will point to head
		Node current = getTop(), index = null;

		Book temp;
		if (top == null) {
			return;
		}
		else {
			while (current != null) {
				index = current.next;

				while (index != null) {

					if (current.getInfo().getNameLibrary().compareTo(index.getInfo().getNameLibrary()) > 0) {
						temp = current.getInfo();
						current.setInfo(index.getInfo()); 
						index.setInfo(temp); 

					}

					index = index.getNext();
				}
				current = current.getNext();
			}
		}
		display();

	}
	 // Utility function to add an element x in the stack
	 public void push(Book nodes) // insert at the beginning       ////
	 {
	     Node temp = new Node();
	    if (isUniquenNumber(nodes.getNameLibrary())==true) {
	         System.out.print("\n number of book is exit aready ");

	    	 return;
		}
	     if (temp == null) {
	         System.out.print("\nHeap Overflow");
	         return;
	     }

	     temp.setInfo(nodes);
	     temp.setNext(getTop());

	     setTop(temp);
	     System.out.print("\n Add successfully");
	     

	 }
	 public boolean isEmpty() { return this.top == null; }

	 public Book peek()
	 {

	     if (!isEmpty()) {
	         return top.info;
	     }
	     else {
	         System.out.println("Stack is empty");
	         return null;
	     }
	 }
	 public void popLibrary() 
	 {
	     if (isEmpty()) {
	         System.out.print("\nStack Underflow");
	         return;
	     }
	     top = (top).next;
	 }
	 public void deleteByLibraryO(String numberbook) 
	 { if (top == null) {
	     System.out.print("\nStack Underflow");
	     return;
	 }  
	 Node temp = top;
	 if (temp.info.getNumberLibrary().equalsIgnoreCase(numberbook)) {
	     top = temp.next; // Change head
	     return;
	 }
	 while (temp!=null) {
	    if(temp.info.getNumberLibrary().equalsIgnoreCase(numberbook)) {
	  Node next = temp.next;
	  temp.next = next.next; 	
	    }
	         temp = temp.next;
	    }
	}
	 public void searchByNumberLibrary(String nameLibrary) // remove at the beginning
	 {
	     // check for stack underflow
	     if (isEmpty()) {
	         System.out.print("\nStack Underflow");
	         return;
	     }  
	     Node temp = getTop();
	     if (temp.getInfo().getNameLibrary().equalsIgnoreCase(nameLibrary) ) {
	    	 System.out.println(" search of  "+nameLibrary+"  "+temp.info.toString());
	         return;
	     }    
	     while (temp!=null) {
	        if(temp.getInfo().getNameLibrary().equalsIgnoreCase(nameLibrary )) {
	       	 System.out.println(" search of name book "+nameLibrary+"  "+temp.info.toString());
	     
	        }
	             temp = temp.next;
	        }
	 }
	 public void UpdateLibrary(String numberbook,Book ob) //
	 {
	     if (isEmpty()) {
	         System.out.print("\nStack Underflow");
	         return;
	     }  
	     Node temp = getTop();
	     if (temp.getInfo().getNumberLibrary().equalsIgnoreCase(numberbook) ) {
	    		temp.getInfo().setAuthorLibrary(ob.getAuthorLibrary());
	    		temp.getInfo().setNameLibrary(ob.getNameLibrary());       

	    	 System.out.println(" \n update of name book "+numberbook);
	    	 return;
	     }    
	  
	     while (temp!=null) {
	        if(temp.getInfo().getNumberLibrary().equalsIgnoreCase(numberbook)) {
	        	temp.getInfo().setAuthorLibrary(ob.getAuthorLibrary());
	    		temp.getInfo().setNameLibrary(ob.getNameLibrary());       
	      
	        	System.out.println(" update of element "+numberbook);
	        }
	             temp = temp.getNext();
	        }
	 }
	 public void display()
	 {
		 
		// System.out.println("\n ************************************                             ************************************   ");
			System.out.println("\n ************************************ welcome of Library System  ************************************   ");

	     // check for stack underflow
	     if (isEmpty()) {
	         System.out.print("\nStack Underflow");
	       //  exit(1);
	     }
	     else {
	         Node temp = getTop();

	         while (temp != null) {
	             System.out.println("Book  ==> namebook=" + temp.getInfo().getNameLibrary() + ", authorname=" + temp.info.getAuthorLibrary() + ", numberbook=" + temp.info.getNumberLibrary() );
	             
	             temp = temp.getNext();
	         }
	     }


	 }
	 public boolean isUniquenNumber(String numberbook)
	 {
		 if (top == null) {

	         return false;
	     }  
	     Node temp = getTop();
	     if (temp.getInfo().getNameLibrary().equalsIgnoreCase(numberbook) ) {
	    	 System.out.println("\n exit already  of number book "+numberbook+" in Library  "+temp.info.toString());
	         return true;
	     }    
	     while (temp!=null) {
	        if(temp.getInfo().getNumberLibrary().equalsIgnoreCase(numberbook )) {
	       	 System.out.println("\n exit already  of number book "+numberbook+" in Library  "+temp.info.toString());
	     return true;
	        }
	             temp = temp.getNext();
	        }
		return false;

	 }



}
public class MiniProject {
	static String namebook, author, number;

	static Scanner input = new Scanner(System.in);
	static BookOperation book = new BookOperation();
	public static void meenu() {
		System.out.println("\n1)Add book details into the Library.\r\n" + "2) Remove a book from the Library.\r\n"
				+ "3) Update .\r\n" + "4) Display the entire book.\r\n" + "5) Search a book based on the name.\r\n"
				+ "6) Sort the entire book ascending.\r\n" + "7) Exit the program.  ");

		System.out.println("\n Please  choice any operation :");
	}
	
	public static void UpdatrBokk() {
		System.out.println("Please Enter number of book for update  :");
		number = input.next();
		System.out.println("Please Enter name of book  :");
		namebook = input.next();
		System.out.println("Please Enter author name of book :");
		author = input.next();
		Book obStudent = new Book(namebook, author, number);
		book.UpdateLibrary(number, obStudent);
	}
		public static void deleteBokk() {
		System.out.println("Please Enter  number book for delete");
		number = input.next();
		book.deleteByLibraryO(number);
		
	}
		public static void addBokk() {
			System.out.println("Please Enter number of book :");
			number = input.next();	
			
			  if (book.isUniquenNumber(number)==true) {
			         System.out.print("\n number of book is exit aready ");

			    	 return;
				}
		    System.out.println("Please Enter name of book  :");
		    namebook = input.next();
		    System.out.println("Please Enter author name of book :");
	     	author = input.next();


			Book obStudent = new Book(namebook, author, number);
			book.push(obStudent);
		}
		
		public static void main(String[] args) {
			
			//obj.display();

				//	System.out.println("\n ************************************                             ************************************   ");
					System.out.println("\n ************************************ welcome of Book System  ************************************   ");



					int key = 0;
					
					while (true) {//key != 7
						meenu();
						key = input.nextInt();
						switch (key) {
						case 1: {
							addBokk();
						}
							break;
						case 2: {
							
							deleteBokk();
						}
							break;
						case 3: {
							
							UpdatrBokk();
						}
							break;
						case 4: {
							book.display();
						}
							break;
						case 5: {
							System.out.println("Please Enter  name of book :");
							namebook = input.next();
							book.searchByNumberLibrary(namebook);
						}
							break;
						case 6: {
							book.sortListLibrary();

						}break;
						case 7: {
							System.out.println("Exiting...");
							System.exit(1);
						}
							break;
						default:
							break;
						}
					}

				}

}

