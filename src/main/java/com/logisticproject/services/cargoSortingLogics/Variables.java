package com.logisticproject.services.cargoSortingLogics;

public class Variables {

    public int containerNumber = 0;
    //Точка построения нового контейнера (ТНКП)
    public int TPNK_Y_Axis;
    public int TPNK_X_Axis;
    //расстояния области построения
    public int Xboard;
    public int Yboard;
    //точка построения (TП)
    public int TP_Y_Axis;
    public int TP_X_Axis;

   public void setTPMK(int axisX, int axisY){
       this.TPNK_X_Axis = axisX;
       this.TPNK_Y_Axis = axisY;
   }

   public void setTP(int axisX, int axisY){
       this.TP_X_Axis = axisX;
       this.TP_Y_Axis = axisY;
   }

   public void setBoards(int axisX, int axisY){
       this.Xboard = axisX;
       this.Yboard = axisY;
   }

}
