package com.jrobinson.fitfriends.model;

public class User {

	private String level;
	private String followers;
	private String following;
	private Progress progress;
	private String about;
	private UserInfo user;
	private Group[] groups;

	public class Progress {

		private String progressText;
		private String current;
		private String next;

		public String getProgressText() {

			return progressText;
		}

		public void setProgressText(String progressText) {

			this.progressText = progressText;
		}

		public String getCurrent() {

			return current;
		}

		public void setCurrent(String current) {

			this.current = current;
		}

		public String getNext() {

			return next;
		}

		public void setNext(String next) {

			this.next = next;
		}
	}

	public class UserInfo {

		private String image;
		private String url;
		private String name;

		public String getImage() {

			return image;
		}

		public void setImage(String image) {

			this.image = image;
		}

		public String getUrl() {

			return url;
		}

		public void setUrl(String url) {

			this.url = url;
		}

		public String getName() {

			return name;
		}

		public void setName(String name) {

			this.name = name;
		}
	}

	public class Group {

		private String name;

		public String getName() {

			return name;
		}

		public void setName(String name) {

			this.name = name;
		}

		public String getUrl() {

			return url;
		}

		public void setUrl(String url) {

			this.url = url;
		}

		private String url;
	}

	public String getLevel() {

		return level;
	}

	public void setLevel(String level) {

		this.level = level;
	}

	public String getFollowers() {

		return followers;
	}

	public void setFollowers(String followers) {

		this.followers = followers;
	}

	public String getFollowing() {

		return following;
	}

	public void setFollowing(String following) {

		this.following = following;
	}

	public Progress getProgress() {

		return progress;
	}

	public void setProgress(Progress progress) {

		this.progress = progress;
	}

	public String getAbout() {

		return about;
	}

	public void setAbout(String about) {

		this.about = about;
	}

	public UserInfo getUser() {

		return user;
	}

	public void setUser(UserInfo user) {

		this.user = user;
	}

	public Group[] getGroups() {

		return groups;
	}

	public void setGroups(Group[] groups) {

		this.groups = groups;
	}
}
