
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)


public class UserFunctionTest {
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
    @DisplayName("After User Logs in, page displays all user functionalities and is clickable, leads to correct destination")
    public void userFunctionTest() {
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

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement welcomeDiv = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(normalize-space(.), \"Welcome to ONC's new Data Portal\")]")
                )
        );
        Assertions.assertTrue(welcomeDiv.isDisplayed(), "Welcome banner should be visible");

        WebElement chatbotButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Go to Chatbot']")
                )
        );
        Assertions.assertTrue(chatbotButton.isDisplayed(), "Chatbot button should be visible");

        WebElement chatsLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Chats']")
                )
        );
        Assertions.assertTrue(chatsLink.isDisplayed(), "Chats link should be visible");

        //Going into chat
        chatsLink.click();


        //Make sure the 'New Chat' Button is shown
        WebElement newChatLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("span.fi-btn-label")
                )
        );

        Assertions.assertAll("New Chat label checks",
                () -> Assertions.assertTrue(
                        newChatLabel.isDisplayed(),
                        "Label should be visible"
                ),
                () -> Assertions.assertEquals(
                        "New Chat",
                        newChatLabel.getText().trim(),
                        "Label text should read 'New Chat'"
                )
        );

        //Go into New Chat
        newChatLabel.click();

        WebElement header = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[normalize-space()='Helpful Filters']")
                )
        );
        Assertions.assertTrue(header.isDisplayed(), "Header should be visible");

        //Make sure interactive map is present
        WebElement marker = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("img.leaflet-marker-icon.leaflet-zoom-animated.leaflet-interactive")
                )
        );
        Assertions.assertAll("Leaflet marker icon checks",
                () -> Assertions.assertTrue(marker.isDisplayed(),   "Marker visible on map"),
                () -> Assertions.assertEquals("Marker",
                        marker.getAttribute("alt"),
                        "Alt text should be 'Marker'"),
                () -> Assertions.assertTrue(marker.getAttribute("src")
                                .endsWith("marker-icon-2x.png"),
                        "Src should end with 'marker-icon-2x.png'")
        );

        //Ensure dates are present
        WebElement fromDate = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("fromDate")
                )
        );
        Assertions.assertTrue(fromDate.isDisplayed(), "FromDate should be visible");

        WebElement toDate = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("toDate")
                )
        );
        Assertions.assertTrue(toDate.isDisplayed(), "ToDate should be visible");

        //Ensure Filter Options are present
        WebElement depthButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Depth']")));
        Assertions.assertTrue(depthButton.isDisplayed(), "Depth button should be visible");

        WebElement temperatureButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Temperature']")));
        Assertions.assertTrue(temperatureButton.isDisplayed(), "Temperature button should be visible");

        WebElement salinityButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Salinity']")));
        Assertions.assertTrue(salinityButton.isDisplayed(), "Salinity button should be visible");

        WebElement pressureButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Pressure']")));
        Assertions.assertTrue(pressureButton.isDisplayed(), "Pressure button should be visible");

        WebElement pHButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='pH']")));
        Assertions.assertTrue(pHButton.isDisplayed(), "pH button should be visible");

        WebElement oxygenButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Oxygen']")));
        Assertions.assertTrue(oxygenButton.isDisplayed(), "Oxygen button should be visible");

        WebElement densityButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Density']")));
        Assertions.assertTrue(densityButton.isDisplayed(), "Density button should be visible");

        WebElement nitrateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Nitrate']")));
        Assertions.assertTrue(nitrateButton.isDisplayed(), "Nitrate button should be visible");

        WebElement co2Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='CO2']")));
        Assertions.assertTrue(co2Button.isDisplayed(), "CO2 button should be visible");

        WebElement alkalinityButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Alkalinity']")));
        Assertions.assertTrue(alkalinityButton.isDisplayed(), "Alkalinity button should be visible");
    }

    @Test
    @DisplayName("After Opening the Profile Menu, User can enter ONC API, view personal info")
    public void userFunctionTest2() {
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

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //Go into Profile Menu
        WebElement userOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[normalize-space() = 'tim']")
                )
        );
        userOption.click();

        WebElement profileLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Profile")
                )
        );
        profileLink.click();

        WebElement profileHeaderByText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[normalize-space()='Profile Information']")
                )
        );
        Assertions.assertTrue(profileHeaderByText.isDisplayed(), "Profile header should be visible");

    }

    /*@Test
    @DisplayName("After Opening the Profile Menu, User can change password using the menu given there")
    public void userFunctionTest3() {

    }*/


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
