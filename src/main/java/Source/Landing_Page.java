package Source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Landing_Page {
    private WebDriver Driver;
    private  By PressonCreatLink= By.id("w-node-_8ccf6ac0-d548-0687-f699-ff4ec59a73dc-9e916913");

   public Landing_Page(WebDriver driver)
    {
         this.Driver= driver;
    }


    public SignUP_Page GetSignPage()
    {
          Driver.findElement(PressonCreatLink).click();
          return new SignUP_Page(Driver);
    }
}
