package com.mugu.restws.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mugu.restws.messanger.database.DatabaseClass;
import com.mugu.restws.messanger.model.Profile;

public class ProfileService {


	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("kumarmugu", new Profile(1L,"kumarmugu", "Mugu", "Kumar"));
		profiles.put("kumarmugu2", new Profile(2L, "kumarmugu2", "Hellow Mugu", "Mugu"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getId() <= 0) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeMessage(String profileName){
		return profiles.remove(profileName);
	}
}
