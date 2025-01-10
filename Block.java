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
	}
}