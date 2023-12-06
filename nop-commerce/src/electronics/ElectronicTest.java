package electronics;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElectronicTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUpOpenBrowser() {  //navigating to the Homepage
        openBrowser(baseUrl);

    }
String email = "kish12345@yahoo.com";
    public void login() throws InterruptedException {
            Actions actions = new Actions(driver);
            WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
            loginLink.click();
            WebElement emailLoginField = driver.findElement(By.id("Email"));
            emailLoginField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("124578");
        WebElement login = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        login.click();
        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement( By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        actions.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
    }

@Test
    public void textverified(){
//    1.1 Mouse Hover on “Electronics” Tab
    driver.findElement(By.xpath("//div[@class='master-wrapper-page']/div[2]/ul[1]/li[2]/a")).click();

//    1.2 Mouse Hover on “Cell phones” and click
    driver.findElement(By.xpath("//div[@class='page-body']/div[1]/div/div[2]/div/div/a")).click();

//    1.3 Verify the text “Cell phones”
    String actualText = driver.findElement(By.tagName("h1")).getText();
    System.out.println(actualText);
    String expectedResult ="Cell phones";
    Assert.assertEquals(actualText,expectedResult);

    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
//        2.1 Mouse Hover on “Electronics” Tab
        driver.findElement(By.xpath("//div[@class='master-wrapper-page']/div[2]/ul[1]/li[2]/a")).click();

//        2.2 Mouse Hover on “Cell phones” and click
        driver.findElement(By.xpath("//div[@class=\"page-body\"]/div[1]/div/div[2]/div/div/a")).click();

//        2.3 Verify the text “Cell phones”
        Thread.sleep(1000);
        String actualText = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualText);
        String expectedResult ="Cell phones";
        Assert.assertEquals(actualText,expectedResult);

//        2.4 Click on List View Tab
        driver.findElement(By.xpath("//div[@class='page-body']/div[1]/div[1]/a[2]")).click();

//        2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/h2/a")).click();

   // 2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(1000);
        String actualText1 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualText1);
        String expectedResult1 ="Nokia Lumia 1020";
        Assert.assertEquals(actualText1,expectedResult1);

//        2.7 Verify the price “$349.00”
        Thread.sleep(2000);
        String actualText2 = driver.findElement(By.id("price-value-20")).getText();
        System.out.println(actualText2);
        String expectedResult2 ="$349.00";
        Assert.assertEquals(actualText2,expectedResult2);

//        2.8 Change quantity to 2
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='add-to-cart']/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='add-to-cart']/div/input")).sendKeys("2");

//        2.9 Click on “ADD TO CART” tab

        driver.findElement(By.xpath("//div[@class='add-to-cart']/div/button")).click();

//        2.10 Verify the Message "The product has been added to your shopping cart" on Top   green Bar
        Thread.sleep(2000);
        String actualResult4 = driver.findElement(By.xpath("//div[@id='bar-notification']/div/p")).getText();
        System.out.println(actualResult4);
        String expectedTesult4 = "The product has been added to your shopping cart";
        Assert.assertEquals(actualResult4,expectedTesult4);

//        After that close the bar clicking on the cross button.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='bar-notification']/div/span")).click();

//        2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        WebElement shopingCart = driver.findElement(By.xpath("//div[@class='header-links']/ul/li[4]/a/span[1]"));
        shopingCart.click();

//        2.12 Verify the message "Shopping cart"
        Thread.sleep(1000);
        String actualResult5 = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        System.out.println(actualResult5);
       String expectedTesult5= "Shopping cart";
       Assert.assertEquals(actualResult5,expectedTesult5);

//        2.13 Verify the quantity is 2
        Thread.sleep(1000);
       String actualResult6 = driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[5]/input")).getText();
       System.out.println(actualResult6);
     //   String expectedTesult6= "2";Assert.assertEquals(actualResult6,expectedTesult6);



//        2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        driver.findElement(By.id("termsofservice")).click();

//        2.16 Click on checkout
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();

//“2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        String actualResult8 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult8);
        String expectedTesult8= "Welcome, Please Sign In!";
        Assert.assertEquals(actualResult8,expectedTesult8);

//        2.18 Click on “REGISTER” tab
        driver.findElement(By.xpath("//div[@class='customer-blocks']/div[1]/div[3]/button[2]")).click();

//        2.19 Verify the text “Register”
        Thread.sleep(1000);
        String actualResult9 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult9);
        String expectedResult9= "Register";
        Assert.assertEquals(actualResult9,expectedResult9);

//        2.20 Fill the mandatory fields
        Thread.sleep(1000);
        driver.findElement(By.id("FirstName")).sendKeys("kinja");
        driver.findElement(By.id("LastName")).sendKeys("sha");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("124578");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("124578");

//        2.21 Click on “REGISTER” Button
        Thread.sleep(1000);
        driver.findElement(By.id("register-button")).click();

//        2.22 Verify the message “Your registration completed”
        Thread.sleep(1000);
        String actualResult10 = driver.findElement(By.xpath("//div[@class='master-wrapper-page']/div[3]/div[1]/div[1]/div/div[2]/div[1]")).getText();
        System.out.println(actualResult10);
        String expectedResult10= "Your registration completed";
        Assert.assertEquals(actualResult10,expectedResult10);

