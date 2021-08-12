package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.interfaces.LegendaryItem;

public class Sulfuras extends Item implements LegendaryItem {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSellIn() {
        update();
    }

    @Override
    public void updateQuality() {
        update();
    }
}
