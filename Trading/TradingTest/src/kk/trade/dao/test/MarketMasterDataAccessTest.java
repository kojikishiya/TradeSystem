package kk.trade.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kk.trade.dao.MarketMasterDataAccess;
import kk.trade.entity.MarketMasterEntity;

import org.junit.Test;

public class MarketMasterDataAccessTest {
	@Test
	public void getDataTest(){
		 MarketMasterDataAccess dao = new  MarketMasterDataAccess();
		 ArrayList<MarketMasterEntity> data = dao.getData();
		 assertNotNull(data);
		 assertNotSame(0,data.size());
		 assertEquals("001", data.get(0).getMarketCode());
		 assertEquals("“ŒØ1•”",data.get(0).getMarketName());
		 
	}
}
