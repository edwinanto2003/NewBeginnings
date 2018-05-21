package com.edwin.backtracking;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        
    	Set<Friend> visited = new HashSet<Friend>();
    	
    	Queue<Friend> q = new LinkedList<Friend>();
    	
    	if (friend == null)
    		return false;
    	
    	q.add(this);
    	
    	while (!q.isEmpty())
    	{
    		Friend u = q.poll();
    		
    		if(!visited.contains(u))
    		{
    			visited.add(u);
    			for (Friend f : u.friends)
    			{
    				if (f != null)
    					q.add(f);
    			}
    		}
    		
    		if (u.equals(friend))
    			return true;
    	}
        return false;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
    }
}