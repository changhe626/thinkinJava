package com.innerclass;

/**
 * Created by zk on 17-10-22.
 * 作用: com.innerclass.
 * 可以在任意的地方添加内部类的
 */
public class Parcell6 {

    private void internalTracking(boolean b){
        if(b){
            class TrackingSlip{
                private String id;
                public TrackingSlip(String id) {
                    this.id = id;
                }
                String getSlip(){
                    return id;
                }
            }
            TrackingSlip trackingSlip = new TrackingSlip("dsadsa");
            String slip = trackingSlip.getSlip();
            System.err.println(slip);
        }
    }

    public static void main(String[] args) {
        new Parcell6().internalTracking(true);
    }


}
