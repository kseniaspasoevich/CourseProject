package Service3;

import Service1.RandomFieldsGenerator;
import Service1.TimeTable;
import Service1.Type;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//судно прибывает в порт, с текущими данными мы его закидиваем в очередь
//а потом и в новый json файл report.json
public class WaitingQueue {
    private String  nameOfTheShip;
    private Time estimatedTimeOfArrival;
    private double deviationInArrival;
    private Time definiteTimeOfArrival;
    private Time WaitingInQueue; //время ожидания в очереди
    private Time beginningOfUnloading; //начало разгрузки3
    private LocalDate estimatedDayOfArrival;
    private LocalDate RealDayOfArrival;
    private Type typeOfTheShip;
    private double  exactWeight;
    public double estimatedTimeOfUnload;
    public double delayUnload; //задержка разгрузки
    public double penalty;    //штраф

    public WaitingQueue() {}

    public WaitingQueue(String nameOfTheShip, Time estimatedTimeOfArrival, double deviationInArrival,
                        Time definiteTimeOfArrival, Time waitingInQueue, Time beginningOfUnloading,
                        LocalDate estimatedDayOfArrival, LocalDate realDayOfArrival,
                        Type typeOfTheShip, double exactWeight, double estimatedTimeOfUnload,
                        double delayUnload, double penalty) {
        this.nameOfTheShip = nameOfTheShip;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.deviationInArrival = deviationInArrival;
        this.definiteTimeOfArrival = definiteTimeOfArrival;
        this.WaitingInQueue = waitingInQueue;
        this.beginningOfUnloading = beginningOfUnloading;
        this.estimatedDayOfArrival = estimatedDayOfArrival;
        this.RealDayOfArrival = realDayOfArrival;
        this.typeOfTheShip = typeOfTheShip;
        this.exactWeight = exactWeight;
        this.estimatedTimeOfUnload = estimatedTimeOfUnload;
        this.delayUnload = delayUnload;
        this.penalty = penalty;
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

    public String getEstimatedDayOfArrival() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.estimatedDayOfArrival.format(formatter);
    }

    public void setEstimatedDayOfArrival(Object estimatedDayOfArrival) {
        if (estimatedDayOfArrival instanceof String) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.estimatedDayOfArrival = LocalDate.parse((String) estimatedDayOfArrival, formatter);
        } else if (estimatedDayOfArrival instanceof LocalDate) {
            this.estimatedDayOfArrival = (LocalDate) estimatedDayOfArrival;
        }
    }
    public String getRealDayOfArrival() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.RealDayOfArrival.format(formatter);
    }

    public void setRealDayOfArrival(Object RealDayOfArrival) {
        if (RealDayOfArrival instanceof String) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.RealDayOfArrival = LocalDate.parse((String) RealDayOfArrival, formatter);
        } else if (RealDayOfArrival instanceof LocalDate) {
            this.RealDayOfArrival = (LocalDate) RealDayOfArrival;
        }
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

    public Time getWaitingInQueue() {
        return WaitingInQueue;
    }

    public void setWaitingInQueue(Time waitingInQueue) {
        WaitingInQueue = waitingInQueue;
    }

    public Time getBeginningOfUnloading() {
        return beginningOfUnloading;
    }

    public void setBeginningOfUnloading(Time beginningOfUnloading) {
        this.beginningOfUnloading = beginningOfUnloading;
    }

    public double getDelayUnload() {
        return delayUnload;
    }

    public void setDelayUnload(double delayUnload) {
        this.delayUnload = delayUnload;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "WaitingQueue{" +
                "nameOfTheShip='" + nameOfTheShip + "\n" +
                ", estimatedTimeOfArrival=" + estimatedTimeOfArrival + "\n" +
                ", deviationInArrival=" + deviationInArrival +"\n" +
                ", definiteTimeOfArrival=" + definiteTimeOfArrival +"\n" +
                ", WaitingInQueue=" + WaitingInQueue +"\n" +
                ", beginningOfUnloading=" + beginningOfUnloading +"\n" +
                ", estimatedDayOfArrival=" + estimatedDayOfArrival +"\n" +
                ", RealDayOfArrival=" + RealDayOfArrival +"\n" +
                ", typeOfTheShip=" + typeOfTheShip +"\n" +
                ", exactWeight=" + exactWeight +"\n" +
                ", estimatedTimeOfUnload=" + estimatedTimeOfUnload +"\n" +
                ", delayUnload=" + delayUnload +"\n" +
                ", penalty=" + penalty +"\n" +
                '}';
    }
}
