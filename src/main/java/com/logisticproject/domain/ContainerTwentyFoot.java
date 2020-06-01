package com.logisticproject.domain;

public class ContainerTwentyFoot {

//    public static final int LENGTH = 590;
//    public static final int WIDTH = 230;

    public int getLength() {
        return 590;
    }

    public int getWidth() {
        return 235;
    }

    public int getHeight() {
        return 238;
    }

    public int getMaximumLoadCapacity() {
        return 24980;
    }

    public int getTareWeight() {
        return 2257;
    }

    public int getMaximumGrossWeight() {
        //ves tovara s upakovkoi(gruz + konteiner)
        return 27240;
    }

}