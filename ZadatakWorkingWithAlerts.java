package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 
Zadatak (WorkingWithAlerts)
1. Otvoriti stranicu
“http://toolsqa.wpengine.com/automation-practice-switch-windows/”
2. Kliknuti na dugme Alert Box”
3. Prihvatiti Alert

 */
public class ZadatakWorkingWithAlerts {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Chromdriver\\chromedriver.exe");
		
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		driver.findElement(By.xpath("//button[@id='alert']")).click();
		
		driver.close();
	}
	public static void WorkingWithAlerts(WebDriver driver) throws InterruptedException
	{
		String urlQa="http://toolsqa.wpengine.com/automation-practice-switch-windows/";
		driver.get(urlQa);
		
		WebElement alertButton= driver.findElement(By.xpath("//button[@id='alert']"));
		alertButton.click();
		
		Thread.sleep(5000);
		String expectedAlertMessage="Knoledge increases by sharing but not by saving";
		
		String actualAlertMessage=driver.switchTo().alert().getText();
		String[] sentance=actualAlertMessage.split("\\.");// string podeljen po tacki
		String firstSentanceAlert=sentance[0];
		
		if(firstSentanceAlert.equals(expectedAlertMessage))
		{
			System.out.println("Test pass - The correct alert message is showned.");
		}
		else
		{
			System.out.println("Test failed - The incorrect alest message is showen.");
		}
		
		driver.switchTo().alert().accept();
		
		
		
		
	}

}
