package com.gildedrose;

public class DefaultItem extends Item implements ToBeCalculatedItem {

    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    @Override
    public int calculateSellIn() {
        return sellIn-1;
    }

    @Override
    public int calculateQuality() {
        if (quality > 0)
        return quality-1;
        else return 0;
    }
}
