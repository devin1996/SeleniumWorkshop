import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
    //psvm
    public static void main(String[] args) {

        System.setProperty(

                "webdriver.chrome.driver",
                "C:\\Users\\Devin Chandula\\Desktop\\abc\\chromedriver.exe"
        );

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/owners/find");
        //put name for a Input area
        WebElement lastName=driver.findElement(By.id("lastName"));
        lastName.sendKeys("Franklin");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        //validation
        assert driver.getCurrentUrl()=="http://localhost:8080/owners/1";
        //assert driver.findElement(By.xpath("//td/b[contains(text(), 'George Franklin']")).getText() == "George Franklin";
        assert driver.findElement(By.xpath("//td/b[contains(text(), 'George Franklin']")).isDisplayed();

      try {
          Thread.sleep(20000);
      } catch (InterruptedException e) {
           e.printStackTrace();
      }

        driver.quit();
    }
}
