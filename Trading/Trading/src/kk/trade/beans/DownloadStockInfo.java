package kk.trade.beans;

public class DownloadStockInfo {

	private String securityCode = "";
	private String marketID = "";
	private String securityName = "";
	private String marketName = "";
	private String industry = "";
	private Double openingPrice = null;
	private Double highPrice = null;
	private Double lowPrice=null;
	private Double closingPrice =null;
	private Double dealings = null;
	private Double salesValue = null;
	private String date = null;
	
	public DownloadStockInfo(
			String securityCode,
			String marketID,
			String securityName,
			String marketName,
			String industry,
			Double openingPrice,
			Double highPrice,
			Double lowPrice,
			Double closingPrice,
			Double dealings,
			Double salesValue,
			String date){
		
		this.setSecurityCode(securityCode);
		this.setMarketID(marketID);
		this.setSecurityName(securityName);
		this.setMarketName(marketName);
		this.setIndustry(industry);
		this.setOpeningPrice(openingPrice);
		this.setHighPrice(highPrice);
		this.setLowPrice(lowPrice);
		this.setClosingPrice(closingPrice);
		this.setDealings(dealings);
		this.setSalesValue(salesValue);
		this.setDate(date);
		
	}
	public String getSecurityCode(){
		return securityCode;
	}
	
	public void setSecurityCode(String code){
		this.securityCode = code;
	}
	public String getMarketID() {
		return marketID;
	}
	public void setMarketID(String marketID) {
		this.marketID = marketID;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
