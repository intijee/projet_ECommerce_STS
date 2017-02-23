package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jboss.resteasy.spi.touri.MappedBy;

/**
 * Classe qui repr�sente les produits du magasin. Les produits sont stock�s dans
 * la table produits
 *
 */
@Entity
@Table(name = "produits")
public class Produit implements Serializable{
	
	

	private static final long serialVersionUID = 1L;

	// Cl� primaire de la classe Produit
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produit")
	private int id;

	private String designation;
	private String description;
	private long prix;
	private int quantite;

	// Pour savoir si le produit est s�lectionnn� ou non
	private boolean selectionne;

	// Attribut qui lie un produit � sa cat�gorie
	@ManyToOne
	@JoinColumn(name = "categorie_id_fk", referencedColumnName = "id_categorie")
	private Categorie pCategorie;

	// Attribut qui lie un produit � une ligne de commande
	@OneToMany(mappedBy="pProduit")
	// D�finition d'une liste de lignes de commande auquel le produit appartient
	private List<LigneCommande> listeLigneCommande;


	// Constructeur vide
	public Produit() {
		super();
	}

	// Constructeur avec param�tre sans id
	public Produit(String designation, String description, long prix, int quantite, boolean selectionne) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
	}

	// Constructeur avec id
	public Produit(int id, String designation, String description, long prix, int quantite, boolean selectionne) {
		super();
		this.id = id;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
	}

	// Getter et setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	
	
	// Getter et setter pour associer un produit � sa cat�gorie
	public Categorie getpCategorie() {
		return pCategorie;
	}

	public void setpCategorie(Categorie pCategorie) {
		this.pCategorie = pCategorie;
	}

	
	// Getter et setter pour associer un produit � une ou plusieurs lignes de commande
	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommande;
	}

	public void setListeLigneCommande(List<LigneCommande> listeLigneCommande) {
		this.listeLigneCommande = listeLigneCommande;
	}
	


	// Red�finition de toString
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", description=" + description + ", prix=" + prix
				+ ", quantite=" + quantite + ", selectionne=" + selectionne + "]";
	}

	

}
