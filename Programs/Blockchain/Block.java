import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	String previousHash;
	public static String pHash;
	String data;
	String currentHash;

	// currentHash is SHA-256 hash of previous hash and current data
        public String calculateHash() {
                String hash = ShaUtils.sha256(this.previousHash, this.data);
                return hash;
        }

	// genesis block
	public Block(String previousHash, String data) {
                this.previousHash = previousHash;
                this.data = data;
                this.currentHash = calculateHash();
		pHash = currentHash;
	}

        public Block(String data) {
                this.previousHash = pHash;
                this.data = data;
                this.currentHash = calculateHash();
		pHash = currentHash;
        }

    @Override
    public String toString() {
        return "[PH-" + this.previousHash +" D-" + this.data
		+ " CH-" + this.currentHash + "]";
    }

private class ShaUtils {

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
