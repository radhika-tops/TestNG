package Tops;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Assignment.DriverConnection;

public class login {
	
		public class Login {
		static WebDriver driver;

		@BeforeClass
		public static void openbrowser() {
			 driver = new DriverConnection().getConnection();
			driver.get("https://careercenter.tops-int.com/");
		}

		@Test(dataProvider = "dp", priority = 1)
		public void login(String mobile, String password) throws InterruptedException {
			WebElement mob = driver.findElement(By.id("mobile"));
			mob.clear();
			mob.sendKeys(mobile);
			WebElement pass = driver.findElement(By.id("password"));
			System.out.println("password get");
			pass.clear();
			pass.sendKeys(password);
			Thread.sleep(2000);
			WebElement login = driver.findElement(By.xpath("//form[@id='loginForm']/div[3]/input"));
			login.click();
		}
		@Test(priority = 2)
		public void Profile() throws InterruptedException {
				WebElement Profile_btn = driver.findElement(By.xpath("//a[@id='profileDropdown']/span[1]"));
				Profile_btn.click();
				WebElement Pd = driver.findElement(By.linkText("Personal Details"));
		        Pd.click(); 
			        driver.findElement(By.id("select2-salutation-container")).click();
			        Actions action = new Actions(driver);
			        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			        driver.findElement(By.id("firstName")).sendKeys("Radhika");
			        driver.findElement(By.id("lastName")).sendKeys("Patel");
			        driver.findElement(By.id("email")).sendKeys("pradhika438@gmail.com");
			        Thread.sleep(2000);
//			        driver.findElement(By.id("profileImage")).sendKeys(".jpg");
//			        Thread.sleep(2000);
//			        driver.findElement(By.id("linkedin_id")).sendKeys("www.");
//			        Thread.sleep(2000);
//			        driver.findElement(By.id("instagram_id")).sendKeys("https:");
//			        Thread.sleep(2000);
//			        driver.findElement(By.id("select2-gender-container")).click();
			        Actions action2 = new Actions(driver);
			        action2.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

			
			WebElement Education_Btn = driver.findElement(By.linkText("Education Details"));
			Education_Btn.click();
			Thread.sleep(2000);
			
			WebElement Profile_btn1 = driver.findElement(By.xpath("//a[@id='profileDropdown']/span[1]"));
			Profile_btn1.click();
			//change password
			driver.findElement(By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/ul/li[3]/a")).click();
			Thread.sleep(2000);
		}
		
		@Test(priority = 3)
		public void Courses() throws InterruptedException {
				WebElement course_btn = driver.findElement(By.id("course-dropdown"));
				course_btn.click();
	
		}

		@DataProvider(name = "dp")
		public Object[][] dpmethod() {
			Object o[][] = new Object[4][2];
			o[0][0] = "2121";
			o[0][1] = "2199";

			o[1][0] = "9";
			o[1][1] = "9558870650";

			o[2][0] = "9558870650";
			o[2][1] = "90";

			o[3][0] = "9970205624";
			o[3][1] = "9970205624";

			return o;

		}

}
