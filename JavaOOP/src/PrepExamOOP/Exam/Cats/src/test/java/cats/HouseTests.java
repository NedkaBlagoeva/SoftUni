package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    House house;
    @Before
    public void setup(){
        house = new House("Ned's house", 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNullThrowException(){
        House house1 = new House(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameIsEmptyThrowException(){
        House house1 = new House("   ", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityLessThanZeroThrowException(){
        House house1 = new House("Test", -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatOverCapacity(){
        Cat cat = new Cat("Cat1");
        house.addCat(cat);
        house.addCat(cat);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatDoesNotExist(){
        Cat cat = new Cat("Suzi");
        house.addCat(cat);
        house.removeCat("Eli");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleCatDoesNotExist(){
        house.catForSale("CatName");
    }

    @Test
    public void testCatForSaleWorksFine(){
        Cat cat = new Cat("CatName");
        house.addCat(cat);
        house.catForSale("CatName");
        Assert.assertFalse(cat.isHungry());
    }

    @Test
    public void testStatisticWorkFine(){
        House house1 = new House("TestHouse", 5);
        Cat cat1 = new Cat("Cat1");
        Cat cat2 = new Cat("Cat2");
        Cat cat3 = new Cat("Cat3");
        house1.addCat(cat1);
        house1.addCat(cat2);
        house1.addCat(cat3);
        Assert.assertEquals("The cat Cat1, Cat2, Cat3 is in the house TestHouse!", house1.statistics());
    }
}
