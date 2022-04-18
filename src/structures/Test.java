package structures;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.println("*****************************************************************************************");
		System.out.println("*****************************************************************************************");
		System.out
				.println("**************************/  OPERATIONS SUR LES GRAPHES  /*********************************");
		System.out.println("*****************************************************************************************");
		System.out.println("*****************************************************************************************");
		System.out.println("\n \t \t \t \t DONNNEZ-MOI VOTRE GRAPHE \n");
		System.out.println("COMBIEN DE SOMMETS COMPORTERA VOTRE GRAPHE ?");
		Scanner saisie = new Scanner(System.in);
		int nombreSommet = saisie.nextInt();
		Sommet[] tabSommet = new Sommet[nombreSommet];
		for (int i = 0; i < nombreSommet; i++) {
			tabSommet[i] = new Sommet(i, 0);
		}
		Matrice matrice = new Matrice(nombreSommet);

		matrice.saisie();


		
		  Graphe graphe = new Graphe(nombreSommet,tabSommet,matrice); 
	int option =0;	  

do {
			  
			  System.out.println("\n\t\t1. AFFICHER LA MATRICE D'ADJACENCE \n\n" 
			  			+"\t\t2. FAIRE UN PARCOURS EN PROFONDEUR A PARTIR D'UN SOMMET \n\n" 
			  			+"\t\t3. FAIRE UN PARCOURS EN LARGEUR A PARTIR D'UN SOMMET \n\n" 
			  			+"\t\t4. VIFIER S'IL Y A UN CHEMIN ENTRE DEUX SOMMETS \n\n"
			  			+"\t\t5. VISITER LES VOISINS D'UN SOMMET DONNE \n\n" 
			  			+"\t\t6. QUITTER L'APPLICATION \n"); 

	   option =saisie.nextInt(); 
	  switch (option) {
	case 1:
		matrice.afficher();
		break;
	case 2 : 
		System.out.println("QUEL EST LE SOMMET EN A PARTIR DUQUEL IL FAUT PARCOURIR ?");	
		int sommet = saisie.nextInt();
		graphe.parcoursProfondeur(sommet);
		System.out.print("\n\t\t LES SOMMETS ");
		for (Sommet s : tabSommet) {
			if(s.getMarque()==1) 
				{
					System.out.print("\t"+s.getEtiquette());
				}
		}
		System.out.print("\tSONT VISITES\n\n");
		for (Sommet somm : tabSommet) somm.setMarque(0);
		break;
	case 3 :
		System.out.println("QUEL EST LE SOMMET EN A PARTIR DUQUEL IL FAUT PARCOURIR ?\n");	
		int S = saisie.nextInt();
		graphe.parcoursLargeur(S);
		System.out.print("\n\t\t LES SOMMETS ");
		for (Sommet s : tabSommet) {
			if(s.getMarque()==1) 
				{
					System.out.print("\t"+s.getEtiquette());
				}
		}
		System.out.print("\tSONT VISITES\n\n");
		for (Sommet somm : tabSommet) somm.setMarque(0);
		break;
	case 4 :
		System.out.println("\tQUEL EST LE PREMIER SOMMET ?");
		int S1 = saisie.nextInt();
		System.out.println("\tQUEL EST LE SECOND SOMMET ?");
		int S2 = saisie.nextInt();
		if (graphe.estChemin(S1, S2)==1) System.out.println("\tIL Y A BIEN CHEMIN ENTRE LE SOMMET "+S1+" ET LE SOMMET "+S2+"\n"); 
		else System.out.println("\tIL N' Y A PAS DE CHEMIN ENTRE LE SOMMET "+S1+" ET LE SOMMET "+S2+"\n");
		for (Sommet somm : tabSommet) somm.setMarque(0);
		break;
	case 5 : 
		System.out.println("QUEL EST LE SOMMET EN QUESTION ?\n");
		int S3 = saisie.nextInt();
		graphe.visiterVoisins(S3);
		System.out.print("\n\t\t LES SOMMETS ");
		for (Sommet s : tabSommet) {
			if(s.getMarque()==1) 
				{
					System.out.print("\t"+s.getEtiquette());
				}
		}
		System.out.print("\tSONT VISITES\n\n");
		for (Sommet somm : tabSommet) somm.setMarque(0);
		break;
	case 6 : 
		System.out.println("\tAUREVOIR !!! "); 
	break;
	
	default:
		System.out.println("\tDESOLE, JE N'AI PAS CETTE OPTION \n");
		break;
	}
			
} while (option!=6);
		 
		 

		/*
		 * Matrice matrice = new Matrice(3); matrice.saisie(); matrice.afficher();
		 * Sommet s0 = new Sommet(0, 0); Sommet s1 = new Sommet(1, 0); Sommet s2 = new
		 * Sommet(2, 0); Sommet s3 = new Sommet(3, 0); Sommet[] tabSommet =
		 * {s0,s1,s2,s3}; Graphe graphe = new Graphe(3, tabSommet, matrice);
		 * graphe.parcoursProfondeur(s2.getEtiquette());
		 * graphe.parcoursLargeur(s0.getEtiquette());
		 * 
		 * graphe.visiterVoisins(s2.getEtiquette()); for (Sommet sommet : tabSommet) {
		 * if (sommet.getMarque()==1) {
		 * System.out.println("Le sommet "+sommet.getEtiquette()+" est visité"); } }
		 * 
		 * 
		 * 
		 * 
		 * for (Sommet sommet : tabSommet) { System.out.println(sommet.getEtiquette());
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * if(graphe.estChemin(s0.getEtiquette(), s2.getEtiquette())==1)
		 * System.out.println("Il y a un chemin entre " +s0.getEtiquette()
		 * +"  et "+s2.getEtiquette());
		 * 
		 * 
		 */

	}

}

