/*
 * File: ProfileDatabase.java
 * -------------------------------
 * This class represents the social network: it keeps track of the profiles 
 * of all users (and organizations if you implement the extra credit).
 */


package project3;

/*
 * File: ProfileDatabase.java
 * -------------------------------
 * This class represents the social network: it keeps track of the profiles 
 * of all users (and organizations if you implement the extra credit).
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ProfileDatabase {
	HashMap<String, Profile> profiles;
	Scanner fileScan, profileScan;
	String profileInfo;
	
	public ProfileDatabase()
	{
		profiles = new HashMap<String, Profile>();
	}
	
	public void addProfile(String name, Profile p)
	{
		profiles.put(name, p);
	}
	
	Profile find(String name)
	{
		return profiles.get(name);
	}
	
	public void printAll()
	{
		for (Map.Entry<String, Profile> entry: profiles.entrySet())
		{
			System.out.println("Key: " + entry.getKey());
			System.out.println("Data: " + entry.getValue());
		}
	}
	
	public void addProfilesFromFile(String fileName) throws IOException
	{
		String type, name, status, friends;
		//???
		String photoFileName;
		int year;
		
		fileScan = new Scanner(new File("profiles"));
		while (fileScan.hasNext())
		{
			Profile newProfile;
			profileInfo = fileScan.nextLine();
			profileScan = new Scanner(profileInfo);
			profileScan.useDelimiter("; ");
			while (profileScan.hasNext())
			{
				type = profileScan.next();
				name = profileScan.next();
				year = profileScan.nextInt();
				photoFileName = profileScan.next();
				status = profileScan.next();
				friends = profileScan.next();
				
				newProfile = new Profile (type, name, year, photoFileName, status, friends);
				//profiles.put(key, value);
			}
			
		}
	}
	
	public void loadProfiles()
	{
		//FILL IN CODE:
	}
	
	public boolean findProfile(String name)
	{
		if (profiles.containsKey(name) == true)
			return true;
		else
			return false;
	}

}
