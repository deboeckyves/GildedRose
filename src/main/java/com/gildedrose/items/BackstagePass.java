package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ToBeCalculatedItem;

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
        if ( sellIn > 10) quality = updateDefault();
        else if (sellIn <= 10 && sellIn > 5)  quality = update10Days();
        else if (sellIn <= 5 && sellIn > 0) quality = update5Days();
        else quality = updateExpired();
    }

    private int updateDefault() {
        return Math.min(++quality,50);
    }

    private int update10Days() {
        return Math.min(quality+2,50);
    }

    private int update5Days() {
        return Math.min(quality+3,50);
    }

    private int updateExpired() {
        return 0;
    }
}
