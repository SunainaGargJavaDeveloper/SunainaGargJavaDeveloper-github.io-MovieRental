package sunainaa13118;
import java.io.Serializable;
public class Customer implements Serializable{
	private String firstName;
	private String lastName;
	private String phoneNo;
	private int custID;
	private Movie[] issuedMovies;
    public Customer(){}
    public void setFirstName(String name){
    	firstName=name;
    }
    public void setLastName(String name){
    	lastName=name;
    }
    public void setCustID(int id){
    	custID=id;
    }
    public void setIssuedMovies(Movie[] s){
    	
    		issuedMovies=s;
    	
    }
    public void setPhoneNo(String phoneNo){
    	this.phoneNo=phoneNo;
    }
    public String getphoneNo(){
    	return phoneNo;
    }
    public String getFirstName(){
    	return firstName;
    }
    public String getLastName(){
    	return lastName;
    }
    public int getCustID(){
    	return custID;
    }
    public Movie[] getIssuedMovies(){
    	return issuedMovies;
    }
    }

