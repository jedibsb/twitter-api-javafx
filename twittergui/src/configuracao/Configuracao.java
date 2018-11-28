package configuracao;

import twitter4j.conf.ConfigurationBuilder;


public class Configuracao {
	
	
	private final String consumerKey = "?";
	private final String consumerSecret = "?";
	private final String accessToken = "?";
	private final String accessTokenSecret = "?";

	
	public ConfigurationBuilder getConfiguracao() {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(false);
		cb.setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret)
			.setOAuthAccessToken(accessToken)
			.setOAuthAccessTokenSecret(accessTokenSecret);
		
		return cb;
	}
}
