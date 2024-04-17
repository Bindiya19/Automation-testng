import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


    public class AutomationPractice2 {
        public static WebDriver driver;

        public static void clickOnElement(By bY)
        {
            driver .findElement(bY).click();
        }
        public static void typeText(By by,String text)
        {
            driver.findElement(by).sendKeys(text);
        }
        public static String getTextFromElement(By by)
        {
            return driver.findElement(by).getText();
        }
        public static String randomDate()
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
            Date date = new Date();
            return dateFormat.format(date);
        }

        public static void openBrowser()
        {
            //open browser Chrome
            driver = new ChromeDriver();
            //Type URL
            driver.get("https://demo.nopcommerce.com/");
        }
        public static void closeBrowser()
        {
            //close browser
            driver.close();
        }



        public static void main(String[] args) {
            //open Browser
            //driver =new ChromeDriver();
            openBrowser();
            //type the URL OR Website
            //driver.get("https://demo.nopcommerce.com/");



            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();




            //click on register button
            clickOnElement(By.className("ico-register"));
            //driver.findElement(By.className("ico-register")).click();

            //type firstname
            typeText(By.id("FirstName"),"Bindiya");
            //driver.findElement(By.id("FirstName")).sendKeys("Bindiya");

            //type lastname
            typeText(By.id("LastName"),"Patel");
            //driver.findElement(By.id("LastName")).sendKeys("Patel");

            //enter your email
            typeText(By.id("Email"),"bp"+randomDate()+"@gmail.com");
            //driver.findElement(By.id("Email")).sendKeys("bp@gmail.com");

            //enter your password
            typeText(By.id("Password"),"bpjp1914");
            //driver.findElement(By.id("Password")).sendKeys("bpjp1914");

            //enter your Conform password
            typeText(By.id("ConfirmPassword"),"bpjp1914");
            //driver.findElement(By.id("ConfirmPassword")).sendKeys("bpjp1914");

            //click on register button
            clickOnElement(By.name("register-button"));
            //driver.findElement(By.name("register-button")).click();

            //verify correct registration msg display
            getTextFromElement(By.className("result"));

            //initialization expected msg
            String expectedRegisterMsg = "Your registration completed";
            String actualMsg = driver.findElement(By.className("result")).getText();

            if (actualMsg.equals(expectedRegisterMsg)){
                System.out.println("Pass");
            } else{
                System.out.println("Fail");
            }
            //close browser
            driver.close();

        }
    }


