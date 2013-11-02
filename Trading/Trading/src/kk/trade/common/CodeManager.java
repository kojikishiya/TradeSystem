package kk.trade.common;

public class CodeManager {

	private CodeManager(){
		
	}
	private static CodeManager codeManager = null;
	
	public static CodeManager getInstance(){
		if(codeManager == null)
		{
			codeManager = new CodeManager();
		}
		
		return codeManager;
	}
//	private void load(){
//		
//	}
//	public String convertCode(String code){
//		
//		
//	}
}
