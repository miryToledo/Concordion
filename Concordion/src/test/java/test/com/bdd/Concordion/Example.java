package test.com.bdd.Concordion;

import org.concordion.api.extension.Extensions;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.ScreenshotException;

@RunWith(ConcordionRunner.class)
@Extensions(ScreenshotException.class)
public class Example {
	
	private WebDriver driver;
    private LoginPage loginPage;
    
    @Before
    public void setUp() throws InterruptedException {
    	driver = new ChromeDriver();
    	loginPage = new LoginPage(driver);
    }
    
    public boolean sendUser(final String user){
    	loginPage.fillUserInput(user);
    	return true;
    }
    
    public boolean sendPass(final String pass){
    	loginPage.fillPassInputAndSend(pass);
    	return true;
    }
    
    public boolean seeMainView() throws InterruptedException{
    	loginPage.sendFormAndViewMainPage();
    	return true;
    }
    
    
    @After
    public void tearDown(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
