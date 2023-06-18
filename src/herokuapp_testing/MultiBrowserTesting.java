package herokuapp_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;


public class MultiBrowserTesting {

    static Scanner sc = new Scanner(System.in);

    static String baseUrl = "http://the-internet.herokuapp.com/login";

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Enter Browser Name: " );
        String browser = sc.nextLine();

        //1. Browser setup
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("EDGE")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //2. Open Url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3.Print the title of the page
        String title = driver.getTitle();
        System.out.println("Page Title is : " +title);

        //4.Print the current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url is: " +currentUrl);

        //5.Print the page source
        String pageSource = driver.getPageSource();
        System.out.println("Page source is: " +pageSource);

        //6.Enter the username to username field
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("Poonam");

        //7.Enter the password to password field
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Poonam");

        Thread.sleep(2000);
        //8.Close the browser
        driver.close();

    }
}
