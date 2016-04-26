// not sure if this is even correct, but I'm trying to figure it out



// Arrays.sort(statuses); ????



package project3;

import java.util.ArrayList;
import java.util.Calendar;

public class Post implements Comparable<Post>{
	private String status, name;
	private long time;
	private ArrayList<String> statuses;
	private Calendar cal = Calendar.getInstance();
	
	// maybe create another constructor with different parameters
	
	public Post(String status)
	{
		this.status = status;
		time = cal.getTimeInMillis();
	}
	
	public Post(String name, String status)
	{
		this.name = name;
		this.status = status;
		time = cal.getTimeInMillis();
	}
	
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
		//Calendar cal = Calendar.getInstance();
		time = cal.getTimeInMillis();
		return time;
	}
	
	// check if this is correct... does there need to be something inside the parameters?
	public void addStatuses(Post post)
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
