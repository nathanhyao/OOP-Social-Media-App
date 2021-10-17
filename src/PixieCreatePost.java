import javax.swing.*;
import java.awt.*;

/***********************************************************************************************************************
 * PixieCreatePost.java: Contains all panel setups for the "Create Post" main menu option.
 *
 * @author Nathan Yao
 * @version July 28, 2021
 **********************************************************************************************************************/

public class PixieCreatePost extends JComponent {

    //all panels related to the "Create Post" option
    public JPanel createNewPostPanel;
    public JPanel importFromCSVPanel;

    public JTextField createNewPostTitleField;
    public JTextField createNewPostContentField;
    public JButton doneWritingPostButton;

    //IMPORT FROM CSV OPTION -- components
    public JTextField importFromCSVField;
    public JButton importFromCSVButton;

    public PixieCreatePost() {
        createNewPost();
        importFromCSV();
    }

    /**
     * setup for the "Create a New Post" page
     */
    public void createNewPost() {

        createNewPostPanel = new JPanel();
        createNewPostPanel.setLayout(null);

        Font instructionFont = new Font(Font.SANS_SERIF,  Font.BOLD, 12);

        JLabel titleInstruction = new JLabel("Post Title:");
        titleInstruction.setFont(instructionFont);
        titleInstruction.setBounds(100, 50, 300, 25);

        createNewPostTitleField = new JTextField();
        createNewPostTitleField.setBounds(100, 100, 250, 25);

        JLabel contentInstruction = new JLabel("Post Content:");
        contentInstruction.setFont(instructionFont);
        contentInstruction.setBounds(100, 150, 300, 25);

        createNewPostContentField = new JTextField();
        createNewPostContentField.setBounds(100, 200, 250, 25);

        doneWritingPostButton = new JButton("Create Post");
        doneWritingPostButton.setBounds(100, 250, 130, 30);

        createNewPostPanel.add(titleInstruction);
        createNewPostPanel.add(createNewPostTitleField);

        createNewPostPanel.add(contentInstruction);
        createNewPostPanel.add(createNewPostContentField);
        createNewPostPanel.add(doneWritingPostButton);
    }

    /**
     * set up for the "Import from CSV" option
     */
    public void importFromCSV() {
        importFromCSVPanel = new JPanel(null);

        //create title for the "change username" page
        JLabel importFromCSV = new JLabel("Enter CSV Filename (include \".csv\"):");
        importFromCSV.setBounds(100, 150, 300, 25);

        //create the text field for the "change username" page
        importFromCSVField = new JTextField();
        importFromCSVField.setBounds(100, 200, 250, 25);

        //create the save changed-username button
        importFromCSVButton = new JButton("Confirm");
        importFromCSVButton.setBounds(100, 250, 130, 30);

        //add them to the changeUsernamePanel in correct order
        importFromCSVPanel.add(importFromCSV);
        importFromCSVPanel.add(importFromCSVField);
        importFromCSVPanel.add(importFromCSVButton);
    }
}
