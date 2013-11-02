package kk.common;

public class DataNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DataNotFoundException(String str){
		super(str);
	}
	public DataNotFoundException(){
		super("データが見つかりませんでした。");
	}

}
