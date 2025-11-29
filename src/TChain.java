import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class TChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        blockchain.add(new Block("first block", "0"));
        blockchain.add(new Block("second block", blockchain.getLast().hash));
        blockchain.add(new Block("third block", blockchain.getLast().hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }

}
