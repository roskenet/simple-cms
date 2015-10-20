package de.roskenet.simplecms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SimpleCmsApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class RootTest {
    @Value("${local.server.port}")
    private int serverPort;
    
    /**
     * Checks for redirection to the landing page.
     */
    @Test
	public void testLandingPage() throws Exception {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:" + serverPort);
        
        assertEquals("TestPage", driver.getTitle());
        
	}
}
