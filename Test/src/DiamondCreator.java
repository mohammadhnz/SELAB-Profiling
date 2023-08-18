import java.io.PrintWriter;
import java.util.*;

public class DiamondCreator {
    public static void main(String[] arg) {
        DiamondDetails diamondDetails = getDiamondDetails();
        createDiamondAndPrint(diamondDetails.k, diamondDetails.shift, diamondDetails.n);
    }

    private static DiamondDetails getDiamondDetails() {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt(), n = s.nextInt();
        int shift = n;
        DiamondDetails diamondDetails = new DiamondDetails(k, n, shift);
        return diamondDetails;
    }

    private static class DiamondDetails {
        public final int k;
        public final int n;
        public final int shift;

        public DiamondDetails(int k, int n, int shift) {
            this.k = k;
            this.n = n;
            this.shift = shift;
        }
    }

    private static void createDiamondAndPrint(int k, int shift, int n) {
        PrintWriter output= new PrintWriter(System.out);
        StringBuilder emptyDiamond=new StringBuilder("");
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n-i+1; j++)
                emptyDiamond.append(" ");
            for (int j = 1; j <= i - 1; j++)
                emptyDiamond.append("**");
            emptyDiamond.append("*");
            emptyDiamond.append("\n");
        }
        for (int i = 1; i <= n - k + 1; i++) {
            for (int j = 1; j <= n-i-k+1; j++)
                emptyDiamond.append(" ");
            for (int j = 0; j < k; j++)
                emptyDiamond.append("*");
            for (int j = 1; j <= i - 1; j++)
                emptyDiamond.append("  ");
            emptyDiamond.append(" ");
            for (int j = 0; j < k; j++)
                emptyDiamond.append("*");
            emptyDiamond.append("\n");
        }
        StringBuilder emptyDiamondd=new StringBuilder("");
        emptyDiamondd.append(emptyDiamond);
        emptyDiamond.delete(emptyDiamond.length()-2*n-3,emptyDiamond.length());
        emptyDiamond.reverse();
        int locationOfSpaces=0,countOfSpaces=0,firstSpaces=0;
        for(int i=n;i>0;i--) {
            locationOfSpaces+=firstSpaces;
            countOfSpaces=n-i+1;
            firstSpaces=2*n+2;
            String spaces=" ";
            for(int j=0;j<countOfSpaces-1;j++)
                spaces=spaces+" ";
            emptyDiamond.insert(locationOfSpaces,spaces);
        }
        emptyDiamondd.append(emptyDiamond);
        output.print(emptyDiamondd);
        output.close();

    }
}
