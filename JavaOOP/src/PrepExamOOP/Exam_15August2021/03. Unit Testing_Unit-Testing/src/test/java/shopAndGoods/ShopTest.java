package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class ShopTest {
    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test
    public void constructorWorksFine() {
        assertEquals(12, shop.getShelves().size());
    }

    @Test
    public void constructorShelvesValuesAreNull(){
        Assert.assertNull(shop.getShelves().get("Shelves1"));
        Assert.assertNull(shop.getShelves().get("Shelves2"));
        Assert.assertNull(shop.getShelves().get("Shelves3"));
        Assert.assertNull(shop.getShelves().get("Shelves4"));
        Assert.assertNull(shop.getShelves().get("Shelves5"));
        Assert.assertNull(shop.getShelves().get("Shelves6"));
        Assert.assertNull(shop.getShelves().get("Shelves7"));
        Assert.assertNull(shop.getShelves().get("Shelves8"));
        Assert.assertNull(shop.getShelves().get("Shelves9"));
        Assert.assertNull(shop.getShelves().get("Shelves10"));
        Assert.assertNull(shop.getShelves().get("Shelves11"));
        Assert.assertNull(shop.getShelves().get("Shelves12"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableMap(){
        Map<String, Goods> shelves = shop.getShelves();
        shelves.put("Shelves11", new Goods("apple", "LK46363"));
    }

    @Test
    public void testAddGoodsShouldReturnCorrectMessageOnAddition() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        String expected = "Goods: test_code is placed successfully!";
        String actual = shop.addGoods("Shelves1", goods);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShelfDoesntExistTrowsException() throws OperationNotSupportedException {
        shop.addGoods("shelf", new Goods("tomatoes", "KM12345"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShelfValueIsDifferentOfNull() throws OperationNotSupportedException {
        shop.addGoods("Shelves5", new Goods("tomatoes", "KM12345"));
        shop.addGoods("Shelves5", new Goods("potatoes", "KM12345"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addGoodsIsAlreadyOnTheShelf() throws OperationNotSupportedException {
        Goods goods = new Goods("tomatoes", "KM12345");
        shop.addGoods("Shelves5", goods);
        shop.addGoods("Shelves6", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeShelfDoesntExistTrowsException() {
        shop.removeGoods("shelf", new Goods("tomatoes", "KM12345"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeGoodsDoesntExistThrowsException() {
        Goods goods = new Goods("tomatoes", "KM12345");
        shop.removeGoods("Shelves5", goods);
    }

    @Test
    public void removeWorksFine() throws OperationNotSupportedException {
        Goods goods = new Goods("tomatoes", "KM12345");
        shop.addGoods("Shelves5", goods);
        shop.removeGoods("Shelves5", goods);
        assertNull(shop.getShelves().get("Shelves5"));
    }

    @Test
    public void removeCompareOutput() throws OperationNotSupportedException {
        Goods goods = new Goods("tomatoes", "KM12345");
        shop.addGoods("Shelves5", goods);
        assertEquals(shop.removeGoods("Shelves5", goods), "Goods: KM12345 is removed successfully!");
    }

    @Test
    public void ff() throws OperationNotSupportedException {
        Goods goods = new Goods("tomatoes", "KM12345");
        shop.addGoods("Shelves5", goods);
        Assert.assertTrue(shop.getShelves().containsValue(goods));
    }
}