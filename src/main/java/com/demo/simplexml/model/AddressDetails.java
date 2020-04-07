package com.demo.simplexml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="address-details")
public class AddressDetails {
	    @Element(name="house-no")
	    public int HouseNo;
	    @Element(name="street-name")
	    public String StreetName;
	    @Element(name="city")
	    public String City;
	    @Element(name="zip-code")
	    public String PoAddress;
		
	    public int getHouseNo() {
			return HouseNo;
		}
		public void setHouseNo(int houseNo) {
			HouseNo = houseNo;
		}
		public String getStreetName() {
			return StreetName;
		}
		public void setStreetName(String streetName) {
			StreetName = streetName;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getPoAddress() {
			return PoAddress;
		}
		public void setPoAddress(String poAddress) {
			PoAddress = poAddress;
		}
	    
	    
}
