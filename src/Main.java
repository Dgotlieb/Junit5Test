import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


/*
* junit 5 does not have the fixmethodorder annotation
* therfore - tests will be excuted in the order they written in code
*/

public class Main {
    private static WebDriver driver;

    @BeforeAll //like @BeforeClass
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\daniel.gotlieb\\Desktop\\Automation\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        //driver.get("https://translate.google.com/");
        //vsdafh.v
        //hgsf
    }

    @BeforeEach // like @Before
    public void before(){
        System.out.println("before");
    }

    @Test
    public void test01_run() throws InterruptedException {
        driver.get("https://translate.google.com/");

        driver.findElement(By.xpath("//div[@role='button' and @tabindex='0']")).click(); //button hikanes
        Thread.sleep(3000);
    }

    @Test
    public void test02_run() throws InterruptedException {
        driver.navigate().to("https://www.diawi.com/");

        driver.findElement(By.xpath("//input[@type='submit']")).click(); //button submit

        //driver.findElement(By.xpath("//a[@href='https://blog.diawi.com']")).click(); // blog read more
        Thread.sleep(3000);

    }


    @AfterEach// like @After
    public void after(){
        System.out.println("after");
    }

    @AfterAll// like @AfterClass
    public static void tearDown(){
        driver.quit();

    }

}
