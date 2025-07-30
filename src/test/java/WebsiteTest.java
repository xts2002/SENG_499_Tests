
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebsiteTest {

    private WebDriver driver;

    @BeforeAll
    void setUpAll() {
        // No external driver binary needed for SafariDriver.
        // Just ensure Develop → Allow Remote Automation is on.
    }

    @BeforeEach
    void setUp() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String username = "tim";
        String user = "qwertmkjh@gmail.com";
        String password = "Soejhsd-2933i";

        //String adminname = "tim_222";
        String admin = "qwertyhfgadmin@gmail.com";
        String admin_password = "Swjdfjks-21343";
    }

    @Test
    @DisplayName("Home page shows Log in and Register links")
    void testLoginAndRegisterLinksPresent() {
        driver.get("https://oceannetworks.nathanielroberts.ca/");

        // Locate by visible link text
        WebElement loginLink    = driver.findElement(By.linkText("Log in"));
        WebElement registerLink = driver.findElement(By.linkText("Register"));

        // Assert both are present and visible
        Assertions.assertAll("Verify both links are displayed",
                () -> Assertions.assertTrue(loginLink.isDisplayed(),    "Log in button should be visible"),
                () -> Assertions.assertTrue(registerLink.isDisplayed(), "Register button should be visible")
        );
    }

    @Test
    @DisplayName("Login Successfully with correct user credentials")
    void testLoginSuccessfully() {

        String user = "qwertmkjh@gmail.com";
        String password = "Soejhsd-2933i";
        driver.get("https://oceannetworks.nathanielroberts.ca/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in"))
        );

        driver.findElement(By.linkText("Log in")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email"))
        );

        WebElement userField = driver.findElement(By.id("email"));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("password"))
        );

        WebElement passField = driver.findElement(By.id("password"));
        userField.sendKeys(user);
        passField.sendKeys(password);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Dash"))
        );

        WebElement logoutLink = driver.findElement(By.linkText("Dash"));
        Assertions.assertTrue(logoutLink.isDisplayed(), "Dashboard should be visible after login");
    }

    @Test
    @DisplayName("Login Successfully with correct admin credentials")
    void testLoginSuccessfully_2() {

        String user = "qwertyhfgadmin@gmail.com";
        String password = "Swjdfjks-21343";
        driver.get("https://oceannetworks.nathanielroberts.ca/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in"))
        );
        driver.findElement(By.linkText("Log in")).click();


        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email"))
        );
        WebElement userField = driver.findElement(By.id("email"));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("password"))
        );
        WebElement passField = driver.findElement(By.id("password"));
        userField.sendKeys(user);
        passField.sendKeys(password);


        driver.findElement(By.cssSelector("button[type='submit']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Documents"))
        );
        WebElement logoutLink = driver.findElement(By.linkText("Documents"));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Feedbacks"))
        );
        WebElement logoutLink2 = driver.findElement(By.linkText("Feedbacks"));

        Assertions.assertTrue(logoutLink.isDisplayed(), "Documents button should be visible after admin login");
        Assertions.assertTrue(logoutLink2.isDisplayed(), "Feedbacks button should be visible after admin login");
    }


    @Test
    @DisplayName("Logged in user cannot access admin functionality")
    void testLoginFunction() {

        String user = "qwertmkjh@gmail.com";
        String password = "Soejhsd-2933i";
        driver.get("https://oceannetworks.nathanielroberts.ca/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in"))
        );

        driver.findElement(By.linkText("Log in")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email"))
        );

        WebElement userField = driver.findElement(By.id("email"));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("password"))
        );

        WebElement passField = driver.findElement(By.id("password"));
        userField.sendKeys(user);
        passField.sendKeys(password);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Dash"))
        );

        List<WebElement> logoutLink = driver.findElements(By.linkText("Documents"));
        List<WebElement> logoutLink2 = driver.findElements(By.linkText("Feedbacks"));
        Assertions.assertTrue(logoutLink.isEmpty(), "Documents button should not be visible to a user after login");
        Assertions.assertTrue(logoutLink2.isEmpty(), "Feedbacks button should not be visible to a user after login");
    }

    @Test
    @DisplayName("Login not Successful with incorrect user credentials")
    void testLoginNotSuccessful() {

        String user = "qwertmkjh@gmail.com";
        String password = "Soejhsd-2933i-------";
        driver.get("https://oceannetworks.nathanielroberts.ca/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in"))
        );

        driver.findElement(By.linkText("Log in")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email"))
        );

        WebElement userField = driver.findElement(By.id("email"));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("password"))
        );

        WebElement passField = driver.findElement(By.id("password"));
        userField.sendKeys(user);
        passField.sendKeys(password);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorItem = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//li[normalize-space() = 'These credentials do not match our records.']")
                )
        );

        String actual = errorItem.getText().trim();
        Assertions.assertEquals(
                "These credentials do not match our records.",
                actual,
                "Expected credential‐mismatch message to be shown"
        );
    }

    @Test
    @DisplayName("Remember Me check box at login page works, Log out also works")
    //Note: Remember Me CheckBox does not work currently
    void testRememberMeCheckBoxLogOut() {
        String user = "qwertmkjh@gmail.com";
        String password = "Soejhsd-2933i";
        driver.get("https://oceannetworks.nathanielroberts.ca/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in")));

        driver.findElement(By.linkText("Log in")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        WebElement userField = driver.findElement(By.id("email"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        WebElement passField = driver.findElement(By.id("password"));
        userField.sendKeys(user);
        passField.sendKeys(password);


        driver.findElement(By.cssSelector("input[type='checkbox'][name='remember']")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement userOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[normalize-space() = 'tim']")
                )
        );

        userOption.click();

        WebElement logoutLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Log Out")
                )
        );
        logoutLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in")));

        WebElement loginLink    = driver.findElement(By.linkText("Log in"));
        WebElement registerLink = driver.findElement(By.linkText("Register"));

        Assertions.assertAll("Verify both links are displayed",
                () -> Assertions.assertTrue(loginLink.isDisplayed(),    "Log in button should be visible"),
                () -> Assertions.assertTrue(registerLink.isDisplayed(), "Register button should be visible")
        );


    }







    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

