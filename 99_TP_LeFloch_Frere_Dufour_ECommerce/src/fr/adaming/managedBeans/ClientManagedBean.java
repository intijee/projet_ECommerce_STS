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
	
	// Creation d'un objet de type ClientService pour utiliser sa m�thode qui
	// recup�re toutes les cat�gories
	@EJB
	private IClientService clientService;
	
	// Creation d'un objet de type AdminService pour utiliser ses m�thodes
	@EJB
	private IAdminService adminService;
	
	
	// Attribut de type client pour recuperer les informations d'un client
	private Client client;
	
	// Attribut de type cat�gorie pour recuperer les informations d'une cat�gorie
	private Categorie categorie;
	
	// Attribut de type produits pour recuperer les informations d'un produit
	private Produit produit;
	
	// Recupere la liste des cat�gories
	private List<Categorie> listeCategorie;
	
	// Recupere la liste des cat�gories
	private List<Produit> listeProduit;

	// Recupere la liste des noms des cat�gories
	private List<String> listeNomCategorie;
	
	// Recupere la liste des noms des produits
	private List<String> listeNomProduit;
	
	
	// Recup�re un nom de cat�gorie pour retrouver une cat�gorie 
	private String nomCategorie = new String();
	
	// Recup�re un nom de produit pour retrouver un produit
	private String nomProduit = new String();
	
	// Recup�re le mot cl� pour retrouver le nom d'un produit
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
	
	
	
	//Les m�thodes du managedBean Client --------------
	
	public void afficherTouteLesCategorie(){
	
	// Remplissage de la liste des cat�gories
	this.listeCategorie = clientService.getAllCategorieService();

	this.listeNomCategorie = clientService.getAllCategorieNameService();	
	
	}


	public void getProduitByCategorie(){
		
	// on r�cup�re une cat�gorie par le nom de sa cat�gorie
	this.categorie = clientService.getCategorieByNameService(nomCategorie);
		
	//on r�cup�re une liste de produit correspondant � la cat�gorie
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
