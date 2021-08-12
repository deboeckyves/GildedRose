package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ToBeCalculatedItem;

public class DefaultItem extends Item implements ToBeCalculatedItem {

    public DefaultItem(String name, int sellIn, int quality) {
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
        return  Math.max(--quality,0);
    }

    private int updateExperired() {
        return  Math.max(quality-2,0);
    }
}
