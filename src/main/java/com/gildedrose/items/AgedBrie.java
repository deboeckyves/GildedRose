package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ToBeCalculatedItem;

public class AgedBrie extends Item implements ToBeCalculatedItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void updateSellIn() {
        sellIn--;
    }

    @Override
    public void updateQuality() {
        if (sellIn > 0) quality = updateDefault();
        if (sellIn <= 0 ) quality = updateExperired();
    }

    private int updateDefault() {
        return Math.min(++quality,50);
    }

    private int updateExperired() {
        return Math.min(quality+2,50);
    }
}
