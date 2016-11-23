package org.manojit.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.manojit.messenger.database.DataBaseClass;
import org.manojit.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DataBaseClass.getProfiles();

	public ProfileService() {
		profiles.put("manoj", new Profile(1L, "manoj", "lekkalapudi", "kumar"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getId() <= 0) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
