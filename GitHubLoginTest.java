import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class GetHubLoginTest {
   
   By signInName = By.xpath("//div[contains(@class,'header-nav-current-user')]");
   By userNameError = By.xpath("//dd[@class='error']");

   // Verify we can create a new free account (Test #1)
   public void createFreeAccountTest()
   {
      // Create new web driver
      WebDriver driver = new HtmlUnitDriver();
      
      // Navigate to the GitHub homepage
      driver.get("https://github.com/");
      
      // Instantiate page objects
      GitHubMainPage mainPage = new GitHubMainPage(driver);
      GitHubLoginPage loginPage;
      
      // Click the signup button
      loginPage = mainPage.clickSignUp();
      
      // Make sure we're on the correct page
      assertTrue(loginPage.getTitle().equals("Join GitHub · GitHub"));
      
      // Create a new free account
      loginPage.createFreeAccount("TestAccount", "test@gmail.com", "123456abc");
      
      // Assert the account creation was successful
      assertTrue(driver.findElement(signInName).getText().equals("Sign in as TestAccount"));
   }
   
   // Verify an error occurs if an already used user name is used (Test #2)
   public void usernameAlreadyExistsTest()
   {
      // Create a new driver
      WebDriver driver = new HtmlUnitDriver();
      
      // Navigate to the GitHub homepage
      driver.get("https://github.com/");
      
      // Instantiate page objects
      GitHubMainPage mainPage = new GitHubMainPage(driver);
      GitHubLoginPage loginPage;
      
      // Click the signup button
      loginPage = mainPage.clickSignUp();
      
      // Make sure we're on the correct page
      assertTrue(loginPage.getTitle().equals("Join GitHub · GitHub"));
      
      // Type in the previously used user name
      loginPage.typeInUserName("TestAccount");
      
      assertTrue(driver.findElement(userNameError).getText().equals("Username is already taken"));
   }
}
