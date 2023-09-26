package com.design.patterns.visitor;

public interface ReportElement {
	<R> R accept(ReportVisitor<R> visitor);

}
