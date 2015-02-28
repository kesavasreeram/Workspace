package cz.cuni.amis.pogamut.ut2004.tournament.deathmatch.config;

import java.io.File;

import cz.cuni.amis.pogamut.ut2004.tournament.match.UT2004BotConfig;

public class MichalBot {

	public static UT2004BotConfig createConfig() {
		UT2004BotConfig config = new UT2004BotConfig();
		
		config.setBotId("MichalBot");
		config.setPathToBotJar("bots" + File.separator + "KnightHunter" + File.separator + "KnightHunter.jar");
		config.setRedirectStdErr(true);
		config.setRedirectStdOut(true);
		config.setTeamNumber(255);
	
		return config;
	}
	
}
