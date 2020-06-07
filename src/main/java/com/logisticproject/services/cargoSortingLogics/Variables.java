package com.logisticproject.services.cargoSortingLogics;

import com.logisticproject.domain.Cargo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Variables {

    public int containerNumber = 0;
    //Точка построения нового/меньшего  контейнера (ТНКП)
    public int TPMK_Y_Axis;
    public int TPMK_X_Axis;
    //расстояния области построения
    public int Xboard;
    public int Yboard;
    //точка построения (TП)
    public int TP_Y_Axis;
    public int TP_X_Axis;

    public List<Cargo> cargoList;

   public void setTPMK(int axisX, int axisY){
       this.TPMK_X_Axis = axisX;
       this.TPMK_Y_Axis = axisY;
   }

   public void setBoards(int axisX, int axisY){
       this.Xboard = axisX;
       this.Yboard = axisY;
   }

    public void setTP(int axisX, int axisY){
        this.TP_X_Axis = axisX;
        this.TP_Y_Axis = axisY;
    }

}
