package eg.edu.alexu.csd.datastructure.maze.cs42_cs44_cs65;

import java.io.File;


/**
 * @author Muhammad Salah
 *
 */
public class Tester {

    /**
     * @param args dd
     */
    public static void main(final String[] args) {
        File f = new File("F:\\CSED21\\year 1\\term2\\Data Structures"
                + "\\GIT\\data-structure\\Assignments\\src\\eg\\edu\\"
                + "alexu\\csd\\datastructure\\maze\\cs42_cs44_cs65\\"
                + "tesk.txt");
        Maze m = new Maze();
        int[][] a = m.solveBFS(f);
    }

}
