package controle;

import java.util.List;

import configuracao.Configuracao;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Buscar {
	
	
	public String buscarTweet(String[] palavraChave) {

		String retorno = "";
		String str = "";
		Configuracao c = new Configuracao();	
		
		/*
		 * elimina a primeira palavra do array de string
		 * a primeira palavra é o comando [postar-tweet]
		 */
		for (int i = 1; i < palavraChave.length; i++) {
			str += palavraChave[i] + " ";
		}		
				

		TwitterFactory tf = new TwitterFactory(c.getConfiguracao().build());
		Twitter twitter = tf.getInstance();
		
		try {

            Query query = new Query(str);
            QueryResult result;
            
            do {
            	/*
            	 * metodo search()
            	 * realiza uma busca geral no twitter
            	 * chama: http://search.twitter.com/search.json
            	 */
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                
                for (Status tweet : tweets) {
                   // System.out.println("@" + tweet.getUser().getScreenName() + "\nMENSAGEM " + tweet.getText() + "\n\n");
                    retorno += ("@" + tweet.getUser().getScreenName() + "\nMENSAGEM " + tweet.getText() + "\n\n");
                }                
            } while ((query = result.nextQuery()) != null);            
        } 
		catch (TwitterException e) { e.printStackTrace(); }
		
		return retorno;
    }	
}
