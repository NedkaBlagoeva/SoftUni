package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class HeroRepositoryTests {
    Hero hero;
    HeroRepository heroRepository;

    @Before
    public void setup() {
        hero = new Hero("Ivan", 1);
        heroRepository = new HeroRepository();
    }

    @Test
    public void testCount() {
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHeroNameNullThrowsException() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroNameDabble() {
        Hero hero1 = new Hero("Ivan", 5);
        heroRepository.create(hero);
        heroRepository.create(hero1);
    }

    @Test
    public void testCreateHeroOutputMessage() {
        Assert.assertEquals("Successfully added hero Ivan with level 1", heroRepository.create(hero));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNameNullThrowsException() {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNameEmptyTrowsException(){
        heroRepository.remove("   ");
    }

    @Test
    public void testRemoveWorksFine(){
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
        Assert.assertTrue(heroRepository.remove("Ivan"));
        Assert.assertEquals(0, heroRepository.getCount());
    }

    @Test
    public void testGetHeroWithHighestLevelWorksFine(){
        heroRepository.create(hero);
        Hero hero1 = new Hero("Pesho", 35);
        heroRepository.create(hero1);
        Hero hero2 = new Hero("Gosho", 28);
        heroRepository.create(hero2);
        Assert.assertEquals(hero1, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelNoHighestLvl(){
        Assert.assertNull(heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWorksFine(){
        heroRepository.create(hero);
        Assert.assertEquals(hero,heroRepository.getHero("Ivan"));
    }

    @Test
    public void testGetHeroIfThereIsNotSuchHero(){
        heroRepository.create(hero);
        Assert.assertNull(heroRepository.getHero("Stoqn"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetHeroesUnmodifiableCollection(){
        Collection<Hero> heroes = heroRepository.getHeroes();
        heroes.add(hero);
    }
}
