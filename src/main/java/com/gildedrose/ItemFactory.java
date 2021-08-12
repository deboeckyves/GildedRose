package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.DefaultItem;
import com.gildedrose.items.Sulfuras;

public class ItemFactory {

    public static ToBeCalculatedItem getItem(Item item) {

        switch (item.name) {
            case "standardItem": return new DefaultItem(item.name, item.sellIn, item.quality);
            case "Aged Brie": return new AgedBrie(item.name, item.sellIn, item.quality);
            case "Sulfuras, Hand of Ragnaros": return new Sulfuras(item.name, item.sellIn, item.quality);
            case "Backstage passes to a TAFKAL80ETC concert": return new BackstagePass(item.name, item.sellIn, item.quality);
        }

        throw new UnsupportedOperationException("Unsupported item: "+item.name);
    }
}
