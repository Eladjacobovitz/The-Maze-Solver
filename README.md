# The-Maze-Solver

Maze-Solver is a Java program to solve mazes. 
It gets a PNG image of a maze as an input and output the number of connected components using Union-Find data structure. If the entrance and end of the maze are in the same component that means the maze can be solved and the program will output True.
Display and output (DisplayImage.java): Creates a picture by reading in a .png, .gif, or .jpg from
Creates the buffer for the image, the GUI to represent it and finally display it in a window on the screen.
The maze-solver (Maze.java): A class for decomposing images into connected components. It goes to each pixel in the image to check whether it relates to its neighbors (checks if they are the same color). If it is the case it performs union on them, or creates another component, if needed. 
In the end of the run, the program returns the number of connected components and whether or not the start and end (represented by red pixels) are in the same component.
Union find data structure (UnionFind.java): Implementation of the UnionFind ADT.

The MazeSolver program uses a simple data structure to solve a real-life real-life problem.
Solving a complicated maze by a human can take a long and even unlimited time. With MazeSolver, the maze is solved in a timely and perfect way.

