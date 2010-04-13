package model;

public class Target {
	public static final double MAGIC_SUPPRESSION = 0.94;
	public Debuffs debuffs;

	public Target() {
		debuffs = new Debuffs();
	}
	
	public double magicSuppression() {
		return MAGIC_SUPPRESSION;
	}
}
