package com.chatapp.CollaborationBackend.dao;

import java.util.List;

import com.chatapp.CollaborationBackend.model.Friend;
import com.chatapp.CollaborationBackend.model.Registration;

public interface FriendDaoInt {
	List<Registration>listOfSuggestedUsers(String firstName );
	public void friendRequest(Friend friend);

}