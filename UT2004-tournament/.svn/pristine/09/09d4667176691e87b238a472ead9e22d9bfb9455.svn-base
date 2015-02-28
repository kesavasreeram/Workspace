package cz.cuni.amis.pogamut.ut2004.tournament.match;

import cz.cuni.amis.utils.token.IToken;

/**
 * Simple interface for data describing the bot.
 * 
 * @author Jimmy
 */
public interface IUT2004BotConfig {

	/**
	 * Returns ID of this bot configuration. This ID will be used for storing result of the tournament for this bot.
	 * <p><p>
	 * DOES NOT MEAN THAT THE EXECUTED BOT WILL HAVE THIS ID IN UT2004!
	 * 
	 * @return
	 */
	public IToken getBotId();
	
	/**
	 * Returns team of the bot.
	 * @return
	 */
	public int getTeamNumber();
	
	/**
	 * Returns desired skill of the bot. If negative number is returned, it won't be set.
	 * @return
	 */
	public int getDesiredSkill();
	
	/**
	 * Returns required skin for the bot. If null, default will be used. 
	 * @return
	 */
	public String getSkin();
	
}
