package model;

public class user {

	  private String pass; // パスワード
	  private String master_id; // マスターID

	  public user() {
	  }

	  public user(String pass) {
		  this.pass = pass;
	  }

	  public user(String master_id, String pass) {
	    this.master_id = master_id;
	    this.pass = pass;
	  }

	  public String getMaster_id() {
	    return master_id;
	  }

	  public String getPass() {
	    return pass;
	  }

}
