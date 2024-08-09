package selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dsl {
	
    private WebDriver driver;
    
    // construtor
    public Dsl(WebDriver driver) {
    	this.driver = driver;
    }
	
	/********  escrever   *****/
    
	public void escreve(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	
	public void escreverNoCampo(By by, String texto) {
		// limpa o campo antes de escrever a mensagem
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}
	
	
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/********  escrever fim   *****/
	
	
	/********  Radio, CheckBox, ComboBox   *****/
	
	public void clicarRadio(String id_campo) {
		driver.findElement(By.id(id_campo)).click();
	}
	
	public boolean isRadioButtonMarcado(String id_campo) {
		return driver.findElement(By.id(id_campo)).isSelected();
	}
	
	public void clicarChebox(String id_campo) {
		driver.findElement(By.id(id_campo)).click();
	}
	
	public void selecionarComboBox(String id, String valor) {
		WebElement element =  driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void desSelecionarComboBox(String id, String valor) {
		WebElement element =  driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	
	public String obterValorcomboBox(String id) {
		WebElement element =  driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	/********  fim  *****/
	
	
	/********  Botão, Link e click   *****/
	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	
	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	
	public String obterTexto(String id) {
		return driver.findElement(By.id(id)).getText();
	}
	
	/********  fim  *****/
	
	
	/********  Alerts, Popup, FRAMES   *****/
	
	public void entrarFrame(String id) {
		driver.switchTo().frame(id);
	}
	
	public void sairFrame() {
		driver.switchTo().defaultContent();
	}
	
	public void trocarJanelas(String id) {
		driver.switchTo().window(id);
	}
	
	
	
	
	
	
	
	
	

}
