package com.datastruct.List;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;

/**
 * Created by zk on 2017/9/25.
 * 作用: com.datastruct.List.
 */
public class Tournament {

    public static void main(String[] args){
        TournamentMaker maker = new TournamentMaker();
        try {
            maker.make();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Team implements Comparable{
    private String teamname;
    private int wins;

    public Team(String teamname, int wins) {
        this.teamname = teamname;
        this.wins = wins;
    }

    @Override
    public int compareTo(Object o) {
        if(this.wins<((Team)o).wins) return -1;
        else
            if(this.wins==((Team)o).wins) return 0;
            else  return 1;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamname='" + teamname + '\'' +
                '}';
    }
}

class TournamentMaker{

    private String getNextTotoken() throws IOException{
        String temptoken,instring;
        StringTokenizer tokenzer;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        instring = in.readLine();
        tokenzer=new StringTokenizer(instring);
        temptoken=tokenzer.nextToken();
        return temptoken;
    }


    public void make() throws IOException{
        ArrayOrderList tournament = new ArrayOrderList();
        String team1,team2,team3,teamname;
        int numwins,numteams=0;
        System.out.println("maker");
        while((numteams%2!=0) || numteams==0){
            System.out.println("enter");
            numteams=Integer.parseInt(getNextTotoken());
        }
        System.out.println("maker");


    }
}
