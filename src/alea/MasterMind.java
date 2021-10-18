package alea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MasterMind {
	
	private static final char OK = 'O';
    private static final char FAUX = 'X';

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner (System.in);
		Scanner sc2 = new Scanner (System.in);
        final int NB_CHAR = 4; // on pourrait aussi demander à l'utilisateur
        
        final int ESSAIS_MAX = 10;
 
        Set<Character> solution = new HashSet<Character>();
 
        Random r = new Random();
        while(solution.size() < NB_CHAR) {	
        	final char couleur = (char)(r.nextInt(12) + 65);
        	solution.add(couleur);  	
        	System.out.println(couleur);
        }
        
        System.out.println(solution);
        System.out.println(solution.size());
        
        //System.out.println(set);
 
        int count = 0;
 
        System.out.println("Mastermind, trouve la combinaison des " + NB_CHAR + " caractères de A à L où chaque caractère représente une couleur.");
        System.out.println("Voici les 12 couleurs :\n");
        System.out.println(" - A = Acajou \n - B = Brique \n - C = Cyan \n - D = Denim \n - E = Ecru \n - F = Fuchsia \n - G = Gris \n - H = Havane \n - I = Indigo \n - J = Jaune \n - K = Kola \n - L = Lavande \n");
        System.out.println( OK + " signifie que c'est le bon caractère à la bonne place et " + FAUX + " signifie que c'est le mauvais caractère.");
        System.out.print("Avant de commencer, choisir le niveau de difficulté (1=Facile, 2=Difficile) : ");
        int difficulté = sc1.nextInt();
        System.out.println();
        if(difficulté==1) {
        	System.out.println("Vous avez choisi le niveau Facile. \nVous devez deviner les 4 couleurs mais pas nécessairement dans le bon ordre.\n");
        }
        else if(difficulté==2) {
        	System.out.println("Vous avez choisi le niveau Difficile. \nDans ce cas, Vous devez trouver les 4 couleurs à la bonne position chacune.\n");
        }
        System.out.println("Attention, vous avez droit a " + ESSAIS_MAX + " essais. Bonne chance.");
        System.out.println("----------------------------");
 
 
        List<Character> caracteres = new ArrayList<Character>();
        boolean victoire = false;
        do {
            System.out.print("\nEssai n° " + (count+1) + "/" + ESSAIS_MAX + " : ");
            String charSaisi = sc2.nextLine();
            for(int i=0 ; i<NB_CHAR ; i++) {
            	char c = charSaisi.charAt(i);
            	System.out.println(c);
        		caracteres.add(c);
            }
            System.out.println(caracteres);
            victoire = true; // on met à vrai pour l'instant
            Iterator<Character> it = solution.iterator();
        	
	            	            	
            		
            		/*boolean bonCaractere = caracteres.get(i)==s;
                    System.out.print( (bonCaractere ? OK : FAUX) + " "); // instruction ternaire
                    
     				caracteres.indexOf(caracteres.get(i))==i;
                    victoire = victoire && bonCaractere; // victoire sera vrai UNIQUEMENT si bonChiffre vaut vrai a CHAQUE tour de boucle*/
            		if(difficulté==1) {
            			for(int i=0 ; i<NB_CHAR ; i++) {
	            			boolean bonCaractere = solution.contains(caracteres.get(i));
	                        System.out.print( (bonCaractere ? OK : FAUX) + " "); // instruction ternaire         
	                        victoire = victoire && bonCaractere; // victoire sera vrai UNIQUEMENT si bonChiffre vaut vrai a CHAQUE tour de boucle
            			}
            		}
            		else if(difficulté==2) {            			
        				for(int i=0 ; i<NB_CHAR ; i++) {
        					while(it.hasNext()) {
                				char s=it.next();			            			
		                        boolean bonnePosition = caracteres.get(i)==s;
		                        System.out.print((bonnePosition ? OK : FAUX) + " ");
		                        victoire = victoire && bonnePosition;
        					}
        				}
            		}         
            System.out.println(); // on passe à la ligne
 
            count++;
            caracteres.clear();
 
            if(count == ESSAIS_MAX)
                System.out.println("Hé non, dommage, vous avez epuisé vos " + ESSAIS_MAX + " essais, c'est perdu pour vous.\n La bonne réponse était : " + solution);
 
        }while(!victoire && count < ESSAIS_MAX);
        System.out.println("Gagné en "+count+ " tentatives !");
        sc1.close();
        sc2.close();

	}

}
