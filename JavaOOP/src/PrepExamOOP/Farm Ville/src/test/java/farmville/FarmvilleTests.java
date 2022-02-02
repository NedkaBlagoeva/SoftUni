package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {

    @Test
    public void constructorEverythingWorks() {
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals("Cow Farm", farm.getName());
        Assert.assertEquals(5, farm.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void nameEqualsToNullThrowsException() {
        Farm farm = new Farm(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void nameIsEmptyThrowsException() {
        Farm farm = new Farm("    ", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void capacityIsLowerThanZeroThrowsException() {
        Farm farm = new Farm("Cow Farm", -6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AnimalsSizeEqualsToCapacityThrowsException() {
        Farm farm = new Farm("Cow Farm", 1);
        farm.add(new Animal("Dog", 20));
        farm.add(new Animal("Cow", 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void AnimalExistThrowsException() {
        Farm farm = new Farm("Cow Farm", 5);
        farm.add(new Animal("Cow", 20));
        farm.add(new Animal("Cow", 5));
    }

    @Test
    public void count(){
        Farm farm = new Farm("Cow farm", 5);
        farm.add(new Animal("Cow", 55));
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void removeIfAnimalExist(){
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Dog", 99));
        Assert.assertEquals(1, farm.getCount());
        Assert.assertTrue(farm.remove("Dog"));
        Assert.assertEquals(0, farm.getCount());
    }

    @Test
    public void removeIfAnimalDoesntExist(){
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Dog", 99));
        Assert.assertEquals(1, farm.getCount());
        Assert.assertFalse(farm.remove("Cow"));
        Assert.assertEquals(1, farm.getCount());
    }

}
