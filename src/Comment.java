import java.util.Date;

/***********************************************************************************************************************
 * Comment.java: Acts as a structure that retains comment information of users with various getters and setters for
 * essential information (e.g., author, content, timestamp). Used in various files to organize comment information.
 *
 * @author Nathan Yao
 * @version Aug 1, 2021
 **********************************************************************************************************************/

public class Comment {
    private final String author; //author who made the comment
    private final String content; //content of the comment
    private final Date timestamp; //timestamp of comment

    public Comment(String author, String content) {
        this.author = author;
        this.content = content;
        timestamp = new Date();
    }
    
    public Comment(String author, String content, Date timestamp) {
    	this.author = author;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    
    public String getAuthor() {
    	return author;
    }

    public String getContent() {
        return content;
    }
    
    public String toFile() {
    	String output = "";
    	output += author + "," + timestamp.toString() + "," + content;
    	return output;
    }

    public String toString() {
        String output = "";
        output += " [Author]: " + author + "\n";
        output += " [Timestamp]: " + timestamp.toString() + "\n";
        output += " > " + content + "\n";
        return output;
    }
}
