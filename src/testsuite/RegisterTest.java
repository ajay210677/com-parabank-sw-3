package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.sql.Driver;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser (baseUrl);
    }
@Test
    public void verifyTatSigningUpPageDisplay(){
        //click on the register link
    driver.findElement(By.xpath("//a[contains(text(),'Register')]"));

    //Verify the text "Signing up is easy"
    String expectedMessage = "Singing up is easy!";
    WebElement actualTextMessageElement= driver.findElement (By.xpath("//h1[contains(text(),'Signing up is easy!')]"));

    String actualMessage = actualTextMessageElement.getText();

    //Varify actual and expexted
    Assert.assertEquals(expectedMessage,actualMessage);
}
@Test
    public void userShouldRegisterAccountSuccessfully(){
        //click on the 'Register Link'
    driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
    //Enter first name
    sendTextToElement(By.id("customer.firstName"),"Hello");
    //Enter Last Name
    sendTextToElement(By.id("customer.lastName"),"World");
//Enter Address
    sendTextToElement(By.id("customer.address.street"),"10,Downing Street");
    //Enter city
    sendTextToElement(By.id("customer.address.city"),"City of Westminster");
    //Enter State
    sendTextToElement(By.id("customer.address.state"),"Colloquially");
    //Enter zip Code
    sendTextToElement(By.id("customer.address.zipCode"),"SW1A 2AA");
    //Enter phone
    sendTextToElement(By.id("customer.phonenumber"),"01923123456");
    //Enter Ssn
    sendTextToElement(By.id("customer.ssn"),"456789");
    //Enter Username
    sendTextToElement(By.id("customer.username"),"Hello");
    //enter Password
    sendTextToElement(By.id("customer.password"),"abc12345");
    //Enter Confirm
    sendTextToElement(By.id("repeatedPassword"),"abc12345");
    //Click on Register button
    clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
    String expectedMessage="Your account was created successfully .You are now logged in";
    WebElement actualTextMessageElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]"));
String actualMessage = actualTextMessageElement.getText();
//Varify actual nd expected
    Assert.assertEquals(expectedMessage,actualMessage);

}
@After
    public void tearDown(){
        closeBrowser();
}

}
