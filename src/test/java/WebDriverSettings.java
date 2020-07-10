import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;


public class WebDriverSettings {

    public WebDriver driver;

    public static void main(String[] args) {

    }
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Start Test!");
        driver.get("https://demo.crm.studio");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void checklodin(){
        driver.findElement(By.id("user_name")).clear();
        driver.findElement(By.id("user_name")).sendKeys("demo");

        driver.findElement(By.id("username_password")).clear();
        driver.findElement(By.id("username_password")).sendKeys("demo");

        driver.findElement(By.id("bigbutton")).click();
    }

//    @AfterMethod
//    public void screenShot() throws IOException {
//        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
//        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
//
//        FileUtils.copyFile(file, new File("C:\\IDEA_Projects\\Screenshots\\.PNG"));
//    }x

    @AfterClass
    public void closeUp() throws InterruptedException {
        Thread.sleep(3000L);
        //driver.quit();
        System.out.println("Test close!");
    }
}
