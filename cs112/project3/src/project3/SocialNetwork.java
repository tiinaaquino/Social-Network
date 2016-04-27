/*
 * not sure what other methods go in here, but
 * create an adding Friends method in here
 * 
 */


// no ArrayLists or HashMaps
package project3;

import java.util.ArrayList;

public class SocialNetwork {
	private ProfileDatabase p;
	private Profile user;
	private String listOfFriends;
	
	public SocialNetwork(String listOfFriends)
	{
		this.listOfFriends = listOfFriends;
	}
	
	public String getListOfFriends(String person)
	{
		listOfFriends = user.getFriends();
		return listOfFriends;
	}
	
	public void addToListOfFriends(String newFriend)
	{
		String currentList = user.getFriends();
		currentList += ", " + newFriend;
	}
	
	public void addToListOfFriends(Profile user, String newFriend)
	{
		String currentList = user.getFriends();
		//Profile[] people = currentList.split(", ");

		currentList += ", " + newFriend;
	}

	// get status updates of all friends???
}
