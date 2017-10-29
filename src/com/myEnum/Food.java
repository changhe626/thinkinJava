package com.myEnum;

public interface Food {
    enum Appetizer implements  Food{
        SALAD,SOUP,ROLLS;

    }

    enum MainCource implements  Food{
        LANSE,HSSL;
    }


}


class TypeOfFood{
    public static void main(String[] args) {
        Food food=Food.Appetizer.SALAD;
        Food food2= Food.MainCource.HSSL;
        System.out.println(food);
        System.out.println(food2);
    }

}
