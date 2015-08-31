import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GitHubLoginPage {
   private final WebDriver driver;
   
   public GitHubLoginPage (WebDriver driver) {
      this.driver = driver;
   }
   
   // Retrive the current page title
   public String getTitle()
   {
      driver.getTitle();
   }
   
   // Locators for the elements we will use on this page
   By usernameLocator = By.id("user_login");
   By emailLocator = By.id("user_email");
   By passwordLocator = By.id("user_password");
   By passwordConfirmationLocator = By.id("user_password_confirmation");
   By submitLocator = By.id("signup_button");
   By freeLocator = By.id("plan_free");
   By finishLocation = By.xpath("//button[@data-org-text]");
   
   // Create a free account
   public void createFreeAccount(String username, String eMail, String password)
   {
      // Type in the user information
      driver.findElement(usernameLocator).sendKeys(username);
      driver.findElement(emailLocator).sendKeys(eMail);
      driver.findElement(passwordLocator).sendKeys(password);
      driver.findElement(passwordConfirmationLocator).sendKeys(password);
      
      // Click sign up
      driver.findElement(submitLocator).click();
      
      // Select the free plan
      driver.findElement(freeLocator).click();
      
      // Click the finish button
      driver.findElement(finishLocator).click();      
   }
}