package com.gildedrose;

import java.util.stream.Collector;
import java.util.stream.Stream;

//test
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        items = Stream.of(items)
                .parallel()
                .map(item -> ItemFactory.getItem(item))
                .map(item -> {item.updateQuality(); return item;})
                .map(item -> {item.updateSellIn(); return item;})
                .map(item -> (Item) item)
                .toArray(Item[]::new);
    }
}