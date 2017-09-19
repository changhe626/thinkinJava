package com.datastruct.recursive;

import java.util.Arrays;

/**
 * Created by zk on 2017/9/19.
 * 迷宫穿越
 */
public class MazeSearch {
    public static void main(String args[]){

        Maze maze = new Maze();
        System.out.println(maze);
        if(maze.traverse(0,0)){
            System.out.println("ok,you have done id");
        }else{
            System.out.println("this is no possible path");
        }
        System.out.println(maze);
    }
}




class Maze{
    private final int THIED=3;
    private final int PATH=7;
    private int[][] grid={
            {0,0,0,1,0,1,1,1},
            {0,1,1,1,0,1,1,0},
            {1,0,1,1,0,1,1,1},
            {1,1,0,1,0,1,1,1},
            {1,1,1,0,0,1,1,1},
            {1,1,1,1,0,1,1,1},
            {0,1,1,1,0,0,1,1},
            {1,1,1,1,0,1,0,1},
            {1,1,1,1,0,1,1,0},
            {1,0,0,1,0,1,1,1},
    };

    public boolean traverse(int row,int column){
        boolean done=false;
        if(valid(row,column)){
            grid[row][column]=THIED;
            if(row==grid.length-1 && column==grid[0].length-1){
                done=true;
            }else{
                done=traverse(row+1,column);
                if(!done){
                    done=traverse(row,column+1);
                }
                if(!done){
                    done=traverse(row-1,column);
                }
                if(!done){
                    done=traverse(row,column-1);
                }
            }
            if(done){
                grid[row][column]=PATH;
            }
        }
        return done;
    }

    private boolean valid(int row, int column) {
        boolean result=false;
        if(row>=0 && row<grid.length && column>=0 && column<grid[row].length){
            if(grid[row][column]==1){
                result=true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Maze{ grid=" + Arrays.deepToString(grid) +"}";
    }

}
