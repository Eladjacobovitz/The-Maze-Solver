package main;

/** 
 * Implementation of the Union-Find ADT. 
 */ 
public class UnionFind { 
   int height[];
   int up[]; 
   int weight[]; 
   int numSets; 
 
   /** 
    * Constructor - initializes up and weight arrays. 
    * @param numElements initial number of singleton sets. 
    */ 
   public UnionFind (int numElements) { 
		up = new int[numElements+1];
		weight = new int[numElements+1];
		height = new int[numElements+1];
		for(int i=0; i<=numElements; i++) {
			up[i] = -1;
			weight[i] = 1;
			height[i]=0;
			}
		numSets = numElements;
		}
 
   /** 
    * Returns the size of the set which contains i.
    * @param i
    */ 
   public int getSize(int i){
	   int current = up[i];
		while(current != -1) {
			current = up[current];
		}
		return weight[current];
   }
   
   /** 
    * Returns the height of the tree containing i. 
	* Disregards any changes which might have been caused by path compression.
    * @param i
    */ 
   public int getHeight(int i){
		int current = find(i);
		return height[current];		
   }
		
   /** 
    * Unites two sets using weigthed union. 
    * @param i is an element of the first set.
    * @param j is an element of the second set. 
    */ 
   public void union (int i, int j) { 
		i = find(i);
		j = find(j);
	    if (i == j) return; 
	    int newWeight = weight[i] + weight[j];
		if(weight[i] < weight[j]) {
			up[i] = j;
			weight[j] = newWeight;
			if(height[i] >= height[j]) {
				height[j] = height[i]+1;
			}
		}else {
			up[j] = i;
			weight[i] = newWeight;
			if(height[j] >= height[i]) height[i] = height[j]+1;
		}
		numSets--;
   } 
 
   /** 
    * Finds the set representative, and applies path compression. 
    * @param i the element to search. 
    * @return the representative of the set which contains i. 
    */ 
   public int find (int i) { 
	   if(i > up.length) 
		   throw new IllegalArgumentException (i + " not an element in this Union-Find ADT");
	   int current = up[i];
		while(current != -1) {
			i = current;
			current = up[current];
		}
		return i;
   } 
 
   /** 
    * Find the current number of sets. 
    * @return the number of set. 
    */ 
   public int getNumSets() { 
		return numSets;
   } 
 
   /** 
    * Prints the contents of the up array. 
    */ 
   public void debugPrintUp() { 
      System.out.print ("up:     "); 
      for (int i = 1; i < up.length; i++) 
         System.out.print (up[i] + " "); 
      System.out.println (""); 
   } 
 
   /** 
    * Prints the results of running find on all elements. 
    */ 
   public void debugPrintFind() { 
 
      System.out.print ("find:   "); 
      for (int i = 1; i < up.length; i++) 
         System.out.print (find (i) + " "); 
      System.out.println (""); 
   } 
 
   /** 
    * Prints the contents of the weight array. 
    */ 
   public void debugPrintWeight() { 
      System.out.print ("weight: "); 
      for (int i = 1; i < weight.length; i++) 
         System.out.print (weight[i] + " "); 
      System.out.println (""); 
   } 
 
   /** 
    * Various tests for the Union-Find functionality. 
    * @param args command line arguments - not used. 
    */ 
   public static void main (String[] args) { 
	   UnionFind uf = new UnionFind (10); 
	   
	      uf.debugPrintUp(); 
	      uf.debugPrintFind(); 
	      uf.debugPrintWeight(); 
	      System.out.println ("Number of sets: " + uf.getNumSets()); 
	      System.out.println (""); 
	 
	      uf.union (2, 1); 
	      uf.union (3, 2); 
	      uf.union (4, 2); 
	      uf.union (5, 2); 
	 
	      uf.debugPrintUp(); 
	      uf.debugPrintFind(); 
	      uf.debugPrintWeight(); 
	      System.out.println ("Number of sets: " + uf.getNumSets()); 
	      System.out.println(); 
	 
	      uf.union (6, 7); 
	      uf.union (8, 9); 
	      uf.union (6, 8); 
	 
	      uf.debugPrintUp(); 
	      uf.debugPrintFind(); 
	      uf.debugPrintWeight(); 
	      System.out.println ("Number of sets: " + uf.getNumSets()); 
	      System.out.println(); 
	 
	      uf.find (8); 
	 
	      uf.debugPrintUp(); 
	      uf.debugPrintFind(); 
	      uf.debugPrintWeight(); 
	      System.out.println ("Number of sets: " + uf.getNumSets()); 
	      System.out.println(); 
   } 
} 
