import java.util.*;

/***********************************************************************************************************************
 * Account.java: Acts as a structure that retains account information of users with various getters and setters for
 * essential information (e.g., username, password, biography). Used in various files to organize account information.
 *
 * @author Charles Graham, Nathan Yao
 * @version Aug 1, 2021
 **********************************************************************************************************************/

public class Account {
    private String username;
    private String password;
    private String bio; //A short blurb about the user
    private ArrayList<Post> posts; //array list of posts (including their comments) made by this account
    
    public Account(String username, String password) {
        this.username = username;
        this.password = password; //will be encrypted from Application.java
        posts = new ArrayList<>();
        bio = ""; //user can set the bio later
    }

    public String getBio() {
        return bio;
    }

    public String getUsername() {
        return username;
    }

    public String toString() { //Outputs a user Account as a printable string
        String lineBreak = "=-=-=-=-=-=-=-=-=-=-=--=-=";
        StringBuilder output = new StringBuilder(lineBreak + "\n\n");
        output.append("Username: ").append(username).append("\n\n");
        output.append("Bio: ").append(bio).append("\n\n");

        for (Post post : posts) { //display a list of posts created by the user
            output.append(post.toString()).append("\n");
        }

        for (Post post : posts) { //display a list of comments created by the user UNDER the main post
            output.append(post.toString()).append("\n");
        }

        output.append(lineBreak).append("\n");
        return output.toString();
    }
    
   //toFile function
    public String[] toFile() {
    	ArrayList<String> output = new ArrayList<>();
    	output.add("Profile");
    	output.add(username);
    	output.add(password);
    	output.add("bio:" + bio); //We need to have bio: here, if its empty, parse issues
    	return output.toArray(new String[0]);
    }
    
    public boolean correctPassword(String input) {
        return password.equals(input);
    }

    //Set user bio, user can set their bio
    public void setBio(String bio) {
        this.bio = bio;
    }

    //Set the username
    public void setUsername(String username) {
        this.username = username;
    }

    //Set the password (password should be encrypted in Application.java)
    public void setPassword(String password) {
        this.password = password;
    }
}