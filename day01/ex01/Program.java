public class Program {
    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            System.out.println(new User("User" + i, i * 2));    
        }

        User Bob = new User("Bob", 1000);
        System.out.println(Bob);
        
        System.out.println("Last generated Id: " + UserIdsGenerator.getInstance().lastGeneratedId());
    }
}