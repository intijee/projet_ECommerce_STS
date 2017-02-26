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
	 * @param id_produit
	 */
	public void selectionnerProduitByNameService(int id_produit);
	
	
	/**
	 * Methode pour retourner la liste des produits selectionn�s
	 * @return liste des produits selectionn�s
	 */
	public List<Produit> getAllProduitSelectionneService();
	
	
	
	/**
	 * Methode pour ajouter dans la base de donn�es la commande et le client
	 * @param client
	 * @return un entier qui nous v�rifie le bon fontionnement de la m�thode
	 */
	public int EnregistrerClientCommandeService(Client client);
	
	
	/**
	 * Methode pour chercher un produit avec un mot cl�
	 * @param motCle
	 * @return la liste des produits correspondants � ce mot cl�
	 */
	public List<Produit> chercherProduitMotCleService(String motCle);
	
	
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
	

	/**
	 * Methode qui remet les valeurs des bool�ens � false dans la base de donn�es
	 */
	public void remiseZeroSelectionneService();
	
}
