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
        System.out.println("in update quality");
        System.out.println("quality before = " +quality);
        System.out.println("sellin before = " +sellIn);
        if (sellIn > 0) {
            System.out.println("in first if");
            quality = Math.max(--quality,0);}
        if (sellIn <= 0 ) quality = Math.max(quality-2,0);
        System.out.println("quality after = " +quality);
        System.out.println("sellin after = " +sellIn);
    }
}
