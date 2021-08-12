package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ToBeCalculatedItem;

public class Sulfuras extends Item implements ToBeCalculatedItem {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSellIn() {
        sellIn = sellIn;
    }

    @Override
    public void updateQuality() {
        quality = quality;
    }
}
