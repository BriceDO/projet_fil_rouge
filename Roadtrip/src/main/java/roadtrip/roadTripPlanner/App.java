package roadtrip.roadTripPlanner;

import java.util.List;

import entities.UserModel;
import params.Connexion;

/**
 * Hello world!
 *
 */
public class App {
	public static void User() {
// 	------ RECUPERATION DE TOUS LES UTILISATEURS ------
		
//		List<UserModel> users = Connexion.getInstance().getUserDao().findAll();
//		System.out.println(users);

//	------ RECUPERATION D'UN UTILISATEUR SELON L'ID ------
		
		UserModel user = Connexion.getInstance().getUserDao().findById(2);
		System.out.println(user);

//	----- CREATION D'UN NOUVEL UTILISATEUR -----
		
		UserModel newUser = new UserModel();

		// On lui ajoute des valeur
					newUser.setFirstName("THERY");
					newUser.setLastName("Jérémie");
					newUser.setEmail("toto.fr");
					newUser.setPassword("1234");
		// On envoie les données sur la BDD
					Connexion.getInstance().getUserDao().create(newUser);
					System.out.println(newUser);
		
					
//	----- MODIFICATION D'UN UTILISATEUR ----- 
//		
//					user.setLastName("DOBROWOLSKI");
//					Connexion.getInstance().getUserDao().update(user);
//					System.out.println(user);
					
//	---- SUPPRESSION DU COMPTE D'UN UTILISATEUR -----
					
//					Connexion.getInstance().getUserDao().delete(5);
	}

	public static void main(String[] args) {
		User();
	}
}
