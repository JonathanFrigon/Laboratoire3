import java.io.*;
import java.util.Scanner;
public class LectureFichier {

	/** 
	 * Programme qui fait la lecture de données dans le fichierAvant. 
	 * Ensuite, le programme fait le calcul (multiplication, soustraction ou addition) des deux nombres lus dans le fichier 
	 * Ensuite, le programme écrit le résultat avec le calcul des deux nombres (par exemple: a + b = c) dans le fichierApres.txt
	 * 
	 */
	public static void main(String[] args) {
		

		// lecture du fichier de données
		try {
			
			File monFichier = new File("fichierAvant.txt");
			FileReader lecture = new FileReader(monFichier);			
			BufferedReader reader = new BufferedReader(lecture);
			
			String ligne = null;

			// traitement de la ligne pour le calcul			
			while ((ligne = reader.readLine()) != null) {
				System.out.println(ligne);	
				
				
				/*exécution de la méthode statique calcul
				qui lit une ligne du fichier et retourne le résultat du calcul
				dans la variable resultat*/
				
				int resultat=LectureFichier.calcul(ligne);
				ligne += " = " + resultat + "\n";
				// écriture des données dans le fichier résultat.			
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("fichierApres.txt",true));
					writer.write(ligne);
					writer.close();
					
				} catch(IOException ex) {
					ex.printStackTrace();
				}	
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// méthode qui permet de lire des entiers de 0 à 99 à partir de la console.
		entrerValeur();
		System.out.println("Fin du programme!");
	}

	// Cette méthode recoit une ligne du fichier text et vérifie que celle-ci est correcte pour ensuite retourner le resultat
	public static int calcul(String ligne) {
		String [] separation = ligne.split(" ");
		
		int num1;
		int num2;
		char operateur;
		int resultat = 0;
		try{
			num1 = Integer.parseInt(separation[0]);
			num2 = Integer.parseInt(separation[2]);
			operateur =separation[1].charAt(0);

			switch(operateur){
			case '+':
				resultat = num1 + num2;
				break;
			case '-':
				resultat = num1 - num2;
				break;
			case '*':
				resultat = num1 * num2;
				break;
			case '/':
				if(num1 != 0 && num2 != 0){
					resultat = num1 / num2;
				} else {
					resultat = 0;
				}
				break;
			}
	}catch(IllegalArgumentException e){
		System.out.println("Un des deux nombres est corrompu! Les nombres doit être des entiers.");
	}
		return (resultat);
	}
	
	// méthode entrerValeur qui sert a lire une valeur de 0 à 99 à partir de la console. On obtient un résultat jusqua temps
	// que la valeur rentré soit valide. (Nombre Entier entre 0 et 99).
	public static int entrerValeur(){
		Scanner Lire = new Scanner(System.in);
		int nombre = 0;
		String entree;
		boolean valide = false;
		
		while(!valide){
			try{
				System.out.print("Veuillez entrer un nombre entier entre 0 et 99 : ");
				entree = Lire.nextLine();
				nombre = Integer.parseInt(entree);
				
				if(nombre < 0){
					System.out.println("Le nombre doit être plus grand ou égale à zero!");
				} else if (nombre > 99){
					System.out.println("Le nombre doit être plus que 100!");
				} else {
					valide = true;
				}
			}catch(Exception e){
				System.out.println("Le nombre entrer n'est pas un entier entre 0 et 99!");
			}
		}
		return nombre;
	}

}
