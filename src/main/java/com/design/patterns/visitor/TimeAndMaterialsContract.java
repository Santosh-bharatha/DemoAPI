package com.design.patterns.visitor;

public class TimeAndMaterialsContract implements ReportElement{
	
	public TimeAndMaterialsContract(long costPerHour, long hours) {
		super();
		this.costPerHour = costPerHour;
		this.hours = hours;
	}
	long costPerHour;
	long hours;
	@Override
	public <R> R accept(ReportVisitor<R> visitor) {
		return visitor.visit(this);
	}
	
	

}
