package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//div[@class = 'frameSectionBody']/ul/li[4]/a")).click();

		driver.findElement(By.xpath("//table[@class = 'twoColumnForm']/tbody/tr/td[2]/a")).click();
		Set<String> winset = driver.getWindowHandles();
		List<String> winlist = new ArrayList<String>(winset);
		driver.switchTo().window(winlist.get(1));
		driver.findElement(By.xpath("//table[@class = 'x-grid3-row-table']/tbody/tr/td[3]")).click();
		
		driver.switchTo().window(winlist.get(0));
		Thread.sleep(5);
		driver.findElement(By.xpath("(//td[@class = 'titleCell'])[2]/following-sibling::td/a")).click();
		Set<String> winset2 = driver.getWindowHandles();
		List<String> winlist2 = new ArrayList<String>(winset2);
		driver.switchTo().window(winlist2.get(1));
		driver.findElement(By.xpath("//div[@class = 'x-grid3-row    x-grid3-row-alt']/table/tbody/tr/td[3]/div/a")).click();
		driver.switchTo().window(winlist.get(0));
driver.findElement(By.xpath("//a[@class = 'buttonDangerous']")).click();
Alert alert = driver.switchTo().alert();
alert.accept();
String title = driver.getTitle();
System.out.println(title);
	}

}
