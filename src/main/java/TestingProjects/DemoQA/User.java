package TestingProjects.DemoQA;

import java.util.List;

public class User {
	
	private Builder builder;
	User( Builder builder) {
		this.builder = builder;
	}
	
	public String getFirstName() {
		return builder.firstName;
	}
	
	public String getLastName() {
		return builder.lastName;
	}
	
	public String getAge() {
		return builder.age;
	}
	
	public String getEmail() {
		return builder.email;
	}
	
	public String getMobile() {
		return builder.mobile;
	}
	
	public String getGender() {
		return builder.gender;
	}
	
	public String getDob() {
		return builder.dob;
	}
	
	public String getSubject() {
		return builder.subject;
	}
	
	public String getPicturePath() { 
		
		return builder.picturePath;
	}
	
	public String getCurrentAddress() {
		return builder.currentAddress;
	}
	
	public List<String> getHobbies() {
		return builder.hobbies;
	}
	
	public String getState() {
		return builder.state;
	}
	
	public String getCity() {
		return builder.city;
	}
	
	
	
	public static class Builder {
		private String firstName;
		private String lastName;
		private String age;
		private String email;
		private String mobile;
		private String gender;
		private String dob;
		private String subject;
		private String picturePath;
		private String currentAddress;
		private List<String> hobbies;
		private String state;
		private String city;
		
		
		public Builder setFirstName(String firstName) { 
			this.firstName = firstName;
			return this;
		}
		
		public Builder setLastName(String lastName) { 
			this.lastName = lastName;
			return this;
		}
		
		public Builder setAge(String age) { 
			this.age = age;
			return this;
		}
		
		public Builder setEmail(String email) { 
			this.email = email;
			return this;
		}
		
		public Builder setMobile(String mobile) { 
			this.mobile = mobile;
			return this;
		}
		
		public Builder setGender(String gender) { 
			this.gender = gender;
			return this;
		}
		
		public Builder setDob(String dob) { 
			this.dob = dob;
			return this;
		}
		
		public Builder setSubject(String subject) { 
			this.subject = subject;
			return this;
		}
		
		public Builder setPicturePath(String picturePath) { 
			this.picturePath = picturePath;
			return this;
		}
		
		public Builder setCurrentAddress(String currentAddress) { 
			this.currentAddress = currentAddress;
			return this;
		}
		
		public Builder setHobbies(List<String> hobbies) { 
			this.hobbies = hobbies;
			return this;
		}
		
		public Builder setState(String state) { 
			this.state = state;
			return this;
		}
		
		public Builder setCity(String city) { 
			this.city = city;
			return this;
		}
		
		public User build() { 
			return new User( this );
		}
	}
}
