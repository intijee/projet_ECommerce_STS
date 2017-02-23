package fr.adaming.metier;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;


/**
 * Interface qui d�finit les signatures des m�thodes pour la couche Metier
 *
 */
@Local
public interface IAdminService {
	

	
	/**
	 * Methode g�rant la connexion pour un admin
	 * @param admin
	 * @return un entier qui v�rifie l'existence d'un admin ou non 
	 */
	public int isExistService(Admin admin);


	/**
	 * M�thode pour ajouter un produit dans la base de donn�es
	 * @param produit
	 * @return un entier pour savoir si l'ajout a reussi
	 */
	public int ajouterProduitService(Produit produit);
	

	/**
	 * M�thode pour supprimer un produit dans la base de donn�es
	 * @param produit
	 * @return un entier pour savoir si la suppression a reussi
	 */
	public int supprimerProduitByNameService(Produit produit);
	

	/**
	 * M�thode pour modifier un produit dans la base de donn�es
	 * @param id_produit pour trouver le produit a modifier
	 * @param produit qui contient les nouvelles informations du produit
	 * @return un entier pour savoir si la modification a reussi
	 */
	public int modifierProduitService(int id_produit, Produit produit);
	

	/**
	 * M�thode pour consulter l'�tat d'un produit
	 * @param designation_produit
	 * @return le produit trouv� (si il existe)
	 */
	public Produit chercherProduitByNameService(String designation_produit);
	

	/**
	 * Methode pour consulter tous les produits
	 * @return la liste des produits de la base de donn�es
	 */
	public List<Produit> getAllProduitService();

}
