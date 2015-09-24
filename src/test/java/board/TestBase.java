package board;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;
import board.pages.PageManager;
import board.util.NavigationUrl;
import board.util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class TestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;
  
  protected NavigationUrl navUrl;
  protected PageManager pages;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    
    pages = new PageManager(driver);    
    navUrl = new NavigationUrl(baseUrl, driver);
    
    //driver.get(baseUrl);
	navUrl.openMainPage();
	
  }

/*  @BeforeMethod
  public void initWebDriver() {
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
  }*/

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverFactory.dismissAll();
  }
  
  
  
}
