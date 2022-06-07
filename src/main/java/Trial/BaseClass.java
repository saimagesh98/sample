package Trial;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
  //	1.BrowserLaunch
	public static WebDriver driver;
	public static WebDriver browserLaunch(String browserName) {
		switch (browserName) {
		
		case"chrome":
		    WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
            break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case"opera"	:
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
            break;
          default:
        	  System.err.println("invalid browser");
	}
		
  		return driver;
}
	
//	2.URl Launch
	 
	public  static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
//3.wait
    public static void implicityWait(long time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);

	}
//    4.getCurrent URl
	
	public static String getCurrentUrl() {
		String currentUrl= driver.getCurrentUrl();
		return currentUrl;

	}
//	5.getTitle
	
	public static String getTitle() {
	String title=driver.getTitle();
	return title;

	}
//	6.SendKeys
	public static void sendkeys(WebElement e,String user) {
	
	e.sendKeys(user);
	}
//7.Click
	public static void buttonClick(WebElement e) {
		e.click();
	}
//8.Actions
//moveToElement
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	}
//	9.getAttribute
	public static String getAttribute(WebElement e) {
		String attribute=e.getAttribute("value");
		return attribute;
	}
		
//10.getText	
	public static String getText(WebElement e) {
		String text=e.getText();
		return text;
	}
	
//11.Navigate Back	
	
	public static void navigateBack() {
		driver.navigate().back();
	}
	
	
//12.Navigate forward	
	
		public static void navigateforword() {
			driver.navigate().forward();
		}	
	
	
//13.Navigate Refresh	
		
		public static void navigaterefresh() {
			driver.navigate().refresh();
		}
	
	
//14.Alert
		
		public static Alert alert() {
			Alert alert=driver.switchTo().alert();
			return alert;
		}
	
//15.Alert Accept
		
				public static Alert alertAccept() {
					Alert alert=driver.switchTo().alert();
					alert.accept();
					return alert;
				}
				
//16.Alert Reject
				
				public static Alert alertReject() {
					Alert alert=driver.switchTo().alert();
					alert.dismiss();
					return alert;
				}
	
	
//17.Windows Handle
				
				public static String parentId() {
					String LocatorName=driver.getWindowHandle();
					return LocatorName;
				}

	
	
//18.Drag & Drop
	public static void dragAndDrop(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}
// 19.Select
//	Select By index
	
	public static void SelectByIndex(WebElement e,int index)
	{
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	
//20.deSelect By index
	
	public static void deSelectByIndex(WebElement e,int index)
	{
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
			
	
// 21. deSelect by value	
	
	public static void deselectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByValue(value);
	
	}
//22.findElement
	
	public static WebElement findElement(String locatorName,String Locatorvalue) {
		WebElement value=null;
		if
		(locatorName.equals("id")){
			value=driver.findElement(By.id(Locatorvalue));
		}else if(locatorName.equals("name")) {
			value=driver.findElement(By.name(Locatorvalue));
		}else if(locatorName.equals("xpath")) {
			value=driver.findElement(By.xpath(Locatorvalue));	
		}
			return value;
	}
	
//	23.dynamic Wait
	void imlicitlyWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
//24.Static Wait
	public static void Threadsleep(long millis) throws InterruptedException{
		Thread.sleep(millis);
	}
//25.click and Hold
	
	public static void clickAndHold(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.clickAndHold(src).release(des).perform();
	}
	
//26.rightClick	
		
	public static void rightclick(WebElement e) {
		Actions a=new Actions(driver);
		a.contextClick(e).perform();
	}
//27.doubleClick	
	
	public static void doubleClick(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e).perform();
	}
	
//28.clear
	
	public static void clear(WebElement e) {
e.clear();
	}
//29.Select by value	
	
	public static void SelectByValue(WebElement e,String value)
	{
		Select s=new Select(e);
		s.selectByValue(value);
	}
	
//30Select by text	
	
		public static void selectByVisibleText(WebElement e,String value)
		{
			Select s=new Select(e);
			s.selectByVisibleText(value);
			}
		
//31.copy text
		
		public static void copytext(WebElement e)throws AWTException{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			
		}
		
		
//32.copy text
		
		public static void pastetext(WebElement e)throws AWTException{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);	
		
		}
		
//33.takeScreenshot	
		public static void pastetext(String url)throws IOException{
			TakesScreenshot tk=((TakesScreenshot)driver);
			File scr=tk.getScreenshotAs(OutputType.FILE);
			File des=new File(url);
			FileUtils.copyFile(scr, des);
		}
		

		
		
//34.first Selection option
		public static void firstSelectionOption(WebElement e)
		{
			Select s=new Select(e);
			s.getFirstSelectedOption();
		}
	
//35. deSelectAll
			public static void deSelectAll(WebElement e)
			{
				Select s=new Select(e);
				s.deselectAll();
			}	
// 36.deSelected by text
			public static void deselectbyVisibleText(WebElement e, String value)
			{
				Select s=new Select(e);
				s.deselectByVisibleText(value);
						}
			
			
//37.quit
			public static void quit()
			{
			driver.quit();
			}
			
			
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

