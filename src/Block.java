package src;
import java.util.Date;

public class Block {

	public String hash; //holds our digital signature
	public String previousHash; //hold the previous block’s hash
	private String data; //our data will be a simple message & hold our block data.
	private long timeStamp; //as number of milliseconds since 1/1/1970.

	//Block Constructor.
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
	}
    public String calculateHash() {
        //calculate the hash from all parts of the block we don’t want to be tampered with.
        String calculatedhash = StringUtil.applySha256( 
                previousHash +
                Long.toString(timeStamp) +
                data 
                );
        return calculatedhash;
    }
}