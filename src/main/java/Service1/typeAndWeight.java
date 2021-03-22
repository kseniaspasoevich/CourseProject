package Service1;

import java.text.DecimalFormat;

//примерные верхние границы веса и грузоподъемности различных видов кранов найдены в интернете, ссылки на источники указать в отчёте
//грузоподъемность вычисляется в единице тонна в минутах

public enum typeAndWeight {
    CONTAINER, LIQUID, BULK;

    typeAndWeight() {}

    final double carryingCapacityContainer = 32.0;
    final double carryingCapacityLiquid = 600.0;
    final double carryingCapacityBulk = 1300.0;

    double generateContainerWeight() { //генерирует вес груза контейнера, до 20 000 тон
        double limit = 20_000.0;
        double weight = (double) (Math.random() * limit);
        return weight;
    }

    double generateTankerWeight() { //генерирует вес жидкого груза-танкер, до 320 000 тон
        double limit = 320_000.0;
        double weight = (double) (Math.random() * limit);
        return weight;
    }

    double generateBulkerWeight() { //генерирует вес сыпучего груза-балкер, до 500 000 тон
        double limit = 500_000.0;
        double weight = (double) (Math.random() * limit);
        return weight;
    }

    double generateContainerTime() { //генерирует срок стоянки на разгрузку контейнера
       return generateContainerWeight()/carryingCapacityContainer;
    }

    double generateTankerTime() { //генерирует срок стоянки на разгрузку танкера
        return generateTankerWeight()/carryingCapacityLiquid;
    }

    double generateBulkerTime() { //генерирует срок стоянки на разгрузку булкера
        return generateContainerWeight()/carryingCapacityBulk;
    }

}
