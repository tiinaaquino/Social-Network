package project3;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** The graphical user interface for project 3 */
public class MainPanel extends JPanel{
	
	private ProfileDatabase socialNetwork;
	private SocialNetwork myWorld;
	private Post someStatus;
	private String loggedInUser = " "; // the user who is currently logged in
	private String lookedUpUser = " "; // the user we looked up
	
    JTextField loginUserName; // the text field to enter a username
    JPasswordField loginUserPassword; // the text field for entering the password
    
	// the Login button 
    JButton loginUserButton;

	// the text field and the button used to look up somebody's profile
    JTextField searchUserName;
    JButton searchUserButton;

	// the text field and the button used to update the status
    JTextField newStatus;
    JButton changeStatusButton;

	// the text field and the button used to add a new friend
    JTextField enterNewFriend;
    JButton addFriendButton;
    
    // when clicked, should take you to the profile of the loggedUser
    JButton homeButton; 
 
    // When clicked, adds the currently logged user as a supporter for the organization
    JButton likeButton;
    
    // subpanels
    JPanel topPanel; //the blue panel on top, where we login or search for users
    JPanel userProfilePanel; // left panel; shows user's profile
    JPanel newsFeedPanel; // right panel: shows recent posts of user and friends
    JPanel bottomPanel; // shows who is logged in
    
    public MainPanel (ProfileDatabase s) {
      socialNetwork = s;
      setPreferredSize (new Dimension(700, 400));
      setBackground (Color.lightGray);
      setLayout (new BorderLayout ());
      createSubpanels() ;
   }

