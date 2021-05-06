package Service3;

import Service1.*;

import java.sql.Time;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdditionalShipParameters extends TimeTable {

    private double delayUnload; //задержка разгрузки
    private double fullUnload; //полная разгрузка
    private double penalty;    //штраф
    private double arrivalDeviation; //отклонение в прибытии
    private Time realTimeOfArrival; //Точное время прибытия
    private LocalDate realDayOfArrival; //точная дата прибытия
    private double waitingForUnload; //время ожидания разгрузки


    public AdditionalShipParameters() {
        super();
        this.delayUnload = ExecutionOfService3.getUnloadDelay();
        this.penalty = ExecutionOfService3.getPenalty(delayUnload);
        this.arrivalDeviation = ExecutionOfService3.getArrivalDeviation();
        this.realTimeOfArrival=ExecutionOfService3.getRealTimeOfArrival(time, arrivalDeviation);
        this.realDayOfArrival=ExecutionOfService3.getRealDayOfArrival(day, realTimeOfArrival, arrivalDeviation); //поправить
        this.fullUnload=ExecutionOfService3.getFullUnloadTime(unload, delayUnload);
        this.waitingForUnload=ExecutionOfService3.getTimeOfWaitingUnload(fullUnload);
    }

    public double getFullUnload() {
        return fullUnload;
    }

    public void setFullUnload(double fullUnload) {
        this.fullUnload = fullUnload;
    }

    public double getDelayUnload() {
        return delayUnload;
    }

    public void setDelay(double delayUnload) {
        this.delayUnload = delayUnload;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public double getArrivalDeviation() {
        return arrivalDeviation;
    }

    public void setArrivalDeviation(double arrivalDeviation) {
        this.arrivalDeviation = arrivalDeviation;
    }
    public Time getRealTimeOfArrival() {
        return realTimeOfArrival;
    }

    public void setRealTimeOfArrival(Time realTimeOfArrival) {
        this.realTimeOfArrival = realTimeOfArrival;
    }

    public double getWaitingForUnload() {
        return waitingForUnload;
    }

    public void setWaitingForUnload(double waitingForUnload) {
        this.waitingForUnload = waitingForUnload;
    }
 /*public LocalDate getRealDayOfArrival() {
        return realDayOfArrival;
    }

    public void setRealDayOfArrival(LocalDate realDayOfArrival) {
        this.realDayOfArrival = realDayOfArrival;
    }*/

    public String getRealDayOfArrival() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.realDayOfArrival.format(formatter);
    }

    public void setRealDayOfArrival(Object day) {
        if (day instanceof String) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.realDayOfArrival = LocalDate.parse((String) day, formatter);
        } else if (day instanceof LocalDate) {
            this.realDayOfArrival = (LocalDate) day;
        }
    }

    @Override
    public String toString(){
        DecimalFormat df2 = new DecimalFormat("0.00");
        return  super.toString()+"\nDelay Unload: "+df2.format(delayUnload)+ " hours"+"\nPenalty: " + df2.format(penalty) + " y. e."+
                "\nArrival Deviation: " + df2.format(arrivalDeviation)+ " hours"+
                "\nReal Day of Arrival: " + realDayOfArrival + "\nReal time of Arrival: " + realTimeOfArrival +
                "\nFull unload took: "
                + df2.format(fullUnload) + " hours\n" +  "-------------------------\n";
    }


}

