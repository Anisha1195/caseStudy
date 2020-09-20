package Testcases;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import au.com.bytecode.opencsv.CSVReader;

public class caseStudy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ifsc.bankifsccode.com/"); //sbin0007611
		
		CSVReader reader = new CSVReader(new FileReader("D://Read.csv"));
		
		String csvCell[];
		String separator=",";
		
		try(OutputStream filestream = new BufferedOutputStream(new FileOutputStream("D://Write.csv"));
				Writer outStreamWriter = new OutputStreamWriter(filestream, StandardCharsets.UTF_8);
				BufferedWriter buffWriter = new BufferedWriter(outStreamWriter)) 
		
		{
			buffWriter.append("IFSC Code");
			buffWriter.append(separator);
            buffWriter.append("Bank");
            buffWriter.append(separator);
            buffWriter.append("Branch");
            buffWriter.append(separator);
            buffWriter.append("District");
            buffWriter.append(separator);
            buffWriter.append("State");
            
            buffWriter.newLine();
            buffWriter.flush();
            
            while((csvCell = reader.readNext()) != null) {
            	
            	String ifsccode = csvCell[0];
            	driver.findElement(By.id("ifsccode")).clear();
            	driver.findElement(By.id("ifsccode")).sendKeys(ifsccode);
            	driver.findElement(By.name("submit")).click();
            	
            	String bank = driver.findElement(By.xpath("//a[contains(text(),'STATE BANK OF INDIA')]")).getText();
            	String branch=driver.findElement(By.xpath("//a[contains(text(),'SHOLINGHUR')]")).getText();
            	String district = driver.findElement(By.xpath("//a[contains(text(),'VELLORE')]")).getText();
            	String state = driver.findElement(By.xpath("//a[contains(text(),'TAMIL NADU')]")).getText();
            	
            	buffWriter.append(ifsccode);
                buffWriter.append(separator);
                buffWriter.append(bank);
                buffWriter.append(separator);
                buffWriter.append(branch);
                buffWriter.append(separator);
                buffWriter.append(district);
                buffWriter.append(separator);
                buffWriter.append(state);

                buffWriter.newLine();
                buffWriter.flush();
                
                System.out.println("=====PASS=======");
            }
            
		}
				
	}

}
