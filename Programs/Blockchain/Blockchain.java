import java.util.LinkedList;

public class Blockchain {

	public static LinkedList<Block> blockchain = new LinkedList<Block>();

	public static void main(String[] args) {
		
    		// create genesis block
		blockchain.add(new Block());
		System.out.println(blockchain);
	}
}
