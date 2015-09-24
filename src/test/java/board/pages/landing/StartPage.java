package board.pages.landing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import board.pages.PageManager;
/**
 * Sample page
 */
public class StartPage extends LandingTopPanelPages {
/*
  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;
*/
  public StartPage(PageManager pages) {
    super(pages);
  }
}
