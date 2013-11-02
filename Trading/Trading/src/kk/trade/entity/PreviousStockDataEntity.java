package kk.trade.entity;

import kk.common.IF.IEntity;

public class PreviousStockDataEntity implements IEntity{
private String securityCode;
private String securityName;
private String id;
private String marketCode;
private String industryCode;
private Double openingPrice;
private Double highPrice;
private Double lowPrice;
private Double closingPrice;
private Double dealings;
private Double salesValue;
private String valueDate;
public String getSecurityCode() {
	return securityCode;
}
public void setSecurityCode(String securityCode) {
	this.securityCode = securityCode;
}
public String getSecurityName() {
	return securityName;
}
public void setSecurityName(String securityName) {
	this.securityName = securityName;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getMarketCode() {
	return marketCode;
}
public void setMarketCode(String marketCode) {
	this.marketCode = marketCode;
}
public String getIndustryCode() {
	return industryCode;
}
public void setIndustryCode(String industryCode) {
	this.industryCode = industryCode;
}
public Double getOpeningPrice() {
	return openingPrice;
}
public void setOpeningPrice(Double openingPrice) {
	this.openingPrice = openingPrice;
}
public Double getHighPrice() {
	return highPrice;
}
public void setHighPrice(Double highPrice) {
	this.highPrice = highPrice;
}
public Double getLowPrice() {
	return lowPrice;
}
public void setLowPrice(Double lowPrice) {
	this.lowPrice = lowPrice;
}
public Double getClosingPrice() {
	return closingPrice;
}
public void setClosingPrice(Double closingPrice) {
	this.closingPrice = closingPrice;
}
public Double getDealings() {
	return dealings;
}
public void setDealings(Double dealings) {
	this.dealings = dealings;
}
public Double getSalesValue() {
	return salesValue;
}
public void setSalesValue(Double salesValue) {
	this.salesValue = salesValue;
}
public String getValueDate() {
	return valueDate;
}
public void setValueDate(String valueDate) {
	this.valueDate = valueDate;
}

}
