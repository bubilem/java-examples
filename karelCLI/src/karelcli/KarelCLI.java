package karelcli;

public class KarelCLI {

    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("KAREL\n-----");
        Playground board = new Playground();
        Command command = new Command();        
        do {
            System.out.print(">");
            switch (command.detect().get()) {
                case "exit":
                case "bye":
                    System.out.println("Bye.Bye.");
                    exit = true;
                    break;
                case "help":
                    System.out.println("Karel COMMANDS:");
                    System.out.println("exit, show, krok, vlevobok, poloz, reset");
                    break;
                default:
                    try {
                        board.doIt(command);
                    } catch (Exception e) {
                        System.out.println("Chyba: " + e.getMessage());
                    }
            }
        } while (!exit);
    }

}
