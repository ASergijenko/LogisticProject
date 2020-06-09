package com.logisticproject.dto;

import com.logisticproject.domain.Cargo;
import com.logisticproject.domain.Container;
import com.logisticproject.domain.Point;

import java.util.List;
import java.util.Map;

public class CargoDTO {

    private List<Cargo> cargoList;
    private Map<Integer, Integer[][]> containerList;
    private List<Point> pointRepository;
    private Point TP_Point;
    private Point TPNK_Point;
    private Point boards;
    private Integer containerNumber;
    private Container container;

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    public Map<Integer, Integer[][]> getContainerList() {
        return containerList;
    }

    public void setContainerList(Map<Integer, Integer[][]> containerList) {
        this.containerList = containerList;
    }

    public List<Point> getPointRepository() {
        return pointRepository;
    }

    public void setPointRepository(List<Point> pointRepository) {
        this.pointRepository = pointRepository;
    }

    public Point getTP_Point() {
        return TP_Point;
    }

    public void setTP_Point(Point TP_Point) {
        this.TP_Point = TP_Point;
    }

    public Point getTPNK_Point() {
        return TPNK_Point;
    }

    public void setTPNK_Point(Point TPNK_Point) {
        this.TPNK_Point = TPNK_Point;
    }

    public Point getBoards() {
        return boards;
    }

    public void setBoards(Point boards) {
        this.boards = boards;
    }

    public Integer getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(Integer containerNumber) {
        this.containerNumber = containerNumber;
    }
}