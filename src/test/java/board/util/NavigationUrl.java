package board.util;

import org.openqa.selenium.WebDriver;

public class NavigationUrl {
	
	private String baseUrl;
	private WebDriver driver; 
	
	public NavigationUrl (String url, WebDriver driver){
		this.baseUrl = url;
		this.driver = driver;
	}
	  
	public void openRelativeUrl(String url) {
		driver.get(baseUrl + url);
	}
	
	public void openMainPage() {
		driver.get(baseUrl);
	}
	
	public String getUrl(){
		return driver.getCurrentUrl();
	}
	  
	  
}
