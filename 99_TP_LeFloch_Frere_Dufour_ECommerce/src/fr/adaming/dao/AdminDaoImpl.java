package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;

/**
 * Classe qui g�re la connexion � la base de donn�es pour les m�thodes de Admin
 *
 */
@Stateful
public class AdminDaoImpl implements IAdminDao {

	// On renseigne le provider qui sera utilis�
	@PersistenceContext(unitName = "PU")
	EntityManager em;

	@Override
	public int isExist(Admin admin) {

		// Ecriture de la requete
		String req = "select a from Admin as a where a.mail=:pMail and a.password=:pPassword";

		// Creation d'une requete
		Query query = em.createQuery(req);

		// Assignation des param�tres
		query.setParameter("pMail", admin.getMail());
		query.setParameter("pPassword", admin.getPassword());

		// Recuperation de l'admin (stock� dans une liste au cas ou on aurait un
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
	public int supprimerProduitByName(int id_produit) {

		try {
			
			Produit p=em.find(Produit.class, id_produit);
			em.remove(p);
			return 1;

		} catch (Exception e) {

			return 0;
		}

	}

	@Override
	public int modifierProduit(int id_produit, Produit produit) {

		try {

			// Recuperation du produit en question dans la base de donn�es
			Produit p = em.find(Produit.class, id_produit);

			// Assignation des nouveaux param�tres
			p.setDescription(produit.getDescription());
			p.setDesignation(produit.getDesignation());
			p.setpCategorie(produit.getpCategorie());
			p.setQuantite(produit.getQuantite());
			p.setPrix(produit.getPrix());
			p.setSelectionne(produit.isSelectionne());

			// Modification du produit dans la base de donn�es
			em.merge(p);

			return 1;

		} catch (Exception e) {

			return 0;

		}

	}

	@Override
	public Produit chercherProduitByName(String designation_produit) {

		try {

			// Ecriture de la requete
			String req = "select p from Produit p where p.designation=:pDesignation";

			// Creation de la requete
			Query query = em.createQuery(req);

			// Assignation des param�tres
			query.setParameter("pDesignation", designation_produit);

			// Recuperation des r�sultats
			return (Produit) query.getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Produit> getAllProduit() {


		// Ecriture de la requete
		String req="select p from Produit p";
		
		// Creation d'une requete
		Query query=em.createQuery(req);
		
		// Recuperation des r�sultats de la requete
		List<Produit> listeProduit=query.getResultList();
		
		// Si il y a au moins un produit dans la base de donn�es
		if (listeProduit.size()!=0){
			
			return listeProduit;
			
		} else {
			
			return null;
		}
	}

}
