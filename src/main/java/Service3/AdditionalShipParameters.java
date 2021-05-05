package Service3;

import Service1.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdditionalShipParameters extends TimeTable {

    private double delayUnload; //задержка разгрузки
    double fullUnload; //полная разгрузка
    private double penalty;    //штраф
    private double arrivalDeviation; //отклонение в прибытии
    private Time realTimeOfArrival; //Точное время прибытия
    private LocalDate realDayOfArrival; //точная дата прибытия


    public AdditionalShipParameters() {
        super();
        this.delayUnload = ExecutionOfService3.getUnloadDelay();
        this.penalty = ExecutionOfService3.getPenalty(delayUnload);
        this.arrivalDeviation = ExecutionOfService3.getArrivalDeviation();
        this.realTimeOfArrival=ExecutionOfService3.getRealTimeOfArrival(time, arrivalDeviation);
        this.realDayOfArrival=ExecutionOfService3.getRealDayOfArrival(day, realTimeOfArrival, arrivalDeviation); //поправить
        this.fullUnload=ExecutionOfService3.getFullUnloadTime(unload, delayUnload);
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

}

