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
 * Classe qui communique avec la base de donn�es pour les m�thodes des clients
 *
 */

// Pour que le conteneur les instancie � partir de leur interface
@Stateful
public class ClientDaoImpl implements IClientDao {

	
	// On renseigne le provider qui sera utilis�
	@PersistenceContext(unitName = "PU")
	EntityManager em;

	
	@Override
	public List<Categorie> getAllCategorie() {
	
		
		// Ecriture de la requete 
		String req="select c from Categorie c";
		
		// Creation d'une requete
		Query query=em.createQuery(req);
		
		// Recuperation du r�sultat de la requete
		return query.getResultList();
	}

	@Override
	public List<Produit> getAllProduitByCategorie(Categorie categorie) {

		System.out.println(categorie.getId());
		// Ecriture de la requete
		String req="select p from Produit p where p.pCategorie.id=:pCatId";
		
		// Creation de la requete
		Query query=em.createQuery(req);
		
		// Assignation des param�tres de la requete
		query.setParameter("pCatId", categorie.getId());
		
		// Recuperation des r�sultats
		List<Produit> listeProduit=query.getResultList();
		
		// Si la liste contient au moins un �l�ment on la retourne sinon on retourne null
		if (listeProduit.size()!=0){
			
			return listeProduit;
		} else {
			return null;
		}
	}

	@Override
	public void selectionnerProduitByName(int id_produit) {


		// On recup�re le produit
		Produit p1=em.find(Produit.class, id_produit);
		
		// Assignation de la valeur true au param�tre selectionn� du produit
		p1.setSelectionne(true);
		
		// Modification dans la base de donn�es
		em.merge(p1);
	
	}

	@Override
	public List<Produit> getAllProduitSelectionne() {
		
		// Ecriture de la requete
		String req="select p from Produit p";
		
		// Creation de la requete
		Query query=em.createQuery(req);
		
		// Recuperation de tous les produits
		List<Produit> listeProd=query.getResultList();
		
		// Creation d'une liste qui recup�re uniquement ceux qui sont selectionn�s
		List<Produit> listeProduitSelectionne=new ArrayList<Produit>();
		
		for (Produit p: listeProd){
			// Si le produit est selectionn� alors il est ajout� � la liste
			if (p.isSelectionne()==true){
				listeProduitSelectionne.add(p);
			} else {
				
			}		
		}
		
		// Retour de la liste des produits s�lectionn�s
		return listeProduitSelectionne;
		
		
		
	}


	@Override
	public int EnregistrerClientCommande(Client client) {


		try {
			
			em.persist(client);
			
			return 1;
			
		} catch (Exception e) {
			
			return 0;
			
		}
		
	}

	

	@Override
	public List<Produit> chercherProduitMotCle(String motCle) {
		
		// Ecriture de la requete
		String req="select p from Produit p where p.designation like ?1'%'";
		
		
		// Creation d'une requete
		Query query=em.createQuery(req);
		
		// Assignation des param�tres de la requete
		query.setParameter(1, motCle);
		
		// Recup�ration des r�sultats (dans une liste afin de faire une v�rification que la recherche n'est pas nulle)
		List<Produit> listeProd=query.getResultList();
		
		if (listeProd.size()!=0){
			// On choisit de recuperer uniquement le premier produit
			return listeProd;
		} else {
			return null;
		}
				
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
		
		
		// Recuperation des r�sultats sous forme d'une liste d'objets cat�gorie
		List<Categorie> listeCat=query.getResultList();
		
		// Instanciation d'un objet de type liste de string qui recupere les noms des cat�gories grace a la boucle for
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
		
		// Instanciation d'un objet de type liste de String qui recupere les decriptions des produits gr�ce � la boucle for
		List<String> listeNomProduit=new ArrayList<String>();
		
		for (Produit p :listeProd){
			listeNomProduit.add(p.getDesignation());
		}
		
		// Renvoi de la liste des noms
		return listeNomProduit;
		
	}
	
	

}
