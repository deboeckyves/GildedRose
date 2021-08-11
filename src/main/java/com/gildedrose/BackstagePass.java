package com.gildedrose;

public class BackstagePass extends Item implements ToBeCalculatedItem {

    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    @Override
    public void calculateSellIn() {
        sellIn--;
    }

    @Override
    public void calculateQuality() {
        if ( sellIn > 10)
            quality++;
        else if (sellIn <= 10 && sellIn > 5) quality+=2;
        else if (sellIn <= 5 && sellIn > 0) quality+=3;
        else quality = 0;

    }
}
