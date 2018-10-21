public class Main {

    public static void main(String[] args) {
        testDeleteLast();
        testDeletefirst();
    }

    private static void testDeleteLast() {
        Udalyator udalyator = new Udalyator(6);
        if (udalyator.deleteX(6)) throw new RuntimeException("delete wrong argument");
        if (udalyator.findSuccessorX(6) != -1) throw new RuntimeException("Can't find successor");

        if (!udalyator.deleteX(5)) throw new RuntimeException("Can't delete last argument");
        if (udalyator.findSuccessorX(5) != -1) throw new RuntimeException("Can't find successor");
    }

    private static void testDeletefirst() {
        Udalyator udalyator = new Udalyator(6);
        if (udalyator.deleteX(-1)) throw new RuntimeException("delete wrong argument");

        if (!udalyator.deleteX(0)) throw new RuntimeException("Can't delete first argument");
        if (udalyator.findSuccessorX(0) != 1) throw new RuntimeException("Can't find successor");
    }
}
