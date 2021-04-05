package Service1;

import java.sql.Time;
import java.time.LocalDate;
import java.text.DecimalFormat;

public class TimeTable {

    //содержимое расписания, входит в json файл
    private String name; //название судна
    private Time time; //время прибытия
    private LocalDate day; //день прибытия
    private Type type; //тип груза
    private double weight; //вес груза
    private double unload; //Время разгрузки

    public TimeTable() {
        this.name = RandomFieldsGenerator.getName();
        this.time = RandomFieldsGenerator.getTime();
        this.day = RandomFieldsGenerator.getDay();
        this.type = RandomFieldsGenerator.getType();
        this.weight = RandomFieldsGenerator.getWeight(type);
        this.unload = RandomFieldsGenerator.getUnload(type, weight);
    }

    @Override
    public String toString() {
        DecimalFormat df2 = new DecimalFormat("0.00");
        return name + "\n" + time + "\n" + day + "\n" + type + "\n" + df2.format(weight) + " тонн\n"
                + df2.format(unload) + " часов\n" +  "-------------------------\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getUnload() {
        return unload;
    }

    public void setUnload(double unload) {
        this.unload = unload;
    }
}


