package board.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import board.model.User;
import board.pages.landing.StartPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class RegistryPage extends Page {

	public RegistryPage(PageManager pages) {
		super(pages);
	}
	
	private String url = "signup/";
	
	public String getPageUrl(){
		return url;
	}

//Locators----------------------
	
	@FindBy(id = "name")
	private WebElement nameField;
	
	@FindBy(id = "email")
	private WebElement emailField;
	
	@FindBy(id = "password")
	private WebElement passField;
	
	@FindBy(xpath = "//button[@class = 'signup__submit' and @type = 'submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[@class = 'signup__input-container signup__input-container--icon-password']//button")
	private WebElement hideButton;
	
	@FindBy(xpath = "//a[@class = 'overlay__logo' and @href = '/index/']")
	private WebElement homeButton;	
	
//Methods---------------------
	
	public StartPage clickHomeButton(){
		homeButton.click();
		return pages.startPage;
	}
	
	public RegistryPage setNameField(String text){
		nameField.clear();
		nameField.sendKeys(text);
		return this;
	}
	
	public String getAttributeNameField(String attribute){
		return nameField.getAttribute(attribute);
	}
		
	public RegistryPage setEmailField(String text){
		emailField.clear();
		emailField.sendKeys(text);
		return this;
	}
	
	public String getAttributeEmailField(String attribute){
		return emailField.getAttribute(attribute);
	}
	
	public RegistryPage setPassField(String text){
		passField.clear();
		passField.sendKeys(text);
		return this;
	}
	
	public String getAttributePassField(String attribute){
		return passField.getAttribute(attribute);
	}
	
	public String getTextPassField(){
		System.out.println(passField.getAttribute("value"));
		return passField.getAttribute("value");
	}
	
	public void clickSubmitButton(){
		submitButton.click();
	}
	
	public RegistryPage clickHideButton(){
		hideButton.click();
		return this;
	}
	
	public void registryIn(User user) {
		setNameField(user.getName())
			.setEmailField(user.getEmail())
			.setPassField(user.getPass())
			.clickSubmitButton();
	}
	
	public boolean errorTextTrue(String text){
		List<WebElement> ErrNum = driver.findElements(By.xpath("//form[@class = 'signup__form']/div[@class = 'signup__error']/div[@class = 'signup__error-item']"));
		int errNum = ErrNum.size();
//		System.out.println(errNum);
		boolean res = false;
//		String[] report = new String[errNum];
		for (int i = 1; i <= errNum; i++){
//			System.out.println(driver.findElement(By.xpath("//form[@class = 'signup__form']/div[@class = 'signup__error']/div[" + i + "]")).getText());
			if (text.equals(driver.findElement(By.xpath("//form[@class = 'signup__form']/div[@class = 'signup__error']/div[" + i + "]")).getText())){				
				res =  true;
				return res;
			} else res = false;
		}		
		return res;
	}

//Ensures------------------
	
	public RegistryPage ensurePageLoaded(){
		wait.until(presenceOfElementLocated(By.id("fb_xdm_frame_https")));
		return this;
	}
	
	public RegistryPage ensurePageLoadedError(){
		wait.until(presenceOfElementLocated(By.id("fb_xdm_frame_https")));
		wait.until(presenceOfElementLocated(By.xpath("//div[@class = 'signup__error']//div[@class = 'signup__error-item']/div[1]")));
//		wait.until(presenceOfElementLocated(By.xpath("//form[@class = 'signup__form']//div[@class = 'signup__message'")));
		return this;
	}
	
}
