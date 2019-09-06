import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

public class AddPetTests {
    @Test
    public void addPetToOwner_Succes() throws Exception {

        /**
         *  SETUP
         */
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Devin Chandula\\Desktop\\abc\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        driver.get("http://localhost:8080/owners/1");


        /**
         * Test
         * Fill form elements
         */
        WebElement addPetButton = driver.findElement(By.xpath("//a[@href=\"1/pets/new\"]"));
        addPetButton.click();

        assert driver.getCurrentUrl().equals("http://localhost:8080/owners/1/pets/new");

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Tweety");

        WebElement birthDate = driver.findElement(By.id("birthDate"));
        birthDate.sendKeys("2018-12-16");

        WebElement type = driver.findElement(By.id("type"));
        Select typeSelect = new Select(type);

        typeSelect.selectByValue("bird");

//        driver.get("http://localhost:8080/owners/1");
        /**
         * submit
         */
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        /**
         * Validation
         */
        List<WebElement> elements = driver.findElements(By.className("dl-horizontal"));

//        elements.forEach(
//                e -> {
//                    WebElement element = e.findElement(By.cssSelector("dl dd"));
//                    if (element.getText().equals("Jerry")) {
//                        return;
//                    }
//                }
//        );

        Optional<WebElement> jerry = elements.stream().filter(
                e -> e.findElement(By.cssSelector("dl dd")).getText().equals("Tweety")
        ).findFirst();

        if (!jerry.isPresent()) {
            throw new Exception("jerry not found");
        }

        Thread.sleep(10000);
        driver.quit();

    }

}
