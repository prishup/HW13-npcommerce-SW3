package computer;

import browsefactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestSuite extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUpOpenBrowser() {  //navigating to the Homepage
        openBrowser(baseUrl);
    }
    @Test
    public void testName(){
//       1.1 Click on Computer Menu.
        driver.findElement(By.xpath("//div[@class='master-wrapper-page']/div[2]/ul[1]/li[1]/a")).click();

//      1.2 Click on Desktop
        driver.findElement(By.xpath("//div[@class='page-body']/div[1]/div/div[1]/div/div/a")).click();

//      1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByIndex(2); // select by index

//     1.4 Verify the Product will arrange in Descending order.

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
//        2.1 Click on Computer Menu.
        driver.findElement(By.xpath("//div[@class=\"master-wrapper-page\"]/div[2]/ul[1]/li[1]/a")).click();

//        2.2 Click on Desktop
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class=\"page-body\"]/div[1]/div/div[1]/div/div/a")).click();

//        2.3 Select Sort By position "Name: A to Z"
        Thread.sleep(1000);
        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByIndex(1); // select by index

//        2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();

//        2.5 Verify the Text "Build your own computer"
        Thread.sleep(1000);
        String actualResult = driver.findElement(By.xpath("//div[@class='product-essential']/div[2]/div[1]/h1")).getText();
        System.out.println(actualResult);
        String expectedTesult = "Build your own computer";
        Assert.assertEquals(actualResult, expectedTesult);

//        2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement selectprocessor = driver.findElement(By.xpath("//dd[@id='product_attribute_input_1']/select"));
        Thread.sleep(2000);
        Select selectpro = new Select(selectprocessor);
        selectpro.selectByIndex(1);

//        2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(2000);
        WebElement selectMemory = driver.findElement(By.xpath("//dd[@id='product_attribute_input_2']/select"));
        Select selectmemory1 = new Select(selectMemory);
        Thread.sleep(2000);
        selectmemory1.selectByIndex(3);

//        2.8 Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();
        Thread.sleep(2000);

//        2.9 Select OS radio "Vista Premium [+$60.00]"
        driver.findElement(By.xpath("//dd[@id='product_attribute_input_4']/ul/li[2]/input")).click();
        Thread.sleep(2000);

//        A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander  [+$5.00]"
        driver.findElement(By.xpath("//dd[@id='product_attribute_input_5']/ul/li[1]/input[1]")).isEnabled();

        driver.findElement(By.xpath("//dd[@id='product_attribute_input_5']/ul[1]/li[3]/input[1]")).click();

//        2.11 Verify the price "$1,475.00"
        Thread.sleep(1000);
        String actualResult3 = driver.findElement(By.xpath("//div[@class='prices']/div/span")).getText();
        System.out.println(actualResult3);
        Thread.sleep(1000);
        String expectedTesult3 = "$1,475.00";
        Assert.assertEquals(actualResult3, expectedTesult3);

//        2.12 Click on "ADD TO CARD" Button.
        driver.findElement(By.xpath("//div[@class='add-to-cart-panel']/button")).click();

//        2.13 Verify the Message "The product has been added to your shopping cart" on Top
//        green Bar
        Thread.sleep(1000);
        String actualResult4 = driver.findElement(By.xpath("//div[@id='bar-notification']/div/p")).getText();

        System.out.println(actualResult4);
        String expectedTesult4 = "The product has been added to your shopping cart";
        Assert.assertEquals(actualResult4, expectedTesult4);

//        After that close the bar clicking on the cross button.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='bar-notification']/div/span")).click();

//        2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        WebElement shopingCart = driver.findElement(By.xpath("//div[@class='header-links']/ul/li[4]/a/span[1]"));
        shopingCart.click();

//        2.15 Verify the message "Shopping cart"
        Thread.sleep(1000);
        String actualResult5 = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        System.out.println(actualResult5);
        String expectedTesult5 = "Shopping cart";
        Assert.assertEquals(actualResult5, expectedTesult5);

//        2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[5]/input")).clear();
        driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[5]/input")).sendKeys("2");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='common-buttons']/button[1]")).click();

////        2.17 Verify the Total"$2,950.00"
//        Thread.sleep(1000);
//        String actualResult6 = driver.findElement(By.xpath("//table[@class='cart-total']/tbody/tr[4]/td[2]/span/strong")).getText();
//        System.out.println(actualResult6);
//        String expectedTesult6= "$2,950.00";
//        Assert.assertEquals(actualResult6,expectedTesult6);


