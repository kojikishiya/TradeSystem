package kk.trade.beans;

public class RealTimeStockInfoBean {

	private String securityCode;
	private String marketCode;
	private Double realtimTePrice;
	private Double lastEndPrice;
	private Double startPrice;
	private Double highPrice;
	private Double lowPrice;
	private Double dealings;
	private Double salesValue;
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getMarketCode() {
		return marketCode;
	}
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	public Double getRealtimTePrice() {
		return realtimTePrice;
	}
	public void setRealtimTePrice(Double realtimTePrice) {
		this.realtimTePrice = realtimTePrice;
	}
	public Double getLastEndPrice() {
		return lastEndPrice;
	}
	public void setLastEndPrice(Double lastEndPrice) {
		this.lastEndPrice = lastEndPrice;
	}
	public Double getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
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
	
}
