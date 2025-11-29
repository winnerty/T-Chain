import java.security.Security;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class TChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;
    public static Wallet walletA;
    public static Wallet walletB;

    public static void main(String[] args) {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        walletA = new Wallet();
        walletB = new Wallet();
        System.out.println("Public and private keys :");
        System.out.println(StringUtil.getStringFromKey(walletA.publicKey));
        System.out.println(StringUtil.getStringFromKey(walletA.privateKey));

        Transaction transaction = new Transaction(walletA.publicKey, walletB.publicKey, 5, null);
        transaction.generateSignature(walletA.privateKey);
        System.out.println("Is signature verified :");
        System.out.println(transaction.verifySignature());

        /*blockchain.add(new Block("first block", "0"));
        System.out.println("trying to Mine block 1...");
        blockchain.get(0).mineBlocks(difficulty);

        blockchain.add(new Block("second block", blockchain.getLast().hash));
        System.out.println("trying to Mine block 2...");
        blockchain.get(1).mineBlocks(difficulty);

        blockchain.add(new Block("third block", blockchain.getLast().hash));
        System.out.println("trying to Mine block 3...");
        blockchain.get(2).mineBlocks(difficulty);

        System.out.println("\nBlockchain is valid : " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain:");
        System.out.println(blockchainJson);*/
    }

    public static boolean isChainValid() {

        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); ++i) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("current Hashes not equal");
                return false;
            }
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("previous Hashes not equal");
                return false;
            }
        }

        return true;

    }

}