//        2.18 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        driver.findElement(By.id("termsofservice")).click();

//        2.19 Click on “CHECKOUT”
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();

//        2.20 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        String actualResult7 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult7);
        String expectedTesult7 = "Welcome, Please Sign In!";
        Assert.assertEquals(actualResult7, expectedTesult7);

//        2.21Click on “CHECKOUT AS GUEST” Tab
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='page login-page']/div[2]/div[1]/div[1]/div[3]/button[1]")).click();

//        2.22 Fill the all mandatory field
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div/div[2]/div/div/div[1]/input")).sendKeys("kinjal");
        driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div/div[2]/div/div/div[2]/input")).sendKeys("kinjal");
        driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div/div[2]/div/div/div[3]/input")).sendKeys("kinj15@yahoo.com");
        WebElement dropdown = driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div/div[2]/div/div/div[5]/select")); //for country
        Select select1 = new Select(dropdown);
        select1.selectByIndex(29);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div/div[2]/div/div/div[7]/input")).sendKeys("london");
        driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div/div[2]/div/div/div[8]/input")).sendKeys("nhtmjuymuy");
        driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div/div[2]/div/div/div[10]/input")).sendKeys("12458");
        driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div/div[2]/div/div/div[11]/input")).sendKeys("1246987453");

//        2.23 Click on “CONTINUE”
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id=\"checkout-step-billing\"]/div/button[4]")).click();

//        2.24 Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@class='method-list']/li[2]/div[1]/input")).click();

//        2.25 Click on “CONTINUE”
        Thread.sleep(1000);
        driver.findElement(By.xpath("//form[@id='co-shipping-method-form']/div[2]/button")).click();

//        2.26 Select Radio Button “Credit Card”
        Thread.sleep(2000);
        driver.findElement(By.id("paymentmethod_1")).click();

        //click on continue
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']")).click();


//        2.27 Select “Master card” From Select credit card dropdown
        Thread.sleep(1000);
        WebElement selectCard = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
        Thread.sleep(1000);
        Select selectcards = new Select(selectCard);
        selectcards.selectByIndex(1);

        // 2.28 Fill all the details
        //    cardholder name
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

        //  2.29 Click on “CONTINUE”
        driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
        Thread.sleep(1000);

        // 2.30 Verify “Payment Method” is “Credit Card”
        String actuals = driver.findElement(By.xpath("//span[contains(text(),'Credit Card')]")).getText();
        System.out.println(actuals);

        //  2.31 Select Radio Button “Credit Card”
        String expects = "Credit Card";
        Assert.assertEquals(actuals, expects);
        Thread.sleep(1000);

//        2.32 Verify “Shipping Method” is “Next Day Air”
        Thread.sleep(2000);
        String actualText8 = driver.findElement(By.xpath("//li[@class='shipping-method']")).getText();
        System.out.println(actualText8);
        String expectedText8 = "Shipping Method: Next Day Air";
        Assert.assertEquals(actualText8, expectedText8);

//        2.33 Verify Total is “$2,950.00”

        Thread.sleep(2000);
        String actualText6 = driver.findElement(By.xpath("//table[@class=\"cart-total\"]/tbody/tr[4]/td[2]/span/strong")).getText();
        System.out.println(actualText6);
        String expectedText6 = "$2,950.00";
        Assert.assertEquals(actualText6, expectedText6);

//        2.34 Click on “CONFIRM”
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']/button")).click();

//        2.35 Verify the Text “Thank You”
        Thread.sleep(2000);
        String actualText9 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualText9);
        String expectedText9 = "Thank you";
        Assert.assertEquals(actualText9, expectedText9);

//        2.36 Verify the message “Your order has been successfully processed!”
        Thread.sleep(2000);
        String actualText10 = driver.findElement(By.xpath("//div[@class='center-1']/div/div[2]/div[1]/div[1]/strong")).getText();
        System.out.println(actualText10);
        String expectedText10 = "Your order has been successfully processed!";
        Assert.assertEquals(actualText10, expectedText10);

//        2.37 Click on “CONTINUE”
        driver.findElement(By.xpath("//div[@class='center-1']/div/div[2]/div[1]/div[3]/button")).click();

////        2.37 Verify the text “Welcome to our store”
//        Thread.sleep(2000);
//        String actualText11 = driver.findElement(By.xpath("//div[@class='page-body']/div[2]/div[1]/h2")).getText();
//        System.out.println(actualText11);
//        String expectedText11 = "Welcome to our store";
//        Assert.assertEquals(actualText11, expectedText11);
//    }
    }}





