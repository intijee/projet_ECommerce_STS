package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;
import fr.adaming.metier.IAdminService;
import fr.adaming.metier.IClientService;

@ManagedBean
@ViewScoped
public class ClientManagedBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	// Creation d'un objet de type ClientService pour utiliser sa méthode qui
	// recupère toutes les catégories
	@EJB
	private IClientService clientService;
	
	// Creation d'un objet de type AdminService pour utiliser ses méthodes
	@EJB
	private IAdminService adminService;
	
	
	// Attribut de type client pour recuperer les informations d'un client
	private Client client;
	
	// Attribut de type catégorie pour recuperer les informations d'une catégorie
	private Categorie categorie;
	
	// Attribut de type produits pour recuperer les informations d'un produit
	private Produit produit;
	
	// Recupere la liste des catégories
	private List<Categorie> listeCategorie;
	
	// Recupere la liste des catégories
	private List<Produit> listeProduit;

	// Recupere la liste des noms des catégories
	private List<String> listeNomCategorie;
	
	// Recupere la liste des noms des produits
	private List<String> listeNomProduit;
	
	
	// Recupère un nom de catégorie pour retrouver une catégorie 
	private String nomCategorie = new String();
	
	// Recupère un nom de produit pour retrouver un produit
	private String nomProduit = new String();
	
	// Recupère le mot clé pour retrouver le nom d'un produit
	private String motCle = new String();


	//Constructeur vide 
	public ClientManagedBean() {
		this.client= new Client();
		this.categorie= new Categorie();
		this.produit= new Produit();
	}
	
	//getter et setter
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}



	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}
	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	
	public List<String> getListeNomCategorie() {
		return listeNomCategorie;
	}
	public void setListeNomCategorie(List<String> listeNomCategorie) {
		this.listeNomCategorie = listeNomCategorie;
	}


	public List<String> getListeNomProduit() {
		return listeNomProduit;
	}
	public void setListeNomProduit(List<String> listeNomProduit) {
		this.listeNomProduit = listeNomProduit;
	}
	

	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	
	public List<Produit> getListeProduit() {
		return listeProduit;
	}
	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	
	
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	
	
	
	//Les méthodes du managedBean Client --------------
	
	public void afficherTouteLesCategorie(){
	
	// Remplissage de la liste des catégories
	this.listeCategorie = clientService.getAllCategorieService();

	this.listeNomCategorie = clientService.getAllCategorieNameService();	
	
	}


	public void getProduitByCategorie(){
		
	// on récupére une catégorie par le nom de sa catégorie
	this.categorie = clientService.getCategorieByNameService(nomCategorie);
		
	//on récupére une liste de produit correspondant à la catégorie
	this.listeProduit = clientService.getAllProduitCategorieService(categorie);
	}
	
	
	public void selectionnerProduit(){
		
	clientService.selectionnerProduitByNameService(nomProduit);
	
	//pas besoin de donner le produit par le nom????
	}
	
	public void afficherProduitSelectionner(){
	
	this.listeProduit = clientService.getAllProduitSelectionneService();
		
	}
	
	public void chercherProduitByMotCle(){
			
	this.produit = clientService.chercherProduitMotCleService(motCle);
	}
	
	public void ajouterProduitPanier(){
	
	}
	
	public void supprimerProduitPanier(){
	
		
		
	}
	
	public String enregistrerClientCommandes(){
		
	int verif= clientService.EnregistrerClientCommandeService(client);
	
		if (verif == 1) {
			return "succesEnregistrer";
		
		} else {
			return "echecEnregistrer";
		}
	}
	
}
