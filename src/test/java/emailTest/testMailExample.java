package emailTest;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.testng.annotations.Test;

import java.io.IOException;

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

        assertNotNull(message);
        assertEquals("QA - Muhammad Nurfaizi", message.subject());

    }
}
