package board.model;

public class User {
	private String name;
	private String email;
	private String pass;
	
/*	public User (String name, String email, String pass){
		this.email = email;
		this.name = name;
		this.pass = pass;
	}	*/
	
	public String getName() {
		return name;
	}
	
	public User setLogin(String name) {
		this.name = name;
		return this;
	}
	
	public String getEmail(){
		return email;
	}
	
	public User setEmail(String email){
		this.email = email;
		return this;
	}
	
	public String getPass() {
		return pass;
	}
	
	public User setPassword(String pass) {
		this.pass = pass;
		return this;
	}

}
