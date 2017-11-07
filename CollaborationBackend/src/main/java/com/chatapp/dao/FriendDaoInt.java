package com.chatapp.dao;

import java.util.List;

import com.chatapp.model.Friend;
import com.chatapp.model.Registration;

public interface FriendDaoInt {
	List<Registration>listOfSuggestedUsers(String firstName );
	public void friendRequest(Friend friend);

}