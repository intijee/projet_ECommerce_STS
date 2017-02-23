package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

/**
 * Classe qui gère la connexion à la base de données pour les méthodes de Admin
 *
 */
@Stateful
public class AdminDaoImpl implements IAdminDao {

	// On renseigne le provider qui sera utilisé
	@PersistenceContext(unitName = "PU")
	EntityManager em;


	
	@Override
	public int isExist(Admin admin) {

		
		// Ecriture de la requete
		String req = "select a from Admin as a where a.mail=:pMail and a.password=:pPassword";

		// Creation d'une requete
		Query query = em.createQuery(req);

		// Assignation des paramètres
		query.setParameter("pMail", admin.getMail());
		query.setParameter("pPassword", admin.getPassword());

		// Recuperation de l'admin (stocké dans une liste au cas ou on aurait un
		// doublon)
		List<Admin> liste = query.getResultList();

		if (liste.size() != 0) {
			
			// Si la liste n'est pas vide alors on a au moins un admin qui
			// correspond
			return liste.size();
			
		} else {
			// Si la liste est vide alors on retourne 0
			return 0;
		}
	}

	@Override
	public int ajouterProduit(Produit produit) {
		
		// Try/Catch permet de prevenir toute exception et de fournir un retour 
		try {
			
			em.persist(produit);
			return 1;
			
		} catch (Exception e) {
			
			return 0;
		}
		
	}

	@Override
	public int supprimerProduitByName(Produit produit) {
		
		try {
			
			return 1;
			
		} catch (Exception e) {
			
			return 0;
		}
		
		
	}

	@Override
	public int modifierProduit(int id_produit, Produit produit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Produit chercherProduitByName(String designation_produit) {
		
		
		try {
			
			// Ecriture de la requete
			String req="select p from Produit p where p.designation=:pDesignation";
			
			// Creation de la requete
			Query query=em.createQuery(req);
			
			// Assignation des paramètres
			query.setParameter("pDesignation", designation_produit);
			
			// Recuperation des résultats 
			return (Produit) query.getSingleResult();
			
			
		} catch (Exception e) {
			return null;
		}
	}

	
	@Override
	public List<Produit> getAllProduit() {
		// TODO Auto-generated method stub
		return null;
	}

}
