package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://dev108900.service-now.com/login.do?user_name=admin&sys_action=sysverb_login&user_password=b2pqp6NVTKgY");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.findElement(By.id("user_name")).sendKeys("admin");
driver.findElement(By.id("user_password")).sendKeys("Manisel@91");
driver.findElement(By.id("sysverb_login")).click();
driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
driver.findElement(By.xpath("(//div[text() = 'All'])[2]")).click();
WebElement frame = driver.findElement(By.xpath("//iframe[@id = 'gsft_main']"));
driver.switchTo().frame(frame);
driver.findElement(By.xpath("//button[@type = 'submit']")).click();
driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("Mani Sekar");
driver.findElement(By.id("incident.short_description")).sendKeys("Mani is learning Selenium");

String num = driver.findElement(By.id("incident.number")).getAttribute("value");
System.out.println(num);
driver.findElement(By.xpath("//button[@id = 'sysverb_insert_bottom']")).click();
driver.findElement(By.xpath("//input[@name = 'cxs_related_search']")).sendKeys(num);

	}

}
