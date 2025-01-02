import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import static org.testng.Assert.assertTrue;

public class GoogleTest {

    private WebDriver driver;

@BeforeMethod
    public void before(){

    driver = new ChromeDriver();
    driver.navigate().to("https://google.pl");
}
@AfterMethod
    public void after(){
  driver.close();
  driver.quit();
}

@Test
public void testGoogle() throws InterruptedException {
    WebElement button = driver.findElement(By.id("W0wltc"));
    button.click();
    WebElement searchInput = driver.findElement(By.className("gLFyf"));
      searchInput.sendKeys("Onet.pl");
      searchInput.submit();
      String pageTitle = driver.getTitle();
      assertTrue(pageTitle.contains("Onet.pl"));
      WebElement firstResult = driver.findElement(By.cssSelector("h3"));
      firstResult.click();
      Thread.sleep(1000);
      WebElement acceptAndClose = driver.findElement(By.className("cmp-intro_acceptAll"));
      acceptAndClose.click();



    }



}
