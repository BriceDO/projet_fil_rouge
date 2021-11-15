package params;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

import daoUser.UserDaoSql;

	
	
public class Connexion {

		private static Connexion instance = null;
		
		//Constante  pour instancier un nouveau client
		private final UserDaoSql userDao = new UserDaoSql();
		
		//Constante  pour instancier un nouveau compte
		
		

		// attribut regroupant les info de connection
		private String url;
		private String username;
		private String password;
		private Connection connection;

		// empecher d'instancier le singleton depuis l'exterieur

		private Connexion() {

		}

		// methode static de création du singleton
		public static Connexion getInstance() {
			// on ne crrée l'instance qu'au 1er appel de la methode
			if (instance == null) {
				instance = new Connexion();
			}
			return instance;
		}
		
		// Méthode qui retour le client
		public UserDaoSql getUserDao() {
			return userDao;
			
		}
		
		
		// fonction qui enregistre les parametres de connection
		public void connexionDAO() {
			this.url = "jdbc:mysql://localhost:3306/roadtrip";    
			this.username = "root";
			this.password = "root";
		}

		// foonction qui realise la connexion

		public Connection getConnexion() throws SQLException {
			// chargement du driver
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
			connexionDAO();
			this.connection=null;
			this.connection = DriverManager.getConnection(this.url, this.username, this.password);
			return connection;
		}

		// fonction qui permet de fermer la connexion

		public void disconnect() {
			try {
				if (this.connection != null) {
					this.connection.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}

	}

