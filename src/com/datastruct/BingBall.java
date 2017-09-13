package com.datastruct;

public class BingBall {

    private  char letter;
    private  int  number;

    public BingBall(int number) {
        this.number=number;
        if(number<=15){
            letter='B';
        }else if(number<=30){
            letter='I';
        }else if(number<=45){
            letter='N';
        }else if(number<=60){
            letter='G';
        }else{
            letter='O';
        }
    }

    @Override
    public String toString() {
        return "BingBall{" + "letter=" + letter + ", number=" + number + '}';
    }
}
