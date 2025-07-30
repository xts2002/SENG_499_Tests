import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

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

    }

    @Test
    @DisplayName("At the Document Page, Admin can create, delete, or edit document")
    public void adminFunctionTest_2() {

    }

    @Test
    @DisplayName("At the Feedbacks page, Admin can see a variety of data associated with the feedback of a chat")
    public void adminFunctionTest_3() {

    }


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
