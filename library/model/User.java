package library.model;

public class User {
  // attribute
  private String fullname;
  private String email;
  private String password;

  // constructor
  public User() {
  }

  public User(String fullname, String email, String password) {
    this.fullname = fullname;
    this.email = email;
    this.password = password;
  }

  // setter and getter
  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // get information
  public void getInfo() {
    System.out.println("{\n email: " + this.email + ",\n fullname: " + this.fullname + "}");
  }

}
