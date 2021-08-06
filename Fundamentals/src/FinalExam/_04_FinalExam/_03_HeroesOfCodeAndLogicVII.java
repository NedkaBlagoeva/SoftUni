package FinalExam._04_FinalExam;

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
                            if (hero.getMP() >= neededMP) {
                                hero.setMP(hero.getMP() - neededMP);
                                System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, hero.getMP());
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
                            hero.setHP(hero.getHP() - damage);
                            if (hero.getHP() > 0) {
                                System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, hero.getHP());
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
                            if (hero.getMP() + amount > 200) {
                                System.out.printf("%s recharged for %d MP!%n", heroName, 200 - hero.getMP());
                                hero.setMP(200);
                            } else {
                                hero.setMP(hero.getMP() + amount);
                                System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                            }
                        }
                    }
                    break;
                case "Heal":
                    int amount2 = Integer.parseInt(tokens[2]);
                    for (Hero hero : heroes) {
                        if (hero.getName().equals(heroName)) {
                            if (hero.getHP() + amount2 >= 100) {
                                System.out.printf("%s healed for %d HP!%n", heroName, 100 - hero.getHP());
                                hero.setHP(100);
                            } else {
                                hero.setHP(hero.getHP() + amount2);
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
        heroes.stream().filter(p -> p.getHP() > 0).sorted((p1, p2) -> {
            int result = Integer.compare(p2.getHP(), p1.getHP());
            if (result == 0) {
                result = p1.getName().compareTo(p2.getName());
            }
            return result;
        }).forEach(p -> System.out.printf("%s%nHP: %d%nMP: %d%n", p.getName(), p.getHP(), p.getMP()));


//        for (Hero hero : heroes) {
//            System.out.println(hero.getName());
//            System.out.println("HP: " + hero.getHP());
//            System.out.println("MP: " + hero.getMP());
//        }

    }

    private static class Hero {
        private String name;
        private int HP;
        private int MP;

        public Hero(String name, int HP, int MP) {
            this.name = name;
            this.HP = HP;
            this.MP = MP;
        }

        public String getName() {
            return name;
        }

        public int getHP() {
            return HP;
        }

        public int getMP() {
            return MP;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHP(int HP) {
            this.HP = HP;
        }

        public void setMP(int MP) {
            this.MP = MP;
        }
    }
}
