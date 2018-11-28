package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import controle.*;

public class SampleController {
	
	@FXML
	private Button botaoEnviar;
	
	@FXML
	private TextField textFieldComando;
	
	@FXML
	private TextArea textAreaResultado;	

	public void botaoEnviar(ActionEvent event) {
		
		textAreaResultado.setWrapText(true);
		
		String[] palavras = textFieldComando.getText().trim().split(" ");
		
		for ( String ss : palavras) {
		    System.out.println(ss);
		}
		System.out.println(palavras.length);
		
		switch(palavras.length) {
			
			case 1 :
				switch(textFieldComando.getText().trim()) {
					case "ajuda" : imprimirAjuda();
						break;
					case "exibir-timeline" : textAreaResultado.setText(new TimeLine().linhaDoTempo());
						break;
					case "trending-mundo"  : textAreaResultado.setText(new Trending().trendingTopics(1));
						break;
					case "trending-brasil" : textAreaResultado.setText(new Trending().trendingTopics(23424768));
						break;
					default 			   : textAreaResultado.setText("COMANDO INVALIDO");
				}
				break;
			
			case 2 :
				switch(palavras[0]) {					
					case "info-usuario"  : textAreaResultado.setText(new UsuarioInfo().getUsuarioInfo(palavras[1]));
						break;
					case "buscar-tweets" : textAreaResultado.setText(new Buscar().buscarTweet(palavras));
						break;
					default 		     : textAreaResultado.setText("COMANDO INVALIDO"); 
				}
				break;
				
			default : 
				switch(palavras[0]) {
					case "postar-tweet"  : textAreaResultado.setText(new Twittar().postarTweet(palavras));
						break;					
					default 			 : textAreaResultado.setText("COMANDO INVALIDO");
				}
		}
		
	}
	
	public void imprimirAjuda() {
		
		textAreaResultado.setText("exibir-timeline -> exibe timeline"); 
		textAreaResultado.appendText("\ntrending-mundo -> exibe trending topics mundial");
		textAreaResultado.appendText("\ntrending-brasil -> exibe trending topics brasil");
		textAreaResultado.appendText("\npostar-tweet [tweet] -> posta um tweet");
		textAreaResultado.appendText("\nbuscar-tweets [palavra-chave] -> busca tweets relacionados a palavra chave");
		textAreaResultado.appendText("\ninfo-usuario [nome-usuario] -> informacoes de usuario");
		
	}	
	
}
