package Service1;

//примерные верхние границы веса и грузоподъемности различных видов кранов найдены в интернете, ссылки на источники указать в отчёте
//грузоподъемность вычисляется в единице тонна в минутах

public enum typeAndWeight {
    CONTAINER, LIQUID, BULK;

    typeAndWeight() {}

    double generateWeight() { //генерирует вес груза контейнера, до 20 000 тон
        double limit = switch (this){
            case CONTAINER -> 20_000.0;
            case LIQUID -> 320_000.0;
            case BULK -> 500_000.0;
        };
        double weight = (double) (Math.random() * limit);
        return weight;
    }


    double generateTime(double weight) {
        double carryingCapacity = switch (this){
            case CONTAINER -> 32.0;
            case LIQUID -> 600.0;
            case BULK -> 1300.0;
        };
        return weight/carryingCapacity;
    }

}
