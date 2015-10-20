package de.roskenet.simplecms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    
    @Test
	public void testRootPage() throws Exception {
        WebDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get("http://localhost:" + serverPort);
//        Assert.assertEquals("TestPage", driver.getTitle());
String currentUrl = driver.getCurrentUrl();
System.out.println(currentUrl);
WebElement resultsDiv = driver.findElement(By.className("test"));

	String text = resultsDiv.getText();
	System.out.println(text);
	}
}
