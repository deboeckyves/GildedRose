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
        if (sellIn > 0) quality = Math.max(--quality,0);
        if (sellIn <= 0 ) quality = Math.max(quality-2,0);
    }
}
