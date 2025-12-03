package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.net.URL;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger; //log4j

public class baseClass {
	static public WebDriver driver;
	public Properties prop;
	public Logger logger;

	@BeforeClass(groups = { "Master", "Sanity", "Regression" })
	@Parameters({ "os", "browser" })

	public void setUp(String os, String br) throws IOException {

		// loading properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);

		logger = LogManager.getLogger(this.getClass());// Log4j
		//String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");

		// launching browser based on condition
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap= new DesiredCapabilities();
			// os
			if(os.equalsIgnoreCase("Windows")) {
				cap.setPlatform(Platform.WIN10);
				
			}else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
				
			}else {
				System.out.println("no matching OS found");
				return;
				
			}
			
			//browser
			if(br.equalsIgnoreCase("chrome")) {
				cap.setBrowserName("chrome");
			}else if(br.equalsIgnoreCase("edge")) {
				cap.setBrowserName("MicrosoftEdge");
			}
			else {
				System.out.println("No matching browser");
				return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("No matching browser..");
			return;
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);

	}

//
	@AfterClass(groups = { "Master", "Sanity", "Regression" })
	public void tearDown() {
		driver.quit();
	}

//	// to generate random inputs
//	public String randomString() {
//		@SuppressWarnings("deprecation")
//		String generatedString = RandomStringUtils.randomAlphabetic(5);
//		return generatedString;
//
//	}
//
//	public String randomeNumber() {
//		@SuppressWarnings("deprecation")
//		String generatedString = RandomStringUtils.randomNumeric(10);
//		return generatedString;
//	}
//
//	@SuppressWarnings("deprecation")
//	public String randomAlphaNumeric() {
//		String str = RandomStringUtils.randomAlphabetic(3);
//		String num = RandomStringUtils.randomNumeric(3);
//
//		return (str + "@" + num);
//	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	

}
