import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)


public class AdminFunctionTest {
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
    @DisplayName("After Admin Logs in, page displays all admin functionalities and is clickable, leads to correct destination")
    public void adminFunctionTest() {

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

        WebElement documentsLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Documents']")
                )
        );
        Assertions.assertTrue(documentsLink.isDisplayed(), "Documents link should be visible");

        //Go to document page
        documentsLink.click();
        WebElement header = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("h3.fi-ta-header-heading")
                )
        );
        Assertions.assertAll("Documents header checks",
                () -> Assertions.assertTrue(header.isDisplayed(), "Header should be visible"),
                () -> Assertions.assertEquals(
                        "Documents",
                        header.getText().trim(),
                        "Header text should read 'Documents'"
                )
        );

        WebElement newDocLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='fi-btn-label' and normalize-space()='New document']")
                )
        );
        Assertions.assertTrue(newDocLabel.isDisplayed(), "New document button should be visible");

        WebElement deleteSpan = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[normalize-space()='Delete']")
                )
        );
        Assertions.assertTrue(deleteSpan.isDisplayed(), "Delete button should be visible");

        WebElement editSpan = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[normalize-space()='Edit']")
                )
        );
        Assertions.assertTrue(editSpan.isDisplayed(), "Edit button should be visible");

        //Now enter Feedbacks Page
        WebElement feedbacksLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Feedbacks']")
                )
        );
        Assertions.assertTrue(feedbacksLink.isDisplayed(), "Feedbacks link should be visible");

        feedbacksLink.click();
        WebElement feedbacksHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[normalize-space() = 'Feedbacks']")
                )
        );
        Assertions.assertAll("Feedbacks header checks",
                () -> Assertions.assertTrue(feedbacksHeader.isDisplayed(), "Header should be visible"),
                () -> Assertions.assertEquals(
                        "Feedbacks",
                        feedbacksHeader.getText().trim(),
                        "Header text should read 'Feedbacks'"
                )
        );

        WebElement questionLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[normalize-space() = 'Question']")
                )
        );
        Assertions.assertTrue(questionLabel.isDisplayed(), "Question label should be visible");

        WebElement feedbackLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[normalize-space() = 'Feedback']")
                )
        );
        Assertions.assertTrue(feedbackLabel.isDisplayed(), "Feedback label should be visible");


    }

    /*@Test
    @DisplayName("At the Document Page, Admin can create, delete, or edit document")
    public void adminFunctionTest_2() {

    }*/

    /*@Test
    @DisplayName("At the Feedbacks page, Admin can see a variety of data associated with the feedback of a chat")
    public void adminFunctionTest_3() {

    }*/


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
