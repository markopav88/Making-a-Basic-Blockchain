package src;
import java.util.Date;

public class Block {

	public String hash; //holds our digital signature
	public String previousHash; //hold the previous block’s hash
	private String data; //our data will be a simple message & hold our block data.
	private long timeStamp; //as number of milliseconds since 1/1/1970.
    private int nonce;

	//Block Constructor.
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
	}
    public String calculateHash() {
        //calculate the new hash from all parts of the block we don’t want to be tampered with.
        String calculatedhash = StringUtil.applySha256( 
                previousHash +
                Long.toString(timeStamp) +
                data 
                );
        return calculatedhash;
    }
    public void mineBlock(int difficulty) {
        //In practice each miner will start iterating from a random point. 
        //Some miners may even try random numbers for nonce
        //mineBlock() method takes in an int called difficulty, this is the number of 0’s they must solve for
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
    }




}