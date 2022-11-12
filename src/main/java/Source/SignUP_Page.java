package Source;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUP_Page {
// Properites of Sign UP Page
    private By E_Full_Name_TXT = By.xpath("//*[@id=\"signup-form\"]/div[1]/div/input");
    private By E_Store_Name_TXT = By.xpath("//*[@id=\"signup-form\"]/div[2]/div/input");
    private By E_Register_Business_ChechBox = By.xpath("//*[@id=\"signup-form\"]/div[3]/label");
    private By E_Phone_num_TXT = By.xpath("//*[@id=\"signup-form\"]/div[4]/div/input");
    private By E_Email_Address_TXT = By.xpath("//*[@id=\"signup-form\"]/div[5]/div/input");
    private By E_Pass_TXT = By.xpath("//*[@id=\"register-password\"]");
    private By E_Confirm_Pass_TXT = By.xpath("//*[@id=\"r-register-password\"]");
    private By Sign_UP_BTN = By.id("signup-span");

    WebDriver Driver;

    public SignUP_Page(WebDriver driver) {
        this.Driver = driver;
    }

    public void Fullname(String FullName) {
        Driver.findElement(E_Full_Name_TXT).sendKeys(FullName);
    }
    public void StoreName(String Storename) {
        Driver.findElement(E_Store_Name_TXT).sendKeys(Storename);
    }
    public void RegisterBuisness() {
        Driver.findElement(E_Register_Business_ChechBox).click();

    }
    public void EmailAddress(String Emailaddress) {
        Driver.findElement(E_Email_Address_TXT).sendKeys(Emailaddress);
    }
    public void PhoneNum(String Phonenum) {
        Driver.findElement(E_Phone_num_TXT).sendKeys(Phonenum);
    }
    public void SetPassAndConfirm(String Pass , String Confirmpass) {
        Driver.findElement(E_Pass_TXT).sendKeys(Pass);
        Driver.findElement(E_Confirm_Pass_TXT).sendKeys(Confirmpass);

    }
    public void Signup() {
        Driver.findElement(Sign_UP_BTN).click();

    }



}
