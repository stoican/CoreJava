package UserRegistration.model;

public class User {
    private String username;
    private String pwd;
    private String firstName;
    private String lastName;
    private String email;

    public User(String _firstName, String _lastName, String _email, String _userName, String _pwd) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.username = _userName;
        this.pwd = _pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        final String sep = ",";
        StringBuilder s = new StringBuilder(this.getFirstName());
        s.append(sep)
                .append(lastName)
                .append(sep).append(username)
                .append(sep).append(email)
                .append(sep).append(pwd);
        return s.toString();
    }
}
