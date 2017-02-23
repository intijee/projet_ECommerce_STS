package fr.adaming.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator")
public class ValidatorChampVide implements Validator {
	// Pour �tre un validator il doit impl�menter l'interface validator et je
	// dois le d�clarer dans face config ou avec une annotation



	@Override
	public void validate(FacesContext context, UIComponent composant,
			Object valeur) throws ValidatorException {

		String saisie = (String) valeur;

		if (saisie.equals("")) {
			
			try {
				// Cr�er un exception si le mail ne contient pas d'arobase
				throw new Exception("Le champ ne peut pas �tre vide");
				
			} catch (Exception e) {
				
				// L'objet de type Faces Message sert de bus pour transporter les messages d'erreur vers la Facelet
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}

	}

}