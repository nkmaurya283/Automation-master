package pages;

import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Home {
    WebDriver driver;
    Actions act;


    private String partialXpathpart1="//span[@class='button-label icon-right'][contains(text(),'";
    private String partialXpathpart2="')]";
    private String partialCssFlightTypesPart1="[aria-label='";
    private String partialCssFlightTypesPart2="']";
    @FindBy( css = "[title='Date Picker']" )
    private WebElement xpathCalender;
    @FindBy( xpath = "//span[contains(text(),'Accept and Continue')]" )
    private WebElement cookieXpath;
    private String partialCssTerminalPart1="[aria-label='";
    private String partialCssTerminalPart2="']";
    private String partialCssDatePickerPart1="[aria-label='";
    private String partialCssDatePickerPart2="']";
    private String XpathFlightNamePart1="//div[@class='col-terminal']//p";
    @FindBy( css = "[class='icon  search']" )
    private WebElement searchField;
    @FindBy( css = "#header-search-input" )
    private WebElement searchTextField;
    @FindBy( xpath = "//a[contains(text(),'Heathrow parking')]" )
    private WebElement heathrowParking;






    public Home(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void moveToElement(String linkItemsInHeader) throws Exception{
        act=new Actions(driver);
        WebElement ele= driver.findElement(By.xpath(partialXpathpart1+linkItemsInHeader+partialXpathpart2));
        act.moveToElement(ele).perform();
        Thread.sleep(2000);
      return ;
    }
    public void clickOnTypeOfFlights(String flightType) throws Exception{
        WebElement ele= driver.findElement(By.cssSelector(partialCssFlightTypesPart1+flightType+partialCssFlightTypesPart2));
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();
        return ;
    }
    public void selectDate(String date) throws Exception{
        Thread.sleep(2000);
        xpathCalender.click();
        WebElement ele= driver.findElement(By.cssSelector(partialCssDatePickerPart1+date+partialCssDatePickerPart2));
        Thread.sleep(2000);
        ele.click();
        return ;
    }
    public void selectTerminal(String terminal) throws Exception{
        WebElement ele= driver.findElement(By.cssSelector(partialCssTerminalPart1+terminal+partialCssTerminalPart2));
        ele.click();
        Thread.sleep(1000);
        return ;
    }
    public void verifyTheTerminal(String terminal) throws Exception{
        Thread.sleep(3000);
        List<WebElement> ele= driver.findElements(By.xpath(XpathFlightNamePart1));
        int count=0;
        for(int i=0;i<ele.size();i++){
            //ele.remove(0);
           String element= ele.get(i).getText();
           if(element.equalsIgnoreCase(terminal)){
               System.out.println("Terminal visible is :"+element);
               count++;
           }else {
               Assert.fail("Terminal is not visible");
           }


        }
        System.out.println("Total number is: "+count);
        return ;
    }
    public void acceptCookie() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(cookieXpath));
        cookieXpath.click();
    }
    public void clickOnSearchField() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.click();
    }
    public void searchAndVerify(String keyword) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(searchTextField));
        searchTextField.sendKeys(keyword);
        wait.until(ExpectedConditions.visibilityOf(heathrowParking));
        if(heathrowParking.isDisplayed()){
            System.out.println("Element displayed");
        }else {
            Assert.fail("Element not found");
        }
    }
}
