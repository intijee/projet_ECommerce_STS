package fr.adaming.metier;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Produit;

@Local
public interface IClientService {

	
	
	
	
	/**
	 * Methode pour consulter toutes les catégories 
	 * @return la liste des catégories qui existent dans la base de données
	 */
	public List<Categorie> getAllCategorieService();
	
	
	/**
	 * Methode pour consulter tous les produits d'une catégorie
	 * @param categorie
	 * @return une liste des produits appartenant à la catégorie
	 */
	public List<Produit> getAllProduitCategorieService(Categorie categorie);
	
	
	/**
	 * Methode pour selectionner un produit (donne true au boolean selectionner de Produit)
	 * @param designation_produit
	 */
	public void selectionnerProduitByNameService(String designation_produit);
	
	
	/**
	 * Methode pour retourner la liste des produits selectionnés
	 * @return liste des produits selectionnés
	 */
	public List<Produit> getAllProduitSelectionneService();
	
	
	/**
	 * Methode pour ajouter un produit au panier (en specifiant la quantite)
	 * @param designation_produit
	 * @param quantite
	 * @return le produit qu'on ajouter au panier
	 */
	public Produit ajouterProduitPanierByNameService(String designation_produit, int quantite);
	
	
	/**
	 * Methode pour supprimer un objet du panier (on lui donne l'index du produit dans la liste du panier)
	 * @param indexProduit
	 * @return le produit à supprimer du panier
	 */
	public Produit supprimerProduitPanierByIdService(int indexProduit);
	
	
	/**
	 * Methode pour ajouter dans la base de données la commande et le client
	 * @param client
	 * @param commande
	 * @return un entier qui nous vérifie le bon fontionnement de la méthode
	 */
	public int EnregistrerClientCommandeService(Client client, Commande commande);
	
	
	/**
	 * Methode pour chercher un produit avec un mot clé
	 * @param motCle
	 * @return un produit qui sera presenté au client
	 */
	public Produit chercherProduitMotCleService(String motCle);
	
	
	/**
	 * Methode qui permet de récupérer une catégorie dans la base de données avec son nom
	 * @param nom_categorie
	 * @return la categorie qui possède ce nom
	 */
	public Categorie getCategorieByNameService(String nom_categorie);
	
	
	/**
	 * Methode qui permet de récuperer la liste des noms des catégories de la base
	 * @return la liste des noms des catégories (utilise lors de l'ajout d'un produit à la base de données)
	 */
	public List<String> getAllCategorieNameService();
	
	/**
	 * Methode qui permet de récuperer la liste des noms des produits de la base
	 * @return la liste des noms des produits (utilisee dans beaucoup de méthodes)
	 */
	public List<String> getAllProduitNameService();
	
}
