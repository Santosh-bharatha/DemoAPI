package com.demo.springbatch.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ClassificationsModel")
public class ClassificationsModel {

	private String applicationNumber;
	private String section;
	private String classs;
	private String subClass;
	private String mainGroup;
	private String subGroup;

	@XmlElement(name = "application-number")
	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	@XmlElement(name = "")
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@XmlElement(name = "")
	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	@XmlElement(name = "")
	public String getSubClass() {
		return subClass;
	}

	public void setSubClass(String subClass) {
		this.subClass = subClass;
	}

	@XmlElement(name = "")
	public String getMainGroup() {
		return mainGroup;
	}

	public void setMainGroup(String mainGroup) {
		this.mainGroup = mainGroup;
	}

	@XmlElement(name = "")
	public String getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}

}
