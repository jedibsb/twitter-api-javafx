package controle;

import configuracao.Configuracao;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Twittar {			
	
	public String postarTweet(String[] mensagem)  {

		String str = "";
		
		/*
		 * elimina a primeira palavra do array de string
		 * a primeira palavra é o comando [postar-tweet]
		 */
		for (int i = 1; i < mensagem.length; i++) {
			str += mensagem[i] + " ";
		}
		
		Configuracao c = new Configuracao();		

		TwitterFactory tf = new TwitterFactory(c.getConfiguracao().build());
		Twitter twitter = tf.getInstance();
		
		String tweet = str;

		try {
			/*
			 * metodo: updateStatus()
			 * realiza um tweet
			 * chama: https://api.twitter.com/1.1/statuses/update
			 */
			twitter.updateStatus(tweet);
			return "Tweet postado com sucesso!";
		}
		catch(TwitterException e) { 
			e.printStackTrace(); 
			return "Ocorreu um erro. Verificar log do sistema para mais detalhes"; 
		}		
	}
}
