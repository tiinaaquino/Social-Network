/*
 * not sure what other methods go in here, but
 * create an adding Friends method in here lol
 * 
 */

package project3;

public class SocialNetwork {
	private String listOfFriends;
	
	public SocialNetwork(String listOfFriends)
	{
		this.listOfFriends = listOfFriends;
	}
	
	public String getListOfFriends()
	{
		return listOfFriends;
	}
	
	public void addToListOfFriends(String newFriend)
	{
		String currentList = getListOfFriends();
		currentList += ", " + newFriend;
	}

}
