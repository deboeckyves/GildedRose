package com.gildedrose;

import com.gildedrose.interfaces.ToBeCalculatedItem;
import com.gildedrose.items.*;

public class ItemFactory {

    public static ToBeCalculatedItem getItem(Item item) {

        switch (item.name) {
            case "standardItem": return new DefaultItem(item.name, item.sellIn, item.quality);
            case "Aged Brie": return new AgedBrie(item.name, item.sellIn, item.quality);
            case "Sulfuras, Hand of Ragnaros": return new Sulfuras(item.name, item.sellIn, item.quality);
            case "Backstage passes to a TAFKAL80ETC concert": return new BackstagePass(item.name, item.sellIn, item.quality);
            case "Conjured item": return new Conjured(item.name, item.sellIn, item.quality);
        }

        throw new UnsupportedOperationException("Unsupported item: "+item.name);
    }
}
