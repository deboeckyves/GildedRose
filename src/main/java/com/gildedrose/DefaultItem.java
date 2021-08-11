package com.gildedrose;

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
        if (quality > 0)
        quality-=1;
        else quality = 0;
    }
}
