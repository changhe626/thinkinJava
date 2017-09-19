package com.datastruct.recursive;

import java.lang.reflect.Modifier;

/**
 * Created by zk on 2017/9/19.
 * 汉诺塔的解决
 */
public class SolveTowers {
    public static void main(String[] args){
        TowersOfHanoi towers = new TowersOfHanoi(6);
        towers.solve();
    }

}

class TowersOfHanoi{
    private int totalDisk;

    public TowersOfHanoi(int towers) {
        this.totalDisk = towers;
    }

    public  void solve() {
        moveTower(totalDisk,1,3,2);
    }

    private void moveTower(int totalDisk, int start, int end, int temp) {
        if(totalDisk==1){
            moveOneDisk(start,end);
        }else{
            //移动到临时上去,一下子全部移走,进行递归
            moveTower(totalDisk-1,start,temp,end);
            //进行移动
            moveOneDisk(start,end);
            //从临时移动到最终上去
            moveTower(totalDisk-1,temp,end,start);
        }
    }

    private void moveOneDisk(int start, int end) {
        System.out.println("move the disk from "+start+"to the "+end);
    }
}
