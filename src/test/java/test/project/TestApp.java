package test.project;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class TestApp {

	private WebDriver cdriver =null;
	private WebDriver driver =null;
	
	//To be deleted 
	//To be deleted
	/*@Test
	public void test1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\u71712\\Downloads\\chromedriver_win32\\chromedriver.exe");
		this.cdriver=new ChromeDriver();
		this.cdriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		this.cdriver.get("https://zoom.us/wc/join/2610606471?pwd=ajIweTd2V2x2NHk3QzdSOTcwVDdIdz09");
		this.cdriver.findElement(By.id("inputname")).sendKeys("SomeName");
		this.cdriver.findElement(By.id("joinBtn")).click();
	}*/
	
	@Test
	public void test2() throws IOException, InterruptedException {
		String notepadApplicationPath = "C:\\Users\\U67122\\AppData\\Roaming\\Zoom\\bin\\Zoom.exe";
		String winiumDriverPath = "C:\\Users\\U67122\\Jenkins\\Winium.Desktop.Driver.exe";// To stop winium desktop driverbefore start another session
		Process process = Runtime.getRuntime().exec("taskkill /F /IM Winium.Desktop.Driver.exe");
		process.waitFor();
		process.destroy();
		DesktopOptions options = new DesktopOptions(); // Initiate Winium Desktop Options
		options.setApplicationPath(notepadApplicationPath); // Set notepad application path
		WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(new
		File(winiumDriverPath)).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
		service.start(); // Build and Start a Winium Driver service
		this.driver = new WiniumDriver(service, options); // Start a winium driver
		Thread.sleep(5000);
		this.driver.findElement(By.name("meeting topicDaily Team Metting; Meeting ID: 261-060-6471; ")).click();	
		this.driver.findElement(By.name("start meeting")).click();
		Thread.sleep(10000);
		this.driver.findElement(By.name("Share")).click();
		this.driver.findElement(By.name("Share Screen")).click();
		Thread.sleep(10000);
/*		Set<String> windows = this.driver.getWindowHandles();
		for(String s:windows)
			System.out.println(s.toString());
		Thread.sleep(2000);
		WebElement float_section = this.driver.findElement(By.className("ZPFloatToolbarClass"));
		Actions a = new Actions(this.driver);
		a.moveToElement(float_section).build().perform();
		Thread.sleep(5000);*/
		this.driver.findElement(By.name("Meeting Controls")).click();
		Thread.sleep(2000);
		this.driver.findElement(By.name("Remote Control")).click();
		Thread.sleep(2000);
		this.driver.findElement(By.name("Auto accept all requests")).click();
	}
	
	
	
}
