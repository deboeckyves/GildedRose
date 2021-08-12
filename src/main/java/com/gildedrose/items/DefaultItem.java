package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.interfaces.NonLegendaryItem;

public class DefaultItem extends Item implements NonLegendaryItem {

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
        if (sellIn <= 0 ) quality = updateExpired();
    }

    public int updateDefault() {
        return  Math.max(--quality,0);
    }

    public int updateExpired() {
        return  Math.max(quality-2,0);
    }
}
