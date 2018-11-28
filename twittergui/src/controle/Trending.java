package controle;

import configuracao.Configuracao;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Trend;
import twitter4j.Trends;

public class Trending {
	
	/*
	 * recebe woeid 
	 * 1 para trending mundial
	 * 23424768 treinding brasil
	 */
	public String trendingTopics(int woeid) {
		
		String str = "";
		Configuracao c = new Configuracao();	
		
		TwitterFactory tf = new TwitterFactory(c.getConfiguracao().build());
		Twitter twitter = tf.getInstance();
		
		try {
			/*
			 * https://api.twitter.com/1.1/trends/place.json
			 */
			Trends trends = twitter.getPlaceTrends(woeid);
			
			int count = 0;
			for (Trend trend : trends.getTrends()) {
	            if (count < 10) {
	                //System.out.println(trend.getName());
	                //System.out.println(trend.getTweetVolume()!=-1?trend.getTweetVolume():"Nao Disponivel");	                
	                //System.out.println();
	                
	                str = str + trend.getName() + "\n" + (trend.getTweetVolume()!=-1?trend.getTweetVolume():"Nao Disponivel") + "\n\n";
	                count++;
	            }
	        }
		} catch (TwitterException e) { e.printStackTrace(); }
		
		return str;
	}

}
