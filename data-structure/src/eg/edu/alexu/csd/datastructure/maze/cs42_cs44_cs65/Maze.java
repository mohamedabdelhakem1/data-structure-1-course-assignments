package eg.edu.alexu.csd.datastructure.maze.cs42_cs44_cs65;

import java.awt.Point;
import java.io.File;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs44_cs42_cs65.LinkedListBasedQueue;
import eg.edu.alexu.csd.datastructure.stack.cs44.MyStack;

/**
 * @author Muhammad Salah
 *
 */
public class Maze implements IMazeSolver {
    /**
     *
     */
    private char[][] mazeArr = null;
    /**
     *
     */
    private int n = 0;
    /**
     *
     */
    private int m = 0;
    /**
     *
     */
    private Point start = new Point(0, 0);
    /**
     *
     */
    private boolean[][] visited = null;
    /**
     *
     */
    private Node[][] visitedBFS = null;
    /**
     *
     */
    private void createVBFS() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visitedBFS[i][j] = new Node();
            }
        }
    }
    /**
     * @param file File
     */
    private void setMaze(final File file) {
        FileRead f = new FileRead();
        f.setFile(file);
        try {
            mazeArr = f.readArr();
            n = f.getN();
            m = f.getM();
            if (n <= 0 || m <= 0) {
                throw new RuntimeException();
            }
            visited = new boolean[n][m];
            Node[][] g = new Node[n][m];
            visitedBFS = g;
            createVBFS();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    /**
     *
     */
    private void findStart() {
        int flag = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mazeArr[i][j] == 'S') {
                    start.x = i;
                    start.y = j;
                    flag++;
                }
                if (mazeArr[i][j] == 'E') {
                    flag++;
                }
                if (flag == 2) {
                    return;
                }
            }
        }
        throw new RuntimeException();
    }
    /**
     * @return stack
     */
    private MyStack dfs() {
        MyStack s = new MyStack();
        findStart();
        Point t = start;
        s.push(t);
        while (!s.isEmpty()) {
            t = (Point) s.peek();
            visited[t.x][t.y] = true;
            if (mazeArr[t.x][t.y] == 'E') {
                return s;
            }
            try {
                if (!visited[t.x + 1][t.y]
                        && mazeArr[t.x + 1][t.y] != '#') {
                    s.push(new Point(t.x + 1, t.y));
                    continue;
                }
            } catch (Exception e) {
                e.getClass();
            }
            try {
                if (!visited[t.x][t.y + 1]
                        && mazeArr[t.x][t.y + 1] != '#') {
                    s.push(new Point(t.x, t.y + 1));
                    continue;
                }
            } catch (Exception e) {
                e.getClass();
            }
            try {
                if (!visited[t.x - 1][t.y]
                        && mazeArr[t.x - 1][t.y] != '#') {
                    s.push(new Point(t.x - 1, t.y));
                    continue;
                }
            } catch (Exception e) {
                e.getClass();
            }
            try {
                if (!visited[t.x][t.y - 1]
                        && mazeArr[t.x][t.y - 1] != '#') {
                    s.push(new Point(t.x, t.y - 1));
                    continue;
                }
            } catch (Exception e) {
                e.getClass();
            }
            s.pop();
        }
        return s;
    }

    /**
     * @return ddd
     */
    private Point bfs() {
        LinkedListBasedQueue q = new LinkedListBasedQueue();
        findStart();
        Point t = start;
        q.enqueue(t);
        visitedBFS[t.x][t.y].setVisited(true);
        visitedBFS[t.x][t.y].setDis(0);
        while (!q.isEmpty()) {
            t = (Point) q.dequeue();
            visitedBFS[t.x][t.y].setVisited(true);
            if (mazeArr[t.x][t.y] == 'E') {
                return t;
            }
            try {
                if (!visitedBFS[t.x + 1][t.y].getVisited()
                        && mazeArr[t.x + 1][t.y] != '#') {
                    q.enqueue(new Point(t.x + 1, t.y));
                    visitedBFS[t.x + 1][t.y].setPoint(t);
                    visitedBFS[t.x + 1][t.y].setDis(
                            visitedBFS[t.x][t.y].getDis() + 1);
                }
            } catch (Exception e) {
                e.getClass();
            }
            try {
                if (!visitedBFS[t.x][t.y + 1].getVisited()
                        && mazeArr[t.x][t.y + 1] != '#') {
                    q.enqueue(new Point(t.x, t.y + 1));
                    visitedBFS[t.x][t.y + 1].setPoint(t);
                    visitedBFS[t.x][t.y + 1].setDis(
                            visitedBFS[t.x][t.y].getDis() + 1);
                }
            } catch (Exception e) {
                e.getClass();
            }
            try {
                if (!visitedBFS[t.x - 1][t.y].getVisited()
                        && mazeArr[t.x - 1][t.y] != '#') {
                    q.enqueue(new Point(t.x - 1, t.y));
                    visitedBFS[t.x - 1][t.y].setPoint(t);
                    visitedBFS[t.x - 1][t.y].setDis(
                            visitedBFS[t.x][t.y].getDis() + 1);
                }
            } catch (Exception e) {
                e.getClass();
            }
            try {
                if (!visitedBFS[t.x][t.y - 1].getVisited()
                        && mazeArr[t.x][t.y - 1] != '#') {
                    q.enqueue(new Point(t.x, t.y - 1));
                    visitedBFS[t.x][t.y - 1].setPoint(t);
                    visitedBFS[t.x][t.y - 1].setDis(
                            visitedBFS[t.x][t.y].getDis() + 1);
                }
            } catch (Exception e) {
                e.getClass();
            }
        }
        return null;
    }
    /**
     *
     */
    @Override
    public int[][] solveBFS(final File maze) {
        setMaze(maze);
        Point end  = bfs();
        if (end == null) {
            return null;
        }
        int i = visitedBFS[end.x][end.y].getDis();
        int[][] res = new int[i + 1][2];
        while (i >= 0) {
            res[i][0] = end.x;
            res[i][1] = end.y;
            end = visitedBFS[end.x][end.y].getPoint();
            i--;
        }
        return res;
    }
   /**
    *
    */
    @Override
    public int[][] solveDFS(final File maze) {
        setMaze(maze);
        MyStack s = dfs();
        if (s.isEmpty()) {
            return null;
        }
        int[][] ans = new int[s.size()][2];
        int i = s.size() - 1;
        while (!s.isEmpty()) {
            Point p = (Point) s.pop();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i--;
        }
        return ans;
    }

}
