package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

public class P2_OrangeHrmLive {

    // 1. Set up a browser.
    static String browser = "Edge";

    // 2. Open URL.
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {

        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid Browser name");
        }

        // Base Url.
        driver.get(baseUrl);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Print the title of the page.
        System.out.println("Page Title : " +driver.getTitle());

        // 4. Print the current url.
        System.out.println("Current Url : " +driver.getCurrentUrl());

        // 5. Print the page source.
        System.out.println("Page Source : \n" +driver.getPageSource());

        // 6. Click on ‘Forgot your password?’ link.
        driver.findElement(By.className("orangehrm-login-forgot-header")).click();

        // 7. Print the current url.
        System.out.println("Current Url : " + driver.getCurrentUrl());

        // 8. Navigate back to the login page.
        driver.navigate().back();

        // 9. Refresh the page.
        driver.navigate().refresh();

        // 10. Enter the email to email field.
        driver.findElement(By.name("username")).sendKeys("Admin");

        // 11. Enter the password to password field.
        driver.findElement(By.name("password")).sendKeys("admin123");

        // 12. Click on Login Button.
        WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginLink.click();

        //13. Close the browser.
        driver.quit();
    }
}
