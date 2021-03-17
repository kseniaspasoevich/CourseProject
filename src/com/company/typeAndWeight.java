package com.company;

import java.text.DecimalFormat;
import java.util.Random;

//примерные верхние границы веса и грузоподъемности различных видов кранов найдены в интернете, ссылки на источники указать в отчёте
//грузоподъемность вычисляется в единице тонна в минутах

public enum typeAndWeight {
    CONTAINER, LIQUID, BULK;

    typeAndWeight() {}
    private static DecimalFormat df2=new DecimalFormat("#.##");
    final double carryingCapacityContainer=32.0;
    final double carryingCapacityLiquid=600.0;
    final double carryingCapacityBulk=1300.0;

    void generateContainerData() { //генерирует вес груза контейнера, до 20 000 тон
        double limit = 20_000.0;
        double weight = (double) (Math.random() * limit);
        double durationOfStay = (weight / carryingCapacityContainer) / 60.0; //сразу перевожу минуты в час
        System.out.println("\nWeight: " + df2.format(weight)+" tones");
        System.out.println("Duration of unloading in port: "+ df2.format(durationOfStay)+ " hours");
    }

    void generateTankerData() { //генерирует вес жидкого груза-танкер, до 320 000 тон
        double limit = 320_000.0;
        double weight =  (double) (Math.random() * limit);
        double durationOfStay = (weight / carryingCapacityLiquid) / 60.0; //сразу перевожу  минуты в час
        System.out.println("\nWeight: " + df2.format(weight)+" tones");
        System.out.println("Duration of unloading in port: "+ df2.format(durationOfStay)+ " hours");
    }

    void generateBulkerData() { //генерирует вес сыпучего груза-балкер, до 500 000 тон
        double limit = 500_000.0;
        double weight = (double) (Math.random() * limit);
        double durationOfStay = (weight / carryingCapacityBulk) / 60.0; //сразу перевожу  минуты в час
        System.out.println("\nWeight: " + df2.format(weight)+" tones");
        System.out.println("Duration of unloading in port: "+ df2.format(durationOfStay)+ " hours");
    }
}
