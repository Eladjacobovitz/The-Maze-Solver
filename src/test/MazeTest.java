package test;
import main.DisplayImage;
import main.Maze;


/**
 * A class for decomposing images into connected components.
 */
public class MazeTest {
   /**
    * Various tests for the segmentation functionality.
    *
    * @param args command line arguments - name of file to process.
    */
   public static void main (String[] args) { 
      // we will  run the program on a maze that has no solution.
      // We expect to see a negative answer on whether the maze has a solution and in addition, 
      // we would like to see the maze component number when each component is painted a different color
      Maze maze = new Maze ("maze4.png");
      System.out.println (maze.mazeHasSolution());
      System.out.println ("Number of components: " + maze.getNumComponents());
      DisplayImage compImg = maze.getComponentImage();
      compImg.show();
      
      // we will  run the program on a maze that has solution.
      // We expect to see a positive answer on whether the maze has a solution and in addition, 
      // we would like to see the maze component number when each component is painted a different color
      maze = new Maze ("maze5.png");
      System.out.println (maze.mazeHasSolution());
      System.out.println ("Number of components: " + maze.getNumComponents());
      compImg = maze.getComponentImage();
      compImg.show();
      
   }
}
