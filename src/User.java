import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization versioning
    private String username;
    private String password;
    private boolean isInstructor;

    public User(String username, String password, boolean isInstructor) {
        this.username = username;
        this.password = password;
        this.isInstructor = isInstructor;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isInstructor() {
        return isInstructor;
    }
}