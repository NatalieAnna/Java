/* Blockchain 
 * @author Natalie Anna
 * @version April 2022
 */

import java.util.ArrayList;

public class Blockchain {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();

	public static void main(String[] args) {

		blockchain.add(new Block(Constants.GENESIS_PREV_HASH, Constants.GENESIS_DATA));
		blockchain.add(new Block("second block"));
		blockchain.add(new Block("third block"));

		for (Block block : blockchain) {
			System.out.println(block);
		}
	}
}
