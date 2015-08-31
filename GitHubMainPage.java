import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GitHubMainPage {
   private final WebDriver driver;
   
   public GitHubMainPage (WebDriver driver) {
      this.driver = driver;
   }
   
   By signUpButton = By.ByLinkText("Sign Up");
   
   public GitHubLoginPage clickSignUp()
   {
      driver.findElement(signUpButton).click();
      return new GitHubLoginPage(driver);
   }
}