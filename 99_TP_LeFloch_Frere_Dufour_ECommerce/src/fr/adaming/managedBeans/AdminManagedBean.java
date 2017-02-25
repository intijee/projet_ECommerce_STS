package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.metier.IAdminService;
import fr.adaming.metier.IClientService;

@ManagedBean
@ViewScoped
public class AdminManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Attribut de type admin pour recuperer les informations d'un admin
	private Admin admin;

	// Attribut de type Produit pour recuperer ses informations ou les envoyer
	// dans la base de données
	private Produit produit;

	// Creation d'un objet de type AdminService pour utiliser ses méthodes
	@EJB
	private IAdminService adminService;

	// Creation d'un objet de type ClientService pour utiliser sa méthode qui
	// recupère toutes les catégories
	@EJB
	private IClientService clientService;

	// Recupere la liste des catégories
	private List<Categorie> listeCategorie;

	// Recupere la liste des noms des catégories
	private List<String> listeNomCategorie;

	// Attribut qui recupere la catégorie du produit à ajouter
	private Categorie categorie;

	// Recupère un nom de catégorie pour retrouver une catégorie (ajout d'un
	// produit)
	private String nomCategorie = new String();
	
	// Recupere la liste des noms des produits
		private List<String> listeNomProduit;
		
	// Recupère le nom d'un produit depuis la vue
	private String nomProduit;

	// Boolean pour afficher le tableau uniquement la recherche effectuée dans
	// les méthodes chercher
	private boolean rendu;
	
	//récupére l'id du produit
	private int id_produit;

	// Constructeur vide
	public AdminManagedBean() {
		super();
		this.admin = new Admin();
		this.produit = new Produit();
		this.categorie = new Categorie();
		this.id_produit= new Produit().getId();
		
	}

	// Getter et setter
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	// Getter et setter pour le produit
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	// Getter et setter pour la liste des catégories
	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the listeNomCategorie
	 */
	public List<String> getListeNomCategorie() {
		return listeNomCategorie;
	}

	/**
	 * @param listeNomCategorie
	 *            the listeNomCategorie to set
	 */
	public void setListeNomCategorie(List<String> listeNomCategorie) {
		this.listeNomCategorie = listeNomCategorie;
	}

	/**
	 * @return the nomCategorie
	 */
	public String getNomCategorie() {
		return nomCategorie;
	}

	/**
	 * @param nomCategorie
	 *            the nomCategorie to set
	 */
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	/**
	 * @return the nomProduit
	 */
	public String getNomProduit() {
		return nomProduit;
	}

	/**
	 * @param nomProduit
	 *            the nomProduit to set
	 */
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	
	

	/**
	 * @return the listeNomProduit
	 */
	public List<String> getListeNomProduit() {
		return listeNomProduit;
	}

	/**
	 * @param listeNomProduit the listeNomProduit to set
	 */
	public void setListeNomProduit(List<String> listeNomProduit) {
		this.listeNomProduit = listeNomProduit;
	}

	/**
	 * @return the rendu
	 */
	public boolean isRendu() {
		return rendu;
	}

	/**
	 * @param rendu
	 *            the rendu to set
	 */
	public void setRendu(boolean rendu) {
		this.rendu = rendu;
	}
	
	
	/**
	 * @return id_produit
	 */
	public int getId_produit() {
		return id_produit;
	}
	
	/**
	 * @param id_produit
	 *            the id_produit to set
	 */
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	/**
	 * Methode déclenché après l'instanciation d'un AdminManagedBean qui
	 * recupère la liste des catégories pour ensuite assigner la bonne catégorie
	 * lorsqu'on ajoute un produit
	 */
	@PostConstruct
	public void getAllCategories() {
		// Remplissage de la liste des catégories
		this.listeCategorie = clientService.getAllCategorieService();

		// Remplissage de la liste des catégories
		this.listeNomCategorie = clientService.getAllCategorieNameService();
		
		// Remplissage de la liste des noms des produits
		this.listeNomProduit=clientService.getAllProduitNameService();
	}

	/**
	 * Methode gérant les informations de connexion pour un admin
	 * 
	 * @return un String qui permet de rediriger sur un page en fonction de a
	 *         réussite ou non
	 */
	public String connecter() {

		// On recupere le retour de la méthode isExist de l'admin
		int verif = adminService.isExistService(admin);

		// Si le retour est 1, alors un admin existe
		if (verif == 0) {
			return "echecAdmin";
		} else {
			return "succesAdmin";
		}
	}

	/**
	 * Methode pour ajouter un produit à la base de données
	 * 
	 * @return un string afin d'effectuer la redirection
	 */
	public String ajouterProduit() {

		// Recupération de la catégorie avec son nom
		this.categorie = clientService.getCategorieByNameService(this.nomCategorie);

		// On associe sa catégorie au produit
		produit.setpCategorie(this.categorie);

		// Si le retour est 1 alors on a reussi
		int verif = adminService.ajouterProduitService(this.produit);

		if (verif == 1) {
			return "succesAdmin";
			
		} else {
			return "echecAdmin";
		}
		
	}

	/**
	 * Methode pour chercher un produit à l'aide de son nom
	 */
	public void chercherProduitByName() {

		this.produit = adminService.chercherProduitByNameService(nomProduit);
		this.rendu = true;
		
	}
	
	/**
	 * Methode permettant à l'admin de supprimer un produit de la base de données 
	 * 
	 * @return un string afin d'effectuer la redirection
	 */
	public String supprimerProduit(){
		
		//Rechercher un produit par son nom
		this.produit= adminService.chercherProduitByNameService(nomProduit);
		
		// Si le retour est 1 alors on a supprimé le produit et on retourne sur page accueil admin
		int verif = adminService.supprimerProduitByNameService(this.produit);

		if (verif == 1) {
			return "succesAdmin";
			
		} else {
			return "echecAdmin";
		}
		
	}
	
	/**
	 * Methode permettant à l'admin de modifier un produit de la base de données 
	 * 
	 * @return un string afin d'effectuer la redirection
	 */
	public String modifierProduit(){
		
		
		// Si le retour est 1 alors on a supprimé le produit et on retourne sur page accueil admin
		int verif = adminService.modifierProduitService(this.id_produit, this.produit);

		if (verif == 1) {
			return "succesAdmin";
			
		} else {
			return "echecAdmin";
		}
	}
}
