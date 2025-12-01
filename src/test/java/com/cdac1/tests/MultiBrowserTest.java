package com.cdac1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiBrowserTest {

    WebDriver driver;

    public void runTest(String browser) {
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    // Provide path to your Firefox installation
                    options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                    driver = new FirefoxDriver(options);
                    break;

                case "edge":
                    // If WebDriverManager fails to download, set EdgeDriver path manually
                    System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;

                default:
                    System.out.println("Unknown browser: " + browser + ", defaulting to Chrome");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
//            driver.get("https://www.amazon.in");
            driver.get("https://facebook.com/");
//            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("cup");
            driver.findElement(By.id("email")).sendKeys("usama.tariq131@gmail.com");
            driver.findElement(By.id("pass")).sendKeys("12345678");
            driver.findElement(By.name("login")).click();
            System.out.println(driver.getTitle());
//            driver.findElement(By.xpath("//button[@name=login")).click();


        } catch (Exception e) {
            System.out.println("Error with browser " + browser + ": " + e.getMessage());
        } finally {
            if (driver != null) {
//                driver.quit();
            }
        }
    }

    @Test
    public void testChrome() {
        runTest("chrome");
    }

    @Test
    public void testFirefox() {
        runTest("firefox");
    }

    @Test
    public void testEdge() {
        runTest("edge");
    }
}
