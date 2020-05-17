package test;
import main.DisplayImage;


/**
 * A class for displaying the image.
 */
public final class DisplayImageTest {

   /**
    * Test client. Reads a picture specified by the command-line argument,
    * and shows it in a window on the screen.
    *
    * @param args command line arguments
    */
   public static void main (String[] args) {
	   	   
	  //We will print the width and length of the image (from the CommandLineArguments) 
      DisplayImage pic = new DisplayImage (args[0]);
      System.out.printf ("%d-by-%d\n", pic.width(), pic.height());
      //We will try to show the image on the screen
      pic.show();
      //We will try to Sets colors of pixel (i, j) to null.
      pic.set(1,1, null);
      //We will try to print the dimensions of an existing image
      pic = new DisplayImage ("MazeThatDoesNotExist.png");
      System.out.printf ("%d-by-%d\n", pic.width(), pic.height());
      //we will try to show the image that doesn't exist on the screen
      pic.show();
      //We will try to save the image in a standard image file when the image name 
      //does not end with the appropriate format (.jpg or .png).
      pic.save("maze4");
      
      /** During the DisplayImage function, we call the read and gets functions and check them.

    	* when we perform the show function, we call the following functions:
    	* setContentPane,
    	* setDefaultCloseOperation,
    	* setTitle,
    	* setResizable,
    	* pack,
    	* setVisible.

    	* These functions create a new screen on which the image appears.
      */ 
   }
}
