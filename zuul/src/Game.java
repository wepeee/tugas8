public class Game {
    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room outside, lobby, basketballCourt, adminRoom, lab;

        // Initialize rooms
        outside = new Room("outside the building...");
        lobby = new Room("in the lobby...");
        basketballCourt = new Room("on the basketball court...");
        adminRoom = new Room("in the admin room...");
        lab = new Room("in the lab...");

        // Set exits
        outside.setExits(null, null, lobby, null);
        lobby.setExits(outside, basketballCourt, adminRoom, null);
        basketballCourt.setExits(null, null, null, lobby);
        adminRoom.setExits(lobby, null, null, lab);
        lab.setExits(null, adminRoom, null, null);

        // Set starting room
        currentRoom = outside;
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you! Goodbye!");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Adventure!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        printExits();
    }

    private boolean processCommand(Command command) {
        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandword();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("quit")) {
            return quit(command);
        } else {
            System.out.println("This command is not recognized.");
        }
        return false;
    }

    private void printHelp() {
        System.out.println("You are lost. You wander around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("  go quit help");
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondword();

        Room nextRoom = null;
        if (direction.equals("utara")) {
            nextRoom = currentRoom.getKeluarUtara();
        } else if (direction.equals("timur")) {
            nextRoom = currentRoom.getKeluarTimur();
        } else if (direction.equals("selatan")) {
            nextRoom = currentRoom.getKeluarSelatan();
        } else if (direction.equals("barat")) {
            nextRoom = currentRoom.getKeluarBarat();
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            printExits();
        }
    }

    private void printExits() {
        System.out.println("Exits:");
        if (currentRoom.getKeluarUtara() != null) System.out.println("utara");
        if (currentRoom.getKeluarTimur() != null) System.out.println("timur");
        if (currentRoom.getKeluarSelatan() != null) System.out.println("selatan");
        if (currentRoom.getKeluarBarat() != null) System.out.println("barat");
        System.out.println();
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
