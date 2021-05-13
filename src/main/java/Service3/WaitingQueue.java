package Service3;

import Service1.RandomFieldsGenerator;
import Service1.TimeTable;
import Service1.Type;

import java.sql.Time;
import java.time.LocalDate;

//судно прибывает в порт, с текущими данными мы его закидиваем в очередь
//а потом и в новый json файл report.json
public class WaitingQueue {
    private String  nameOfTheShip;
    private Time estimatedTimeOfArrival;
    private double deviationInArrival;
    private Time definiteTimeOfArrival;
    //private Time WaitingInQueue; //время ожидания в очереди
    //private Time beginingOfUnloading; //начало разгрузки3
    private LocalDate estimatedDayOfArrival;
    private LocalDate RealDayOfArrival;
    private Type typeOfTheShip;
    private double  exactWeight;
    public double estimatedTimeOfUnload;

    public WaitingQueue() {}

    public WaitingQueue(String nameOfTheShip, Time estimatedTimeOfArrival, double deviationInArrival, Time definiteTimeOfArrival,
                        LocalDate estimatedDayOfArrival, LocalDate RealDayOfArrival, Type typeOfTheShip, double exactWeight,
                        double estimatedTimeOfUnload) {
        this.nameOfTheShip = nameOfTheShip;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.deviationInArrival=deviationInArrival;
        this.definiteTimeOfArrival = definiteTimeOfArrival;
        this.estimatedDayOfArrival = estimatedDayOfArrival;
        this.RealDayOfArrival=RealDayOfArrival;
        this.typeOfTheShip = typeOfTheShip;
        this.exactWeight = exactWeight;
        this.estimatedTimeOfUnload = estimatedTimeOfUnload;
    }

    public String getNameOfTheShip() {
        return nameOfTheShip;
    }

    public void setNameOfTheShip(String nameOfTheShip) {
        this.nameOfTheShip = nameOfTheShip;
    }

    public Time getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }

    public void setEstimatedTimeOfArrival(Time estimatedTimeOfArrival) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
    }

    public Time getDefiniteTimeOfArrival() {
        return definiteTimeOfArrival;
    }

    public void setDefiniteTimeOfArrival(Time definiteTimeOfArrival) {
        this.definiteTimeOfArrival = definiteTimeOfArrival;
    }

    public double getDeviationInArrival() {
        return deviationInArrival;
    }

    public void setDeviationInArrival(double deviationInArrival) {
        this.deviationInArrival = deviationInArrival;
    }

    public LocalDate getEstimatedDayOfArrival() {
        return estimatedDayOfArrival;
    }

    public void setEstimatedDayOfArrival(LocalDate estimatedDayOfArrival) {
        this.estimatedDayOfArrival = estimatedDayOfArrival;
    }

    public Type getTypeOfTheShip() {
        return typeOfTheShip;
    }

    public void setTypeOfTheShip(Type typeOfTheShip) {
        this.typeOfTheShip = typeOfTheShip;
    }

    public double getExactWeight() {
        return exactWeight;
    }

    public void setExactWeight(double exactWeight) {
        this.exactWeight = exactWeight;
    }

    public double getEstimatedTimeOfUnload() {
        return estimatedTimeOfUnload;
    }

    public void setEstimatedTimeOfUnload(double estimatedTimeOfUnload) {
        this.estimatedTimeOfUnload = estimatedTimeOfUnload;
    }

    @Override
    public String toString() {
        return "\nWaitingQueue{\n" +
                "nameOfTheShip='" + nameOfTheShip + "\n" +
                ", estimatedTimeOfArrival=" + estimatedTimeOfArrival + "\n"+
                ", deviationInArrival=" + deviationInArrival + "\n"+
                ", definiteTimeOfArrival=" + definiteTimeOfArrival + "\n"+
                ", estimatedDayOfArrival='" + estimatedDayOfArrival + "\n" +
                ", RealDayOfArrival='" + RealDayOfArrival + "\n" +
                ", typeOfTheShip='" + typeOfTheShip + "\n" +
                ", exactWeight=" + exactWeight + "\n"+
                ", estimatedTimeOfUnload=" + estimatedTimeOfUnload + "\n"+
                '}';
    }
}
