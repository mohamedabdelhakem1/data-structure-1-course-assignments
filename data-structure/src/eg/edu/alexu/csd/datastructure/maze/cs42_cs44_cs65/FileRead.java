package eg.edu.alexu.csd.datastructure.maze.cs42_cs44_cs65;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * @author Muhammad Salah
 *
 */
public class FileRead {
    /**
     *
     */
    private File f = null;
    /**
     *
     */
    private int n = 0;
    /**
     *
     */
    private int m = 0;
    /**
     * @param file f
     */
    public void setFile(final File file) {
        f = file;
    }
    /**
     * @return n
     */
    public int getN() {
        return n;
    }
    /**
     * @return m
     */
    public int getM() {
        return m;
    }
    /**
     * @return ddd
     * @throws Exception dd
     */
    public char[][] readArr() throws Exception {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String w = br.readLine();
            String[] ww = w.split(" ");
            n = Integer.parseInt(ww[0]);
            m = Integer.parseInt(ww[1]);
            char[][] mat = new char[n][m];
            int i = 0;
            w = br.readLine();
            while (w != null) {
                w = w.replace(" ", "");
                mat[i] = w.toCharArray();
                i++;
                w = br.readLine();
            }

            br.close();
            return mat;
    }
}
