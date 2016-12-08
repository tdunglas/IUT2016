package tdunglas;

public class Book {
	
	public String title;
	public String contenu;
	public Author author;
	
	public Book(String t, String c, Author a){
		this.title = t;
		this.contenu  = c;
		this.author = a;
	}
	
	public String toString(){
		return "book title : " + this.title
				+ "\nbook author " + this.author
				+ "\ncontenu : " + this.contenu;
	}
}
