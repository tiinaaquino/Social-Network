/*
 * photoFileName shouldn't be of type String?
 */


package project3;

public class Profile {
	private String type, name, photoFileName, status, friends;
	private int year;
	private String password;
	
	
	public Profile(String type, String name, int year, String photoFileName, String status, String friends)
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
	
	public int getYear()
	{
		return year;
	}
		
	public String getStatus()
	{
		return status;
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
		String stringYear = Integer.toString(year);
		String firstThree = name.substring(0, 3);
		String lowerCaseThree = firstThree.toLowerCase();
		password = lowerCaseThree + stringYear;
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
	
	public void setYear(int userYear)
	{
		year = userYear;
	}
		
	public void setStatus(String update)
	{
		status = update;
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
		return (name + " " + photoFileName + " " + status + password);
	}
	
	
	// not sure if this method belongs in this class
	public boolean authenticate(String inputPassword)
	{
		if (inputPassword.equals(password))
		{
			return true;
		}
		else
			return false;
	}

}
