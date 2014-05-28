package fr.treeptik.action;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Commande;
import fr.treeptik.service.CommandeService;

public class SessionManager {
	
	private static Commande commande;
	private static CommandeService commandeService;

	public static Commande getCommande() {
		return commande;
	}

	public static void setCommande(Commande c) {
		commande = c;
	}
	
	public static Commande getCommandeById(Integer id) throws ServiceException {
		commande = commandeService.findById(id);
		return commande;
	}
	
	public static void setCommandeId(Integer id) throws ServiceException {
		commande = commandeService.findById(id);
	}
}
