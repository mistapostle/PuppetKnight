import com.thoughtworks.selenium.webdriven.commands.Click;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by mistapostle on 17/4/8.
 */
public class SelBuitinCommandTest {
    private WebDriver driver;
    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mistapostle/Jam_Tools/Selenium/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://www.baidu.com/");
        Thread.sleep(10000);  // Let the user actually see something!

    }

    @Test
    public void test(){
        //Click c = new Click(new AlertOverride);
    }

}
