package karelcli;

import java.util.Scanner;

public class Command {

    private String cmd;

    private final Scanner scanner;

    public Command() {
        scanner = new Scanner(System.in);
    }

    public Command detect() {
        set(scanner.next());
        return this;
    }

    public void set(String cmd) {
        this.cmd = cmd.trim();
    }

    public String get() {
        return this.cmd;
    }

}
