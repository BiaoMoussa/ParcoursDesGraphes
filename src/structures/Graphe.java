package structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graphe {
	private int n ; //nombre de sommets du graphe
	private Sommet[] tabSommet = new Sommet[n] ;
	private Matrice matrice;
	
	
	
	public Graphe(int n, Sommet[] tabSommet, Matrice matrice) {
		super();
		this.n = n;
		this.tabSommet = tabSommet;
		this.matrice = matrice;
	}
	
	public Graphe() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public Sommet[] getTabSommet() {
		return tabSommet;
	}

	public void setTabSommet(Sommet[] tabSommet) {
		this.tabSommet = tabSommet;
	}

	public Matrice getMatrice() {
		return matrice;
	}

	public void setMatrice(Matrice matrice) {
		this.matrice = matrice;
	}
	//les méthodes
	
	//la méthode visiter
	public void visiter(int sommetDepart) {
		tabSommet[sommetDepart].setMarque(1);
		for (int i = 0; i < tabSommet.length; i++) {
			if ((tabSommet[i].getMarque()==0) && (matrice.getMatrice()[sommetDepart][i]==1)) visiter(i);
		}
	}
	
	//la méthode visiterVoisins
	public void visiterVoisins(int sommet) {
		for (int i = 0; i < tabSommet.length; i++) {
			tabSommet[i].setMarque(0);
		}
		tabSommet[sommet].setMarque(1);
		for (int i = 0; i < tabSommet.length; i++) {
			if((tabSommet[i].getMarque()==0) && (matrice.getMatrice()[sommet][i]==1)) tabSommet[i].setMarque(1);
		}
	}
	
	
	
	//la méthode parcoursProfondeur
	
	public void parcoursProfondeur(int sommetDepart) {
		//on marque tous les sommets à 0
		
		for (Sommet som : tabSommet) {
			som.setMarque(0);
		}
		
		//on visite ensuite les sommets
		visiter(sommetDepart);
	}
	
	//la méthode parcoursLargeur
	public ArrayList<Sommet> parcoursLargeur(int sommetDepart) {
			ArrayList<Sommet> listSommet = new ArrayList<Sommet>();
			for (int i = 0; i < n; i++) tabSommet[sommetDepart].setMarque(0);
			tabSommet[sommetDepart].setMarque(1);
			listSommet.add(tabSommet[sommetDepart]);
			ArrayList<Sommet> listSommetResultat= new ArrayList<Sommet>();
			listSommetResultat.add(tabSommet[sommetDepart]);
			for (int i = 0; i < tabSommet.length; i++) {
				if((tabSommet[i].getMarque()==0) &&(matrice.getMatrice()[sommetDepart][i]==1)) {
					visiterVoisins(i);
					if(tabSommet[i].getMarque()==1) listSommet.add(tabSommet[i]);
				}
			}
			// Cette bouble permet  d'ordonner les sommets par leur ordre de visite...
			for (Sommet sommet : listSommet) {
				listSommetResultat.add(sommet);
			}
			
			return listSommetResultat;
	}
	
	
	
	//la méthode visterChemin
	public int visiterChemin(int sommetDepart, int sommetArrivee) {
		/*
		 * methode pour parcourir les chemins d'un sommet de dépat vers un sommet d'arriver, elle renvoir un entier...
		 * */
		//on marque le départ à 1
		tabSommet[sommetDepart].setMarque(1);
		if(sommetDepart==sommetArrivee) // si le depart et l'arrivée son confondu => il existe un chemin => on retourne donc 1
		 return 1;
		for (int i = 0; i < n; i++) {
			// "s'il existe un chemin entre le depart et sommet i" et "et si le sommet i n'a pas été visiter" 
			//alors on fait un parcours en profondeur  à partir du sommet i
			// s'il existe un chemin entre le sommet de départ et le sommet d'arrivée, le sommet d'arrivée sera marqué à 1
			//sinon il sera marqué à 0
			if ((matrice.getMatrice()[sommetDepart][i]==1) && (tabSommet[i].getMarque()==0)) {
				parcoursProfondeur(i);
			}
		}
		return tabSommet[sommetArrivee].getMarque();//on recupère la marque du sommet d'arrivée
		
	}
	
	public int estChemin(int sommetDepart, int sommetArrivee) {
		/*
		 * Méthode pour savoir s'il existe un chemin entre un sommet départ et un sommet d'arrivée
		 */
		// On marque tous les sommets à 0
		for (Sommet sommet : tabSommet) {
			sommet.setMarque(0);
		}
		return visiterChemin(sommetDepart, sommetArrivee);
	}
	
 
}
