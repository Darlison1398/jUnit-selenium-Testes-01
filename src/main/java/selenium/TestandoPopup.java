package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestandoPopup {
	
	@Test
	public void testandoPopup() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1:5500/componentes.html");
		
		 // Guardar o identificador da janela original
        String janelaPrincipal = driver.getWindowHandle();
        
		driver.findElement(By.id("buttonPopUpEasy")).click();
		
		// trocando o foco do driver para o popup
		driver.switchTo().window("Popup");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Seu teste deu certo");
		
		// fechando apenas o popup
		driver.close();
		
		driver.switchTo().window(janelaPrincipal);
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("e agora, o popup foi finalizado!");
		
		driver.quit();
	}
	

	@Test
	public void deveInteragircomJanelasSemTitulo() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1:5500/componentes.html");
        
		driver.findElement(By.id("buttonPopUpHard")).click();
		
		// imprimindo no console a janela corrente.
		System.out.println(driver.getWindowHandle());
		
		// imprimindo todas as janelas gerenciadas
		System.out.println(driver.getWindowHandles());
		
		/*
		 * Ao usar o método acima para imprimir no console os 
		 * id das janelas gerenciadas, podemos usar o id de cada
		 * uma delas
		 */
		
		// MUDANDO PARA A JANELA 2
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("DEU CERTO");
		
		//VOLTANDO O FOCO PARA A JANELA 1
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("Janella 01 focada novamente.");
		
		driver.quit();
	}

}
