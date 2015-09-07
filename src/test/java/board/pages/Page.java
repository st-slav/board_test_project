package board.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected PageManager pages;
  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(PageManager pages) {
	this.pages = pages;
	driver = pages.getWebDriver();
	wait= new WebDriverWait(driver, 15); 
  }
  
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }
  
  public boolean searñhText(String text){
	  try{
		  presenceOfElementLocated(By.xpath("//*[contains(text(), '" + text + "')]"));
		  return true;
	  } catch (Exception e) {
		  return false;
	  }
  }
  
}
