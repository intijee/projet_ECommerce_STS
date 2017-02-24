package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Produit;



/**
 * Classe qui communique avec la base de données pour les méthodes des clients
 *
 */

// Pour que le conteneur les instancie à partir de leur interface
@Stateful
public class ClientDaoImpl implements IClientDao {

	
	// On renseigne le provider qui sera utilisé
	@PersistenceContext(unitName = "PU")
	EntityManager em;

	
	@Override
	public List<Categorie> getAllCategorie() {
	
		
		// Ecriture de la requete 
		String req="select c from Categorie c";
		
		// Creation d'une requete
		Query query=em.createQuery(req);
		
		// Recuperation du résultat de la requete
		return query.getResultList();
	}

	@Override
	public List<Produit> getAllProduitByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectionnerProduitByName(String designation_produit) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Produit> getAllProduitSelectionne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit ajouterProduitPanierByName(Produit produit, int quantite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit supprimerProduitPanierById(int indexProduit) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int EnregistrerClientCommande(Client client, Commande commande) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public Produit chercherProduitMotCle(String motCle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getCategorieByName(String nom_categorie) {

		
		// Ecriture de la requete 
		String req="select c from Categorie c where c.nom=:pNom";
		
		// Creation d'une requete
		Query query=em.createQuery(req);
		
		query.setParameter("pNom", nom_categorie);
		
		return (Categorie) query.getSingleResult();
		
		
	}

	@Override
	public List<String> getAllCategorieName() {


		// Ecriture de la requete
		String req="select c from Categorie c";
		
		// Creation d'une requete
		Query query=em.createQuery(req);
		
		
		// Recuperation des résultats sous forme d'une liste d'objets catégorie
		List<Categorie> listeCat=query.getResultList();
		
		// Instanciation d'un objet de type liste de string qui recupere les noms des catégories grace a la boucle for
		List<String> listeNomCategorie=new ArrayList<String>();
		
		for (Categorie c:listeCat){
			listeNomCategorie.add(c.getNom());
		}
		
		// Renvoi de la liste des noms
		return listeNomCategorie;
	}

	@Override
	public List<String> getAllProduitName() {
		
		// Ecriture de la requete
		String req="select p from Produit p";
		
		// Creation d'une requete
		Query query=em.createQuery(req);
		
		// Recuperation des resultats sous forme d'une liste d'objets produits
		List<Produit> listeProd=query.getResultList();
		
		// Instanciation d'un objet de type liste de String qui recupere les decriptions des produits grâce à la boucle for
		List<String> listeNomProduit=new ArrayList<String>();
		
		for (Produit p :listeProd){
			listeNomProduit.add(p.getDesignation());
		}
		
		// Renvoi de la liste des noms
		return listeNomProduit;
		
	}
	
	

}
