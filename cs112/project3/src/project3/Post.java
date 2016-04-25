// not sure if this is even correct, but I'm trying to figure it out

package project3;

import java.util.ArrayList;
import java.util.Calendar;

public class Post implements Comparable<Post>{
	private String status, name;
	private long time;
	private ArrayList<String> statuses;
	
	public Post(String name, String status, int time)
	{
		this.name = name;
		this.status = status;
		this.time = time;
	}
	
	//getters
	public String getName()
	{
		return name;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	// should status be in parameter?
	public long getTime()
	{
		Calendar cal = Calendar.getInstance();
		time = cal.getTimeInMillis();
		return time;
	}
	
	// check if this is correct
	public void addStatuses()
	{
		statuses.add(status);
	}
	
	
	public int compareTo(Post other)
	{
		if (this.getTime() < other.getTime())
		{
			return -1;
		}
		else
			if (this.getTime() == other.getTime())
			{
				return 0;
			}
			else
				return 1;
	}

}
