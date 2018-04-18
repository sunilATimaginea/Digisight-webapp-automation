package practice.basics;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ClassLinkTest {
	    @Test
	    public  void main() throws InterruptedException {
	    		System.setProperty("webdriver.firefox.bin","/Applications/Firefox");
	            System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
	        WebDriver driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.get("http://www.uvdesk.com");
	        Thread.sleep(5000);
	        List<WebElement> links = driver.findElements(By.tagName("a"));    
	        System.out.println("Total links are "+links.size());    
	        for(int i=0; i<links.size(); i++) {
	            WebElement element = links.get(i);
	            String url=element.getAttribute("href");
	            System.out.print((i+1)+" - ");
//	            driver.get(url);
//	            driver.navigate().back();
	            verifyLink(url);            
	        }   
	    }
	    
	    public  void verifyLink(String urlLink) {
	        try {
	            URL link = new URL(urlLink);
	            HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
	            httpConn.setConnectTimeout(1000);
	            httpConn.connect();
//	                if(httpConn.getResponseCode()== 200)   
//	                    System.out.println(urlLink+" - "+httpConn.getResponseMessage());
//	                else if(httpConn.getResponseCode()== 404)
	                	   System.out.println(urlLink+" - "+httpConn.getResponseMessage());
	            }
	        catch (Exception e) {
	        		e.printStackTrace();
	        }
	    } 
	}

