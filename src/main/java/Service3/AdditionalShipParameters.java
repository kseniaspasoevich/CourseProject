package Service3;

import Service1.*;

import java.sql.Time;
import java.time.LocalDate;

public class AdditionalShipParameters extends TimeTable {

    private double delayUnload; //задержка разгрузки
    private double penalty;    //штраф
    private double arrivalDeviation; //отклонение в прибытии
    private Time realTimeOfArrival; //Точное время прибытия
    private LocalDate realDayOfArrival; //точная дата прибытия


    public AdditionalShipParameters() {
        super();
        this.delayUnload = ExecutionOfService3.getUnloadDelay();
        this.penalty = ExecutionOfService3.getPenalty(delayUnload);
        this.arrivalDeviation = ExecutionOfService3.getArrivalDeviation();
        this.realTimeOfArrival=ExecutionOfService3.getRealTimeOfArrival(arrivalDeviation);
        this.realDayOfArrival=ExecutionOfService3.getRealDayOfArrival(arrivalDeviation);
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

    public LocalDate getRealDayOfArrival() {
        return realDayOfArrival;
    }

    public void setRealDayOfArrival(LocalDate realDayOfArrival) {
        this.realDayOfArrival = realDayOfArrival;
    }

}

