package Service3;


import Service1.*;

public class AdditionalParameters extends TimeTable {

    private double delayUnload; //задержка разгрузки
    private double penalty;    //штраф
    private double arrivalDeviation; //отклонение в прибытии

    public AdditionalParameters() {
        super();
        this.delayUnload = ExecutionOfService3.getUnloadDelay();
        this.penalty = ExecutionOfService3.getPenalty(delayUnload);
        this.arrivalDeviation = ExecutionOfService3.getArrivalDeviation();
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

}
