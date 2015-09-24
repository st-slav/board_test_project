package board.pages.landing;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import board.pages.PageManager;
import board.pages.RegistryPage;

public class LandingTopPanelPages extends LandingFooterPages {

	public LandingTopPanelPages(PageManager pages) {
		super(pages);
	}
	
	@FindBy(xpath = "//a[@href = '/signup/']")
	private WebElement signupButton;
	
	public RegistryPage clickSignupButton(){
		signupButton.click();
		return pages.registryPage;
	}
	
	public LandingTopPanelPages ensurePageLoaded(){
		wait.until(presenceOfElementLocated(By.xpath("//ul[@class = 'nav-landing__item-container']")));
		return this;
	}
	
	

}
