package com.gildedrose;

public class BackstagePass extends Item implements ToBeCalculatedItem {

    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    @Override
    public void updateSellIn() {
        sellIn--;
    }

    @Override
    public void updateQuality() {
        if ( sellIn > 10) quality = Math.min(++quality,50);
        else if (sellIn <= 10 && sellIn > 5) quality=Math.min(quality+2,50);
        else if (sellIn <= 5 && sellIn > 0) quality=Math.min(quality+3,50);
        else quality = 0;
    }
}
