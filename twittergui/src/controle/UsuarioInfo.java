package controle;

import configuracao.Configuracao;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class UsuarioInfo {

	public String getUsuarioInfo(final String nomeUsuario) {

		String str = "";
		Configuracao c = new Configuracao();	

		TwitterFactory tf = new TwitterFactory(c.getConfiguracao().build());
		Twitter twitter = tf.getInstance();

		User user;
		try {
			/*
			 * https://api.twitter.com/1.1/users/show.json
			 */
			user = twitter.showUser(nomeUsuario);

			if (user.getStatus() != null) {
				
				str = ("@" + user.getScreenName()) + "\n"
					+ ("Descricao: " + user.getDescription()) + "\n"
					+ ("Criado em: " + user.getCreatedAt()) + "\n"
					+ ("Email: " + user.getEmail()) + "\n"
					+ ("Seguidores: " + user.getFollowersCount()) + "\n"
					+ ("Seguindo: " + user.getFriendsCount()) + "\n"
					+ ("Localizacao: " + user.getLocation()) + "\n"
					+ ("Conta verificada? : " + user.isVerified());
			} else {
				// conta protegida
				str = ("@" + user.getScreenName());
			}
		} catch (TwitterException e) { e.printStackTrace(); }
		
		return str;
	}
}
