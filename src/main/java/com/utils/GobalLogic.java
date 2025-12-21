package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
//import javax.mail.BodyPart;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.Session;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import com.driverFactory.Driver_Factory;
public class GobalLogic {

	public WebDriver driver;
	public JavascriptExecutor js;

	public GobalLogic(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void click(String elementName, WebElement element) {

		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].style.border='3px solid green'", element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void actionClick(String elementName, WebElement element) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].style.border='3px solid green'", element);
			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			actions.moveToElement(element).click().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void clickJS(String elementName, WebElement element) {

		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].style.border='3px solid green'", element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void waitVisibilityOfElement(String elementName, WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectByText(WebElement element, String text) {

		try {
			Select select = new Select(element);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].style.border='3px solid green'", element);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectByindex(WebElement element, int index) {

		try {
			Select select = new Select(element);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].style.border='3px solid green'", element);
			select.selectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void deSelectByText(WebElement element, String text) {

		try {
			Select select = new Select(element);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].style.border='3px solid green'", element);
			select.deselectByVisibleText(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deSelectByindex(WebElement element, int index) {

		try {
			Select select = new Select(element);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].style.border='3px solid green'", element);
			select.deselectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void refreshWebPage() {

		driver.navigate().refresh();
	}

	public void navigateBack() {

		driver.navigate().back();
	}

	public void navigateForward() {

		driver.navigate().forward();
	}

	public void navigateURL(String url) {

		driver.navigate().to(url);
	}

	public void pageLoad() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	public void fluentWait() {

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
	}

	public void writeText(String elementName, WebElement element, String text) {

		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

			// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].style.border='3px solid green'", element);
			fluentWait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void getText(String elementName, WebElement element, String elementText) {

		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].style.border='3px solid green'", element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			elementText = element.getText();
			System.out.println("Element name " + elementText);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void switchFrame(WebElement element) {

		driver.switchTo().frame(element);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].style.border='3px solid green'", element);
		driver.switchTo().frame(element);
	}

	public void defaultFrame() {

		driver.switchTo().defaultContent();

	}

	public void acceptPopup() {

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void dismissPopup() {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	public void getWindowHandle() {

		try {
			Set<String> AllWindow = driver.getWindowHandles();

			String newWindow = "";

			for (String window : AllWindow) {

				if (!window.equals(AllWindow)) {

					newWindow = window;
					break;
				}
			}

			// Switch new window
			driver.switchTo().window(newWindow);

			for (String win : AllWindow) {

				driver.switchTo().window(win);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void pdfFilereader(String filePath) throws IOException {

//		try {
//			File fo = new File(filePath);
//			PDDocument document = PDDocument.load(fo);
//			int pdfPageCount = document.getNumberOfPages();
//			System.out.println("PDF Pages Count :: " + pdfPageCount);
//			PDFTextStripper pdfTextStripper = new PDFTextStripper();
//			String pdfText = pdfTextStripper.getText(document);
//			System.out.println("PDF Text::" + pdfText);
//			document.close();
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
	}

	public void pdfToTextParser(String filePath, String pdfFilepath) throws IOException {

		// Parse pdf content into Text file

//		File fo = new File(pdfFilepath);
//		PDDocument document = PDDocument.load(fo);
//		int pdfPageCount = document.getNumberOfPages();
//		System.out.println("PDF Pages Count :: " + pdfPageCount);
//		PDFTextStripper pdfTextStripper = new PDFTextStripper();
//		String pdfText = pdfTextStripper.getText(document);

		File fs = new File(filePath);// Created object of java File class.
		fs.createNewFile();// Create file.
		FileWriter FW = new FileWriter(filePath);
		BufferedWriter BW = new BufferedWriter(FW);
		//BW.write(pdfText);
		BW.close();
		System.out.println("==================Parse PDF content into Text file==============");

		// Read Text file
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String Content = " ";
		while ((Content = bufferedReader.readLine()) != null) {
			System.out.println(Content);
			System.out.println("==================Read Text file==============");
		}
	}

	public void scrollPage() throws InterruptedException {

		// scroll the page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
		jse.executeScript("window.scrollTo(0,0)");
		Thread.sleep(3000);

	}

//	public void sendMail(String textBodyFilePath) {
//
//		System.out.println("< ----------------Preparing for mail -------------------------->");
//
//		final String username = "prakash.patil@autozone.com";
//		final String password = "Appium@12345";
//
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.office365.com");
//		props.put("mail.smtp.port", "587");
//		props.put("java.net.preferIPv4Stack", "true");
//		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		});
//
//		try {
//
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("prakash.patil@autozone.com"));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("Prakashp4@hexaware.com"));
//			message.setSubject(" Selenium automation: C code .mx file data extract:: Commercial Deal");
//
//			BodyPart messageBodyPart1 = new MimeBodyPart();
//			messageBodyPart1.setText("C code File .mx file data extract successfully. Commercial Deal");
//
//			// 4) create new MimeBodyPart object and set DataHandler object to
//			// this object
//			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//
//			// String filename = "File path if you want to attach in
//			// mail";//change
//			// accordingly
//			DataSource source = new FileDataSource(textBodyFilePath);
//			messageBodyPart2.setDataHandler(new DataHandler(source));
//			messageBodyPart2.setFileName(textBodyFilePath);
//			// 5) create Multipart object and add MimeBodyPart objects to this
//			// object
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart1);
//			multipart.addBodyPart(messageBodyPart2);
//			// 6) set the multiplart object to the message object
//			message.setContent(multipart);
//			Transport.send(message);
//			System.out.println("Mail Sent Successfully");
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//
//		System.out.println("< ------------------ Mail Send ------------------------------------>>");
//
//	}

	public void dynamic_start_date(WebElement element) throws Throwable {

		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, 1);
		// Date d = cal.getTime();
		java.util.Date d = cal.getTime();
		System.out.println("Next Business date : : " + d);
		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		String nextDate = ymdFormat.format(d);
		System.out.println("Next Business Formatted date : : " + nextDate);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid green'", element);
		element.clear();
		element.click();
		Thread.sleep(4000);
		element.sendKeys(nextDate);
		Thread.sleep(4000);

	}

	public void dynamic_end_date(WebElement element) throws Throwable {

		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, 10);
		// Date d = cal.getTime();
		java.util.Date d = cal.getTime();
		System.out.println("Next Business date : : " + d);
		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		String nextDate = ymdFormat.format(d);
		System.out.println("Next Business Formatted date : : " + nextDate);
		element.click();
		Thread.sleep(4000);
		element.sendKeys(nextDate);
		Thread.sleep(4000);

	}

//	public void scroll_down() throws Throwable {
//
//		JavascriptExecutor js = (JavascriptExecutor) Driver_Factory.driver;
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight");
//		Thread.sleep(50000);
//	}
	
	public void clickElementCenterUsingActions(WebDriver driver, WebElement element) {
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element, element.getSize().getWidth()/2, element.getSize().getHeight()/2).click().perform();
	}

	
	
	
	
}
