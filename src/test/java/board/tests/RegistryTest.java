package board.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
//import static org.junit.Assert.*;

import board.TestBase;
import board.model.User;

public class RegistryTest extends TestBase {

//  private StartPage homepage;

   @BeforeMethod
   public void goRegistryForm(){
    pages.landingTopPanelPage.ensurePageLoaded()
    	.clickSignupButton()
    	.ensurePageLoaded();
  }
  
/*  @Test
  public void test() {
	  User user = new User().setEmail("st.mam_@hotmail.com").setPassword("123456").setLogin("stslav");
	  pages.registryPage.registryIn(user);
	  pages.registryPage.ensurePageLoaded();
	  Assert.assertTrue(pages.registryPage.errorTextTrue("Sorry, this email is already registered"));
  }
  
  @Test
  public void test2(){
	  User user = new User();
	  pages.registryPage.registryIn(user);
	  pages.registryPage.ensurePageLoaded();
	  Assert.assertTrue(pages.registryPage.errorTextTrue("Please enter your name"));
	  Assert.assertTrue(pages.registryPage.errorTextTrue("Please enter your email address"));
	  Assert.assertTrue(pages.registryPage.errorTextTrue("Please enter your password"));
  }*/
  
  @Test
  public void test3(){
	  pages.registryPage.setPassField("123456").clickHideButton();
	  Assert.assertTrue("signup__input  hideShowPassword-field hideShowPassword-shown".equals(pages.registryPage.getAttributePassField("class")));
	  Assert.assertTrue("text".equals(pages.registryPage.getAttributePassField("type")));
	  Assert.assertTrue("123456".equals(pages.registryPage.getTextPassField()));
	  pages.registryPage.clickHideButton();
	  Assert.assertTrue("signup__input  hideShowPassword-field hideShowPassword-hidden".equals(pages.registryPage.getAttributePassField("class")));
	  Assert.assertTrue("password".equals(pages.registryPage.getAttributePassField("type")));	
	  Assert.assertTrue("******".equals(pages.registryPage.getTextPassField()));
  }
  
  @Test
  public void test4(){
	  User user = new User().setEmail("st.mam@yandex.ru").setLogin("Stas").setPassword("123456");
	  pages.registryPage.registryIn(user);
	  pages.accountPage.ensurePageLoaded();
	  navUrl.openRelativeUrl(pages.accountPage.getPageUrl());
	  pages.accountPage.ensurePageLoaded();
	  Assert.assertTrue(user.getEmail().equals(pages.accountPage));
	  
  }
  
  @AfterMethod
  public void goInStartPage(){
	  System.out.println(baseUrl.concat(pages.registryPage.getPageUrl()));
	  System.out.println(navUrl.getUrl());
  	if (baseUrl.concat(pages.registryPage.getPageUrl()).equals(navUrl.getUrl())) {
  		pages.registryPage.clickHomeButton().ensurePageLoaded();
  	} else if (baseUrl.equals(navUrl.getUrl())){
  		return;
  	}
  }
  
}
