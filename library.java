import java.util.*;
class Book{
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId(){
        return bookId;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

}

class User{
    private int userId;
    private String username;
    private ArrayList<Book> borrowedBooks;

    public User(int userId, String username){
        this.userId = userId;
        this.username = username;
    }

    public int getUserId(){
        return userId;
    }

    public String getUsername(){
        return username;
    }

    public ArrayList<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }
}

class manageLibrary{
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public manageLibrary(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book){
       books.add(book);
    }

    public void borrowBook(int brBookId){
        try{
        for(Book book : books){
           if(brBookId == book.getBookId()){
            books.remove(book);
           }
        }     
    }catch(Exception e){
        System.out.println("Error:"+e.getMessage());
    }
    }

    public void returnBook(Book book){
        books.add(book);
    }

    public void displayBooks(){
        if(books.isEmpty()){
            System.out.println("\n There are no books in the library");
        }
        else{
            for(Book book: books){
                System.out.println("ID:"+book.getBookId()+"\t Title:"+book.getTitle()+"\t Author:"+book.getAuthor());
            }
        }
    }

    public void addUser(User user){
       users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

}

public class library{
    public static void main(String[] args) {
        manageLibrary lib = new manageLibrary();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("\n Welcome to the Library Management System!");
            System.out.println(" 1.Add/Return Book \n 2.Display Books \n 3.Borrow Book \n 4. Exit");
            System.out.print("\n Enter your choice:");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                System.out.println("\n Enter book details:");
                System.out.print("\n Enter Book ID:");
                int bookId = sc.nextInt();
                System.out.print("\n Enter Book Title:");
                String title = sc.next();
                System.out.print("\n Enter Book Author:");
                String author = sc.next();
                Book newBook = new Book(bookId, title, author);
                    lib.addBook(newBook);
                    break;
            
                case 2:
                lib.displayBooks();
                    break;
            
                case 3:
                System.out.print("\n Enter the book ID you want to borrow:");
                int brBookId = sc.nextInt();
                lib.borrowBook(brBookId);
                    break;
            
                case 4:
                running = false;
                System.out.println("\n Thank you for using the application");
                    break;
            
                default:
                System.out.println("\n Please enter a valid input");
                    break;
            }
        }
        sc.close();
    }
}