   /** Creates the four subpanels of the current panel **/
    public void createSubpanels() {
   
    	createTopPanel();
    	createUserProfilePanel();
        createNewsFeedPanel();
        createBottomPanel();
        
         
        showTestInfo(socialNetwork.getRandomProfile());
        //showTestInfo("Helen"); // placeholder for your code 
    	
       
        // do not change the code below
        add(topPanel, BorderLayout.NORTH);
        add(userProfilePanel, BorderLayout.CENTER);
        add(newsFeedPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
    	
    }

    /** Creates the top panel that is used for logging in and looking up a profile **/
    private void createTopPanel() {
    	
        topPanel = new JPanel();
        topPanel.setBackground (new Color(0, 0, 100));
        
        // the text field to enter the username
        loginUserName = new JTextField(5);
        topPanel.add(loginUserName);
        
        // the text field to enter the password
        loginUserPassword = new JPasswordField(5);
        loginUserPassword.setEchoChar('*');
        topPanel.add(loginUserPassword);
        
        // the Login button
        loginUserButton = new JButton("Login");
        loginUserButton.addActionListener (new ButtonListener());
        topPanel.add(loginUserButton);
        this.add(topPanel, BorderLayout.NORTH);
        
        // the text field and the button for looking up some user's profile
        searchUserName = new JTextField(5);
        topPanel.add(searchUserName);
        searchUserButton = new JButton("Find a profile");
        searchUserButton.addActionListener (new ButtonListener());
        topPanel.add(searchUserButton);

        this.add(topPanel, BorderLayout.NORTH);

    }
    
    /**  Creates the subpanel  on the left that displays the user's profile  **/
    private void createUserProfilePanel() {
    	
        userProfilePanel = new JPanel();
        userProfilePanel.setPreferredSize (new Dimension(300, 400));
        userProfilePanel.setLayout (new BoxLayout( userProfilePanel, BoxLayout.Y_AXIS));
        userProfilePanel.setBackground (Color.lightGray);
        
    }
    
    /**  Creates the subpanel on the right that displays the the user's news feed  **/
    private void createNewsFeedPanel() {
    	
    	newsFeedPanel = new JPanel();
        newsFeedPanel.setPreferredSize (new Dimension(450, 400));
        newsFeedPanel.setBackground (Color.white);
        newsFeedPanel.setLayout (new BoxLayout (newsFeedPanel, BoxLayout.Y_AXIS));
 	
    }
    
    /**  The subpanel  on the bottom that displays who is logged in **/
    private void createBottomPanel() {
    	
    	 bottomPanel = new JPanel();
         JLabel currentlyLoggedIn = new JLabel("You are currently logged in as " + loggedInUser);
         bottomPanel.add(currentlyLoggedIn);    
    }
    
    /** The inner class that implements ActionListener interface
     *  Use it to handle all the button events.
     */
    /*
     * 
     * 
     * 
     * 
     * 
     *  this is just a space holder so I can find ButtonListener
     *  easily
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
     private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			////// public void findProfile
			
			
			//socialNetwork.findProfile(name); ??????
			
			System.out.println("Button pressed");
			JButton b = (JButton)e.getSource();
			
			if (b.equals(loginUserButton)) { 
				// The code below will be executed when the Login button is pressed
				userProfilePanel.removeAll();
				String name = loginUserName.getText();
				String password = new String(loginUserPassword.getPassword());
				
				// FILL IN CODE: 
				// check if this user exists in the social network, and 
				// authenticate the user: check whether he or she entered the 
				// username and password correctly. If yes, then assign
				// loggedInUser = name;
				
				showTestInfo(name); // replace with the function you will write
				// FILL IN CODE:
				// You need to access the profile given the name,
				// and display the profile info
				
			}
			// TODO: write if statements for other buttons
			
			if (b.equals(changeStatusButton)) {
				String status = newStatus.getText();
				//statusInfo = status;
				System.out.println(status);
			}
				
			
			
			updateUI(); // call it at the very end of this method
		}
   }
     
     
     /** The function that shows how to use GUI to display a user profile. 
      * Everything is hard coded. You need to replace it with your own function
      * that uses information from the profile database. 
      * Nothing should be hard coded in your implementation.
      **/
     /*
      * 
      * 
      * 
      * 
      * HARD CODED CODE HERE:
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      * 
      */
     public void showTestInfo(String name) {
    	 
    	 userProfilePanel.removeAll();
    	 
    	 // make sure this method pulls information from ProfileDatabase
    	 // use socialNetwork variable I think...
    	 
    	 loggedInUser = name;
    	 // add the name label  and image to the panel
    	 addLabel(name, "Serif", 25, userProfilePanel);
    	 
    	 
    	// add image 
    	addImage("no_image.png", userProfilePanel);
    	 /*
    	 String imageString;
    	 imageString = name + ".png";
    	 addImage(imageString, userProfilePanel);
    	 */
    	 
    	 // add status
    	 //Profile user;
    	 String statusInfo =  "Playing golf";
    	 //String statusInfo = user.getStatus();
    	 addLabel(statusInfo, "Serif", 18, userProfilePanel);
    	 addStatusTextfieldAndButton("Change status");
    	 
    	 // add friends
    	 String friends = "\nFriends: " + "Jenny";
    	 addLabel(friends, "Serif", 18, userProfilePanel);
    	 addFriendTextfieldAndButton();

    	 // add information to the news feed
    	 newsFeedPanel.removeAll();
		 JLabel title = new JLabel("News Feed"); 
	     title.setFont(new Font("Serif", Font.PLAIN, 20));
	     newsFeedPanel.add(title);
	     JLabel line = new JLabel("------------");
	     newsFeedPanel.add(line);
	     newsFeedPanel.add(new JLabel("\n"));
	    
	     // Adding Jenny's status update to the news panel
	     // In the starter code it's hard-coded, but you will change that.
	     // You need to access friends of the  user who is currently logged in, 
	     // get status updates for all friends, 
	     // sort them based on time and post them on the newsfeed.
	     JLabel nameFriend = new JLabel("Jenny");
	     nameFriend.setAlignmentX(Component.LEFT_ALIGNMENT);
	     nameFriend.setFont(new Font("Serif", Font.PLAIN, 18));
	     newsFeedPanel.add(nameFriend);
	     JLabel friendsStatus = new JLabel("Traveling in Tibet");
	     friendsStatus.setAlignmentX(Component.LEFT_ALIGNMENT);
	     newsFeedPanel.add(friendsStatus);
	     newsFeedPanel.add(new JLabel(" "));
	    
		 bottomPanel.removeAll();
		 bottomPanel.add(new JLabel("Currently logged in as " + loggedInUser));
      
     }
    
     
     
     /** Adds a label with the given text (name) to the panel passed as a parameter
      *  Centers the label in the center of the panel.
      */
     public void addLabel(String name, String font, int fontSize, JPanel panel) {

    	 	JLabel userName = new JLabel(name);
    	 	userName.setFont(new Font(font, Font.PLAIN, fontSize));
    	 	userName.setAlignmentX(Component.CENTER_ALIGNMENT);
    	 	panel.add(userName);    
     }
     
     /** Adds an image with the given filename to the userProfilePanel */
     public void addImage(String imagefile, JPanel panel) {
	    	 File imFile = new File("images/" + imagefile);	
	    	 BufferedImage myPicture;
	    	 try {
	    		 myPicture = ImageIO.read(imFile);
	    		 JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	    		 picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    		 panel.add(picLabel);
	    	 }
	    	 catch (IOException e) {
	    		 System.out.println(e);
	    	 }
     }   
     
     
     /** Adds a text field and a button for changing the status to the userProfilePanel */
      public void addStatusTextfieldAndButton(String text) {
    	 // add a textfield
    	 newStatus = new JTextField(15);
    	 newStatus.setMaximumSize( newStatus.getPreferredSize() );
    	 newStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
         userProfilePanel.add(newStatus );
         
         //add a button
         changeStatusButton = new JButton(text);
         changeStatusButton.addActionListener (new ButtonListener());
         changeStatusButton.setAlignmentX(Component.CENTER_ALIGNMENT);
         userProfilePanel.add(changeStatusButton);

      }
     
      /** Adds a text field and a button for adding a friend to the userProfilePanel */
      public void addFriendTextfieldAndButton() {
    	 // add a text field
    	 enterNewFriend = new JTextField(15);
    	 enterNewFriend.setMaximumSize( newStatus.getPreferredSize() );
    	 enterNewFriend.setAlignmentX(Component.CENTER_ALIGNMENT);
    	 userProfilePanel.add(enterNewFriend );
      
    	 //add a button
    	 addFriendButton = new JButton("Add a friend");
    	 addFriendButton.addActionListener (new ButtonListener());
    	 addFriendButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    	 userProfilePanel.add(addFriendButton);
      }
	
	

}
