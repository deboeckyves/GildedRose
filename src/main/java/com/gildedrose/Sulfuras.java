package com.gildedrose;

public class Sulfuras extends Item implements ToBeCalculatedItem {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void calculateSellIn() {
        sellIn = sellIn;
    }

    @Override
    public void calculateQuality() {
        quality = quality;
    }
}
