package emailTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GrowOTPTest {

    // Available in the API tab of a server
    String apiKey = "uUps3WcZQUATtcCUijlzSkHNQinptQtl";
    String serverId = "lyoxcf21";
    String serverDomain = "lyoxcf21.mailosaur.net";

    public String getRandomEmail() {
        return "user" + System.currentTimeMillis() + "@" + serverDomain;
    }

    @Test
    public void testMailExample() {
        WebDriver driver = new ChromeDriver();

    }



}
