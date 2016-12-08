package tdunglas;

public class Author {

	public String firstName;
	public String lastName;
	
	public Author(String fn, String ln){
		this.firstName = fn;
		this.lastName = ln;
	}
	
	public String toString(){
		return "author first name : " + this.firstName 
				+ " and last name : " + this.lastName ;
	}
}
