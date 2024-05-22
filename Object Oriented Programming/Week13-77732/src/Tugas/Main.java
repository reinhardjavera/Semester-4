package Tugas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main implements BattleLog {
    private static BigBoss boss;
    private static ArrayList<Player> arrPlayers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boss = new BigBoss(1000, 10); // Inisialisasi Big Boss dengan nilai hitPoint 1000 dan damageReduction 10
        Main mainInstance = new Main();
        boss.registerBattleLog(mainInstance);

        while (true) {
            System.out.println("Hello Minna San");
            System.out.println("Welcome to RPG Game");
            System.out.println("1. Add Player");
            System.out.println("2. Hit Boss");
            System.out.println("3. Exit Game");
            System.out.print("Pilihan : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPlayer(scanner);
                    break;
                case 2:
                    hitBoss(scanner);
                    break;
                case 3:
                    System.out.println("Thanks for playing :)");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPlayer(Scanner scanner) {
        System.out.print("Nama : ");
        String name = scanner.nextLine();
        System.out.print("Hit Point : ");
        int hitPoint = scanner.nextInt();
        System.out.print("Damage : ");
        int damage = scanner.nextInt();
        System.out.print("Energy : ");
        int energy = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Player newPlayer = new Player(name, hitPoint, damage, energy);
        arrPlayers.add(newPlayer);
        System.out.println("New Player added successfully named " + name);
    }

    private static void hitBoss(Scanner scanner) {
        if (arrPlayers.isEmpty()) {
            System.out.println("No players available. Add a player first.");
            return;
        }

        System.out.println("Choose your Character:");
        for (int i = 0; i < arrPlayers.size(); i++) {
            Player p = arrPlayers.get(i);
            System.out.println((i + 1) + ". " + p.getName());
            System.out.println("Hit Point : " + p.getHitPoint());
            System.out.println("Damage : " + p.getDamage());
            System.out.println("Energy : " + p.getEnergy());
            System.out.println("---------------------------");
        }
        System.out.print("Silahkan pilih nomor Character: ");
        int playerIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (playerIndex < 0 || playerIndex >= arrPlayers.size()) {
            System.out.println("Invalid character selection. Please try again.");
            return;
        }

        Player selectedPlayer = arrPlayers.get(playerIndex);
        boss.onDamageApplied(selectedPlayer);
    }

    @Override
    public void playerHitBack(Player player, int damageReductionFromBoss) {
        player.setHitPoint(player.getHitPoint() - damageReductionFromBoss);
        player.setEnergy(player.getEnergy() - player.getDamage());
    }

    @Override
    public void reportBattle(Player player, int damageTakenBoss, int hitPointBoss) {
        System.out.println("Player : " + player.getName());
        System.out.println("Damage Given To Boss : " + damageTakenBoss);
        System.out.println("Current Energy : " + player.getEnergy());
        System.out.println("Current HitPoint : " + player.getHitPoint());
        System.out.println("Health Boss : " + hitPointBoss);
    }
}
