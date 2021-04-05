package Service3;


import java.text.DecimalFormat;

public class AdditionalParameters {

    private double delayUnload; //задержка разгрузки
    private double penalty;    //штраф
    private double arrivalDeviation; //отклонение в прибытии

    public AdditionalParameters() {
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

    @Override
    public String toString() {
        //DecimalFormat df2 = new DecimalFormat("0.00");
        String s ="Отклонение в прибытии: " + arrivalDeviation + "\n";
        return s;
    }
}
