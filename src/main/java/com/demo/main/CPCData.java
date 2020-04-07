package com.demo.main;


import org.w3c.dom.Node;

public class CPCData {
	
	private String cpcSection;
	private String cpcClass;
	private String cpcSubclass;
	private String cpcMainGroup;
	private String cpcSubGroup;
	private String cpcSymbol;
	
	
	public void generateMachineCPCSymbol() {
		if(CommonUtil.isNULLString(this.cpcSymbol)) {
			StringBuilder sb = new StringBuilder();
			sb.append(getCpcSection()).append(getCpcClass()).append(getCpcSubclass()).append(getCpcMainGroup());
			sb.append("/").append(getCpcSubGroup());
			this.cpcSymbol=sb.toString();
			System.out.println(cpcSymbol.toString());
		}
	}
	public String getCpcSection() {
		return cpcSection;
	}
	public void setCpcSection(String string) {
		this.cpcSection = string;
	}
	public String getCpcClass() {
		return cpcClass;
	}
	public void setCpcClass(String cpcClass) {
		this.cpcClass = cpcClass;
	}
	public String getCpcSubclass() {
		return cpcSubclass;
	}
	public void setCpcSubclass(String cpcSubclass) {
		this.cpcSubclass = cpcSubclass;
	}
	public String getCpcMainGroup() {
		return cpcMainGroup;
	}
	public void setCpcMainGroup(String cpcMainGroup) {
		this.cpcMainGroup = cpcMainGroup;
	}
	public String getCpcSubGroup() {
		return cpcSubGroup;
	}
	public void setCpcSubGroup(String cpcSubGroup) {
		this.cpcSubGroup = cpcSubGroup;
	}
	@Override
	public String toString() {
		return "CPCData [cpcSection=" + cpcSection + ", cpcClass=" + cpcClass + ", cpcSubclass=" + cpcSubclass
				+ ", cpcMainGroup=" + cpcMainGroup + ", cpcSubGroup=" + cpcSubGroup + ", cpcSymbol=" + cpcSymbol + "]";
	}
	
	
	

}

class CommonUtil{
	public static boolean isNULLString(String object) {

        if (object == null || object.length() == 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
