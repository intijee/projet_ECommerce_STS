package fr.adaming.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;


/**
 * Classe qui sert à implementer les règles de gestion pour les méthodes de l'Admin
 *
 */
@Stateful
public class AdminServiceImpl implements IAdminService {

	// Instanciation d'un objet de type AdminDao pour utliser ses méthodes à partir de son interface
	@EJB
	IAdminDao adminDao;
	
	@Override
	public int isExistService(Admin admin) {
		
		return adminDao.isExist(admin);
		
	}
	
	@Override
	public int ajouterProduitService(Produit produit) {
		
		return adminDao.ajouterProduit(produit);
	}

	@Override
	public int supprimerProduitByNameService(Produit produit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifierProduitService(int id_produit, Produit produit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Produit chercherProduitByNameService(String designation_produit) {
		return adminDao.chercherProduitByName(designation_produit);
	}

	@Override
	public List<Produit> getAllProduitService() {
		// TODO Auto-generated method stub
		return null;
	}



}
