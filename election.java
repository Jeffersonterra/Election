
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class election {

    public static void main(String args[]) {
        Scanner leitor = new Scanner(System.in);
        int yes, no, countvote;
        System.out
                .println("Would you like to keep previus election results? input 1 for yes any other number for no: ");

        int keepconst = leitor.nextInt();
        boolean keep = 1 == keepconst;
        yes = 0;
        no = 0;
        countvote = 0;

        do {
            System.out.println("Vote 1 for yes\nVote 2 for no\nVote 0 to close the system");
            countvote = leitor.nextInt();
            if (countvote == 1) {
                System.out.println("You voted yes! Thank you for voting!");
                yes++;
            } else if (countvote == 2) {
                System.out.println("You voted no! Thank you for voting!");
                no++;
            } else {
                System.out.println("No vote registered at this time!");
            }
        } while (countvote != 0);
        System.out.println("There were a total of " + yes + " votes for yes");
        System.out.println("There were a total of " + no + " votes for no");
        try {
            FileWriter writer = new FileWriter("Result.txt", keep);

            writer.write("\nThere were a total of " + yes + " votes for yes   \nThere were a total of " + no
                    + " votes for no");
            writer.append("\n(Powered by Jefftm)");
            writer.close();
        } catch (IOException e) {
            // AUTO GENERATED CATCH BLOCK
            e.printStackTrace();
        }
        leitor.close();

        if (keep == true) {
            System.out.println("All previous results were keep on record.");
        } else {
            System.out.println("All previous results were flushed from record");
        }
    }
}
