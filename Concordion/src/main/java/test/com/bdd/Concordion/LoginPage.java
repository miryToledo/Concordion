package test.com.bdd.Concordion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private final WebDriver webDriver;
	private static final String URL = "https://accounts.google.com/";
	
	private static final By USER = By.id("identifierId");
	private static final By PASS = By.name("password");
	private static final By NEXT_BUTTON = By.id("identifierNext");
	private static final By ACCEPT_BUTTON = By.id("passwordNext");
	private static final By MAIN_VIEW = By.id("gbwa");
	
	
	public LoginPage(WebDriver driver) {
        this.webDriver = driver;
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.webDriver.get(URL);
    }
	
	public void fillUserInput(String user){
		this.webDriver.findElement(USER).sendKeys(user);
	}
	
	public void fillPassInputAndSend(String pass){
		this.webDriver.findElement(NEXT_BUTTON).click();
		this.webDriver.findElement(PASS).sendKeys(pass);;
	}
	
	
	public void sendFormAndViewMainPage() throws InterruptedException{
		this.webDriver.findElement(ACCEPT_BUTTON).click();
		this.webDriver.findElement(MAIN_VIEW);
		Thread.sleep(5000);
	}
	
	
}
