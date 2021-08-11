package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void basicTest() {
        Item[] items = new Item[] { new Item("standardItem", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("standardItem", app.items[0].name);
    }

    @Test
    void normalCases() {
        Item[] items = new Item[] {
                new Item("standardItem", 15, 15),
                new Item("Aged Brie", 15, 15),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 15),
                //new Item("Conjured Mana Cake", 15, 15)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        //standardItem
        assertEquals(14, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
        //Aged Brie
        assertEquals(14, app.items[1].sellIn);
        assertEquals(16, app.items[1].quality);
        //Sulfuras, Hand of Ragnaros
        assertEquals(0, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);
        //Conjured item
        assertEquals(14, app.items[3].sellIn);
        assertEquals(16, app.items[3].quality);
        //assertEquals(14, app.items[4].sellIn);
        //assertEquals(13, app.items[4].quality);
    }

    @Test
    void sellDatePassed() {
        Item[] items = new Item[] {
                new Item("standardItem", 0, 15),
                new Item("Aged Brie", 0, 15),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 15),
                //new Item("Conjured Mana Cake", 0, 15)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        //standardItem
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
        //Aged Brie
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(17, app.items[1].quality);
        //Sulfuras, Hand of Ragnaros
        assertEquals(0, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);
        //Backstage passes to a TAFKAL80ETC concert
        assertEquals(-1, app.items[3].sellIn);
        assertEquals(0, app.items[3].quality);
        //Conjured item
        //assertEquals(-1, app.items[4].sellIn);
        //assertEquals(11, app.items[4].quality);
    }

    @Test
    void qualityNotNegative() {
        Item[] items = new Item[] {
                new Item("standardItem", 15, 0),
                new Item("Aged Brie", 15, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0),
                //new Item("Conjured Mana Cake", 15, 0)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        //standardItem
        assertEquals(14, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        //Aged Brie
        assertEquals(14, app.items[1].sellIn);
        assertEquals(1, app.items[1].quality);
        //Sulfuras, Hand of Ragnaros
        assertEquals(0, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);
        //Backstage passes to a TAFKAL80ETC concert
        assertEquals(14, app.items[3].sellIn);
        assertEquals(1, app.items[3].quality);
        //Conjured item
        //assertEquals(14, app.items[4].sellIn);
        //assertEquals(0, app.items[4].quality);
    }

    @Test
    void qualityNotOver50() {
        Item[] items = new Item[] {
                new Item("standardItem", 15, 50),
                new Item("Aged Brie", 15, 50),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48),
                //new Item("Conjured Mana Cake", 15, 0)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        //standardItem
        assertEquals(14, app.items[0].sellIn);
        assertEquals(49, app.items[0].quality);
        //Aged Brie
        assertEquals(14, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);
        //Sulfuras, Hand of Ragnaros
        assertEquals(0, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);
        //Backstage passes to a TAFKAL80ETC concert
        assertEquals(14, app.items[3].sellIn);
        assertEquals(50, app.items[3].quality);
        assertEquals(9, app.items[4].sellIn);
        assertEquals(50, app.items[4].quality);
        assertEquals(4, app.items[5].sellIn);
        assertEquals(50, app.items[5].quality);
        //Conjured item
        //assertEquals(14, app.items[4].sellIn);
        //assertEquals(50, app.items[4].quality);
    }

    @Test
    void backstagePass10DaysLeft() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 15),

        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        //Backstage passes to a TAFKAL80ETC concert
        assertEquals(9, app.items[0].sellIn);
        assertEquals(17, app.items[0].quality);
    }

    @Test
    void backstagePass11DaysLeft() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 15),

        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        //Backstage passes to a TAFKAL80ETC concert
        assertEquals(10, app.items[0].sellIn);
        assertEquals(16, app.items[0].quality);

    }

    @Test
    void backstagePass5DaysLeft() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 15),

        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        //Backstage passes to a TAFKAL80ETC concert
        assertEquals(4, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void backstagePas6DaysLeft() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 15),

        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        //Backstage passes to a TAFKAL80ETC concert
        assertEquals(5, app.items[0].sellIn);
        assertEquals(17, app.items[0].quality);

    }

}
