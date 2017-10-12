import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * 
 * @author Frigon
 *	Programme qui sert � tester les m�thodes de la class LectureFichier : Calcul et EntrerValeur.
 */
public class LectureFichierTest {
	/**
	 * V�rifie le r�sultat de l'addition
	 */
    @Test
	public void addition() {
        
    	final int resultat = LectureFichier.calcul("6 + 2");
    	
        assertEquals(resultat, 8);
    }
	/**
	 * V�rifie le r�sultat de la substraction
	 */
    @Test
	public void substraction() {
        
    	final int resultat = LectureFichier.calcul("6 - 2");
    	
        assertEquals(resultat, 4);
    }
	/**
	 * V�rifie le r�sultat de la multiplication
	 */
    @Test
	public void multiplication() {
        
    	final int resultat = LectureFichier.calcul("6 * 2");
    	
        assertEquals(resultat, 12);
    }
	/**
	 * V�rifie le r�sultat de la division
	 */
    @Test
	public void division() {
        
    	final int resultat = LectureFichier.calcul("6 / 2");
    	
        assertEquals(resultat, 3);
    }
	/**
	 * V�rifie le r�sultat de la division avec deux z�ro
	 */
    @Test
	public void divisionAvecDeux0() {
        
    	final int resultat = LectureFichier.calcul("0 / 0");
    	
        assertEquals(resultat, 0);
    }
	/**
	 * V�rifie le r�sultat de la division avec un nombre et un z�ro
	 */
    @Test
	public void divisionAvecUnNombreEt0() {
        
    	final int resultat = LectureFichier.calcul("5 / 0");
    	
        assertEquals(resultat, 0);
    }
	/**
	 * V�rifie le r�sultat de la division avec un z�ro et un nombre
	 */
    @Test
	public void divisionAvec0etUnNombre() {
        
    	final int resultat = LectureFichier.calcul("0 / 5");
    	
        assertEquals(resultat, 0);
    }
	/**
	 * V�rifie le r�sultat avec un nombre non valide (ex : lettre)
	 */
    @Test
	public void UnNombreNonValide() {
        
    	final int resultat = LectureFichier.calcul("t + y");
    	
        assertEquals(resultat, 0);
    }
	/**
	 * V�rifie le r�sultat avec un op�rateur non valide (ex : t)
	 */
    @Test
	public void OperateurNonValide() {
        
    	final int resultat = LectureFichier.calcul("5 t 3");
    	
        assertEquals(resultat, 0);
    }
	/**
	 * V�rifie le r�sultat apr�s une s�rie de test
	 */
    @Test
	public void EntrerDesValeursNonValide() {
        /* test : plus grand que 99 (100)
    		*	: plus petit que 0 (-1)
    		*	: une valeur qui n'est pas un nombre (t)
    		*	: un nombre valide (99)
    		*/	
    	final int resultat = LectureFichier.entrerValeur();
    	
    	assertEquals(resultat, 99);
    }
}
