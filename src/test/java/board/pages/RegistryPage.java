package board.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class RegistryPage extends Page {

	public RegistryPage(PageManager pages) {
		super(pages);
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
	
//Methods---------------------
	
	public RegistryPage setNameField(String text){
		nameField.clear();
		nameField.sendKeys(text);
		return this;
	}
		
	public RegistryPage setEmailField(String text){
		nameField.clear();
		nameField.sendKeys(text);
		return this;
	}
	
	public RegistryPage setPassField(String text){
		nameField.clear();
		nameField.sendKeys(text);
		return this;
	}
	
	public void clickSubmitButton(){
		submitButton.click();
	}
	
	public RegistryPage clickHideButton(){
		hideButton.click();
		return this;
	}

	
	public RegistryPage ensurePageLoaded(){
		wait.until(presenceOfElementLocated(By.id("fb_xdm_frame_https")));
		return this;
	}

}
