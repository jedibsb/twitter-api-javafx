package controle;

import java.util.List;

import configuracao.Configuracao;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TimeLine {

	
	public String linhaDoTempo() {
		
		String str = "";
		Configuracao c = new Configuracao();	
		
		TwitterFactory tf = new TwitterFactory(c.getConfiguracao().build());
		Twitter twitter = tf.getInstance();
		
		try {
			/*
			 * metodo: getHomeTimeLine()
			 * retorna os vinte ultimos posts listados na timeline
			 * chama: https://api.twitter.com/1.1/statuses/home_timeline
			 * 
			 */
			List<Status> status = twitter.getHomeTimeline();			
			
			for (Status st : status) {
				str = str + ("usuario: @" + st.getUser().getScreenName() + "\nMENSAGEM " + st.getText() + "\n\n");
			}
		}
		catch(TwitterException e) { e.printStackTrace(); }		
		
		return str;
	}
}
