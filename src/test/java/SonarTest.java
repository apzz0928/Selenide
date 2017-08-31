import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SonarTest {
	private static WebDriver driver;
    private static JavascriptExecutor js;
    private static String nodeURL;
    
    @BeforeClass
    public void beforeTest() throws MalformedURLException {
	       nodeURL = "http://10.10.105.228:5555/wd/hub";
	       DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeURL), cap);
	       js = (JavascriptExecutor) driver;
   }
	   
    @Test
    public void Login() throws Exception {
	       driver.get("http://www.herowarz.com");
	       Thread.sleep(2000);
	       js.executeScript("$('.uid_login_id').prop('value', 'apzz0928')");
	       js.executeScript("$('.uid_login_password').prop('value', 'qordlf12')");
	       Thread.sleep(2000);
	       js.executeScript("$('.uid_login_login').click();");
	       Thread.sleep(2000);
	   }
    
    @AfterClass
    public void afterTest() {
            driver.close();
    }       
}   
