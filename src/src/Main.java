import java.util.Scanner;

public class Main {

    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);
        TicketQueue ticketQueue = new TicketQueue();
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("""
                    1. Kunden hinzufügen
                    2. Nächsten Kunden aufrufen
                    3. Vorne schauen
                    4. Warteschlange anzeigen
                    5. Warteschlange leeren
                    6. Beenden
                    """);

            int menuChoice;

            while (true) {
                String menuInput = scanner.nextLine();

                try {
                    menuChoice = Integer.parseInt(menuInput);
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Gib eine Nummer ein!");
                }
            }

            switch (menuChoice) {
                case 1:
                    System.out.println("Gib einen Namen ein:");
                    String newCustomer = scanner.nextLine();

                    ticketQueue.addCustomer(newCustomer);
                    System.out.printf("%s erfolgreich gespeichert!%n", newCustomer);
                    break;
                case 2:
                    System.out.println("--- Nächster Kunde wird aufgerufen ---");
                    String nextCustomer = ticketQueue.nextCustomer();

                    if (nextCustomer == null) {
                        System.out.println("Warteschlange ist leer...\n");
                    } else {
                        System.out.println(nextCustomer);
                    }
                    break;
                case 3:
                    System.out.println("--- Nächster Kunde in der Reihe ---");
                    String peekNextCustomer = ticketQueue.peekCustomer();

                    if (peekNextCustomer == null) {
                        System.out.println("Warteschlange ist leer...\n");
                    } else {
                        System.out.println(peekNextCustomer);
                    }
                    break;
                case 4:
                    System.out.println("--- Komplette Warteschlange ---");
                    if (ticketQueue.isEmpty()) {
                        System.out.println("Warteschlange ist leer...\n");
                    } else {
                        for (String customer : ticketQueue.getAllCustomers()) {
                            System.out.println(customer);
                        }
                    }
                    break;
                case 5:
                    ticketQueue.clearQueue();
                    System.out.println("Warteschlange wurde geleert\n");
                    break;
                case 6:
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte 1 - 6 eingeben!");
            }
        }
    }
}