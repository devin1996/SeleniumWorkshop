import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SanityTest {
    public static void main(String[] args){
        System.setProperty(

          "webdriver.chrome.driver",
          "C:\\Users\\Devin Chandula\\Desktop\\abc\\chromedriver.exe"
        );

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
