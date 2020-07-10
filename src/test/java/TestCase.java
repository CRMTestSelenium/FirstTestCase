import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;


public class TestCase extends WebDriverSettings {


    String FIRST_NAME = "Иван";
    String SECOND_NAME = "Иванов";
    String TYPE = "Новый";


    public void scroll() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)", "");
    }


    public void sleep() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    @Test
    public void enterSales() throws InterruptedException {


        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
        action.moveToElement(we).build().perform();

        driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[3]//a[1]")).click();
        sleep();

        driver.findElement(cssSelector("html.yui3-js-enabled body div#ajaxHeader div#sidebar_container.container-fluid.sidebar_container div.sidebar div#actionMenuSidebar.actionMenuSidebar ul li.actionmenulinks a div.actionmenulink")).click();
        sleep();


        //Main Information

        driver.findElement(cssSelector("#name")).sendKeys(SECOND_NAME + " " + FIRST_NAME);
        sleep();

        driver.findElement(cssSelector("#phone_office")).sendKeys("88008008080");

        driver.findElement(By.xpath("//div[@id='detailpanel_-1']//option[2]")).click();


        //Additional Information

        driver.findElement(By.xpath("//select[@id='account_type']//option[4]")).click();

        driver.findElement(By.xpath("//body//option[28]")).click();

        driver.findElement(cssSelector("#annual_revenue")).sendKeys("1000000");

        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/form[1]/div[3]/input[1]")).click();

        String strName = driver.findElement(By.xpath("//div[@id='tab-content-0']//div[2]//div[1]//div[2]")).getText();
        Assert.assertEquals(true, strName.contains(FIRST_NAME));

        String strType = driver.findElement(By.xpath("//div[@id='tab-content-0']//div[1]//div[2]//div[2]")).getText();
        Assert.assertEquals(true, strType.contains(TYPE));

        scroll();

        driver.findElement(By.xpath("//a[@id='subpanel_title_contacts']//div[@class='col-xs-10 col-sm-11 col-md-11']//div")).click();
        sleep();

        driver.findElement(By.xpath("//ul[@class='clickMenu fancymenu SugarActionMenu']")).click();
        sleep();

        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(SECOND_NAME);

        driver.findElement(By.xpath("//*[@id=\"Contacts_subpanel_save_button\"]")).click();
        sleep();

        driver.findElement(cssSelector("#pagecontent > form > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > table.list.view > tbody > tr:nth-child(1) > td > table > tbody > tr > td > input:nth-child(1)")).click();

        String sideBarSecondName = driver.findElement(By.xpath("//div[@id='recentlyViewedSidebar']")).getText();
        System.out.println(sideBarSecondName);
        Assert.assertEquals(true, sideBarSecondName.contains(SECOND_NAME + " " + FIRST_NAME));


        driver.findElement(By.xpath("//a[@id='subpanel_title_account_aos_contracts']//div[@class='col-xs-10 col-sm-11 col-md-11']//div")).click();

        scroll();
        sleep();
        driver.findElement(cssSelector(".footable-2 > thead:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > span:nth-child(3)")).click();
        driver.findElement(cssSelector("#account_aos_contracts_select_button")).click();

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();
        String parentWindow = itr.next();
        String newWindow = itr.next();

        driver.switchTo().window(newWindow);

        driver.findElement(cssSelector("body > table.list.view > tbody > tr.oddListRowS1 > td:nth-child(1) > a")).click();

        driver.switchTo().window(parentWindow);

        sleep();

        String contractCheck = driver.findElement(cssSelector("#list_subpanel_account_aos_contracts > table > tbody > tr > td:nth-child(2) > a")).getText();
        System.out.println(contractCheck);
        Assert.assertEquals(true, contractCheck.contains("test1"));

        driver.findElement(cssSelector("#AOS_Contracts_создать_button")).click();

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("test2");
        driver.findElement(By.xpath("//td[@class='buttons']//input[@id='SAVE']")).click();

        String secondContractCheck = driver.findElement(cssSelector("#list_subpanel_account_aos_contracts > table > tbody")).getText();
        System.out.println(secondContractCheck);
        Assert.assertEquals(true, secondContractCheck.contains("test2"));

        driver.findElement(cssSelector("#list_subpanel_account_aos_contracts > table > tbody > tr.oddListRowS1 > td:nth-child(2) > a")).click();

        sleep();

        driver.findElement(By.cssSelector("#tab-actions > a")).click();

        driver.findElement(cssSelector("#delete_button")).click();


        driver.switchTo().alert().accept();
        sleep();

        
        driver.findElement(By.cssSelector("#recentlyViewedSidebar > ul > div:nth-child(2) > li > a.recent-links-detail")).click();

        scroll();
    }
}
