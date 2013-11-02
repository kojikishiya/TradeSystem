package kk.trade.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import kk.trade.dao.IndustryMasterDataAccess;
import kk.trade.entity.IndustryMasterEntity;

import org.junit.Test;

public class IndustryMasterDataAccessTest {
	@Test
	public void getDataTest(){
		IndustryMasterDataAccess dao = new  IndustryMasterDataAccess();
		 ArrayList<IndustryMasterEntity> data = dao.getData();
		 assertNotNull(data);
		 assertNotSame(0,data.size());
		 assertEquals("001", data.get(0).getIndustryCode());
		 assertEquals("…YE”_—Ñ‹Æ",data.get(0).getIndusryName());
		 
	}
}
