import java.io.*;
import java.util.*;

public class Game {

    // 8 Neighbour value for any cell
    static int[][] neighbour = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    // Running the game of life for 100 states
    public static void game(int[][] grid){
        int[][] oldGrid = grid;
        int[][] newGrid = new int[200][200];
        int state = 1;
        while (state <= 100){
            for (int i = 0; i < oldGrid.length; i++) {
                for (int j = 0; j < oldGrid.length; j++) {
                    boolean live = isLive(oldGrid,i,j);
                    if(live){
                        newGrid[i][j] = 1;
                    }else{
                        newGrid[i][j] = 0;
                    }
                }
            }
            oldGrid = print(newGrid,oldGrid,state);   // clones new grid into old grid for next step
            state++;
        }
    }

    // Checks whether cell will live or die
    public static boolean isLive(int[][] grid,int i,int j){
        int sum = 0;
        for(int k = 0; k < neighbour.length; k++){
            sum += getCell(grid,i + neighbour[k][0],j + neighbour[k][1]);    // find sum of every neighbours
        }
        if(grid[i][j] == 1){
            if(sum == 2 || sum == 3){
                return true;
            }else{
                return false;
            }
        }else{
            if(sum == 3){
                return true;
            }else{
                return false;
            }
        }
    }

    // Return value of asked cell (Mainly for the edges of grid)
    public static int getCell(int[][] grid,int i,int j){
        if( i < 0 ||  j < 0 || i > 199 || j > 199 ){     // Edges of grid with less number of neighbours
            return 0;
        }
        return grid[i][j];
    }

    // print new grid and clone that grid for next state 
    public static int[][] print(int[][] newGrid,int[][] oldGrid,int step){
        System.out.print(step+": ");
        for (int i = 0; i < newGrid.length; i++) {
            for (int j = 0; j < newGrid.length; j++) {
                oldGrid[i][j] = newGrid[i][j];
                if(newGrid[i][j] == 1){
                    System.out.print("["+i+","+j+"]");
                }
            }
        }
        System.out.println();
        return oldGrid;
    }
    public static void main(String[] args) {
        int[][] grid = new int[200][200];
        try{
            String inputFile = args[0];
            File file = new File(inputFile);
            Scanner lines = new Scanner(file);
            try{
                while(lines.hasNextLine()){                                     // Reads the input file and makes initial grid accordingly
                    String[] liveCell = lines.nextLine().trim().split(",");
                    int gridX = Integer.parseInt(liveCell[0]); 
                    int gridY = Integer.parseInt(liveCell[1]);
                    grid[gridX][gridY] = 1;
                }
            game(grid);
            lines.close();
            }catch(Exception e){
               System.err.println("Input is not properly formated.");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Provide path of input file");
        }catch(FileNotFoundException e){
            System.err.println("Input File not found");
        }catch(Exception e){
            System.err.println(e);
        }
    } 
}