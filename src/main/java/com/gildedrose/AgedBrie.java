package com.gildedrose;

public class AgedBrie extends Item implements ToBeCalculatedItem{

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void updateSellIn() {
        sellIn--;
    }

    @Override
    public void updateQuality() {
        if (sellIn > 0) quality = Math.min(++quality,50);
        if (sellIn <= 0 ) quality = Math.min(quality+2,50);
    }
}
