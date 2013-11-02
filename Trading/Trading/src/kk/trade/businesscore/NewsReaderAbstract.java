package kk.trade.businesscore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public abstract class NewsReaderAbstract implements Iterator<String>{

	private ArrayList<String> urlList = new ArrayList<String>();

	private int currenctIndex = 0;
	
	public NewsReaderAbstract(){

		
	}
	public void read() throws IOException{
		
		
		ArrayList<String> list = createUrls();
		readUrl(list);
	}
	protected abstract ArrayList<String> createUrls();
	
	private void readUrl(ArrayList<String> urllist) throws IOException{
		for(String url : urllist){
			if(urlList.size() >= getMaxUrlCount())
				return;
			
			if (!urlList.contains(url)){
				urlList.add(url);
				readUrl(findUrl(url));
			}			
		}
	}
	protected abstract int getMaxUrlCount();
	

	
	protected abstract  ArrayList<String> findUrl(String url) throws IOException;
	
	protected abstract String extractBodyText(String url) throws IOException;

	@Override
	public boolean hasNext(){
		if(currenctIndex < urlList.size() - 1){
			return true;
		}
		return false;
	}

	@Override
	public String next() {
		if(currenctIndex < urlList.size() -1)
		{
			try {
				return extractBodyText(urlList.get(++currenctIndex));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remove() {
		urlList.remove(currenctIndex);
		
	}
}
