import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {

	private String previousHash;
	private String data;
	private String currentHash;
	private Block next;

    // currentHash is SHA-256 hash of previous hash and current data
    public String calculateHash() {
        String hash = ShaUtils.sha256(previousHash, data);
        return hash;
    }

	public Block() {
		this.previousHash = "0";
		this.data = "genesis block 1";
		this.currentHash = calculateHash();
		this.next = null;
	}
    
    @Override
    public String toString() {
        return "[" + this.previousHash + " " + this.data + " " + this.currentHash + "] --> " + this.next;
    }

public class ShaUtils {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    public static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String sha256(String previousHash, String data) {
        String pHash = previousHash + data;
        byte[] shaInBytes = ShaUtils.digest(pHash.getBytes(UTF_8), "SHA3-256");
        String hash = bytesToHex(shaInBytes);
	    return hash;
    }
  }
}
