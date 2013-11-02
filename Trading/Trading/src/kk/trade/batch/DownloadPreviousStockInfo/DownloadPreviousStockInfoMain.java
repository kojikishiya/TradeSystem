package kk.trade.batch.DownloadPreviousStockInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import kk.common.DataNotFoundException;
import kk.trade.beans.DownloadStockInfo;
import kk.trade.business.StockLoader;
import kk.trade.dao.IndustryMasterDataAccess;
import kk.trade.dao.MarketMasterDataAccess;
import kk.trade.dao.PreviousStockDataAccess;
import kk.trade.entity.*;

public class DownloadPreviousStockInfoMain {

	private static ArrayList<MarketMasterEntity> marketData;
	private static ArrayList<IndustryMasterEntity> industryData;
	public static void main(String[] args){
		update();
	}
	
	private static void update() {
		try{
			MarketMasterDataAccess mDao = new MarketMasterDataAccess();
			marketData = mDao.getData();
			industryData = new IndustryMasterDataAccess().getData();
			Calendar cal = Calendar.getInstance();
			PreviousStockDataAccess dao = new PreviousStockDataAccess();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			cal.setTime(sdf1.parse(dao.getMaxDate()));
			String date;
			Date now =new Date();
			while(now.after(cal.getTime()))
			{
				switch(cal.get(Calendar.DAY_OF_WEEK)){
				case Calendar.SUNDAY: 
				case Calendar.SATURDAY:continue;
				}
				date = sdf1.format(cal.getTime());
				ArrayList<DownloadStockInfo> infs = (new StockLoader()).loadStock(date,"stockT");
				
				dao.updateData(convertToEntity(infs));
				cal.add(Calendar.DATE, 1);
			}
		}
		
			catch(Exception e){
				e.printStackTrace();
			}	
	
	}
	private static ArrayList<PreviousStockDataEntity> convertToEntity(ArrayList<DownloadStockInfo> infos) throws DataNotFoundException{
		ArrayList<PreviousStockDataEntity> list = 
				new ArrayList<PreviousStockDataEntity>();
		for(DownloadStockInfo inf : infos){
			list.add(convertToEntity(inf));
		}
		return list;
		
	}
	private static PreviousStockDataEntity convertToEntity(DownloadStockInfo info) throws DataNotFoundException{
		PreviousStockDataEntity data = new PreviousStockDataEntity();
		data.setSecurityCode(info.getSecurityCode());
		data.setSecurityName(info.getSecurityName());
		data.setId(info.getMarketID());
		data.setMarketCode(getMarketCode(info.getMarketName()));
		data.setIndustryCode(getIndustryCode(info.getIndustry()));
		data.setOpeningPrice(info.getOpeningPrice());
		data.setHighPrice(info.getHighPrice());
		data.setLowPrice(info.getLowPrice());
		data.setClosingPrice(info.getClosingPrice());
		data.setDealings(info.getDealings());
		data.setSalesValue(info.getSalesValue());
		data.setValueDate(info.getDate());
		return data;
	}
	
	private static String getMarketCode(String marketName) throws DataNotFoundException{
		for(MarketMasterEntity entity : marketData){
			if(entity.getMarketName().equals(marketName))
				return entity.getMarketCode();
		}
		throw new DataNotFoundException(marketData.toString());
	}
	
	private static String getIndustryCode(String industryName) throws DataNotFoundException{
		for(IndustryMasterEntity entity : industryData){
			if(entity.getIndusryName().equals(industryName))
				return entity.getIndustryCode();
		}
		throw new DataNotFoundException();
	}
	
}
