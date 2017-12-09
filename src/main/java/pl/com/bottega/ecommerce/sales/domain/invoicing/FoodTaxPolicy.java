package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public class FoodTaxPolicy implements TaxPolicy {

    public Tax getTax(RequestItem requestItem) {
        Money net = requestItem.getTotalCost();
        BigDecimal ratio = null;
        String desc = null;

        ratio = BigDecimal.valueOf(0.07);
        desc = "7% (F)";

        Money taxValue = net.multiplyBy(ratio);

        return new Tax(taxValue, desc);
    }
}
