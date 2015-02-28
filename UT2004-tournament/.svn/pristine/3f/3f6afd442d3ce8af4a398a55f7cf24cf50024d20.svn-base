package cz.cuni.amis.pogamut.ut2004.tournament.match;

import cz.cuni.amis.pogamut.ut2004.tournament.botexecution.UT2004BotExecutionConfig;
import cz.cuni.amis.utils.token.IToken;

/**
 * Describes configuration of the custom-bot created using Pogamut platform.
 * @author Jimmy
 */
public class UT2004BotConfig extends UT2004BotExecutionConfig implements IUT2004BotConfig {

	/**
	 * Name in the game.
	 */
	private String name = null;
	
	/**
	 * Number of the team the bot should be in.
	 */
	private int teamNumber = 255;
	
	/**
	 * Desired skill of the bot. 
	 */
	private int desiredSkill = -1;
	
	/**
	 * Desired skin of the bot.
	 */
	private String skin = null;
		
	public UT2004BotConfig() {
	}
	
	/**
	 * Copy-constructor.
	 * @param value
	 */
	public UT2004BotConfig(UT2004BotConfig value) {
		super(value);
		this.teamNumber = value.teamNumber;
	}

	@Override
	public int getTeamNumber() {
		return teamNumber;
	}
	
	@Override
	public int getDesiredSkill() {
		return desiredSkill;
	}
	
	@Override	
	public String getSkin() {
		return skin;
	}
	
	public String getName() {
		return name;
	}

	/**
	 * Sets team number the bot should play for.
	 * @param teamNumber
	 */
	public UT2004BotConfig setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
		return this;
	}
	
	/** 
	 * Sets desired skill level for the bot (0 ... NOOB - 7 ... GODLIKE), if negative, default will be used. 
	 * @param desiredSkill
	 * @return
	 */
	public UT2004BotConfig setDesiredSkill(int desiredSkill) {
		this.desiredSkill = desiredSkill;
		return this;
	}
	
	/**
	 * Name to give the bot within the game. 
	 * @param name
	 * @return
	 */
	public UT2004BotConfig setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * Sets bot skin to be used. If null, default will be used. 
	 * @param skin
	 * @return
	 */
	public UT2004BotConfig setSkin(String skin) {
		this.skin = skin;
		return this;
	}
	
	@Override
	public UT2004BotConfig setBotId(String botId) {
		super.setBotId(botId);
		return this;
	}
	
	@Override
	public UT2004BotConfig setBotId(IToken botId) {
		super.setBotId(botId);
		return this;
	}	
	
	@Override
	public UT2004BotConfig setPathToBotJar(String pathToBotJar) {
		super.setPathToBotJar(pathToBotJar);
		return this;
	}
	
	@Override
	public UT2004BotConfig setRedirectStdErr(boolean redirectStdErr) {
		super.setRedirectStdErr(redirectStdErr);
		return this;
	}
	
	@Override
	public UT2004BotConfig setRedirectStdOut(boolean redirectStdOut) {
		super.setRedirectStdOut(redirectStdOut);
		return this;
	}	

	@Override
	public String toString() {
		return "UT2004BotConfig[botId=" + getBotId().getToken() + ", team=" + teamNumber + ", jar=" + getPathToBotJar() + "]";
	}
}
