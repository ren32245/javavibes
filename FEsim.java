import java.util.Random;
public class Brawl {
    static boolean fight = true;
    static Random rand = new Random();
public static void main(String[] args) {
Bots robo1 = new Bots("Eliwood", rand.nextInt(100)+1, rand.nextInt(20)+1,rand.nextInt(20)+1,rand.nextInt(20)+1);
Bots robo2 = new Bots("Hector", rand.nextInt(100)+1, rand.nextInt(20)+1,rand.nextInt(20)+1,rand.nextInt(20)+1);
System.out.println("FIGHT START!\n");

while (fight) {
robo1.whack(robo1, robo2);
robo2.dedcheck();
if (!fight) break;

robo2.whack(robo2, robo1);
robo1.dedcheck();
if (!fight) break
}

System.out.println("\nBattle over!");
}
}
class Bots {
    int hp;
    int def;
    String name;
    int luck;
    int spd;
    Bots(String name, int hp, int def, int luck, int spd) {
        this.name = name;
        this.hp = hp;
        this.def = def;
        this.spd = spd;
        this.luck = luck;
        }
    void taunt(String taunt) {
        if (Brawl.rand.nextInt(10) >= 5) {
            System.out.println(taunt);
        }
    }
    int dodge(Bots hitted) {
        System.out.println(hitted.name + " dodged the attack!");
        taunt(hitted.name + ": Too slow!");
        return 0;
    }
    int crit(Bots hitter, int ogdmg) {
        taunt(hitter.name + ": Prepare yourself!");
        return ogdmg * 3;
        }
    void whack(Bots hitter, Bots hitted) {
        taunt(hitter.name + ": take that!!");
        int dmg = Math.max(0, Brawl.rand.nextInt(30)+1 - hitted.def);
        System.out.println(hitter.name + " attacked " + hitted.name + " for " + dmg + " damage!");
        if (dmg <= 0) {
        System.out.println("Perfect block! " + hitted.name + " took 0 damage.");
            taunt(hitted.name + ": is that the best you can do?");
        } else if (Brawl.rand.nextInt(100) + 1 <= hitter.luck) {
            dmg = crit(hitter,dmg);
        } else if (Brawl.rand.nextInt(100)+1 <= hitted.spd) {
            dmg = dodge(hitted);
        }
        hitted.hp -= dmg;
        System.out.println(hitted.name + " has " + hitted.hp + " HP remaining!");
        System.out.println("\n");
        }

    void dedcheck() {
        if (this.hp <= 0) {
            System.out.println(this.name + " has been defeated!");
            Brawl.fight = false;
            }
    }
}
