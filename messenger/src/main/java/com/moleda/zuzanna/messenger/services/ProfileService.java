package com.moleda.zuzanna.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.moleda.zuzanna.messenger.database.DatabaseClass;
import com.moleda.zuzanna.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("zuzua", new Profile(1L, "zuzua", "Zuzanna", "M."));
	}

	public List<Profile> getAllProfile(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		} else {
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
