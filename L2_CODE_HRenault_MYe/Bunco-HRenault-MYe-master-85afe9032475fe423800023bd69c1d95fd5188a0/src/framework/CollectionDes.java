package framework;

import java.util.Collection;
import java.util.Iterator;

/**
 * Collection des dés du jeu 
 */
public class CollectionDes implements Collection<De> {
    private int compteur = 0;
    private De[] arrDe;
    
    public CollectionDes(int nombreDes) {
        this.arrDe = new De[nombreDes];
    }
	@Override
	public boolean add(De arg0) {
	    arrDe[compteur] = arg0;
	    compteur++;
		return false;
	}

	@Override
	public boolean addAll(Collection arg0) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean contains(Object arg0) {
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator iterator() {
		return new DeIterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return false;
	}

	@Override
	public boolean removeAll(Collection arg0) {
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		return false;
	}

	@Override
	public int size() {
		return compteur;
	}

	@Override
	public Object[] toArray() {
		return arrDe;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		return null;
	}

	@Override
	public String toString() {
    	String results = "";
    	for(De d : arrDe){
    		results += "\t"+d.getNombre();
		}
		return results;
	}

	/**
	 * Permet d'itérer sur la collection de des pour passer de
	 * des a des pendant le jeu
	 */
	private class DeIterator implements Iterator<De> {

	      int index;

	      /**
		   * @return true jusqu'à ce que tous les des sont parcourus
		   */
	      @Override
	      public boolean hasNext() {
	      
	         if(index <  arrDe.length){
	            return true;
	         }
	         return false;
	      }

	      /**
		   * @return le prochain de
		   */
	      @Override
	      public De next() {
	      
	         if(this.hasNext()){
	            return arrDe[index++];
	         }
	         return null;
	      }		
	   }
	}



