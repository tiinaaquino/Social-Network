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
	private HashMap<String, Profile> profiles;
	private Scanner fileScan, profileScan;
	//private Scanner friendsScan;
	private String profileInfo;
	Profile newProfile;
	
	// constructor
	public ProfileDatabase()
	{
		profiles = new HashMap<String, Profile>();
	}
	
	// this method adds a profile
	public void addProfile(String name, Profile p)
	{
		profiles.put(name, p);
	}
	
	// this method finds and returns a profile
	public Profile find(String name)
	{
		return profiles.get(name);
	}
	
	
	// not if method should return a profile with a String or Profile reference
	/*
	public Profile getRandomProfile()
	{
		Profile randomUser = profiles.get(null);
		for (Map.Entry<String, Profile> entry : profiles.entrySet())
		{
			randomUser = entry.getValue();
			break;
		}
		return randomUser;
	}
	*/
	
	// this method returns a string of a random profile
	public String getRandomProfile()
	{
		String randomUser = " ";
		for (String key: profiles.keySet())
		{
			randomUser = key;
			break;
		}
		return randomUser;
	}
	
	public void printAll()
	{
		for (Map.Entry<String, Profile> entry: profiles.entrySet())
		{
			System.out.println("Key: " + entry.getKey());
			System.out.println("Data: " + entry.getValue());
		}
	}
	
	// this method reads info from file profile
	public void loadProfiles(String fileName) throws IOException
	{
		// try/ catch block
		BufferedReader br;
		try {	
			br = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {
			//System.out.println("some message.");
			System.out.println(e);
		}
		
		String type, name, year, status, friends;
		String photoFileName;
		
		fileScan = new Scanner(new File("profiles"));
		while (fileScan.hasNext())
		{
			Profile newProfile;			
			profileInfo = fileScan.nextLine();
			
			// tutor suggested to use split method
			String [] attributes = profileInfo.split("; ");
			type = attributes[0];
			if (type.equals("organization"))
			{
				profiles.remove(type);
			}
			name = attributes[1];
			year = attributes[2];
			photoFileName = attributes[3];
			status = attributes[4];
			friends = attributes[5];
			
			newProfile = new Profile (type, name, year, photoFileName, status, friends);
			profiles.put(name, newProfile);
			
			/*
			profileScan = new Scanner(profileInfo);		
			profileScan.useDelimiter("; ");
			while (profileScan.hasNext())
			{
				type = profileScan.next();
				if (type.equals("organization"))
				{
					profiles.remove(type);
				}
				name = profileScan.next();
				year = profileScan.next();
				photoFileName = profileScan.next();
				status = profileScan.next();
				friends = profileScan.next();				
				newProfile = new Profile (type, name, year, photoFileName, status, friends);
				profiles.put(name, newProfile);
			
				//if (type.equals("organization"))
					//profiles.remove(name);
			}
			*/
		}
	}
	
	// this method checks if a user is in the file profiles
	public boolean findProfile(String name)
	{
		if (profiles.containsKey(name) == true)
			return true;
		else
			return false;
	}
}