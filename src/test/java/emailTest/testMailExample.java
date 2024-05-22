package emailTest;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class testMailExample {

    @Test
    public void testMailExample() throws MailosaurException, IOException {
        // Available in the API tab of a server
        String apiKey = "uUps3WcZQUATtcCUijlzSkHNQinptQtl";
        String serverId = "lyoxcf21";
        String serverDomain = "lyoxcf21.mailosaur.net";

        MailosaurClient mailosaur = new MailosaurClient(apiKey);

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo("anything@" + serverDomain);

        Message message = mailosaur.messages().get(params, criteria);

        System.out.println("subject= " + message.subject());
        System.out.println("cc= " + message.cc());
        System.out.println("to= " + message.to().get(0).email());
        System.out.println("from= " + message.from().get(0).email());

        //Body
        System.out.println("====BODY EMAIL====");
        System.out.println(message.text().body());  // "Print all the body in email"

        //find 6 digit code
        System.out.println(message.text().body()); // "Your access code is 243546."

        Pattern pattern = Pattern.compile(".*([0-9]{6}).*");
        Matcher matcher = pattern.matcher(message.text().body());
        matcher.find();

        System.out.println("OTP code is = " + matcher.group(1)); // "243546"


        //Links
        // How many links?
        System.out.println("====LINKS====");

        System.out.println("Links found in email is = " + message.html().links().size()); // 2

        Link firstLink = message.html().links().get(0);
        System.out.println(firstLink.text()); // "Google Search"
        System.out.println(firstLink.href()); // "https://www.google.com/"

        //Attachment
        System.out.println("====Attachment====");

        System.out.println("Attachment found in email is = " + message.attachments().size()); // 2

        Attachment firstAttachment = message.attachments().get(0);
        System.out.println(firstAttachment.fileName()); // "contract.pdf"
        System.out.println(firstAttachment.contentType()); // "application/pdf"





        assertNotNull(message);
        assertEquals("QA - Muhammad Nurfaizi", message.subject());

    }
}
