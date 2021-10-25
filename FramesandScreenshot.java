package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesandScreenshot {

	public static void main(String[] args) throws IOException {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leafground.com/pages/frame.html");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
WebElement frame = driver.findElement(By.tagName("iframe"));
driver.switchTo().frame(frame);
WebElement button = driver.findElement(By.xpath("//button[@id = 'Click']"));
File screesnshot = button.getScreenshotAs(OutputType.FILE);
File des = new File("./snaps/pic1.png");
FileUtils.copyFile(screesnshot, des);
driver.switchTo().defaultContent();
List<WebElement> findframes = driver.findElements(By.tagName("iframe"));
System.out.println(findframes.size());
	}

}
