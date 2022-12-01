package Docker.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

public class Dockertest {


    @Test
    public void dockTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName(BrowserType.CHROME);
        dc.setCapability("enableVNC",true);
        dc.setCapability("enableVideo",true);
        dc.setCapability("videoName","test1_video.mp4");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
        driver.get("https://www.google.com/");
        //driver.wait(5000);
        System.out.println("Title is : "+driver.getTitle());
        driver.quit();
    }

    @Test
    public void dockTestFirefox() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName(BrowserType.FIREFOX);
        dc.setCapability("enableVNC",true);
        dc.setCapability("enableVideo",true);
        dc.setCapability("videoName","test2_video.mp4");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"),dc);
        driver.get("https://www.google.com/");
        //driver.wait(5000);
        System.out.println("Title is : "+driver.getTitle());
        driver.quit();
    }

//    @DataProvider(parallel = true)
//    public Object[][] getdata(){
//        return new Object[][]
//                {{"chrome"},{"chrome"},{"firefox"},{"firefox"}};
//    }
}
