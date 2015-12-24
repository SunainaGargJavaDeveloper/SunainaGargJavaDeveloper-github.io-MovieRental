package sunainaa13118;
import java.io.Serializable;

public class Movie implements Serializable{
	public static final int AVAILABLE=1;
	public static final int ISSUED=2;
	private String MovieName;
	private int year;
	private String Genere;
	private int movieID;
	private int status=AVAILABLE;
	private java.util.Date dueDate;
	private java.util.Date issueDate;
	
	public Movie(){status=AVAILABLE;};
	public Movie(int movieID,String mv,int year,String Genere){
		this.movieID=movieID;
		this.MovieName=mv;
		this.year=year;
		this.Genere=Genere;
	
	}
	public int getMovieID()
	{
		return movieID;
	}
	public String GetMovieName(){
		return MovieName;
	}
	public int getYear(){
		return year;
	}
	public String getGenere(){
		return Genere;
	}
	public String getStatus(){
		if(status==1)
			return ("AVAILABLE");
		else
			return ("ISSUED");
	}
	public java.util.Date getIssueDate()
	{
		return issueDate;
	}
	public java.util.Date getDueDate()
	{
		return dueDate;
	}
	
    public void setMovieName(String s){
    	MovieName=s;
    }
    public void setYear(int year){
    	this.year=year;
    }
    public void setGenere(String g){
    	Genere=g;
    }
    public void setMovieID(int x)
    {
    	movieID=x;
    }
    public void setStatus(int x){
    	status=x;
    }
    public void setIssueDate(java.util.Date d){
    	issueDate=d;
    }
    public void setDuedate(java.util.Date d){
    	dueDate=d;
    }
}
