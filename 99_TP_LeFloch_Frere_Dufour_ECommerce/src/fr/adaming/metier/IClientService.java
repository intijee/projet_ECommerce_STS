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
	 * Methode pour consulter toutes les cat�gories 
	 * @return la liste des cat�gories qui existent dans la base de donn�es
	 */
	public List<Categorie> getAllCategorieService();
	
	
	/**
	 * Methode pour consulter tous les produits d'une cat�gorie
	 * @param categorie
	 * @return une liste des produits appartenant � la cat�gorie
	 */
	public List<Produit> getAllProduitCategorieService(Categorie categorie);
	
	
	/**
	 * Methode pour selectionner un produit (donne true au boolean selectionner de Produit)
	 * @param designation_produit
	 */
	public void selectionnerProduitByNameService(String designation_produit);
	
	
	/**
	 * Methode pour retourner la liste des produits selectionn�s
	 * @return liste des produits selectionn�s
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
	 * @return le produit � supprimer du panier
	 */
	public Produit supprimerProduitPanierByIdService(int indexProduit);
	
	
	/**
	 * Methode pour ajouter dans la base de donn�es la commande et le client
	 * @param client
	 * @param commande
	 * @return un entier qui nous v�rifie le bon fontionnement de la m�thode
	 */
	public int EnregistrerClientCommandeService(Client client, Commande commande);
	
	
	/**
	 * Methode pour chercher un produit avec un mot cl�
	 * @param motCle
	 * @return un produit qui sera present� au client
	 */
	public Produit chercherProduitMotCleService(String motCle);
	
	
	/**
	 * Methode qui permet de r�cup�rer une cat�gorie dans la base de donn�es avec son nom
	 * @param nom_categorie
	 * @return la categorie qui poss�de ce nom
	 */
	public Categorie getCategorieByNameService(String nom_categorie);
	
	
	/**
	 * Methode qui permet de r�cuperer la liste des noms des cat�gories de la base
	 * @return la liste des noms des cat�gories (utilise lors de l'ajout d'un produit � la base de donn�es)
	 */
	public List<String> getAllCategorieNameService();
	
	/**
	 * Methode qui permet de r�cuperer la liste des noms des produits de la base
	 * @return la liste des noms des produits (utilisee dans beaucoup de m�thodes)
	 */
	public List<String> getAllProduitNameService();
	
}
