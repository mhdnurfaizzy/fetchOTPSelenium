package emailTest;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReziOTPTest {

    // Available in the API tab of a server
    String apiKey = "Your-Api";
    String serverId = "SERVERID";
    String serverDomain = "SERVERDOMAIN";
    String from = "support@rezi.io";

    public String getRandomEmail() {
        return "user" + System.currentTimeMillis() + "@" + serverDomain;
    }

    public String getRandomPassword() {
        return "user" + System.currentTimeMillis();
    }

    @Test
    public void testMailExample() throws MailosaurException, IOException, InterruptedException {
        String emailID = getRandomEmail();
        String password = getRandomPassword();

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.rezi.ai/signup");

        driver.findElement(By.cssSelector("#sign-up-email > div > div:nth-child(1) > input")).sendKeys(emailID);
        driver.findElement(By.cssSelector("#sign-up-email > div > div:nth-child(2) > input")).sendKeys(password);
        driver.findElement(By.cssSelector("#sign-up-email > button")).click();


        MailosaurClient mailosaur = new MailosaurClient(apiKey);

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo(emailID);
        criteria.withSentFrom(from);


        Message message = mailosaur.messages().get(params, criteria);

        System.out.println(message.text().body()); // "Your access code is 243546."

        Pattern pattern = Pattern.compile(".*([0-9]{6}).*");
        Matcher matcher = pattern.matcher(message.text().body());
        matcher.find();

        String otp = matcher.group(1); // "243546"
        System.out.println(otp);

//        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#layout_full_screen > div:nth-child(1) > div > div > div > div > div.grid.grid-flow-col.gap-2.visible > input:nth-child(1)")).sendKeys(otp);



    }



}
