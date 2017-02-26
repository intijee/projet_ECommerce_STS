package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;
import fr.adaming.metier.IAdminService;
import fr.adaming.metier.IClientService;

@ManagedBean
@ViewScoped
public class ClientManagedBean implements Serializable {

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

	// Attribut de type catégorie pour recuperer les informations d'une
	// catégorie
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

	// Recupere la liste des lignes de commande
	private List<LigneCommande> listeLigneCommande;

	// Creation d'un objet de type Panier
	private Panier panier;

	// Creation d'un objet de type ligne de commande
	private LigneCommande ligneCom;

	// Creation d'un objet de type Commande
	private Commande commande;

	// Recupère un nom de catégorie pour retrouver une catégorie
	private String nomCategorie = new String();

	// Recupère un nom de produit pour retrouver un produit
	private String nomProduit = new String();
	
	// Recupère la liste des commandes d'un client
	private List<Commande> listeCommandeClient;

	// Recupère le mot clé pour retrouver le nom d'un produit
	private String motCle = new String();

	// Recupère l'index des lignes de commande du panier
	private int index;

	// Constructeur vide
	public ClientManagedBean() {
		this.client = new Client();
		this.categorie = new Categorie();
		this.produit = new Produit();
		this.ligneCom=new LigneCommande();
	}

	// getter et setter
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}

	/**
	 * @param produit the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	/**
	 * @return the listeCategorie
	 */
	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	/**
	 * @param listeCategorie the listeCategorie to set
	 */
	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	/**
	 * @return the listeProduit
	 */
	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	/**
	 * @param listeProduit the listeProduit to set
	 */
	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	/**
	 * @return the listeNomCategorie
	 */
	public List<String> getListeNomCategorie() {
		return listeNomCategorie;
	}

	/**
	 * @param listeNomCategorie the listeNomCategorie to set
	 */
	public void setListeNomCategorie(List<String> listeNomCategorie) {
		this.listeNomCategorie = listeNomCategorie;
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
	 * @return the nomCategorie
	 */
	public String getNomCategorie() {
		return nomCategorie;
	}

	/**
	 * @param nomCategorie the nomCategorie to set
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
	 * @param nomProduit the nomProduit to set
	 */
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	/**
	 * @return the motCle
	 */
	public String getMotCle() {
		return motCle;
	}

	/**
	 * @param motCle the motCle to set
	 */
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the panier
	 */
	public Panier getPanier() {
		return panier;
	}

	/**
	 * @param panier
	 *            the panier to set
	 */
	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	/**
	 * @return the ligneCom
	 */
	public LigneCommande getLigneCom() {
		return ligneCom;
	}

	/**
	 * @param ligneCom
	 *            the ligneCom to set
	 */
	public void setLigneCom(LigneCommande ligneCom) {
		this.ligneCom = ligneCom;
	}

	/**
	 * @return the commande
	 */
	public Commande getCommande() {
		return commande;
	}

	/**
	 * @param commande
	 *            the commande to set
	 */
	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	/**
	 * @return the listeLigneCommande
	 */
	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommande;
	}

	/**
	 * @param listeLigneCommande
	 *            the listeLigneCommande to set
	 */
	public void setListeLigneCommande(List<LigneCommande> listeLigneCommande) {
		this.listeLigneCommande = listeLigneCommande;
	}

	
	/**
	 * @return the listeCommandeClient
	 */
	public List<Commande> getListeCommandeClient() {
		return listeCommandeClient;
	}

	/**
	 * @param listeCommandeClient the listeCommandeClient to set
	 */
	public void setListeCommandeClient(List<Commande> listeCommandeClient) {
		this.listeCommandeClient = listeCommandeClient;
	}

	// Les méthodes du managedBean Client --------------
	@PostConstruct
	public void remplirListe() {

		// Remplissage de la liste des catégories
		this.listeCategorie = clientService.getAllCategorieService();

		this.listeNomCategorie = clientService.getAllCategorieNameService();

		this.listeNomProduit = clientService.getAllProduitNameService();

	}

	/**
	 * Methode pour recuperer tous les produits d'une catégorie donnée
	 */
	public void getProduitByCategorie() {

		// on récupére une catégorie par le nom de sa catégorie
		this.categorie = clientService.getCategorieByNameService(nomCategorie);

		// on récupére une liste de produit correspondant à la catégorie
		this.listeProduit = clientService.getAllProduitCategorieService(categorie);
	}

	/**
	 * Methode pour selectionner un produit (ajouter à une liste de produits
	 * sélectionnées)
	 */
	public void selectionnerProduit() {

		clientService.selectionnerProduitByNameService(nomProduit);

	}

	/**
	 * Methode pour recuperer la liste des produits selectionnés
	 * (selectionne=true)
	 */
	public void afficherProduitSelectionner() {

		this.listeProduit = clientService.getAllProduitSelectionneService();

	}

	/**
	 * Methode pour recuperer un produit à partir d'un mot clé (le début de son
	 * nom)
	 */
	public void chercherProduitByMotCle() {

		listeProduit = clientService.chercherProduitMotCleService(motCle);

	}

	/**
	 * Methode pour ajouter un produit au panier 
	 */
	public void ajouterProduitPanier() {

		// Recuperation d'un produit à partir du nom envoyé par la page
		this.produit = adminService.chercherProduitByNameService(nomProduit);

		// On associe a une ligne de commande son produit
		ligneCom.setpProduit(produit);

		// On calcule le prix en fonction de la quantité et du prix du produit
		long prix = produit.getPrix() * ligneCom.getQuantite();
		
		// On donne son prix a la ligne de commande
		ligneCom.setPrix(prix);

		// On ajoute la ligne de commande à une liste
		listeLigneCommande.add(ligneCom);
		
		// On associe cette liste au panier
		panier.setListeLigneCommandes(listeLigneCommande);

	}

	/**
	 * Methode pour supprimer un produit du panier avec son index
	 */
	public void supprimerProduitPanier() {

		listeLigneCommande.remove(index);

	}

	/**
	 * Methode pour enregistrer un client (sa commande, et les lignes de
	 * commande grâce au cascadeType)
	 * 
	 * @return un string qui détermine la réussite ou non de l'enregistrement
	 */
	public String enregistrerClientCommandes() {
		
		commande.setListeLignesCommandes(listeLigneCommande);
		
		listeCommandeClient.add(commande);
		
		client.setListeCommandes(listeCommandeClient);
		
		int verif = clientService.EnregistrerClientCommandeService(client);

		if (verif == 1) {
			return "succesEnregistrer";

		} else {
			return "echecEnregistrer";
		}
	}

}
