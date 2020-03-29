package stepdefinition;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.Home;


public class HeathrowGluecode {
    public HeathrowGluecode(){
    }
     WebDriver driver;
     Home page;


    @Before
    public void setUp() throws Exception
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.heathrow.com/#/");

    }
    @Given("^I open the Browser$")
    public void iOpenTheBrowser() throws Throwable {


    }
    @When("^I mouse Hover on \"([^\"]*)\"$")
    public void i_mouse_Hover_on(String link) throws Throwable {
        page=new Home(driver);
        page.moveToElement(link);
    }
    @Given("^I clicked on \"([^\"]*)\" flights$")
    public void i_clicked_on_flights(String flightType) throws Throwable {
       page=new Home(driver);
       page.clickOnTypeOfFlights(flightType);
    }
    @Given("^I filter with \"([^\"]*)\"$")
    public void i_filter_with(String terminal) throws Throwable {
        page=new Home(driver);
        page.selectTerminal(terminal);
    }
    @Given("^I select the date \"([^\"]*)\"$")
    public void i_select_the_date(String date) throws Throwable {
        page=new Home(driver);
        page.selectDate(date);
    }

    @Given("^I accept cookie$")
    public void i_accept_cookie() throws Throwable {
        page=new Home(driver);
        page.acceptCookie();
    }
    @Then("^I verify the \"([^\"]*)\" terminal only displayed on the page$")
    public void i_verify_the_terminal_only_displayed_on_the_page(String terminal) throws Throwable {
        page=new Home(driver);
        page.verifyTheTerminal(terminal);
    }

    @Given("^I click on Search field$")
    public void i_click_on_Search_field() throws Throwable {
        page=new Home(driver);
        page.clickOnSearchField();
    }

    @When("^I search the value in ([^\"]*)$")
    public void iSearchTheValueInSearchField(String searchField) throws Exception{
        page=new Home(driver);
        page.searchAndVerify(searchField);
    }
    @After
    public void tearDown(Scenario scenario){
        /*if(scenario.isFailed() ){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }*/
        driver.quit();
    }

}
