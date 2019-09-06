import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

public class AddPetTest {
    public static void main(String[] args) throws InterruptedException {

//        System.setProperty(
//
//                "webdriver.chrome.driver",
//                "C:\\Users\\Devin Chandula\\Desktop\\abc\\chromedriver.exe"
//        );
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("http://localhost:8080/owners/1");
//
//        WebElement addpetbtn = driver.findElement(By.xpath("//a[@href=\"1/pets/new\"]"));
//        addpetbtn.click();
//
//        assert driver.getCurrentUrl()=="http://localhost:8080/owners/1/pets/new";
//
//        WebElement name = driver.findElement(By.id("name"));
//        name.sendKeys("Jerry");
//
//        WebElement birthdate = driver.findElement(By.id("birthdate"));
//        birthdate.sendKeys("2000-01-01");
//
//        WebElement type = driver.findElement(By.id("type"));
//        Select typeSelect = new Select(type);
//
//        typeSelect.selectByValue("cat");
//
//        WebElement submitbttn = driver.findElement(By.cssSelector("button[type='submit']"));
//        submitbttn.click();
//
//
//        final List<WebElement> elements= (List<WebElement>) driver.findElement(By.className("dl-horizontal"));
////        elements.forEach(
////                e -> {
////                    WebElement element = e.findElement(By.cssSelector("dl dd"));
////                    if (element.getText().equals("Jerry")){
////                        return;
////                    }
////                }
////        );
//
//        Optional<WebElement> jerry = elements.stream().filter(
//                e -> e.findElement(By.cssSelector("dl dd")).getText().equals("tweety")
//        ).findFirst();
//
//        if (!jerry.isPresent()){
//            try {
//                throw new Exception("Jerry not fount");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.quit();
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
        name.sendKeys("Jerry");

        WebElement birthDate = driver.findElement(By.id("birthDate"));
        birthDate.sendKeys("2018-12-06");

        WebElement type = driver.findElement(By.id("type"));
        Select typeSelect = new Select(type);

        typeSelect.selectByValue("cat");

        driver.get("http://localhost:8080/owners/1");
        /**
         * submit
         */
//        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
//        submitButton.click();

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
                e -> e.findElement(By.cssSelector("dl dd")).getText().equals("Jerry")
        ).findFirst();

        if (!jerry.isPresent()) {
            try {
                throw new Exception("jerry not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Thread.sleep(10000);
        driver.quit();
    }


}
