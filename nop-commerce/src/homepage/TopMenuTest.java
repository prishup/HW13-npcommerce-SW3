package homepage;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUpOpenBrowser() {  //navigating to the Homepage
        openBrowser(baseUrl);

    }
    public void selectMenu(String menu){
      WebElement elements = driver.findElement(By.xpath(menu));
    elements.click();
}
@Test
    public void verifyPageNavigation(){
        selectMenu("//div[@class='master-wrapper-page']/div[2]");
}
    @After
    public void endTest() {
        //   closeBrowser();
    }
}


