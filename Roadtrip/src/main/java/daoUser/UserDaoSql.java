package daoUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.UserModel;
import params.Connexion;

public class UserDaoSql {


/**
 * Class UserDaoSql qui permet le dialogue avec l'entité user de la base de
 * donnée mySQL
 * 
 * @author romain vasseur
 *
 */

	// fonction pour faire une requete getAll
	/**
	 * fonction qui permet de recuperer tous les user de la base de donnee
	 * 
	 * @return List<UserModel> : l'ensemble des user
	 */
	public List<UserModel> findAll() {
		// cree ma liste pour recup le resultat de ma requete
		List<UserModel> users = new ArrayList<UserModel>();
		// creer les variables de connexion et de resultat de requete
		Connection connection = null;
		PreparedStatement ps;
		ResultSet result;
		try {
			// ouvre la connexion
			connection = Connexion.getInstance().getConnexion();
			// faire la requete
			ps = connection.prepareStatement("SELECT id, firstName ,lastName,email,password FROM user");
			result = ps.executeQuery();
			// faire boucle
			while (result.next()) {
				// creer un objet user
				UserModel findUser = new UserModel(result.getInt("id"), result.getString("firstName"), result.getString("lastName"), result.getString("email"), result.getString("password"));
				users.add(findUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// important de rajouter le finally pour fermer la connexion
		} finally {
			Connexion.getInstance().disconnect();
		}

		return users;
	}

	
	/**
	 * fonction qui permet de recuperer un user de la base de donnees par son id
	 * 
	 * @param : int un id de user
	 * @return l'user correspondant a l'id rechercher.
	 */
	public UserModel findById(Integer id) {
		// creation d'un utilisateur pour le recuperer
		UserModel user = null;
		// creer les variables de connexion et de resultat de requete
		Connection connection = null;
		PreparedStatement ps;
		ResultSet result;

		try {
			// ouvre la connexion
			connection = Connexion.getInstance().getConnexion();
			// faire la requete
			ps = connection.prepareStatement("SELECT id, firstName, lastName, email, password FROM user WHERE ID = ?");
			ps.setInt(1, id);
			result = ps.executeQuery();

			if (result.next()) {
				Integer idUser = result.getInt("id");
				String firstNameUser = result.getString("firstName");
				String lastNameUser = result.getString("lastName");
				String emailUser = result.getString("email");
				String password = result.getString("password");
				user = new UserModel(id, firstNameUser,lastNameUser,emailUser,password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// important de rajouter le finally pour fermer la connexion
		} finally {
			Connexion.getInstance().disconnect();
		}
		return user;
	}

	/**
	 * Fonction qui permet d'ajouter un user dans la base de donnes
	 * 
	 * @param UserModel : un objet user a ajouter
	 */
	public void create(UserModel obj) {
		// creer les variables de connexion et de resultat de requete
		Connection connection = null;
		PreparedStatement ps;

		try {
			// ouvre la connexion
			connection = Connexion.getInstance().getConnexion();
			/*
			 * //desactiver l'auto-commit connection.setAutoCommit(false);
			 */
			// faire la requete
			// on demande le renvoi des valeurs attribuees a la cle primaire
			ps = connection.prepareStatement("INSERT INTO user(lastName,firstName,email,password) VALUES (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getLastName());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPassword());
			int rows = ps.executeUpdate();
			/*
			 * //valider le commit connection.commit();
			 */
			// executeUpdate() return 1 si succes ; 0 si echec.
			if (rows != 1) {
				throw new Exception("Problème à l'insertion du user : " + obj.getFirstName());
			} else {
				// parcours les valeurs attribuees
				ResultSet keys = ps.getGeneratedKeys();
				if (keys.next()) {
					int id = keys.getInt(1);
					obj.setId(id);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			// important de rajouter le finally pour fermer la connexion
		} finally {
			Connexion.getInstance().disconnect();
		}
	}

	/**
	 * fonction pour mettre a jour un user dans la base de donnees
	 * 
	 * @param UserModel : le user a mettre a jour
	 */
	public void update(UserModel obj) {
		// creer les variables de connexion et de resultat de requete
		Connection connection = null;
		PreparedStatement ps;

		try {
			// ouvre la connexion
			connection = Connexion.getInstance().getConnexion();
			             
			// faire la requete
			ps = connection.prepareStatement("UPDATE user SET firstName =? , lastName =? ,email=?, password = ? WHERE id=?");
			
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPassword());
			ps.setInt(5, obj.getId());
			int rows = ps.executeUpdate();
			// executeUpdate() return 1 si succes ; 0 si echec.
			if (rows != 1) {
				throw new Exception("Problème à la mise à jour du user n°" + obj.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			// important de rajouter le finally pour fermer la connexion
		} finally {
			Connexion.getInstance().disconnect();
		}

	}

	/**
	 * fonction qui permet de supprimer un user de la base de donnees
	 * 
	 * @param Int : l'id du user a supprimer
	 */
	public void delete(Integer id) {
		// creer les variables de connexion et de resultat de requete
		Connection connection = null;
		PreparedStatement ps;

		try {
			// ouvre la connexion
			connection = Connexion.getInstance().getConnexion();
			// faire la requete
			ps = connection.prepareStatement("DELETE FROM user WHERE id=?");
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			// executeUpdate() return 1 si succes ; 0 si echec.
			if (rows != 1) {
				throw new Exception("Problème à la suppression du user n°" + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			// important de rajouter le finally pour fermer la connexion
		} Connexion.getInstance().disconnect();
	}

}


