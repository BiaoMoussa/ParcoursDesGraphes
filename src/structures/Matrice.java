package structures;

import java.util.Scanner;

public class Matrice {
	private int taille;
	private int[][] matrice = new int[400][400];
	public Matrice(int taille) {
		super();
		this.taille = taille;
	}

	public int[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(int[][] matrice) {
		this.matrice = matrice;
	}

	public Matrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public void saisie() {
		 Scanner saisie =new Scanner(System.in);
			for (int i = 0; i <taille; i++) {
				for (int j = 0; j < taille; j++) {
					System.out.println("Existe-t-il un arc du sommet "+i+" vers le sommet "+j+" ? Si oui 1 sinon 0");
					System.out.println(" ");
					int temp = saisie.nextInt();
					if((temp==0)||(temp==1)) matrice[i][j] = temp; 
				}
			}
		/* saisie.close(); */
	}
	
	public void afficher() {
		System.out.println("\t\t***LA MATRICE D'ADJACENCE*** \n");
		for (int j = 0; j < taille; j++) 
			 System.out.print("     "+j +" ");
		System.out.println(" ");
		System.out.println(" ");
		for (int i = 0; i < taille; i++) {
			System.out.print(+i);
			for (int j = 0; j < taille; j++) {
				System.out.print("    "+matrice[i][j]+"  ");
			}
			System.out.println("");
			System.out.println("");
		}
		
	}
}
