package com.kce.bean;

public class LocalCourier extends courier {
	public String city;
	
	 public String getCity() {
		 return city;
	 }

	 public void setCity(String city) {
		 this.city = city;
	 }

}
class InternationalCourier extends courier {
	 public String country;
	
	 public String getCountry() {
		 return country;
	 }

	 public void setCountry(String country) {
		 this.country = country;
	 }
}