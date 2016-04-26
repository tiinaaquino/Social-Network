/*
 * photoFileName shouldn't be of type String?
 */


package project3;

import java.util.ArrayList;

public class Profile {
	private String type, name, year, photoFileName, status, friends;
	private String password;
	
	
	public Profile(String type, String name, String year, String photoFileName, String status, String friends)
	{
		this.type = type;
		this.name = name;
		this.year = year;
		this.photoFileName = photoFileName;
		this.status = status;
		this.friends = friends;
	}
	
	// getters
	public String getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getYear()
	{
		return year;
	}
		
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String update)
	{
		status = update;
	}
		
	public String getPhotoFileName()
	{
		return photoFileName;
	}
	
	public String getFriends()
	{
		return friends;
	}
	
	public String getPassword()
	{
		String firstThree = name.substring(0, 3);
		String lowerCaseThree = firstThree.toLowerCase();
		password = lowerCaseThree + year;
		return password;
	}
	
	// setters
	public void setType(String userType)
	{
		type = userType;
	}
	
	public void setName(String aName)
	{
		name = aName;
	}
	
	public void setYear(String userYear)
	{
		year = userYear;
	}
		
	public void setPhotoFileName(String photoFile)
	{
		photoFileName = photoFile;
	}
	
	public void setFriends(String buddies)
	{
		friends = buddies;
	}
	
	public void setPassword(String userPassword)
	{
		password = userPassword;
	}
	
	// String toString
	public String toString()
	{
		return (name + " " + year + " " + photoFileName + " " + status + " " + friends);
	}
	
	// other methods
	public boolean authenticate(String inputPassword)
	{
		if (inputPassword.equals(getPassword()))
		{
			return true;
		}
		else
			return false;
	}
	
	public void addFriend(String newFriend)
	{
		friends += ", " + newFriend;
		setFriends(friends);
	}
	
	public boolean alreadyFriends(String newFriend)
	{
		//fix this later
		String newVar = "(.*)" + newFriend + "(.*)";
		if (friends.matches(newVar) == true)
		{
			return true;
		}
		else
			return false;
	}

}
