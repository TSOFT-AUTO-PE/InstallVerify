package OnlineStore;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterOnline {

    private WebDriver driver;

    By SingInLocator = By.linkText("Sign in");
    By authenticationLocator = By.className("page-heading");
    By emailLocator = By.id("email_create");
    By btnCreateAccountLocator = By.id("SubmitCreate");
    By createAccountLocator = By.className("page-heading");

    By selectTituloLocator = By.id("id_gender2");
    By firstNameLocator = By.id("customer_firstname");
    By lastNameLocator = By.id("customer_lastname");
    By passwdLocator = By.id("passwd");
    By diaNacLocator = By.id("days");
    By mesNacLocator = By.id("months");
    By anioNacLocator = By.id("years");
    By adressLocator = By.id("address1");
    By cityLocator = By.id("city");
    By stateLocator = By.id("id_state");
    By zipCodeLocator = By.id("postcode");
    By countryLocator = By.id("id_country");
    By mobileLocator = By.id("phone_mobile");
    By aliasAdressLocator = By.id("alias");
    By btnRegisterLocator = By.id("submitAccount");
    By myAccountLocator = By.className("page-heading");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

    }

    @Test
    public void flow() throws InterruptedException {
        validarEmail();
        crearCuenta();
    }

    public void validarEmail() throws InterruptedException {
        driver.findElement(SingInLocator).click();
        Thread.sleep(2000);
        if (driver.findElement(authenticationLocator).isDisplayed()) {
            driver.findElement(emailLocator).sendKeys("tsoftprueba1@tsoftlatam.com");
            driver.findElement(btnCreateAccountLocator).click();
            Thread.sleep(2000);
            assertTrue(driver.findElement(createAccountLocator).isDisplayed());
        }
        else {
            System.out.println("Registro no encontrado");
        }
    }

    public void crearCuenta() {
        if (driver.findElement(createAccountLocator).isDisplayed()) {
            driver.findElement(selectTituloLocator).click();
            driver.findElement(firstNameLocator).sendKeys("Rosita");
            driver.findElement(lastNameLocator).sendKeys("Peralta Vasquez");
            driver.findElement(passwdLocator).sendKeys("123456");
            Select day = new Select(driver.findElement(diaNacLocator));
            day.selectByValue("20");
            Select mes = new Select(driver.findElement(mesNacLocator));
            mes.selectByValue("5");
            Select anio = new Select(driver.findElement(anioNacLocator));
            anio.selectByValue("1994");
            driver.findElement(adressLocator).sendKeys("Jr. MonteCarlo 2342");
            driver.findElement(cityLocator).sendKeys("Lima");
            Select state = new Select(driver.findElement(stateLocator));
            state.selectByVisibleText("Alaska");
            driver.findElement(zipCodeLocator).sendKeys("12001");
            Select country = new Select(driver.findElement(countryLocator));
            country.selectByVisibleText("United States");
            driver.findElement(mobileLocator).sendKeys("960775433");
            driver.findElement(aliasAdressLocator).sendKeys("Lima");
            driver.findElement(btnRegisterLocator).click();
            assertTrue(driver.findElement(myAccountLocator).isDisplayed());
        } else {
            System.out.println("Registro no encontrado");
        }
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
