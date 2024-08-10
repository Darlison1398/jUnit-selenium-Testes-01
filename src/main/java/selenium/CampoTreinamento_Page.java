package selenium;

import org.openqa.selenium.WebDriver;

public class CampoTreinamento_Page {

	private Dsl dsl;
	
	public CampoTreinamento_Page(WebDriver driver) {
		dsl = new Dsl(driver);
	}
	
	public void setNome(String nome) {
		dsl.escreve("elementosForm:nome", nome);
	}
	
	public void setSobreNome(String sobrenome) {
		dsl.escreve("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	public void setComidaFavorita() {
		dsl.clicarChebox("elementosForm:comidaFavorita:0");
	}
	
	
	public void setEscolaridade(String valor) {
		dsl.selecionarComboBox("elementosForm:escolaridade", valor);
	}
	
	public void setEsporte(String valor) {
		dsl.selecionarComboBox("elementosForm:esportes", valor);
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	
	public String obterResultadoCadastro() {
		return dsl.obterTexto("resultado");
	}
	
	public String obterNomeCadastrado() {
		return dsl.obterTexto("descNome");
	}
	
	public String obterSobreNomeCadastrado() {
		return dsl.obterTexto("descSobrenome");
	}
	
	public String obterSexoCadastrado() {
		return dsl.obterTexto("descSexo");
	}
	
	public String obterComidaCadastrado() {
		return dsl.obterTexto("descComida");
	}
	
	public String obterEscolaridadeCadastrado() {
		return dsl.obterTexto("descEscolaridade");
	}
	
	public String obterEsporteCadastrado() {
		return dsl.obterTexto("descEsportes");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

