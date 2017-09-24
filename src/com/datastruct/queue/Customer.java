package com.datastruct.queue;

/**
 * Created by zk on 2017/9/24.
 * 作用: com.datastruct.queue.
 * 顾客买票的模拟实现
 */
public class Customer {

    private int arrivalTime,departuerTime;

    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        departuerTime=0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setDepartuerTime(int departuerTime) {
        this.departuerTime = departuerTime;
    }

    public int toTotalTime(){
        return departuerTime-arrivalTime;
    }
}


class TicketCounter{
    final static int PROCESS=120;

    final static int MAX_CASHIERS=10;

    final static int NUM_CUSTOMERS=100;

    public static void main(String[] args){
        Customer customer;
        LinkedQueue customerQueue=new LinkedQueue();
        int[] cashierTime =new int[MAX_CASHIERS];
        int totalTime,averageTime,departs;

        for (int i = 0; i < NUM_CUSTOMERS; i++) {

            
        }

    }


}
