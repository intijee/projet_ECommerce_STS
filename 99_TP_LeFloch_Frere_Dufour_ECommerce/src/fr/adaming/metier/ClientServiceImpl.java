package fr.adaming.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Produit;

@Stateful
public class ClientServiceImpl implements IClientService {

	@EJB
	IClientDao clientDao;
	
	
	@Override
	public List<Categorie> getAllCategorieService() {
		return clientDao.getAllCategorie();
	}

	@Override
	public List<Produit> getAllProduitCategorieService(Categorie categorie) {
		
		return clientDao.getAllProduitByCategorie(categorie);
	}

	@Override
	public void selectionnerProduitByNameService(String designation_produit) {
		
		clientDao.selectionnerProduitByName(designation_produit);
	}

	@Override
	public List<Produit> getAllProduitSelectionneService() {
		
		return clientDao.getAllProduitSelectionne();
	}


	@Override
	public int EnregistrerClientCommandeService(Client client) {
		
		return clientDao.EnregistrerClientCommande(client);
		
	}

	@Override
	public List<Produit> chercherProduitMotCleService(String motCle) {
		
		return clientDao.chercherProduitMotCle(motCle);
	}

	@Override
	public Categorie getCategorieByNameService(String nom_categorie) {
		
		return clientDao.getCategorieByName(nom_categorie);
	}

	@Override
	public List<String> getAllCategorieNameService() {
	
		return clientDao.getAllCategorieName();
	}

	@Override
	public List<String> getAllProduitNameService() {
		
		return clientDao.getAllProduitName();
	}

}
