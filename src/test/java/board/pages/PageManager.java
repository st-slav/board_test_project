package board.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import board.pages.landing.AccountPage;
import board.pages.landing.LandingFooterPages;
import board.pages.landing.LandingTopPanelPages;
import board.pages.landing.StartPage;
import board.util.DisplayedElementLocatorFactory;

public class PageManager {

	private WebDriver driver;
	
	public RegistryPage registryPage;
	public LandingFooterPages landingFooterPage;
	public LandingTopPanelPages landingTopPanelPage;
	public StartPage startPage;
	public HelloPage helloPage;
	public AccountPage accountPage;
	
	public PageManager(WebDriver driver) {
		this.driver = driver;
		registryPage = initElements(new RegistryPage(this));
		landingFooterPage = initElements(new LandingFooterPages(this));
		landingTopPanelPage = initElements(new LandingTopPanelPages(this));
		startPage = initElements(new StartPage(this));
		helloPage = initElements(new HelloPage(this));
		accountPage = initElements(new AccountPage(this));
	}

	private <T extends Page> T initElements(T page) {
	  //PageFactory.initElements(driver, page);
	  //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
	  PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 15), page);
	  return page;
	}
	
	public WebDriver getWebDriver() {
	  return driver;
	}
}
