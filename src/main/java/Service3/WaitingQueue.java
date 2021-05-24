package Service3;

import Service1.RandomFieldsGenerator;
import Service1.TimeTable;
import Service1.Type;
import Service2.ToJSON;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Service2.Global.List2;
import static Service2.Global.shipQueue;

//судно прибывает в порт, с текущими данными мы его закидиваем в очередь
//а потом и в новый json файл report.json
public class WaitingQueue implements Runnable {
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

    public WaitingQueue(Type typeOfTheShip) {
        this.typeOfTheShip = typeOfTheShip;
    }

    public WaitingQueue(){
        this.nameOfTheShip=RandomFieldsGenerator.getName();
        this.estimatedTimeOfArrival=RandomFieldsGenerator.getTime();
        this.deviationInArrival=ExecutionOfService3.getArrivalDeviation();
        this.definiteTimeOfArrival=ExecutionOfService3.getRealTimeOfArrival(estimatedTimeOfArrival, deviationInArrival);
        this.estimatedDayOfArrival=RandomFieldsGenerator.getDay();
        this.RealDayOfArrival=ExecutionOfService3.getRealDayOfArrival(estimatedDayOfArrival, definiteTimeOfArrival, deviationInArrival);
        this.typeOfTheShip=RandomFieldsGenerator.getType();
        this.exactWeight=RandomFieldsGenerator.getWeight(typeOfTheShip);
        this.estimatedTimeOfUnload=RandomFieldsGenerator.getUnload(typeOfTheShip, exactWeight);
        this.WaitingInQueue=ExecutionOfService3.getTimeOfWaitingForUnloading(typeOfTheShip, estimatedTimeOfUnload);
        this.beginningOfUnloading=ExecutionOfService3.getBeginningUnloading(WaitingInQueue, definiteTimeOfArrival);
        this.delayUnload=ExecutionOfService3.getUnloadDelay();
        this.penalty=ExecutionOfService3.getPenalty(delayUnload);
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
                "nameOfTheShip='" + nameOfTheShip + "\n"+
                ", estimatedTimeOfArrival=" + estimatedTimeOfArrival + "\n"+
                ", deviationInArrival=" + deviationInArrival +"\n"+
                ", definiteTimeOfArrival=" + definiteTimeOfArrival + "\n"+
                ", WaitingInQueue=" + WaitingInQueue + "\n"+
                ", beginningOfUnloading=" + beginningOfUnloading + "\n"+
                ", estimatedDayOfArrival=" + estimatedDayOfArrival + "\n"+
                ", RealDayOfArrival=" + RealDayOfArrival +"\n"+
                ", typeOfTheShip=" + typeOfTheShip +"\n"+
                ", exactWeight=" + exactWeight +"\n"+
                ", estimatedTimeOfUnload=" + estimatedTimeOfUnload +"\n"+
                ", delayUnload=" + delayUnload +"\n"+
                ", penalty=" + penalty +"\n"+
                '}';
    }

    @Override
    public void run() {
        System.out.println("Unloading started: ");
        for (int i=0; i<10; i++){ //Закыдиваем все судна в очередь
            WaitingQueue newShip=new WaitingQueue(); //создаём новое судно на каждой итерации
            shipQueue.add(newShip); //добавляем в очередь
//            List2.add(newShip); //для добавления в json файл
            System.out.println("Thread" + Thread.currentThread().getId() + "   " + shipQueue.size());
//            try {
//                ToJSON.serializeReport();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        //System.out.println("Unloading started: ");

        //извлекаем одно судно за другим и получаем отчёт о разгрузке
        while (!(shipQueue.isEmpty())){
            WaitingQueue ship2= shipQueue.poll();
            System.out.println("Thread" + Thread.currentThread().getId() + " Ship:" + ship2.nameOfTheShip);
            System.out.println(ship2);
            System.out.println("-------------------------------");
        }
    }
}
