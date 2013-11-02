package kk.trade.entity;

import kk.common.IF.IEntity;

public class IndustryMasterEntity implements IEntity {
	private String industryCode;
	private String indusryName;
	public String getIndustryCode() {
		return industryCode;
	}
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	public String getIndusryName() {
		return indusryName;
	}
	public void setIndusryName(String indusryName) {
		this.indusryName = indusryName;
	}
	
}