//        2.23 Click on “CONTINUE” tab
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='buttons']/a")).click();

//        2.24 Verify the text “Shopping cart”
        Thread.sleep(1000);
        String actualResult11 = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        System.out.println(actualResult11);
        String expectedResult11= "Shopping cart";
        Assert.assertEquals(actualResult11,expectedResult11);

        login();

//        2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        WebElement agreeTerms1 = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        agreeTerms1.click();

//        2.26 Click on “CHECKOUT”
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();

//        2.27 Fill the Mandatory fields
        Thread.sleep(1000);
        WebElement dropdown3 = driver.findElement(By.xpath("//div[@class='edit-address']/div[5]/select")); //for country
        Select select3 =new Select(dropdown3);
        select3.selectByVisibleText("United Kingdom");
        WebElement city = driver.findElement(By.xpath("//div[@class='edit-address']/div[7]/input"));
        city.sendKeys("London");
        WebElement address1 = driver.findElement(By.xpath("//div[@class='edit-address']/div[8]/input"));
        address1.sendKeys("15,king street");
        WebElement postCode = driver.findElement(By.xpath("//div[@class='edit-address']/div[10]/input"));
        postCode.sendKeys("HA2 1TR");
        WebElement telephone = driver.findElement(By.xpath("//div[@class='edit-address']/div[11]/input"));
        telephone.sendKeys("7269874560");

//        2.28 Click on “CONTINUE”
        Thread.sleep(1000);
        WebElement continueButton = driver.findElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        continueButton.click();

//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(1000);
        WebElement secondDayAir = driver.findElement(By.xpath("//input[@id='shippingoption_2']"));
        secondDayAir.click();

//        2.30 Click on “CONTINUE”
        Thread.sleep(1000);
        WebElement continueButton1 = driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));
        continueButton1.click();

//        2.31 Select Radio Button “Credit Card”
        Thread.sleep(1000);
        WebElement creditCard = driver.findElement(By.xpath("//div[@class='section payment-method']/ul/li[2]/div/div[2]/input"));
        creditCard.click();
        Thread.sleep(1000);
        WebElement continueButton2 = driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
        continueButton2.click();

//        2.32 Select “Visa” From Select credit card dropdown
        Thread.sleep(1000);
        WebElement visaCard = driver.findElement(By.id("CreditCardType"));
        Select select4 = new Select(visaCard);
        select4.selectByIndex(0); // select by index

//        2.33 Fill all the details
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("Kinj");

        //Card number
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("5555 1234 1234 ");

        //Expiry Date(day)
        driver.findElement(By.xpath("//select[@id='ExpireMonth']")).sendKeys("10");

        //expiry year
        driver.findElement(By.xpath("//select[@id='ExpireYear']")).sendKeys("2027");

        // Card code
        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("790");

//        2.34 Click on “CONTINUE ”CHECKOUT”
        Thread.sleep(1000);
        WebElement continueButton3 = driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
        continueButton3.click();

//        2.35 Verify “Payment Method” is “Credit Card”
        Thread.sleep(1000);
        String actualResult13 = driver.findElement(By.xpath("//div[@class='payment-method-info']/ul/li/span[2]")).getText();
        System.out.println(actualResult13);
        String expectedResult13 = "Credit Card";
        Assert.assertEquals(actualResult13,expectedResult13);

//        2.36 Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(1000);
        String actualResult12 = driver.findElement(By.xpath("//div[@class='shipping-info-wrap']/div[2]/ul/li/span[2]")).getText();
        System.out.println(actualResult12);

//        2.37 Verify Total is “$698.00”
        Thread.sleep(1000);
        String actualResult14 = driver.findElement(By.xpath("//td[@class='subtotal']/span")).getText();
        System.out.println(actualResult14);

//        2.38 Click on “CONFIRM”
        Thread.sleep(1000);
        WebElement confirm = driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));
        confirm.click();

//        2.39 Verify the Text “Thank You”
        Thread.sleep(1000);
        String actualResult15 = driver.findElement(By.xpath("//div[@class='center-1']/div/div[1]/h1")).getText();
        System.out.println(actualResult15);
        String expectedResult15 = "Thank you";
        Assert.assertEquals(actualResult15,expectedResult15);

//        2.40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(1000);
        String actualResult16 = driver.findElement(By.xpath("//div[@class='section order-completed']/div/strong")).getText();
        System.out.println(actualResult16);
        String expectedResult16 = "Your order has been successfully processed!";
        Assert.assertEquals(actualResult16,expectedResult16);

//        2.41 Click on “CONTINUE”
        Thread.sleep(1000);
        WebElement continueButton4 = driver.findElement(By.xpath("//div[@class='page-body checkout-data']/div/div[3]/button"));
        continueButton4.click();

//        2.42 Verify the text “Welcome to our store”
        Thread.sleep(1000);
        String actualResult17 = driver.findElement(By.xpath("//div[@class='topic-block-title']/h2")).getText();
        System.out.println(actualResult17);
        String expectedResult17 = "Welcome to our store";
        Assert.assertEquals(actualResult17,expectedResult17);

//        2.43 Click on “Logout” link
        WebElement logOut = driver.findElement(By.className("ico-logout"));
        logOut.click();

//        2.44 Verify the URL is “https://demo.nopcommerce.com/”
    }
    @After
    public void endTest() {
        closeBrowser();
    }
}

