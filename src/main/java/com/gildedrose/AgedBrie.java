package com.gildedrose;

public class AgedBrie extends Item implements ToBeCalculatedItem{

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void calculateSellIn() {
        sellIn--;
    }

    @Override
    public void calculateQuality() {
        if (quality <= 50)
        quality++;
        quality = 50;
    }
}
