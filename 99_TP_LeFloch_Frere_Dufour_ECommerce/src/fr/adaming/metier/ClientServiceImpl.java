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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectionnerProduitByNameService(String designation_produit) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Produit> getAllProduitSelectionneService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit ajouterProduitPanierByNameService(String designation_produit,int quantite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit supprimerProduitPanierByIdService(int indexProduit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int EnregistrerClientCommandeService(Client client, Commande commande) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Produit chercherProduitMotCleService(String motCle) {
		// TODO Auto-generated method stub
		return null;
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
