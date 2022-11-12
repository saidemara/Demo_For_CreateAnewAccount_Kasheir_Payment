package Tests.Source.Test_Base;

import Source.Landing_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Test_Base {
    protected Landing_Page homePage;
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver","ReSources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kashier.io");
        homePage = new Landing_Page(driver);
    }

    @AfterTest
    void teardown() {
        driver.close();
    }




}
