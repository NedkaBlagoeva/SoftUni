package _FinalExam._04_FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] heroStats = scan.nextLine().split("\\s+");
            String heroName = heroStats[0];
            int heroHP = Integer.parseInt(heroStats[1]);
            int heroMP = Integer.parseInt(heroStats[2]);
            Hero newHero = new Hero(heroName, heroHP, heroMP);
            heroes.add(newHero);
        }
        String commands = scan.nextLine();
        while (!"End".equals(commands)) {
            String[] tokens = commands.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];
            switch (command) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    for (Hero hero : heroes) {
                        if (hero.getName().equals(heroName)) {
                            if (hero.getMp() >= neededMP) {
                                hero.setMp(hero.getMp() - neededMP);
                                System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, hero.getMp());
                            } else {
                                System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                            }
                        }
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    for (Hero hero : heroes) {
                        if (hero.getName().equals(heroName)) {
                            hero.setHp(hero.getHp() - damage);
                            if (hero.getHp() > 0) {
                                System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, hero.getHp());
                            } else {
                                System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                            }
                        }
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    for (Hero hero : heroes) {
                        if (hero.getName().equals(heroName)) {
                            if (hero.getMp() + amount > 200) {
                                System.out.printf("%s recharged for %d MP!%n", heroName, 200 - hero.getMp());
                                hero.setMp(200);
                            } else {
                                hero.setMp(hero.getMp() + amount);
                                System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                            }
                        }
                    }
                    break;
                case "Heal":
                    int amount2 = Integer.parseInt(tokens[2]);
                    for (Hero hero : heroes) {
                        if (hero.getName().equals(heroName)) {
                            if (hero.getHp() + amount2 >= 100) {
                                System.out.printf("%s healed for %d HP!%n", heroName, 100 - hero.getHp());
                                hero.setHp(100);
                            } else {
                                hero.setHp(hero.getHp() + amount2);
                                System.out.printf("%s healed for %d HP!%n", heroName, amount2);
                            }
                        }
                    }
                default:
                    break;
            }
            commands = scan.nextLine();
        }
//        heroes = heroes.stream()
//                .filter(p -> p.getHP() > 0).sorted((a,b) -> b.getHP() - a.getHP()).collect(Collectors.toList());
        heroes.stream().filter(p -> p.getHp() > 0).sorted((p1, p2) -> {
            int result = Integer.compare(p2.getHp(), p1.getHp());
            if (result == 0) {
                result = p1.getName().compareTo(p2.getName());
            }
            return result;
        }).forEach(p -> System.out.printf("%s%nHP: %d%nMP: %d%n", p.getName(), p.getHp(), p.getMp()));


//        for (Hero hero : heroes) {
//            System.out.println(hero.getName());
//            System.out.println("HP: " + hero.getHP());
//            System.out.println("MP: " + hero.getMP());
//        }

    }

    private static class Hero {
        private String name;
        private int hp;
        private int mp;

        public Hero(String name, int hp, int mp) {
            this.name = name;
            this.hp = hp;
            this.mp = mp;
        }

        public String getName() {
            return name;
        }

        public int getHp() {
            return hp;
        }

        public int getMp() {
            return mp;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public void setMp(int mp) {
            this.mp = mp;
        }
    }
}
