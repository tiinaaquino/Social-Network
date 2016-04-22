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
	private String profileInfo;
	
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
	
	public void loadProfiles(String fileName) throws IOException
	{
		
		// create a scanner for friends
		
		
		// try/ catch block
		/*
		BufferedReader br;
		
		try {
			
			br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (IOException e) {
			System.out.println("some message.");
			e.printStackTrace();
		}
		
		*/
		
		
		
		String type, name, status, friends;
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
				profiles.put(name, newProfile);
			}
			
		}
	}
	
	
	public boolean findProfile(String name)
	{
		if (profiles.containsKey(name) == true)
			return true;
		else
			return false;
	}

}
