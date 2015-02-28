package cz.cuni.amis.pogamut.ut2004.tournament;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import au.com.bytecode.opencsv.CSVReader;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Switch;
















import cz.cuni.amis.pogamut.base.utils.logging.LogCategory;
import cz.cuni.amis.pogamut.ut2004.communication.messages.ItemType;
import cz.cuni.amis.pogamut.ut2004.communication.translator.bot.state.BotDeadState;
import cz.cuni.amis.pogamut.ut2004.tournament.capturetheflag.UT2004CaptureTheFlag;
import cz.cuni.amis.pogamut.ut2004.tournament.capturetheflag.UT2004CaptureTheFlagConfig;
import cz.cuni.amis.pogamut.ut2004.tournament.deathmatch.UT2004DeathMatch;
import cz.cuni.amis.pogamut.ut2004.tournament.deathmatch.UT2004DeathMatchConfig;
import cz.cuni.amis.pogamut.ut2004.tournament.match.UT2004BotConfig;
import cz.cuni.amis.pogamut.ut2004.tournament.match.UT2004HumanConfig;
import cz.cuni.amis.pogamut.ut2004.tournament.match.UT2004MatchConfig;
import cz.cuni.amis.pogamut.ut2004.tournament.match.UT2004NativeBotConfig;


public class UT2004MatchConsole {

	static int globalGenerationNumber=1;
	static int numberOfGenerations=30;
	static int numberOfIterations=3;
	static int currentIterationNumber=1;
	static String baseLineBotsPATH = "C:\\Users\\MotionCapture\\Documents\\NetBeansProjects\\mavenproject3\\target\\mavenproject3-1.0-SNAPSHOT.one-jar.jar";
	static String baseLineBotTeamPATH = ";" + baseLineBotsPATH +";" + baseLineBotsPATH + ";" + baseLineBotsPATH;

	static String bot1JAR = "C:\\Karthik\\Simulation\\JAR\\1.jar";
	static String bot2JAR = "C:\\Karthik\\Simulation\\JAR\\2.jar";
	static String bot3JAR = "C:\\Karthik\\Simulation\\JAR\\3.jar";
	static String bot4JAR = "C:\\Karthik\\Simulation\\JAR\\4.jar";
	static String bot5JAR = "C:\\Karthik\\Simulation\\JAR\\5.jar";
	static String bot6JAR = "C:\\Karthik\\Simulation\\JAR\\6.jar";
	static String bot7JAR = "C:\\Karthik\\Simulation\\JAR\\7.jar";
	static String bot8JAR = "C:\\Karthik\\Simulation\\JAR\\8.jar";
	static String bot9JAR = "C:\\Karthik\\Simulation\\JAR\\9.jar";
	static String bot10JAR = "C:\\Karthik\\Simulation\\JAR\\10.jar";
	static String bot11JAR = "C:\\Karthik\\Simulation\\JAR\\11.jar";
	static String bot12JAR = "C:\\Karthik\\Simulation\\JAR\\12.jar";
	static String bot13JAR = "C:\\Karthik\\Simulation\\JAR\\13.jar";
	static String bot14JAR = "C:\\Karthik\\Simulation\\JAR\\14.jar";
	static String bot15JAR = "C:\\Karthik\\Simulation\\JAR\\15.jar";
	static String bot16JAR = "C:\\Karthik\\Simulation\\JAR\\16.jar";
	static String bot17JAR = "C:\\Karthik\\Simulation\\JAR\\17.jar";
	static String bot18JAR = "C:\\Karthik\\Simulation\\JAR\\18.jar";
	static String bot19JAR = "C:\\Karthik\\Simulation\\JAR\\19.jar";
	static String bot20JAR = "C:\\Karthik\\Simulation\\JAR\\20.jar";
	static String bot21JAR = "C:\\Karthik\\Simulation\\JAR\\21.jar";
	static String bot22JAR = "C:\\Karthik\\Simulation\\JAR\\22.jar";
	static String bot23JAR = "C:\\Karthik\\Simulation\\JAR\\23.jar";
	static String bot24JAR = "C:\\Karthik\\Simulation\\JAR\\24.jar";
	static String bot25JAR = "C:\\Karthik\\Simulation\\JAR\\25.jar";
	static String bot26JAR = "C:\\Karthik\\Simulation\\JAR\\26.jar";
	static String bot27JAR = "C:\\Karthik\\Simulation\\JAR\\27.jar";
	static String bot28JAR = "C:\\Karthik\\Simulation\\JAR\\28.jar";
	static String bot29JAR = "C:\\Karthik\\Simulation\\JAR\\29.jar";
	static String bot30JAR = "C:\\Karthik\\Simulation\\JAR\\30.jar";
	static String bot31JAR = "C:\\Karthik\\Simulation\\JAR\\31.jar";
	static String bot32JAR = "C:\\Karthik\\Simulation\\JAR\\32.jar";
	static String bot33JAR = "C:\\Karthik\\Simulation\\JAR\\33.jar";
	static String bot34JAR = "C:\\Karthik\\Simulation\\JAR\\34.jar";
	static String bot35JAR = "C:\\Karthik\\Simulation\\JAR\\35.jar";
	static String bot36JAR = "C:\\Karthik\\Simulation\\JAR\\36.jar";
	static String bot37JAR = "C:\\Karthik\\Simulation\\JAR\\37.jar";
	static String bot38JAR = "C:\\Karthik\\Simulation\\JAR\\38.jar";
	static String bot39JAR = "C:\\Karthik\\Simulation\\JAR\\39.jar";
	static String bot40JAR = "C:\\Karthik\\Simulation\\JAR\\40.jar";
	static String bot41JAR = "C:\\Karthik\\Simulation\\JAR\\41.jar";
	static String bot42JAR = "C:\\Karthik\\Simulation\\JAR\\42.jar";
	static String bot43JAR = "C:\\Karthik\\Simulation\\JAR\\43.jar";
	static String bot44JAR = "C:\\Karthik\\Simulation\\JAR\\44.jar";
	static String bot45JAR = "C:\\Karthik\\Simulation\\JAR\\45.jar";
	static String bot46JAR = "C:\\Karthik\\Simulation\\JAR\\46.jar";
	static String bot47JAR = "C:\\Karthik\\Simulation\\JAR\\47.jar";
	static String bot48JAR = "C:\\Karthik\\Simulation\\JAR\\48.jar";
	static String bot49JAR = "C:\\Karthik\\Simulation\\JAR\\49.jar";
	static String bot50JAR = "C:\\Karthik\\Simulation\\JAR\\50.jar";
	static String bot51JAR = "C:\\Karthik\\Simulation\\JAR\\51.jar";
	static String bot52JAR = "C:\\Karthik\\Simulation\\JAR\\52.jar";
	static String bot53JAR = "C:\\Karthik\\Simulation\\JAR\\53.jar";
	static String bot54JAR = "C:\\Karthik\\Simulation\\JAR\\54.jar";
	static String bot55JAR = "C:\\Karthik\\Simulation\\JAR\\55.jar";
	static String bot56JAR = "C:\\Karthik\\Simulation\\JAR\\56.jar";
	static String bot57JAR = "C:\\Karthik\\Simulation\\JAR\\57.jar";
	static String bot58JAR = "C:\\Karthik\\Simulation\\JAR\\58.jar";
	static String bot59JAR = "C:\\Karthik\\Simulation\\JAR\\59.jar";
	static String bot60JAR = "C:\\Karthik\\Simulation\\JAR\\60.jar";



	static String[] gameMatch = {
		bot1JAR+";"+bot2JAR+";"+bot3JAR,
		bot4JAR+";"+bot5JAR+";"+bot6JAR,
		bot7JAR+";"+bot8JAR+";"+bot9JAR,
		bot10JAR+";"+bot11JAR+";"+bot12JAR,
		bot13JAR+";"+bot14JAR+";"+bot15JAR,
		bot16JAR+";"+bot17JAR+";"+bot18JAR,
		bot19JAR+";"+bot20JAR+";"+bot21JAR,
		bot22JAR+";"+bot23JAR+";"+bot24JAR,
		bot25JAR+";"+bot26JAR+";"+bot27JAR,
		bot28JAR+";"+bot29JAR+";"+bot30JAR,
		bot31JAR+";"+bot32JAR+";"+bot33JAR,
		bot34JAR+";"+bot35JAR+";"+bot36JAR,
		bot37JAR+";"+bot38JAR+";"+bot39JAR,
		bot40JAR+";"+bot41JAR+";"+bot42JAR,
		bot43JAR+";"+bot44JAR+";"+bot45JAR,
		bot46JAR+";"+bot47JAR+";"+bot48JAR,
		bot49JAR+";"+bot50JAR+";"+bot51JAR,
		bot52JAR+";"+bot53JAR+";"+bot54JAR,
		bot55JAR+";"+bot56JAR+";"+bot57JAR,
		bot58JAR+";"+bot59JAR+";"+bot60JAR,
	};

	public enum MatchType {

		DM("DM", "Death Match", false, "BotDeathMatch"),
		TDM("TDM", "Team Death Match", true, "BotTeamGame"),
		CTF("CTF", "Capture the flag", true, "BotCTFGame"),
		DD("DD", "Double Domination", true, "BotDoubleDomination"),
		;

		String shortName;
		String name;
		boolean teamGame;
		String uccGameType;

		private MatchType(String shortName, String name, boolean teamGame, String uccGameType) {
			this.shortName = shortName;
			this.name = name;
			this.teamGame = teamGame;
			this.uccGameType = uccGameType;
		}

	}

	private static final char ARG_MATCH_TYPE_SHORT = 'y';

	private static final String ARG_MATCH_TYPE_LONG = "match-type";

	private static final char ARG_UT2004_HOME_DIR_SHORT = 'u';

	private static final String ARG_UT2004_HOME_DIR_LONG = "ut2004-home-dir";

	private static final char ARG_NATIVE_COUNT_SHORT = 'c';

	private static final String ARG_NATIVE_COUNT_LONG = "native-count";

	private static final char ARG_NATIVE_NAMES_SHORT = 'd';

	private static final String ARG_NATIVE_NAMES_LONG = "native-names";

	private static final char ARG_NATIVE_SKILLS_SHORT = 'e';

	private static final String ARG_NATIVE_SKILLS_LONG = "native-skills";

	private static final char ARG_NATIVE_TEAMS_SHORT = 'g';

	private static final String ARG_NATIVE_TEAMS_LONG = "native-teams";

	private static final char ARG_HUMAN_COUNT_SHORT = 'x';

	private static final String ARG_HUMAN_COUNT_LONG = "human-count";

	private static final char ARG_HUMAN_TEAMS_SHORT = 'z';

	private static final String ARG_HUMAN_TEAMS_LONG = "human-teams";

	private static final char ARG_BOT_JARs_SHORT = 'a';

	private static final String ARG_BOT_JARs_LONG = "bot-jars";

	private static final char ARG_BOT_NAMES_SHORT = 'b';

	private static final String ARG_BOT_NAMES_LONG = "bot-names";

	private static final char ARG_BOT_SKINS_SHORT = 'k';

	private static final String ARG_BOT_SKINS_LONG = "bot-skins";

	private static final char ARG_BOT_SKILLS_SHORT = 'l';

	private static final String ARG_BOT_SKILLS_LONG = "bot-skills";

	private static final char ARG_BOT_TEAMS_SHORT = 'i';

	private static final String ARG_BOT_TEAMS_LONG = "bot-teams";

	private static final char ARG_MAP_NAME_SHORT = 'm';

	private static final String ARG_MAP_NAME_LONG = "map-name";

	private static final char ARG_MATCH_NAME_SHORT = 'n';

	private static final String ARG_MATCH_NAME_LONG = "match-name";

	private static final char ARG_RESULT_DIR_SHORT = 'r';

	private static final String ARG_RESULT_DIR_LONG = "result-directory";

	private static final char ARG_SERVER_NAME_SHORT = 's';

	private static final String ARG_SERVER_NAME_LONG = "server-name";

	private static final char ARG_SCORE_LIMIT_SHORT = 'f';

	private static final String ARG_SCORE_LIMIT_LONG = "score-limit";

	private static final char ARG_TIMEOUT_MINUTES_SHORT = 't';

	private static final String ARG_TIMEOUT_MINUTES_LONG = "timeout-minutes";

	private static final char ARG_HUMAN_LIKE_LOG_SHORT = 'h';

	private static final String ARG_HUMAN_LIKE_LOG_LONG = "human-like-log";

	private static final char ARG_UT2004_PORT_SHORT = 'p';

	private static final String ARG_UT2004_PORT_LONG = "ut2004-port";

	private static JSAP jsap;

	private static boolean headerOutput = false;

	private static String ut2004HomeDir;

	private static int nativeCount;

	private static String matchTypeName;

	private static MatchType matchType;

	private static String nativeNames;

	private static String[] nativeNamesSeparated;

	private static String nativeSkills;

	private static String[] nativeSkillsSeparated;

	private static Integer[] nativeSkillsNumbers;

	private static String nativeTeams;

	private static String[] nativeTeamsSeparated;

	private static Integer[] nativeTeamsNumbers;

	public static int humanCount;

	private static String humanTeams;

	private static String[] humanTeamsSeparated;

	private static Integer[] humanTeamsNumbers;

	private static int botCount;

	private static String botJars;

	private static String[] botJarsSeparated;

	private static String botNames;

	private static String[] botNamesSeparated;

	private static String botSkills;

	private static String[] botSkillsSeparated;

	private static Integer[] botSkillsNumbers;

	private static String botTeams;

	private static String[] botTeamsSeparated;

	private static Integer[] botTeamsNumbers;

	private static String botSkins;

	private static String[] botSkinsSeparated;

	private static File[] botJarFiles;

	private static String map;

	private static String serverName;

	private static String resultDir;

	private static String matchName;

	private static int scoreLimit;

	private static int timeoutMinutes;

	private static JSAPResult config;

	private static File ut2004HomeDirFile;

	private static File bot1JarFile;

	private static File bot2JarFile;

	private static File mapsDirFile;

	private static File mapFile;

	private static File ut2004SystemDirFile;

	private static File ut2004IniFile;

	private static boolean humanLikeLog;

	private static int ut2004Port;	

	private static void fail(String errorMessage) {
		fail(errorMessage, null);
	}

	private static void fail(String errorMessage, Throwable e) {
		header();
		System.out.println("ERROR: " + errorMessage);
		System.out.println();
		if (e != null) {
			e.printStackTrace();
			System.out.println("");
		}		
		System.out.println("Usage: java -jar ut2004-tournament-1v1....jar ");
		System.out.println("                " + jsap.getUsage());
		System.out.println();
		System.out.println(jsap.getHelp());
		System.out.println();
		throw new RuntimeException("FAILURE: " + errorMessage);
	}

	private static void header() {
		if (headerOutput) return;
		System.out.println();
		System.out.println("=============================");
		System.out.println("Pogamut UT2004 Match Executor");
		System.out.println("=============================");
		System.out.println();
		headerOutput = true;
	}

	private static String getMatchTypes() {
		StringBuffer sb = new StringBuffer();
		boolean first = true;
		for (MatchType matchType : MatchType.values()) {
			if (first) first = false;
			else sb.append(", ");
			sb.append(matchType.shortName + " (" + matchType.name + ")");
		}
		return sb.toString();
	}

	private static void initJSAP() throws JSAPException {
		jsap = new JSAP();

		FlaggedOption opt1 = new FlaggedOption(ARG_UT2004_HOME_DIR_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(true) 
		.setShortFlag(ARG_UT2004_HOME_DIR_SHORT)
		.setLongFlag(ARG_UT2004_HOME_DIR_LONG);    
		opt1.setHelp("UT2004 home directory containing GameBots2004 (System/GameBots2004.u) present.");

		jsap.registerParameter(opt1);

		FlaggedOption opt111 = new FlaggedOption(ARG_MATCH_TYPE_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(true) 
		.setShortFlag(ARG_MATCH_TYPE_SHORT)
		.setLongFlag(ARG_MATCH_TYPE_LONG);    
		opt111.setHelp("Type of the match to execute. Valid values: " + getMatchTypes());

		jsap.registerParameter(opt111);

		FlaggedOption opt2 = new FlaggedOption(ARG_BOT_JARs_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_BOT_JARs_SHORT)
		.setLongFlag(ARG_BOT_JARs_LONG);    
		opt2.setHelp("Semicolon separated PATH/TO/JAR/file1;PATH/TO/JAR/file2 containing executable jars of bots.");

		jsap.registerParameter(opt2);

		FlaggedOption opt3 = new FlaggedOption(ARG_BOT_NAMES_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_BOT_NAMES_SHORT)
		.setLongFlag(ARG_BOT_NAMES_LONG);    
		opt3.setHelp("Semicolon separated name1;name2;name3 (ids) that should be given to bots.");

		jsap.registerParameter(opt3);

		FlaggedOption opt31 = new FlaggedOption(ARG_BOT_SKILLS_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_BOT_SKILLS_SHORT)
		.setLongFlag(ARG_BOT_SKILLS_LONG);    
		opt31.setHelp("Semicolon separated skill1;skill2;skill3 (desired skill levels) that should be given to bots. Can have 'empty space', e.g 1;;2, within to mark 'use bot supplied default value'.");

		jsap.registerParameter(opt31);

		FlaggedOption opt32 = new FlaggedOption(ARG_BOT_SKINS_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_BOT_SKINS_SHORT)
		.setLongFlag(ARG_BOT_SKINS_LONG);    
		opt32.setHelp("Semicolon separated skin1;skin2;skin3 (skins) that should be given to bots. Can have 'empty space', e.g skin1;;skin3, within to mark 'use bot supplied default value'.");

		jsap.registerParameter(opt32);

		FlaggedOption opt33 = new FlaggedOption(ARG_BOT_TEAMS_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_BOT_TEAMS_SHORT)
		.setLongFlag(ARG_BOT_TEAMS_LONG);    
		opt33.setHelp("Semicolon separated team1;team2;team3 (desired teams) that should bots be in.");

		jsap.registerParameter(opt33);

		FlaggedOption opt6 = new FlaggedOption(ARG_MAP_NAME_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_MAP_NAME_SHORT)
		.setLongFlag(ARG_MAP_NAME_LONG);    
		opt6.setHelp("Map where the game should be played (e.g. DM-1on1-Albatross).");

		jsap.registerParameter(opt6);

		FlaggedOption opt7 = new FlaggedOption(ARG_MATCH_NAME_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_MATCH_NAME_SHORT)
		.setLongFlag(ARG_MATCH_NAME_LONG)
		.setDefault("DMMatch1v1");    
		opt7.setHelp("Name of the match == output folder for the results.");

		jsap.registerParameter(opt7);

		FlaggedOption opt8 = new FlaggedOption(ARG_RESULT_DIR_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_RESULT_DIR_SHORT)
		.setLongFlag(ARG_RESULT_DIR_LONG)
		.setDefault(".");
		opt8.setHelp("PATH/TO/directory where to output results (does not need to exist).");

		jsap.registerParameter(opt8);

		FlaggedOption opt9 = new FlaggedOption(ARG_SERVER_NAME_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_SERVER_NAME_SHORT)
		.setLongFlag(ARG_SERVER_NAME_LONG)
		.setDefault("DMMatch1v1");
		opt9.setHelp("Server name that should be advertised via LAN.");

		jsap.registerParameter(opt9);

		FlaggedOption opt10 = new FlaggedOption(ARG_SCORE_LIMIT_LONG)
		.setStringParser(JSAP.INTEGER_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_SCORE_LIMIT_SHORT)
		.setLongFlag(ARG_SCORE_LIMIT_LONG)
		.setDefault("20");
		opt10.setHelp("DeathMatch - frag limit, Capture The Flag - team score limit");

		jsap.registerParameter(opt10);

		FlaggedOption opt11 = new FlaggedOption(ARG_TIMEOUT_MINUTES_LONG)
		.setStringParser(JSAP.INTEGER_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_TIMEOUT_MINUTES_SHORT)
		.setLongFlag(ARG_TIMEOUT_MINUTES_LONG)
		.setDefault("20");
		opt11.setHelp("Match timeout in minutes.");

		jsap.registerParameter(opt11);

		Switch opt12 = new Switch(ARG_HUMAN_LIKE_LOG_LONG)
		.setShortFlag(ARG_HUMAN_LIKE_LOG_SHORT)
		.setLongFlag(ARG_HUMAN_LIKE_LOG_LONG)
		.setDefault("false");
		opt12.setHelp("Whether to produce log for 'HumanLike Project' analysis.");

		jsap.registerParameter(opt12);

		FlaggedOption opt13 = new FlaggedOption(ARG_UT2004_PORT_LONG)
		.setStringParser(JSAP.INTEGER_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_UT2004_PORT_SHORT)
		.setLongFlag(ARG_UT2004_PORT_LONG)
		.setDefault("7777");
		opt13.setHelp("UT2004 port for the dedicated server (1-32000).");

		jsap.registerParameter(opt13);

		FlaggedOption opt14 = new FlaggedOption(ARG_NATIVE_COUNT_LONG)
		.setStringParser(JSAP.INTEGER_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_NATIVE_COUNT_SHORT)
		.setLongFlag(ARG_NATIVE_COUNT_LONG)
		.setDefault("0");
		opt14.setHelp("Number of native bots to participate within the match.");

		jsap.registerParameter(opt14);

		FlaggedOption opt15 = new FlaggedOption(ARG_NATIVE_NAMES_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_NATIVE_NAMES_SHORT)
		.setLongFlag(ARG_NATIVE_NAMES_LONG);
		opt15.setHelp("Semicolon separated name1;name2;... of names to be given to native bots.");

		jsap.registerParameter(opt15);

		FlaggedOption opt16 = new FlaggedOption(ARG_NATIVE_SKILLS_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_NATIVE_SKILLS_SHORT)
		.setLongFlag(ARG_NATIVE_SKILLS_LONG);
		opt16.setHelp("Semicolon separated skill1;skill2;... of skill levels of native bots.");

		jsap.registerParameter(opt16);

		FlaggedOption opt17 = new FlaggedOption(ARG_NATIVE_TEAMS_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_NATIVE_TEAMS_SHORT)
		.setLongFlag(ARG_NATIVE_TEAMS_LONG);
		opt17.setHelp("Semicolon separated team1;team2;... of teams the native bots should be in.");

		jsap.registerParameter(opt17);

		FlaggedOption opt20 = new FlaggedOption(ARG_HUMAN_COUNT_LONG)
		.setStringParser(JSAP.INTEGER_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_HUMAN_COUNT_SHORT)
		.setLongFlag(ARG_HUMAN_COUNT_LONG)
		.setDefault("0");
		opt20.setHelp("Number of humans that should participate in the match.");

		jsap.registerParameter(opt20);

		FlaggedOption opt21 = new FlaggedOption(ARG_HUMAN_TEAMS_LONG)
		.setStringParser(JSAP.STRING_PARSER)
		.setRequired(false) 
		.setShortFlag(ARG_HUMAN_TEAMS_SHORT)
		.setLongFlag(ARG_HUMAN_TEAMS_LONG);
		opt21.setHelp("Semicolon separated team1;team2;... of teams humans should be in.");

		jsap.registerParameter(opt21);
	}

	private static void readConfig(String[] args) {
		System.out.println("Parsing command arguments.");

		try {
			config = jsap.parse(args);
		} catch (Exception e) {
			fail(e.getMessage());
			System.out.println("");
			e.printStackTrace();
			throw new RuntimeException("FAILURE!");
		}

		if (!config.success()) {
			String error = "Invalid arguments specified.";
			Iterator errorIter = config.getErrorMessageIterator();
			if (!errorIter.hasNext()) {
				error += "\n-- No details given.";
			} else {
				while (errorIter.hasNext()) {
					error += "\n-- " + errorIter.next();
				}
			}
			fail(error);
		}

		ut2004HomeDir = config.getString(ARG_UT2004_HOME_DIR_LONG);

		matchTypeName = config.getString(ARG_MATCH_TYPE_LONG);

		botJars = config.getString(ARG_BOT_JARs_LONG);
		botJarsSeparated = botJars == null ? null : botJars.split(";");
		botCount = botJarsSeparated == null ? 0 : botJarsSeparated.length;
		botNames = config.getString(ARG_BOT_NAMES_LONG);
		botNamesSeparated = botNames == null ? null : botNames.split(";");
		botSkills = config.getString(ARG_BOT_SKILLS_LONG);
		botSkillsSeparated = botSkills == null || botSkills.length() == 0 ? null : botSkills.split(";");
		botSkins = config.getString(ARG_BOT_SKINS_LONG);
		botSkinsSeparated = botSkins == null || botSkins.length() == 0 ? null : botSkins.split(";");
		botTeams = config.getString(ARG_BOT_TEAMS_LONG);
		botTeamsSeparated = botTeams == null || botTeams.length() == 0 ? null : botTeams.split(";");

		nativeCount = config.getInt(ARG_NATIVE_COUNT_LONG);
		nativeNames = config.getString(ARG_NATIVE_NAMES_LONG);
		nativeNamesSeparated = nativeNames == null ? null : nativeNames.split(";");
		nativeSkills = config.getString(ARG_NATIVE_SKILLS_LONG);
		nativeSkillsSeparated = nativeSkills == null ? null : nativeSkills.split(";");
		nativeTeams = config.getString(ARG_NATIVE_TEAMS_LONG);
		nativeTeamsSeparated = nativeTeams == null ? null : nativeTeams.split(";");

		humanCount = config.getInt(ARG_HUMAN_COUNT_LONG);
		humanTeams = config.getString(ARG_HUMAN_TEAMS_LONG);
		humanTeamsSeparated = humanTeams == null ? null : humanTeams.split(";");

		map = config.getString(ARG_MAP_NAME_LONG);
		serverName = config.getString(ARG_SERVER_NAME_LONG);
		resultDir = config.getString(ARG_RESULT_DIR_LONG);
		matchName = config.getString(ARG_MATCH_NAME_LONG);
		scoreLimit = config.getInt(ARG_SCORE_LIMIT_LONG);
		timeoutMinutes = config.getInt(ARG_TIMEOUT_MINUTES_LONG);
		humanLikeLog = config.getBoolean(ARG_HUMAN_LIKE_LOG_LONG);
		ut2004Port = config.getInt(ARG_UT2004_PORT_LONG);
	}

	private static void sanityChecks() {
		System.out.println("Sanity checks...");

		// UT2004

		ut2004HomeDirFile = new File(ut2004HomeDir);
		if (!ut2004HomeDirFile.exists() || !ut2004HomeDirFile.isDirectory()) {
			fail("UT2004 directory was not found at '" + ut2004HomeDirFile.getAbsolutePath() + "', path resolved from configuration read as '" + ut2004HomeDir + "'.");
		}
		System.out.println("-- UT2004 directory found at '" + ut2004HomeDirFile.getAbsolutePath() + "'");

		ut2004SystemDirFile = new File(ut2004HomeDirFile, "System");
		if (!ut2004SystemDirFile.exists() || !ut2004SystemDirFile.isDirectory()) {
			fail("UT2004/System directory was not found at '" + ut2004SystemDirFile.getAbsolutePath() + "', invalid UT2004 installation.");
		}
		System.out.println("-- UT2004/System directory found at '" + ut2004SystemDirFile.getAbsolutePath() + "'");

		ut2004IniFile = new File(ut2004SystemDirFile, "UT2004.ini");
		if (!ut2004IniFile.exists() || !ut2004IniFile.isFile()) {
			fail("UT2004/System/UT2004.ini file was not found at '" + ut2004IniFile.getAbsolutePath() + "', invalid UT2004 installation.");
		}
		System.out.println("-- UT2004/System/UT2004.ini file found at '" + ut2004IniFile.getAbsolutePath() + "'");

		// MATCH TYPE
		for (MatchType validMatchType : MatchType.values()) {
			if (validMatchType.shortName.equalsIgnoreCase(matchTypeName)) {
				matchType = validMatchType;
				break;
			}
		}
		if (matchType == null) {
			fail("Invalid match type specified '" + matchTypeName + "', valid values: " + getMatchTypes());
		}

		System.out.println("-- Match type set as " + matchType.name + " (" + matchType.shortName + ")");

		if (botCount + nativeCount + humanCount < 2) {
			fail("There must be at least 2 participants specified, custom + natives + humans = " + botCount + " + " + nativeCount + " + " + humanCount + " = " + (botCount + nativeCount + humanCount) + " < 2.");
		}

		// BOTS

		if (botCount > 0) {

			System.out.println("-- Adding " + botCount + " custom bots into the match");

			if (botNamesSeparated == null) {
				fail("Bot name(s) was/were not specified correctly.");
			}

			if (botJarsSeparated.length != botNamesSeparated.length) {
				fail("Bot jar(s) and name(s) numbers mismatch. I've parsed " + botJarsSeparated.length + " bot jar files != " + botNamesSeparated.length + " of bot names.");
			}

			if (botSkillsSeparated != null && botSkillsSeparated.length != botJarsSeparated.length) {
				fail("Bot jar(s) and skills(s) numbers mismatch. I've parsed " + botJarsSeparated.length + " bot jar files != " + botSkillsSeparated.length + " of bot skill levels.");
			}

			if (botSkinsSeparated != null && botSkinsSeparated.length != botJarsSeparated.length) {
				fail("Bot jar(s) and skins(s) numbers mismatch. I've parsed " + botJarsSeparated.length + " bot jar files != " + botSkinsSeparated.length + " of bot skins.");
			}

			botJarFiles = new File[botJarsSeparated.length];
			for (int i = 0; i < botJarsSeparated.length; ++i) {
				botJarFiles[i] = new File(botJarsSeparated[i]);
				if (!botJarFiles[i].exists() || !botJarFiles[i].isFile()) {
					fail("Bot" + (i+1) + " jar file was not found at '"+ botJarFiles[i].getAbsolutePath() + "', path resolved from configuration read as '" + botJarsSeparated[i] + "'.");
				}
				System.out.println("-- Bot" + (i+1) + " jar file found at '" + botJarFiles[i].getAbsolutePath() + "'");
			}
			System.out.println("-- Bot jars ok");

			for (int i = 0; i < botNamesSeparated.length; ++i) {
				if (botNamesSeparated[i] == null || botNamesSeparated[i].isEmpty()) {
					fail("Bot " + (i+1) + " invalid name '" + botNamesSeparated[i] +"' specified.");
				}
				System.out.println("-- Bot" + (i+1) + " name set as '" + botNamesSeparated[i] + "'");
			}
			System.out.println("-- Bot names ok");

			if (botSkillsSeparated != null) {
				botSkillsNumbers = new Integer[botSkillsSeparated.length];
				for (int i = 0; i < botSkillsSeparated.length; ++i) {
					if (botSkillsSeparated[i] == null || botSkillsSeparated[i].length() == 0) {
						botSkillsNumbers[i] = null;
						System.out.println("-- Bot" + (i+1) + " skill level will be set to default");
						continue;
					} 

					Integer number = null;
					try {
						number = Integer.parseInt(botSkillsSeparated[i]);
					} catch (Exception e) {
						fail("Bot " + (i+1) + " skill level specified as '" + botSkillsSeparated[i] + "', which is not a number!");
					}
					if (number < 0 || number > 7) {
						fail("Bot " + (i+1) + " skill level specified as '" + botSkillsSeparated[i] + "' and parsed as '" + number + "', which is of unsupported value, not from the range 0-7!");
					}

					botSkillsNumbers[i] = number;

					System.out.println("-- Bot" + (i+1) + " skill level set to " + number);
				}

				System.out.println("-- Bot skills ok");
			}

			if (botSkinsSeparated != null) {
				for (int i = 0; i < botSkinsSeparated.length; ++i) {
					if (botSkinsSeparated[i] == null || botSkinsSeparated[i].length() == 0) {
						botSkinsSeparated[i] = null;
						System.out.println("-- Bot" + (i+1) + " skin will be supplied by the bot itself");
						continue;
					} 
					System.out.println("-- Bot" + (i+1) + " skin set to '" + botSkinsSeparated[i] + "'");
				}

				System.out.println("-- Bot skins ok");
			}

			if (matchType.teamGame) {
				if (botTeamsSeparated == null) {
					fail("Bot teams not specified, but a team game specified (" + matchType.name + ").");
				}
				if (botTeamsSeparated.length != botJarsSeparated.length) {
					fail("Bot jar(s) and team(s) numbers mismatch. I've parsed " + botJarsSeparated.length + " bot jar files != " + botTeamsSeparated.length + " of bot teams.");
				}
				botTeamsNumbers = new Integer[botTeamsSeparated.length];
				for (int i = 0; i < botTeamsSeparated.length; ++i) {
					if (botTeamsSeparated[i] == null || botTeamsSeparated[i].length() == 0) {
						fail("Bot" + (i+1) + " does not have a team number specified.");
						continue;
					} 

					Integer number = null;
					try {
						number = Integer.parseInt(botTeamsSeparated[i]);
					} catch (Exception e) {
						fail("Bot " + (i+1) + " team number specified as '" + botTeamsSeparated[i] + "', which is not a number!");
					}
					if (number < 0 || number > 3) {
						fail("Bot " + (i+1) + " team number specified as '" + botTeamsSeparated[i] + "' and parsed as '" + number + "', which is of unsupported value, not from the range 0-3!");
					}

					botTeamsNumbers[i] = number;

					System.out.println("-- Bot" + (i+1) + " team number set to " + number);
				}

				System.out.println("-- Bot teams ok");
			}
		} 

		// NATIVES

		if (nativeCount > 0) {

			if (nativeCount < 1 || nativeCount > 16) {
				fail("Could start match with 1-16 native bots at max!");
			}

			System.out.println("-- Adding " + nativeCount + " native bots into the match");

			if (nativeNamesSeparated == null) {
				fail("Native bot name(s) was/were not specified correctly.");
			}

			if (nativeCount != nativeNamesSeparated.length) {
				fail("Native bot name(s) numbers invalid. I've parsed " + nativeNamesSeparated.length + " native bot name != " + nativeCount + " of native bot count.");
			}

			if (nativeSkillsSeparated == null) {
				fail("Native bot skill(s) not specified correctly.");
			}

			if (nativeSkillsSeparated.length != nativeCount) {
				fail("Native bot skills(s) numbers mismatch. I've parsed " + nativeSkillsSeparated.length + " native bot skills != " + nativeCount + " of native bot count.");
			}

			for (int i = 0; i < nativeNamesSeparated.length; ++i) {
				if (nativeNamesSeparated[i] == null || nativeNamesSeparated[i].isEmpty()) {
					fail("Native bot " + (i+1) + " invalid name '" + nativeNamesSeparated[i] +"' specified.");
				}
				System.out.println("-- Native bot " + (i+1) + " name set as '" + nativeNamesSeparated[i] + "'");
			}
			System.out.println("-- Native names ok");

			nativeSkillsNumbers = new Integer[nativeSkillsSeparated.length];
			for (int i = 0; i < nativeSkillsSeparated.length; ++i) {
				if (nativeSkillsSeparated[i] == null || nativeSkillsSeparated[i].length() == 0) {
					fail("Native bot " + (i+1) + " invalid skill level '" + nativeNamesSeparated[i] +"' specified.");
				} 

				Integer number = null;
				try {
					number = Integer.parseInt(nativeSkillsSeparated[i]);
				} catch (Exception e) {
					fail("Native bot " + i + " skill level specified as '" + nativeSkillsSeparated[i] + "', which is not a number!");
				}
				if (number < 0 || number > 7) {
					fail("Native bot " + i + " skill level specified as '" + nativeSkillsSeparated[i] + "' and parsed as '" + number + "', which is of unsupported value, not from the range 0-7!");
				}

				nativeSkillsNumbers[i] = number;

				System.out.println("-- Native bot " + (i+1) + " skill level set to " + number);
			}

			System.out.println("-- Native bot skills OK");

			if (matchType.teamGame) {
				if (nativeTeamsSeparated == null) {
					fail("Native bot teams not specified, but a team game specified (" + matchType.name + ").");
				}
				if (nativeTeamsSeparated.length != nativeCount) {
					fail("Native bot team(s) and native count numbers mismatch. I've parsed " + nativeCount + " native count != " + nativeTeamsSeparated.length + " of native bot teams.");
				}
				nativeTeamsNumbers = new Integer[nativeTeamsSeparated.length];
				for (int i = 0; i < nativeTeamsSeparated.length; ++i) {
					if (nativeTeamsSeparated[i] == null || nativeTeamsSeparated[i].length() == 0) {
						fail("Native bot " + (i+1) + " does not have team number specified.");
						continue;
					} 

					Integer number = null;
					try {
						number = Integer.parseInt(nativeTeamsSeparated[i]);
					} catch (Exception e) {
						fail("Native bot " + (i+1) + " team number specified as '" + nativeTeamsSeparated[i] + "', which is not a number!");
					}
					if (number < 0 || number > 3) {
						fail("Native bot " + (i+1) + " team number specified as '" + nativeTeamsSeparated[i] + "' and parsed as '" + number + "', which is of unsupported value, not from the range 0-3!");
					}

					nativeTeamsNumbers[i] = number;

					System.out.println("-- Native bot " + (i+1) + " team number set to " + number);
				}

				System.out.println("-- Native bot teams ok");
			}
		}

		// HUMANS

		if (humanCount > 0) {

			if (humanCount < 1 || humanCount > 16) {
				fail("Could start match with 1-16 humans at max!");
			}

			System.out.println("-- Expect " + humanCount + " humans to participate in the match");

			if (matchType.teamGame) {
				if (humanTeamsSeparated == null) {
					fail("Teams for humans not specified, but a team game specified (" + matchType.name + ").");
				}
				if (humanTeamsSeparated.length != humanCount) {
					fail("Human team(s) and human count numbers mismatch. I've parsed " + humanCount + " human count != " + humanTeamsSeparated.length + " of human bot teams.");
				}
				humanTeamsNumbers = new Integer[humanTeamsSeparated.length];
				for (int i = 0; i < humanTeamsSeparated.length; ++i) {
					if (humanTeamsSeparated[i] == null || humanTeamsSeparated[i].length() == 0) {
						fail("Human " + (i+1) + " does not have a team number specified.");
						continue;
					} 

					Integer number = null;
					try {
						number = Integer.parseInt(humanTeamsSeparated[i]);
					} catch (Exception e) {
						fail("Human " + (i+1) + " team number specified as '" + humanTeamsSeparated[i] + "', which is not a number!");
					}
					if (number < 0 || number > 3) {
						fail("Human " + (i+1) + " team number specified as '" + humanTeamsSeparated[i] + "' and parsed as '" + number + "', which is of unsupported value, not from the range 0-3!");
					}

					humanTeamsNumbers[i] = number;

					System.out.println("-- Human " + (i+1) + " is expected to belong to the team number" + number);
				}

				System.out.println("-- Human teams ok");
			}
		}

		// MATCH CONFIG

		mapsDirFile = new File(ut2004HomeDirFile, "Maps");
		if (!mapsDirFile.exists() || !mapsDirFile.isDirectory()) {
			fail("UT2004/Maps directory was not found at '" + mapsDirFile.getAbsolutePath() + "', invalid UT2004 installation.");
		}
		System.out.println("-- UT2004/Maps directory found at '" + mapsDirFile.getAbsolutePath() + "'");

		mapFile = new File(mapsDirFile, map + ".ut2");
		if (!mapFile.exists() || !mapFile.isFile()) {
			fail("Specified map '" + map + "' was not found within UT2004/Maps dir at '" + mapFile.getAbsoluteFile() + "', could not execute the match.");
		}
		System.out.println("-- Map '" + map + "' found at '" + mapFile.getAbsolutePath() + "'");

		if (matchName == null || matchName.isEmpty()) {
			fail("Invalid match name '" + matchName + "' specified.");
		}
		System.out.println("-- Match name set as '" + matchName + "'");

		if (serverName == null || serverName.isEmpty()) {
			fail("Invalid server name '" + serverName + "' specified.");
		}
		System.out.println("-- Server name set as '" + serverName + "'");

		if (scoreLimit < 1) {
			fail("Invalid frag/score limit '" + scoreLimit +"' specified, must be >= 1.");
		}
		System.out.println("-- Frag limit set as '" + scoreLimit + "'");

		if (timeoutMinutes < 1) {
			fail("Invalid time limit '" + timeoutMinutes +"' specified, must be >= 1.");
		}
		System.out.println("-- Timeout set as '" + timeoutMinutes + "' minutes.");

		if (ut2004Port < 1 || ut2004Port > 32000) {
			fail("Invalid UT2004 port specified '" + ut2004Port + "', must be 1 <= port <= 32000.");
		}
		System.out.println("-- UT2004 port set as '" + ut2004Port + "'");

		System.out.println("Sanity checks OK!");
	}

	private static void setGenericMatchConfigs(UT2004MatchConfig config) {
		// UT2004 INI
		config.getUT2004Ini().setPort(ut2004Port);
		config.getUT2004Ini().setServerName(serverName, serverName);
		config.getUT2004Ini().setDemoSpectatorClass(UT2004Ini.Value_DemoSpectatorClass);

		// UCC
		config.getUccConf().setStartOnUnusedPort(true);
		config.getUccConf().setUnrealHome(ut2004HomeDir);	
		config.getUccConf().setGameType(matchType.uccGameType);
		config.getUccConf().setMapName(map);

		// OTHERS
		config.setOutputDirectory(new File(resultDir));
		config.setMatchId(matchName);
		config.setHumanLikeLogEnabled(humanLikeLog);
	}

	private static UT2004BotConfig[] createBotConfigs() {
		if (botCount <= 0) return null;
		UT2004BotConfig[] botConfigs = new UT2004BotConfig[botJarFiles.length];
		for (int i = 0; i < botJarFiles.length; ++i) {
			UT2004BotConfig botConfig = new UT2004BotConfig();
			botConfig.setBotId(botNamesSeparated[i]);
			botConfig.setPathToBotJar(botJarFiles[i].getAbsolutePath());
			if (botSkillsNumbers != null && botSkillsNumbers[i] != null) {
				botConfig.setDesiredSkill(botSkillsNumbers[i]);
			}
			if (botSkinsSeparated != null && botSkinsSeparated[i] != null) {
				botConfig.setSkin(botSkinsSeparated[i]);
			}
			if (matchType.teamGame) {
				botConfig.setTeamNumber(botTeamsNumbers[i]);
			}
			botConfig.setRedirectStdErr(true);
			botConfig.setRedirectStdOut(true);
			botConfigs[i] = botConfig;
		}
		return botConfigs;
	}

	private static UT2004NativeBotConfig[] createNativeBotConfig() {
		if (nativeCount <= 0) return null;
		UT2004NativeBotConfig[] nativeConfigs = new UT2004NativeBotConfig[nativeCount];
		for (int i = 0; i < nativeCount; ++i) {
			UT2004NativeBotConfig nativeConfig = new UT2004NativeBotConfig();
			nativeConfig.setBotId(nativeNamesSeparated[i]);
			nativeConfig.setDesiredSkill(nativeSkillsNumbers[i]);
			if (matchType.teamGame) {
				nativeConfig.setTeamNumber(nativeTeamsNumbers[i]);
			}
			nativeConfigs[i] = nativeConfig;
		}
		return nativeConfigs;
	}

	private static UT2004HumanConfig[] createHumanConfig() {
		if (humanCount <= 0) return null;
		UT2004HumanConfig[] humanConfigs = new UT2004HumanConfig[humanCount];
		for (int i = 0; i < humanCount; ++i) {
			UT2004HumanConfig humanConfig = new UT2004HumanConfig();
			humanConfig.setHumanId("Human" + i);
			if (matchType.teamGame) {
				humanConfig.setTeamNumber(humanTeamsNumbers[i]);
			}
			humanConfigs[i] = humanConfig;
		}
		return humanConfigs;
	}

	private static void executeDeathMatch() {
		UT2004DeathMatchConfig config = new UT2004DeathMatchConfig();

		// GENERIC CONFIGS
		setGenericMatchConfigs(config);

		// CUSTOM BOTS
		if (botCount > 0) {
			config.setBot(createBotConfigs());
		}

		// NATIVE BOTS		
		if (nativeCount > 0) {			
			config.setNativeBot(createNativeBotConfig());
		}

		// HUMANS
		if (humanCount > 0) {
			config.setHuman(createHumanConfig());
		}

		// DEATH MATCH SPECIFIC CONFIGS		
		config.setFragLimit(scoreLimit);
		config.setTimeLimit(timeoutMinutes);

		// ------------
		// START IT UP!
		// ------------

		System.out.println("EXECUTING DEATH MATCH!");

		LogCategory log = new LogCategory(matchName);
		UT2004DeathMatch match = new UT2004DeathMatch(config, log);

		match.getLog().setLevel(Level.INFO);
		match.getLog().addConsoleHandler();

		match.run();
	}

	public static void executeTeamDeathMatch() { 
		fail("TEAM DEATH MATCH NOT SUPPORTED YET!");	
	}

	public static void executeCaptureTheFlag() { 
		UT2004CaptureTheFlagConfig config = new UT2004CaptureTheFlagConfig();

		// GENERIC CONFIGS
		setGenericMatchConfigs(config);

		// CUSTOM BOTS
		if (botCount > 0) {
			config.setBot(createBotConfigs());
		}

		// NATIVE BOTS		
		if (nativeCount > 0) {			
			config.setNativeBot(createNativeBotConfig());
		}

		// HUMANS
		if (humanCount > 0) {
			config.setHuman(createHumanConfig());
		}

		// CAPTURE THE FLAG SPECIFIC CONFIGS		
		config.setScoreLimit(scoreLimit);
		config.setTimeLimit(timeoutMinutes);

		// ------------
		// START IT UP!
		// ------------

		System.out.println("EXECUTING CAPTURE THE FLAG!");

		LogCategory log = new LogCategory(matchName);
		UT2004CaptureTheFlag match = new UT2004CaptureTheFlag(config, log);

		match.getLog().setLevel(Level.INFO);
		match.getLog().addConsoleHandler();

		match.run();
	}

	public static void executeDoubleDomination() { 
		fail("DOUBLE DOMINATION NOT SUPPORTED YET!");	
	}


	// ==============
	// TEST ARGUMENTS
	// ==============
	public static String[] getArgs_DM_2v2v1() {
		return new String[] {
				"-y", // MATCH TYPE
				"DM", // DEATH-MATCH
				// GENERIC CONFIG
				"-u",
				"D:\\Games\\UT2004-Devel",
				"-h", // human-like-log
				"-r",
				"./results",
				"-n",
				"Test-DM-2v2v1", // MATCH NAME
				"-s",
				"DMServer",				
				// CUSTOM BOTS CONFIG
				"-a",
				"D:\\Workspaces\\Pogamut-Trunk\\Main\\PogamutUT2004Examples\\04-HunterBot\\target\\ut2004-04-hunter-bot-3.6.2-SNAPSHOT.one-jar.jar;D:\\Workspaces\\Pogamut-Trunk\\Main\\PogamutUT2004Examples\\04-HunterBot\\target\\ut2004-04-hunter-bot-3.6.2-SNAPSHOT.one-jar.jar",
				"-b",
				"HunterBot1;HunterBot2",
				"-l",
				"1;5",
				"-k",
				"HumanFemaleA.NightFemaleA;Aliens.AlienMaleB",
				// NATIVE BOTS CONFIG
				"-c", // NATIVE BOT COUNT
				"2",
				"-d", // NATIVE BOT NAME
				"Native1;Native2",
				"-e", // NATIVE BOT SKILL
				"2;3",
				// HUMANS CONFIG
				"-x",
				"1", // HUMAN COUNT
				// DEATH MATCH SPECIFIC CONFIG
				"-m",
				"DM-TrainingDay",
				"-f", // FRAG LIMIT
				"5",
				"-t", // TIME LIMIT IN MINS
				"5",
		};
	}

	public static String[] getArgs_CTF_3VS_3() {
		return new String[] {
				"-y", // MATCH TYPE
				"CTF", // CAPTURE THE FALG
				// GENERIC CONFIG
				"-u",
				"C:\\UTGame",
				"-h", // human-like-log
				"-r",
				"./Output",
				"-n",
				"Match_", // MATCH NAME
				"-s",
				"CTFServer",				
				// CUSTOM BOTS CONFIG
				"-a",
				"JAR",
				"-b",
				"CTFBot1;CTFBot2;CTFBot3;CTFBot4;CTFBot5;CTFBot6",
				"-l",
				"5;5;5;5;5;5",
				"-k",
				"HumanFemaleA.NightFemaleA;HumanFemaleA.NightFemaleA;HumanFemaleA.NightFemaleA;HumanFemaleA.NightFemaleA;HumanFemaleA.NightFemaleA;HumanFemaleA.NightFemaleA",
				"-i",
				"0;0;0;1;1;1",
				// NATIVE BOTS CONFIG
				"-c", // NATIVE BOT COUNT
				"0",
				"-d", // NATIVE BOT NAME
				"",
				"-e", // NATIVE BOT SKILL
				"",
				"-g", // NATIVE BOT TEAMS
				"",
				// HUMANS CONFIG
				"-x",
				"0", // HUMAN COUNT
				"-z",
				"1",
				// CAPTURE THE FLAG SPECIFIC CONFIG
				"-m",
				"CTF-1on1-Joust",
				"-f",
				"15", // SCORE LIMIT
				"-t",
				"2", // TIME LIMIT
		};
	}

	/*
	 * This method reads the CSV of the BOT Game Result Files and calculate it's fitness and then updates the same to DB
	 */

	public static void CalculateFitness(botStats[] botGeneArray)
	{
		CSVReader reader;
		List<String[]> myEntries;
		String[] row;

		//Set all the variables in the Bots to -999
		//Just for Error Detecting purposes
		for(int i=0;i<60;i++) {

			botGeneArray[i].Generation_Number=globalGenerationNumber;
			botGeneArray[i].Bot_Number=i+1;

			botGeneArray[i].botIdStr="UNKNOWN";
			botGeneArray[i].nameStr="UNKNOWN";
			botGeneArray[i].matchIDStr="UNKNOWN";
			botGeneArray[i].BotTeamIDStr="UNKNOWN";
			botGeneArray[i].EnemyTeamIDStr="UNKNOWN";

			botGeneArray[i].botTeamScore=-999;
			botGeneArray[i].enemyTeamScore=-999;

			botGeneArray[i]. health=-999;
			botGeneArray[i]. Armor=-999;
			botGeneArray[i]. Adrenaline=-999;
			botGeneArray[i]. NumKillsWithoutDeath=-999;

			botGeneArray[i]. ItemsCollect=-999;
			botGeneArray[i]. WeaponsCollect=-999;
			botGeneArray[i]. AmmoCollect=-999;
			botGeneArray[i]. HealthCollect=-999;
			botGeneArray[i]. ArmorCollect=-999;
			botGeneArray[i]. ShieldCollect=-999;
			botGeneArray[i]. AdrenalineCollect=-999;
			botGeneArray[i]. OtherCollect=-999;
			botGeneArray[i]. DoubleDamageCount=-999;
			botGeneArray[i]. Combo=-999;

			botGeneArray[i]. score_bot=-999;
			botGeneArray[i]. kills=-999;
			botGeneArray[i]. killedByOthers=-999;
			botGeneArray[i]. suicides_Bot=-999;
			botGeneArray[i]. deaths_Bot=-999;
			botGeneArray[i]. ScoreLimit=-999;
			botGeneArray[i]. TimeLimit=-999;

			botGeneArray[i]. FLAG_PICKEDUP=-999;
			botGeneArray[i]. FLAG_DROPPED=-999;
			botGeneArray[i]. FLAG_RETURNED=-999;
			botGeneArray[i]. FLAG_CAPTURED=-999;
			botGeneArray[i]. TimeEnd=-999;
			botGeneArray[i].Winner = "UNKNOWN";

			botGeneArray[i]. BOT_KILLED=-999;
			botGeneArray[i]. ITEM_PICKEDUP=-999;
			botGeneArray[i]. fitness=0.00;

		}

		String outputFolderPATH =  "C:\\Users\\MotionCapture\\Desktop\\UT 2004\\Output\\Generation_" + globalGenerationNumber;
		String filePATH = "\\match-Generation_"+ globalGenerationNumber + "-bot-scores.csv";


		//Read the Bot-Scores.csv
		//C:\Users\MotionCapture\Desktop\UT 2004\Output\Generation_1\Match_1\match-Match_1-bot-scores.csv

		try
		{
			//Outer Loop repeats 20 times
			//Inner loop repeats 3 times
			int loopIndex=0;
			for(int outer=1;outer<21;outer++) {

				filePATH = "\\Match_" +outer+ "\\match-Match_"+ outer+"-bot-scores.csv";
				reader = new CSVReader(new FileReader(outputFolderPATH+filePATH),';');
				myEntries = reader.readAll();
				for(int inner=1;inner<4;inner++){
					//botId;name;score;kills;
					//killedByOthers;deaths;suicides;
					//CTFBot1;CTFBot2;CTFBot3;CTFBot4;CTFBot5;CTFBot6;
					//Native1;Native2;Native3;Native4;Native5;Native6
					row=myEntries.get(inner); //Read the Row, +1 because to Ignore the Header Line
					botGeneArray[loopIndex].botIdStr = row[0];
					botGeneArray[loopIndex].nameStr = row[1];
					botGeneArray[loopIndex].score_bot = Integer.parseInt(row[2]);
					botGeneArray[loopIndex].kills = Integer.parseInt(row[3]);
					botGeneArray[loopIndex].killedByOthers = Integer.parseInt(row[4]);
					botGeneArray[loopIndex].deaths_Bot = Integer.parseInt(row[5]);
					botGeneArray[loopIndex].suicides_Bot = Integer.parseInt(row[6]);
					loopIndex++;
				}
			}
		}
		catch (Exception e) {
			try{
				String LogPath = "C:\\Karthik\\Simulation\\CSVExceptions.txt";
				System.out.println("CSV Exception : " + e.getMessage());
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\n");
				out.write(e.getMessage());
				out.write("\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
		}
		//C:\Users\MotionCapture\Desktop\UT 2004\Output\Generation_1\Match_1\match-Match_1-result.csv
		try
		{
			//Outer Loop repeats 20 times
			//Inner loop repeats 3 times
			int loopIndex=0;
			for(int outer=1;outer<21;outer++) {

				filePATH = "\\Match_" +outer+ "\\match-Match_"+ outer+"-result.csv";
				reader = new CSVReader(new FileReader(outputFolderPATH+filePATH),';');
				myEntries = reader.readAll();

				for(int inner=1;inner<4;inner++){
					//MatchId;ScoreLimit;
					//TimeLimit;TimeEnd;Winner
					row=myEntries.get(1); //Read the Row, +1 because to Ignore the Header Line
					botGeneArray[loopIndex].matchIDStr = row[0];
					botGeneArray[loopIndex].ScoreLimit = Integer.parseInt(row[1]);
					botGeneArray[loopIndex].TimeLimit = Integer.parseInt(row[2]);
					botGeneArray[loopIndex].TimeEnd = Double.parseDouble(row[3]);
					botGeneArray[loopIndex].Winner = row[4];
					loopIndex++;

				}
			}

		}
		catch (Exception e) {
			try{
				String LogPath = "C:\\Karthik\\Simulation\\CSVExceptions.txt";
				System.out.println("CSV Exception : " + e.getMessage());
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\n");
				out.write(e.getMessage());
				out.write("\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
		}

		//C:\Users\MotionCapture\Desktop\UT 2004\Output\Generation_1\Match_1\match-Match_1-team-scores.csv
		try
		{
			//Outer Loop repeats 20 times
			//Inner loop repeats 3 times
			int loopIndex=0;
			for(int outer=1;outer<21;outer++) {
				filePATH = "\\Match_" +outer+ "\\match-Match_"+ outer+"-team-scores.csv";
				reader = new CSVReader(new FileReader(outputFolderPATH+filePATH),';');
				myEntries = reader.readAll();
				for(int inner=1;inner<4;inner++){
					//teamId;score

					row=myEntries.get(1); //Read the Row, +1 because to Ignore the Header Line
					botGeneArray[loopIndex].BotTeamIDStr = row[0];
					botGeneArray[loopIndex].botTeamScore = Integer.parseInt(row[1]);

					row=myEntries.get(2); //Team1
					botGeneArray[loopIndex].EnemyTeamIDStr =  row[0];
					botGeneArray[loopIndex].enemyTeamScore = Integer.parseInt(row[1]);
					loopIndex++;

				}
			}
		}
		catch (Exception e) {
			try{
				String LogPath = "C:\\Karthik\\Simulation\\CSVExceptions.txt";
				System.out.println("CSV Exception : " + e.getMessage());
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\n");
				out.write(e.getMessage());
				out.write("\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
		}

		//Read individual Bot files in ./Bots folder
		//C:\Users\MotionCapture\Desktop\UT 2004\Output\Generation_1\bots\CTFBot1-Attacker_1_000.csv
		//C:\Users\MotionCapture\Desktop\UT 2004\Output\Generation_1\Match_1\bots\CTFBot1-Bot1_000.csv

		for(int j=1;j<61;j++) {
			//Reset the values of variables
			botGeneArray[j-1].Generation_Number = globalGenerationNumber;
			botGeneArray[j-1].ITEM_PICKEDUP=0;
			botGeneArray[j-1].FLAG_PICKEDUP=0;
			botGeneArray[j-1].FLAG_DROPPED=0;
			botGeneArray[j-1].FLAG_RETURNED=0;
			botGeneArray[j-1].FLAG_CAPTURED=0;
			botGeneArray[j-1].BOT_KILLED=0;

			filePATH = "\\bots\\CTFBot"+ j + "-Bot"+ j + "_000.csv";
			//Do separate for Defender BOTS
			//Multiples of 3 is identified as Defender bots
			if(j==3 || j==6 || j==9 || j==12 || j==15 || j==18 || j==21 || j==24 || j==27 || j==30) {
				filePATH = "\\bots\\CTFBot"+ j + "-Bot"+ j + "_000.csv";
			}
		}

		try
		{
			//Outer Loop repeats 20 times
			//Inner loop repeats 3 times
			int loopIndex=0;
			for(int outer=1;outer<21;outer++) {
				//C:\Users\MotionCapture\Desktop\UT 2004\Output\Generation_1\Match_1\bots\CTFBot1-Bot1_000.csv
				for(int inner=1;inner<4;inner++){
					filePATH = "\\Match_" +outer+ "\\bots\\CTFBot"+ inner+"-Bot" + (loopIndex+1)+"_000.csv";
					reader = new CSVReader(new FileReader(outputFolderPATH+filePATH),';');
					myEntries = reader.readAll();

					for(int i=1;i<myEntries.size();i++) { //i=1 because ignoring the header.
						row = myEntries.get(i); //If Length is > 51 means an event is generated there.
						if(row.length > 51) {

							if(row[51].equals("ITEM_PICKEDUP")) {
								botGeneArray[loopIndex].ITEM_PICKEDUP++;
							}

							if(row[51].equals("FLAG_PICKEDUP")) {
								botGeneArray[loopIndex].FLAG_PICKEDUP++;
							}

							if(row[51].equals("FLAG_DROPPED")) {
								botGeneArray[loopIndex].FLAG_DROPPED++;
							}
							if(row[51].equals("FLAG_RETURNED")) {
								botGeneArray[loopIndex].FLAG_RETURNED++;
							}
							if(row[51].equals("FLAG_CAPTURED")) {
								botGeneArray[loopIndex].FLAG_CAPTURED =  Integer.parseInt(row[52]);
							}
							if(row[51].equals("BOT_KILLED")) {
								botGeneArray[loopIndex].BOT_KILLED++;
							}
						}
					}

					//Read the rest of the variables
					String[] Header = myEntries.get(0);
					String[] lastRow = myEntries.get(myEntries.size()-1);

					//						(0)MatchTime	65.130
					//					(1)UT2004Time	106.560
					//					(2)Health	100
					botGeneArray[loopIndex].health=Integer.parseInt(lastRow[2]);
					//					(3)Armor	0
					botGeneArray[loopIndex].Armor=Integer.parseInt(lastRow[3]);
					//					(4)Adrenaline	8
					botGeneArray[loopIndex].Adrenaline=Integer.parseInt(lastRow[4]);
					//					(5)Score	0
					//botGeneArray[j-1].Score=Integer.parseInt(lastRow[5]);
					//					(6)Deaths	1
					//botGeneArray[j-1].Deaths=Integer.parseInt(lastRow[6]);

					//					(7)Suicides	0
					//botGeneArray[j-1].Suicides=Integer.parseInt(lastRow[7]);
					//					(8)Killed	0
					//botGeneArray[j-1].Killed=Integer.parseInt(lastRow[8]);
					//					(9)WasKilled	1
					//botGeneArray[j-1].WasKilled=Integer.parseInt(lastRow[9]);
					//					(10)NumKillsWithoutDeath	0
					botGeneArray[loopIndex].NumKillsWithoutDeath=Integer.parseInt(lastRow[10]);
					//					(11)Team	0
					//botGeneArray[j-1].Team=Integer.parseInt(lastRow[11]);
					//					(12)TeamScore	0
					//botGeneArray[j-1].TeamScore=Integer.parseInt(lastRow[12]);
					//					(13)ItemsCollect	0
					botGeneArray[loopIndex].ItemsCollect=Integer.parseInt(lastRow[13]);

					//					(14)WeaponsCollect	3
					botGeneArray[loopIndex].WeaponsCollect=Integer.parseInt(lastRow[14]);
					//					(15)AmmoCollect	1
					botGeneArray[loopIndex].AmmoCollect=Integer.parseInt(lastRow[15]);
					//					(16)HealthCollect	0
					botGeneArray[loopIndex].HealthCollect=Integer.parseInt(lastRow[16]);
					//					(17)ArmorCollect	0
					botGeneArray[loopIndex].ArmorCollect=Integer.parseInt(lastRow[17]);
					//					(18)ShieldCollect	0
					botGeneArray[loopIndex].ShieldCollect=Integer.parseInt(lastRow[18]);
					//					(19)AdrenalineCollect	3
					botGeneArray[loopIndex].AdrenalineCollect=Integer.parseInt(lastRow[19]);

					//					(20)OtherCollect	0
					botGeneArray[loopIndex].OtherCollect=Integer.parseInt(lastRow[20]);
					//					(21)TimeMoving	58.470
					//					(22)TimeShooting	9.920
					//					(23)DoubleDamageCount	0
					botGeneArray[loopIndex].DoubleDamageCount=Integer.parseInt(lastRow[23]);
					//					(24)DoubleDamageTime	0.000
					//					(25)TraveledDistance	20978.436
					//					(26)Combo	None
					botGeneArray[loopIndex].Combo=0;
					if(!lastRow[26].equals("None"))
						botGeneArray[loopIndex].Combo++;
					loopIndex++;
				}
			}
		}
		catch (Exception e) {
			try{
				String LogPath = "C:\\Karthik\\Simulation\\CSVExceptions.txt";
				System.out.println("CSV Exception : " + e.getMessage());
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\n");
				out.write(e.getMessage());
				out.write("\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
		}

		//Reading of all bot data completed
		//Now update to database
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		String DB_URL = "jdbc:mysql://localhost/unrealdb";

		//  Database credentials
		String USERNAME = "root";
		String PASSWORD = "unrealdbpwd1";
		Connection connect = null;

		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int botNumber=1;
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

			String DBQuery;
			for(int i=0;i<60;i++) {
				DBQuery="INSERT INTO"
						+ " Unrealdb.bot_stats " +
						"(`Generation_Number`,`Bot_Number`,`botId`,`MatchId`,`BotTeamID`, " +
						"`EnemyTeamID`,`BotTeamScore`,`EnemyTeamScore`,`Health`,`Armor`,`Adrenaline`,`NumKillsWithoutDeath`,`ItemsCollect`, " +
						"`WeaponsCollect`,`AmmoCollect`,`HealthCollect`,`ArmorCollect`,`ShieldCollect`,`AdrenalineCollect`,`OtherCollect`,`DoubleDamageCount`,`Combo`,`score_bot`, " +
						"`kills`,`killedByOthers`,`suicides_Bot`,`deaths_Bot`,`ScoreLimit`,`TimeLimit`,`FLAG_PICKEDUP`,`FLAG_DROPPED`,`FLAG_RETURNED`,`FLAG_CAPTURED`,`TimeEnd`,`Winner`) "

						+" VALUES ( ?, ? , ? , ?, ? , ? ,?, ?  ,?, ? , ? ,?, ? , ? ,?, ? , ? ,?, ? , ? ,?, ? , ? ,?, ? , ? ,?, ? , ? ,?, ? , ? ,?, ? , ?  )";
				//35 VALUES

				// preparedStatements can use variables and are more efficient
				preparedStatement = connect
						.prepareStatement(DBQuery);
				// "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
				// parameters start with 1

				preparedStatement.setInt(1, globalGenerationNumber);
				preparedStatement.setInt(2, botGeneArray[i].Bot_Number);
				preparedStatement.setString(3, botGeneArray[i].botIdStr);
				preparedStatement.setString(4, botGeneArray[i].matchIDStr);
				preparedStatement.setString(5, botGeneArray[i].BotTeamIDStr);
				preparedStatement.setString(6, botGeneArray[i].EnemyTeamIDStr);
				preparedStatement.setInt(7, botGeneArray[i].botTeamScore);
				preparedStatement.setInt(8, botGeneArray[i].enemyTeamScore);
				preparedStatement.setInt(9, botGeneArray[i].health);

				preparedStatement.setInt(10, botGeneArray[i].Armor);
				preparedStatement.setInt(11, botGeneArray[i].Adrenaline );
				preparedStatement.setInt(12, botGeneArray[i].NumKillsWithoutDeath);
				preparedStatement.setInt(13, botGeneArray[i].ItemsCollect);
				preparedStatement.setInt(14, botGeneArray[i].WeaponsCollect);
				preparedStatement.setInt(15, botGeneArray[i].AmmoCollect);
				preparedStatement.setInt(16, botGeneArray[i].HealthCollect);
				preparedStatement.setInt(17, botGeneArray[i].ArmorCollect);
				preparedStatement.setInt(18, botGeneArray[i].ShieldCollect);
				preparedStatement.setInt(19, botGeneArray[i].AdrenalineCollect);
				preparedStatement.setInt(20, botGeneArray[i].OtherCollect);

				preparedStatement.setInt(21, botGeneArray[i].DoubleDamageCount);
				preparedStatement.setInt(22, botGeneArray[i].Combo);
				preparedStatement.setInt(23, botGeneArray[i].score_bot);
				preparedStatement.setInt(24, botGeneArray[i].kills);
				preparedStatement.setInt(25, botGeneArray[i].killedByOthers);
				preparedStatement.setInt(26, botGeneArray[i].deaths_Bot);
				preparedStatement.setInt(27, botGeneArray[i].suicides_Bot);
				preparedStatement.setInt(28, botGeneArray[i].ScoreLimit);
				preparedStatement.setInt(29, botGeneArray[i].TimeLimit);
				preparedStatement.setInt(30, botGeneArray[i].FLAG_PICKEDUP);

				preparedStatement.setInt(31, botGeneArray[i].FLAG_DROPPED);
				preparedStatement.setInt(32, botGeneArray[i].FLAG_RETURNED);
				preparedStatement.setInt(33, botGeneArray[i].FLAG_CAPTURED);
				preparedStatement.setDouble(34, botGeneArray[i].TimeEnd);
				preparedStatement.setString(35, botGeneArray[i].Winner);
				preparedStatement.executeUpdate();


			} 
		}
		catch (Exception e) {
			try{
				String LogPath = "C:\\Karthik\\Simulation\\CSVExceptions.txt";
				System.out.println("SQL Exception : " + e.getMessage());
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\n");
				out.write(e.getMessage());
				out.write("\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
		} 
		finally {
			//close();
		}


		//Read the Current Gene for Bots

		//Read the Chromosomes Values from the Database
		//Idea is to read the LAST row from the DB, which will be
		//updated by UT2004 Testing Project

		JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		DB_URL = "jdbc:mysql://localhost/unrealdb";

		//  Database credentials
		USERNAME = "root";
		PASSWORD = "unrealdbpwd1";
		Connection conn = null;

		Statement stmt = null;
		preparedStatement = null;
		resultSet = null;

		for(int j=0;j<60;j++)
		{
			try{
				//STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				//STEP 3: Open a connection
				conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
				//STEP 4: Execute a query
				stmt = conn.createStatement();
				//SELECT fields FROM table ORDER BY id DESC LIMIT 1;
				String sql = "SELECT * FROM unrealdb.bot_genes WHERE Bot_Num=" + botGeneArray[j].Bot_Number+ " AND Generation_Num = " + globalGenerationNumber+"  ORDER BY ID DESC LIMIT 1";
				ResultSet rs = stmt.executeQuery(sql);
				//STEP 5: Extract data from result set
				while(rs.next()){
					//Retrieve by column name
					botGeneArray[j].gene[0] = rs.getInt("1");
					botGeneArray[j].gene[1] = rs.getInt("2");
					botGeneArray[j].gene[2] = rs.getInt("3");
					botGeneArray[j].gene[3] = rs.getInt("4");
					botGeneArray[j].gene[4] = rs.getInt("5");
					botGeneArray[j].gene[5] = rs.getInt("6");
					botGeneArray[j].gene[6]= rs.getInt("7");
					botGeneArray[j].gene[7] = rs.getInt("8");
					botGeneArray[j].gene[8] = rs.getInt("9");
					botGeneArray[j].gene[9]= rs.getInt("10");
				}
				rs.close();
			}
			catch(Exception e){
				try{
					String LogPath = "C:\\Karthik\\Simulation\\SQLExceptions.txt";
					System.out.println("SQL Exception : " + e.getMessage());
					FileWriter fstream = new FileWriter(LogPath, true);
					BufferedWriter out = new BufferedWriter(fstream);
					out.write("\n");
					out.write(e.getMessage());
					out.write("\n");
					out.close();
				}
				catch (Exception ie) {
					throw new RuntimeException("Could not write Exception to file", ie);
				}
			}
		}
		//Calculate FITNESS for each of the BOT
		double[] fitnessArray = new double [60];
		final double[] fitnessAttackArray = new double [40];
		final double[] fitnessDefendArray = new double [20];

		//Fitness = (FLAG_PICKEDUP - FLAG_DROPPED ) * 5 + Kills - Deaths

		for(int i=0;i<60;i++) {
			fitnessArray[i] = (botGeneArray[i].FLAG_CAPTURED * 2.0 +  botGeneArray[i].FLAG_PICKEDUP + botGeneArray[i].kills - ((double)botGeneArray[i].FLAG_DROPPED /10.0) - ((double)botGeneArray[i].deaths_Bot /10.0) ) /2.0;
			if ( (i+1)==3 || (i+1)==6 || (i+1)==9 || (i+1)==12 || (i+1)==15 || (i+1)==18 || (i+1)==21 || (i+1)==24 || (i+1)==27 || (i+1)==30 ||
					(i+1)==33 || (i+1)==36 || (i+1)==39 || (i+1)==42 || (i+1)==45 || (i+1)==48 || (i+1)==51 || (i+1)==54 || (i+1)==57 || (i+1)==60 )
			{
				//Bot is Defender
				fitnessArray[i] = (botGeneArray[i].FLAG_RETURNED * 5.0  + botGeneArray[i].kills -  ((double)botGeneArray[i].deaths_Bot /10.0) ) / 2.0;
			}
		}

		//Extract Fitness for Attack and defend Bots
		int index1=0,index2=0;
		for(int i=0;i<60;i++) {
			if ( (i+1)==3 || (i+1)==6 || (i+1)==9 || (i+1)==12 || (i+1)==15 || (i+1)==18 || (i+1)==21 || (i+1)==24 || (i+1)==27 || (i+1)==30 ||
					(i+1)==33 || (i+1)==36 || (i+1)==39 || (i+1)==42 || (i+1)==45 || (i+1)==48 || (i+1)==51 || (i+1)==54 || (i+1)==57 || (i+1)==60)
			{
				fitnessDefendArray[index2++] = fitnessArray[i];
				continue;
			}
			fitnessAttackArray[index1++] = fitnessArray[i];
		}

		//Write to File
		try{
			String LogPath = "C:\\Karthik\\Simulation\\FitnessArrayAttack.txt";
			String result="";
			for(int m=0;m<40;m++)
				result += ", " + fitnessAttackArray[m];
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("\n");
			out.write("Generation Number " +  globalGenerationNumber + "\n");
			out.write(result);
			out.write("\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		try{
			String LogPath = "C:\\Karthik\\Simulation\\FitnessArrayDefend.txt";
			String result="";
			for(int m=0;m<20;m++)
				result += ", " + fitnessDefendArray[m];
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("\n");
			out.write("Generation Num " +  globalGenerationNumber + "\n");
			out.write(result);
			out.write("\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		int[] parentSelectIndexAttack = new int[40];
		//Find the cumulative fitness
		double[] cumulativeFitnesses = new double[40];
		cumulativeFitnesses[0] = fitnessAttackArray[0];
		for (int i = 1; i < 40; i++)
		{
			double fitness = fitnessAttackArray[i];
			cumulativeFitnesses[i] = cumulativeFitnesses[i - 1] + fitness;
		}
		Random rnd = new Random() ;
		for (int i = 0; i < 40; i++)
		{
			double randomFitness = rnd.nextDouble() * cumulativeFitnesses[cumulativeFitnesses.length - 1];
			int index = Arrays.binarySearch(cumulativeFitnesses, randomFitness);
			if (index < 0)
			{
				// Convert negative insertion point to array index.
				index = Math.abs(index + 1);
			}
			parentSelectIndexAttack[i] = index;
		}

		//Write to Attack index to file for Debugging 
		try{
			String LogPath = "C:\\Karthik\\Simulation\\AttackParentSelection.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("\n Generation Number " +  globalGenerationNumber + "\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		for(int k=0;k<40;k++)
		{
			try{
				String LogPath = "C:\\Karthik\\Simulation\\AttackParentSelection.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				String res= "-"+ parentSelectIndexAttack[k] + "-";
				out.write(res);
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
		}
		//Write /n to file
		try{
			String LogPath = "C:\\Karthik\\Simulation\\AttackParentSelection.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("(Attack Index)\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		//Write the Attack Mappings to the File
		for(int k=0;k<40;k++)
		{
			//Write to File
			try{
				String LogPath = "C:\\Karthik\\Simulation\\AttackParentSelection.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				String res= "*"+ attackMapping(parentSelectIndexAttack[k]) + "*";
				out.write(res);
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
		}
		//Write /n to file
		try{
			String LogPath = "C:\\Karthik\\Simulation\\AttackParentSelection.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("(Fitness Index)\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}


		//Select Defend Parents
		int[] parentSelectIndexDefend = new int[20];
		double[] cumulativeFitnessesD = new double[20];
		cumulativeFitnessesD[0] = fitnessDefendArray[0];
		for (int i = 1; i < 20; i++)
		{
			double fitness = fitnessDefendArray[i];
			cumulativeFitnessesD[i] = cumulativeFitnessesD[i - 1] + fitness;
		}
		Random rnd1 = new Random() ;
		for (int i = 0; i < 20; i++)
		{
			double randomFitness = rnd1.nextDouble() * cumulativeFitnessesD[cumulativeFitnessesD.length - 1];
			int index = Arrays.binarySearch(cumulativeFitnessesD, randomFitness);
			if (index < 0)
			{
				// Convert negative insertion point to array index.
				index = Math.abs(index + 1);
			}
			parentSelectIndexDefend[i] = index;
		}

		/*
		 * Write the Defend Fitness
		 */
		//Write to Defend index to file for Debugging 
		try{
			String LogPath = "C:\\Karthik\\Simulation\\DefendParentSelection.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("\n Generation Number " +  globalGenerationNumber + "\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		for(int k=0;k<20;k++)
		{
			try{
				String LogPath = "C:\\Karthik\\Simulation\\DefendParentSelection.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				String res= "-"+ parentSelectIndexDefend[k] + "-";
				out.write(res);
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
		}
		//Write /n to file
		try{
			String LogPath = "C:\\Karthik\\Simulation\\DefendParentSelection.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("(Defend Index)\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		//Write the Defend Mappings to the File
		for(int k=0;k<20;k++)
		{
			try{
				String LogPath = "C:\\Karthik\\Simulation\\DefendParentSelection.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				String res= "*"+ defendMapping(parentSelectIndexDefend[k]) + "*";
				out.write(res);
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
		}
		//Write /n to file
				try{
					String LogPath = "C:\\Karthik\\Simulation\\DefendParentSelection.txt";
					FileWriter fstream = new FileWriter(LogPath, true);
					BufferedWriter out = new BufferedWriter(fstream);
					out.write("(Fitness Index)\n");
					out.close();
				}
				catch (Exception ie) {
					throw new RuntimeException("Could not write Exception to file", ie);
				}

		//Update the FITNESS to DB
		JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		DB_URL = "jdbc:mysql://localhost/unrealdb";

		//  Database credentials
		USERNAME = "root";
		PASSWORD = "unrealdbpwd1";
		conn = null;

		stmt = null;
		preparedStatement = null;
		resultSet = null;

		for(int j=0;j<60;j++)
		{
			try{
				//STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				//STEP 3: Open a connection
				conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
				//STEP 4: Execute a query
				stmt = conn.createStatement();
				//SELECT fields FROM table ORDER BY id DESC LIMIT 1;

				String sql = "UPDATE unrealdb.bot_genes SET Fitness= ? WHERE Bot_Num= ?  AND Generation_Num = ?";

				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1, fitnessArray[j]);
				ps.setInt(2, botGeneArray[j].Bot_Number);
				ps.setInt(3, globalGenerationNumber);
				ps.executeUpdate();

			}
			catch(Exception e){
				try{
					String LogPath = "C:\\Karthik\\Simulation\\SQLExceptions.txt";
					System.out.println("SQL Exception : " + e.getMessage());
					FileWriter fstream = new FileWriter(LogPath, true);
					BufferedWriter out = new BufferedWriter(fstream);
					out.write("\n");
					out.write(e.getMessage());
					out.write("\n");
					out.close();
				}
				catch (Exception ie) {
					throw new RuntimeException("Could not write Exception to file", ie);
				}
			}
		}

		/*
		 * MAPPING - Now we have 2 Arrays - 1 For Attack and 1 for defend 
		 * - We need to MAP them to our main single Array so that we get the right BOT Number
		 * 
		 * We have selected 40 Attack Parents and 20 defend Parents
		 * 
		 * We have already read the Gene values
		 * 
		 */

		int[][] botGenesAfterCrossoverAttack = new int[40][10];
		int[][] botGenesAfterCrossoverDefend = new int[20][10];

		int parentIndex1=0, parentIndex2=0;
		int indexLoop=0;
		int numberOfCrossoverPoints = 2,attIndex=0;

		try{
			String LogPath = "C:\\Karthik\\Simulation\\AttackCrossOver.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("**********************************************************************************\n");
			out.write("Generation Number = " + globalGenerationNumber + "\n");
			
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		for(int l=0;l<20;l++) {
			parentIndex1 = attackMapping(parentSelectIndexAttack[indexLoop]);
			indexLoop++;
			parentIndex2 = attackMapping(parentSelectIndexAttack[indexLoop]);
			indexLoop++;
			numberOfCrossoverPoints = randInt(1, 2);

			try{
				String LogPath = "C:\\Karthik\\Simulation\\AttackCrossOver.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\nParent Index 1 - " + parentIndex1 + "\n");
				out.write("Parent Index 2 - " + parentIndex2 + "\n");
				out.write("Number of Crossover - " + numberOfCrossoverPoints + "\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}


			int[] offspring1 = new int[10];
			System.arraycopy(botGeneArray[parentIndex1].gene, 0, offspring1, 0, botGeneArray[parentIndex1].gene.length);
			int[] offspring2 = new int[10];
			System.arraycopy(botGeneArray[parentIndex2].gene, 0, offspring2, 0, botGeneArray[parentIndex2].gene.length);
			// Apply as many cross-overs as required.
			int[] temp = new int[botGeneArray[parentIndex1].gene.length];

			try{
				String LogPath = "C:\\Karthik\\Simulation\\AttackCrossOver.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("Before CrossOver \n");
				out.write("Child  1 Gene Contains - " + Arrays.toString(offspring1) +"\n");
				out.write("Child  2 Gene Contains - " + Arrays.toString(offspring2) +"\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}

			for (int i = 0; i < numberOfCrossoverPoints; i++)
			{
				Random rng = new Random();
				// Cross-over index is always greater than zero and less than
				// the length of the parent so that we always pick a point that
				// will result in a meaningful cross-over.
				int crossoverIndex = (1 + rng.nextInt(botGeneArray[parentIndex1].gene.length - 1));
				System.out.println("Index = " + crossoverIndex);
				System.arraycopy(offspring1, 0, temp, 0, crossoverIndex);
				System.arraycopy(offspring2, 0, offspring1, 0, crossoverIndex);
				System.arraycopy(temp, 0, offspring2, 0, crossoverIndex);
			}
			try{
				String LogPath = "C:\\Karthik\\Simulation\\AttackCrossOver.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("After CrossOver \n");
				out.write("Child  1 Gene Contains - " + Arrays.toString(offspring1) +"\n");
				out.write("Child  2 Gene Contains - " + Arrays.toString(offspring2) +"\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
			System.arraycopy(offspring1, 0, botGenesAfterCrossoverAttack[attIndex], 0, botGeneArray[parentIndex2].gene.length);
			attIndex++;
			System.arraycopy(offspring2, 0, botGenesAfterCrossoverAttack[attIndex], 0, botGeneArray[parentIndex2].gene.length);
			attIndex++;
		}

		try{
			String LogPath = "C:\\Karthik\\Simulation\\DefendCrossOver.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("**********************************************************************************\n");
			out.write("Generation Number = " + globalGenerationNumber + "\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		indexLoop=0;
		int defindex=0;
		for(int l=0;l<10;l++) {
			parentIndex1 = defendMapping(parentSelectIndexDefend[indexLoop]);
			indexLoop++;
			parentIndex2 = defendMapping(parentSelectIndexDefend[indexLoop]);
			indexLoop++;
			numberOfCrossoverPoints = randInt(1, 2);

			try{
				String LogPath = "C:\\Karthik\\Simulation\\DefendCrossOver.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\nParent Index 1 - " + parentIndex1 + "\n");
				out.write("Parent Index 2 - " + parentIndex2 + "\n");
				out.write("Number of Crossover - " + numberOfCrossoverPoints + "\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}




			int[] offspring1 = new int[10];
			System.arraycopy(botGeneArray[parentIndex1].gene, 0, offspring1, 0, botGeneArray[parentIndex1].gene.length);
			int[] offspring2 = new int[10];
			System.arraycopy(botGeneArray[parentIndex2].gene, 0, offspring2, 0, botGeneArray[parentIndex2].gene.length);
			// Apply as many cross-overs as required.
			int[] temp = new int[botGeneArray[parentIndex1].gene.length];

			try{
				String LogPath = "C:\\Karthik\\Simulation\\DefendCrossOver.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("Before CrossOver \n");
				out.write("Child  1 Gene Contains - " + Arrays.toString(offspring1) +"\n");
				out.write("Child  2 Gene Contains - " + Arrays.toString(offspring2) +"\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}


			for (int i = 0; i < numberOfCrossoverPoints; i++)
			{
				Random rng = new Random();
				// Cross-over index is always greater than zero and less than
				// the length of the parent so that we always pick a point that
				// will result in a meaningful cross-over.
				int crossoverIndex = (1 + rng.nextInt(botGeneArray[parentIndex1].gene.length - 1));
				System.out.println("Index = " + crossoverIndex);
				System.arraycopy(offspring1, 0, temp, 0, crossoverIndex);
				System.arraycopy(offspring2, 0, offspring1, 0, crossoverIndex);
				System.arraycopy(temp, 0, offspring2, 0, crossoverIndex);
			}

			try{
				String LogPath = "C:\\Karthik\\Simulation\\DefendCrossOver.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("After CrossOver \n");
				out.write("Child  1 Gene Contains - " + Arrays.toString(offspring1) +"\n");
				out.write("Child  2 Gene Contains - " + Arrays.toString(offspring2) +"\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
			System.arraycopy(offspring1, 0, botGenesAfterCrossoverDefend[defindex], 0, botGeneArray[parentIndex2].gene.length);
			defindex++;
			System.arraycopy(offspring2, 0, botGenesAfterCrossoverDefend[defindex], 0, botGeneArray[parentIndex2].gene.length);
			defindex++;
		}

		//Perform Mutation on the Genes
		//Do it 

		try{
			String LogPath = "C:\\Karthik\\Simulation\\Mutation.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("\n**********************************************************************************\n");
			out.write("Generation Number = " + globalGenerationNumber + "\n\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		int MUTATION_RATE =15;
		int mutationcount=1;

		for(int i=0;i<40;i++)
		{
			for(int j=0;j<10;j++) {
				if(randInt(1, 1000) < MUTATION_RATE) {
					try{
						String LogPath = "C:\\Karthik\\Simulation\\Mutation.txt";
						FileWriter fstream = new FileWriter(LogPath, true);
						BufferedWriter out = new BufferedWriter(fstream);
						out.write("\nMutation Number: " + mutationcount + "\n" );
						out.write("Mutation Type : Attack \n" );
						out.write("\tAttack Index : " + i+ "\n" );
						out.write("\tGene Index : " + j + "\n" );
						out.write("\tGene Value : " + botGenesAfterCrossoverAttack[i][j]  + "\n" );
						out.write("Mutating Gene \n");
						botGenesAfterCrossoverAttack[i][j] = geneMutation(j);
						out.write("\t New Gene Value : " + botGenesAfterCrossoverAttack[i][j]  + "\n" );
						out.write("\t Bot Number : " +  (attackMapping(i)+1) + "\n");
						out.close();
						mutationcount++;
					}
					catch (Exception ie) {
						throw new RuntimeException("Could not write Exception to file", ie);
					}
				}
			}

		}

		for(int i=0;i<20;i++)
		{
			for(int j=0;j<10;j++) {
				if(randInt(1, 1000) < MUTATION_RATE) {
					try{
						
						String LogPath = "C:\\Karthik\\Simulation\\Mutation.txt";
						FileWriter fstream = new FileWriter(LogPath, true);
						BufferedWriter out = new BufferedWriter(fstream);
						out.write("\nMutation Number: " + mutationcount + "\n" );
						out.write("Mutation Type : Defend \n" );
						out.write("\tAttack Index : " + i+ "\n" );
						out.write("\tGene Index : " + j + "\n" );
						out.write("\tGene Value : " + botGenesAfterCrossoverDefend[i][j]  + "\n" );
						out.write("Mutating Gene \n");
						botGenesAfterCrossoverDefend[i][j] = geneMutation(j);
						out.write("\t New Gene Value : " + botGenesAfterCrossoverDefend[i][j]  + "\n" );
						out.write("\t Bot Number : " +  (defendMapping(i)+1) + "\n");
						out.close();
						mutationcount++;
					}
					catch (Exception ie) {
						throw new RuntimeException("Could not write Exception to file", ie);
					}
				}
			}

		}

		try{
			String LogPath = "C:\\Karthik\\Simulation\\FittestBot.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("**********************************************************************************\n");
			out.write("Generation Number = " + globalGenerationNumber + "\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		//Find the Fittest Attack BOT
		final Integer[] perm = new Integer[fitnessAttackArray.length];
		for (int i = 0 ; i != perm.length ; i++) {
			perm[i] = i;
		}
		Arrays.sort(perm, new Comparator<Integer>()
				{
			@Override
			public int compare(Integer x, Integer y)
			{
				return Double.compare(fitnessAttackArray[x], fitnessAttackArray[y]);
			}
				});

		try{
			String LogPath = "C:\\Karthik\\Simulation\\FittestBot.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("Fittest Attack Bot is " + attackMapping(perm[39]) + "[ Attack Index = " + perm[39] + " ]\n") ;
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		//Replace a Random Attack bot in new population with the Fittest BOT
		int randomAttackBotNum = randInt(0, 39);
		int[] fittestAttackBotCurrent = new int [10];
		//Read the current Fittest genes
		for(int i =0;i<10;i++) 
		{
			fittestAttackBotCurrent[i] = botGeneArray[attackMapping(perm[39])].gene[i];

		}
		
		try{
			String LogPath = "C:\\Karthik\\Simulation\\FittestBot.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("Gene Values of the Fittest Attack Bot are : ");
			out.write(Arrays.toString(fittestAttackBotCurrent) +"\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}
		
		//Perm Matching

		try{
			String LogPath = "C:\\Karthik\\Simulation\\FittestBot.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("Replacing Next Generation Attack Bot Num(AttackIndex) " +randomAttackBotNum + "[ Fitness Index - " +  attackMapping(randomAttackBotNum) + " ] with Current Fittest\n" );
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		for(int i =0;i<10;i++) 
		{
			botGenesAfterCrossoverAttack[randomAttackBotNum] [i] =fittestAttackBotCurrent[i];
		}


		//Replace a Random Fittest Defend bot in new population with the Fittest BOT
		//Find the Fittest Defend BOT
		final Integer[] perm2 = new Integer[fitnessDefendArray.length];
		for (int i = 0 ; i != perm2.length ; i++) {
			perm2[i] = i;
		}
		Arrays.sort(perm2, new Comparator<Integer>()
				{
			@Override
			public int compare(Integer x, Integer y)
			{
				return Double.compare(fitnessDefendArray[x], fitnessDefendArray[y]);
			}
				});
		try{
			String LogPath = "C:\\Karthik\\Simulation\\FittestBot.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("Fittest Defend Bot is " + defendMapping(perm2[19]) + " [ Defend Index = " + perm2[19] + " ] \n") ;
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}

		int randomDefendBotNum = randInt(0, 19);
		int[] fittestDefendBotCurrent = new int [10];
		//Read the current Fittest genes
		for(int i =0;i<10;i++) 
		{
			fittestDefendBotCurrent[i] = botGeneArray[defendMapping(perm2[19])].gene[i];
		}

		for(int i =0;i<10;i++) 
		{
			botGenesAfterCrossoverDefend[randomDefendBotNum] [i] =fittestDefendBotCurrent[i];
		}
		
		try{
			String LogPath = "C:\\Karthik\\Simulation\\FittestBot.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("Gene Values of the Fittest Defend Bot are : ");
			out.write(Arrays.toString(fittestDefendBotCurrent) +"\n");
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}
		

		try{
			String LogPath = "C:\\Karthik\\Simulation\\FittestBot.txt";
			FileWriter fstream = new FileWriter(LogPath, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("Replacing Next Generation Defend Bot Num(Defend Index) " +randomDefendBotNum + " [ Fitness Index - " +  defendMapping(randomDefendBotNum) + " ] \n" );
			out.close();
		}
		catch (Exception ie) {
			throw new RuntimeException("Could not write Exception to file", ie);
		}


		//This completes Cross Over, Mutation and Elitism
		//Update these Gene Values so that NEXT Generation can read them
		//Reading of all bot data completed
		//Now update to database
		JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		DB_URL = "jdbc:mysql://localhost/unrealdb";

		//  Database credentials
		USERNAME = "root";
		PASSWORD = "unrealdbpwd1";
		connect = null;

		statement = null;
		preparedStatement = null;
		resultSet = null;
		botNumber=1;

		PreparedStatement Attack,Defend;

		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName(JDBC_DRIVER);
			// setup the connection with the DB.
			connect = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

			String DBQuery,DBQuery_Attack, DBQuery_Defend;
			int attackIndex =0;
			int defendindex=0;
			for(int i=0;i<60;i++) {

				DBQuery="INSERT INTO"
						+ " Unrealdb.bot_genes (`Generation_Num`,`Bot_Num`,`1`,`2`,`3`,`4`,`5`,`6`,`7`,`8`,`9`,`10`,`Fitness` )"
						+" VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?,?)";

				DBQuery_Attack = "INSERT INTO"
						+ " Unrealdb.bot_genes_Attack (`Generation_Num`,`Bot_Num`,`1`,`2`,`3`,`4`,`5`,`6`,`7`,`8`,`9`,`10`,`Fitness` )"
						+" VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?,?)";

				DBQuery_Defend = "INSERT INTO"
						+ " Unrealdb.bot_genes_Defend (`Generation_Num`,`Bot_Num`,`1`,`2`,`3`,`4`,`5`,`6`,`7`,`8`,`9`,`10`,`Fitness` )"
						+" VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?,?)";


				// preparedStatements can use variables and are more efficient
				preparedStatement = connect.prepareStatement(DBQuery);

				Attack = connect.prepareStatement(DBQuery_Attack);
				Defend = connect.prepareStatement(DBQuery_Defend);

				// "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
				// parameters start with 1

				if ( (i+1)==3 || (i+1)==6 || (i+1)==9 || (i+1)==12 || (i+1)==15 || (i+1)==18 || (i+1)==21 || (i+1)==24 || (i+1)==27 || (i+1)==30 ||
						(i+1)==33 || (i+1)==36 || (i+1)==39 || (i+1)==42 || (i+1)==45 || (i+1)==48 || (i+1)==51 || (i+1)==54 || (i+1)==57 || (i+1)==60 )
				{
					preparedStatement.setInt(1, globalGenerationNumber+1);
					preparedStatement.setInt(2, i+1);
					preparedStatement.setInt(3,botGenesAfterCrossoverDefend[defendindex][0]);
					preparedStatement.setInt(4, botGenesAfterCrossoverDefend[defendindex][1]); 
					preparedStatement.setInt(5, botGenesAfterCrossoverDefend[defendindex][2]); 
					preparedStatement.setInt(6, botGenesAfterCrossoverDefend[defendindex][3] ); 
					preparedStatement.setInt(7, botGenesAfterCrossoverDefend[defendindex][4] ); 
					preparedStatement.setInt(8, botGenesAfterCrossoverDefend[defendindex][5]); 
					preparedStatement.setInt(9,  botGenesAfterCrossoverDefend[defendindex][6]); 
					preparedStatement.setInt(10, botGenesAfterCrossoverDefend[defendindex][7]); 
					preparedStatement.setInt(11,  botGenesAfterCrossoverDefend[defendindex][8]); 	
					preparedStatement.setInt(12, botGenesAfterCrossoverDefend[defendindex][9]); 
					preparedStatement.setDouble(13, 0.00); // Fitness UnKnown;
					preparedStatement.executeUpdate();

					Defend.setInt(1, globalGenerationNumber);
					Defend.setInt(2, i+1);
					Defend.setInt(3,botGeneArray[i].gene[0]); 
					Defend.setInt(4, botGeneArray[i].gene[1]); 
					Defend.setInt(5, botGeneArray[i].gene[2]); 
					Defend.setInt(6, botGeneArray[i].gene[3] ); 
					Defend.setInt(7, botGeneArray[i].gene[4] ); 
					Defend.setInt(8, botGeneArray[i].gene[5]); 
					Defend.setInt(9,  botGeneArray[i].gene[6]);  
					Defend.setInt(10, botGeneArray[i].gene[7]); 
					Defend.setInt(11,  botGeneArray[i].gene[8]); 
					Defend.setInt(12, botGeneArray[i].gene[9]); 
					Defend.setDouble(13, fitnessArray[i]); 
					Defend.executeUpdate();
					defendindex++;
					continue;
				}
				preparedStatement.setInt(1, globalGenerationNumber+1);
				preparedStatement.setInt(2, i+1);
				preparedStatement.setInt(3,botGenesAfterCrossoverAttack[attackIndex][0]); 
				preparedStatement.setInt(4,  botGenesAfterCrossoverAttack[attackIndex][1]); 
				preparedStatement.setInt(5, botGenesAfterCrossoverAttack[attackIndex][2]); 
				preparedStatement.setInt(6, botGenesAfterCrossoverAttack[attackIndex][3] ); 
				preparedStatement.setInt(7, botGenesAfterCrossoverAttack[attackIndex][4] ); 
				preparedStatement.setInt(8, botGenesAfterCrossoverAttack[attackIndex][5]); 
				preparedStatement.setInt(9, botGenesAfterCrossoverAttack[attackIndex][6]); 
				preparedStatement.setInt(10,  botGenesAfterCrossoverAttack[attackIndex][7]); 
				preparedStatement.setInt(11, botGenesAfterCrossoverAttack[attackIndex][8]);
				preparedStatement.setInt(12, botGenesAfterCrossoverAttack[attackIndex][9]); 
				preparedStatement.setDouble(13,  0.00); 
				preparedStatement.executeUpdate();

				Attack.setInt(1, globalGenerationNumber);
				Attack.setInt(2, i+1);
				Attack.setInt(3,botGeneArray[i].gene[0]); 
				Attack.setInt(4, botGeneArray[i].gene[1]); 
				Attack.setInt(5, botGeneArray[i].gene[2]); 
				Attack.setInt(6,botGeneArray[i].gene[3]); 
				Attack.setInt(7, botGeneArray[i].gene[4] ); 
				Attack.setInt(8, botGeneArray[i].gene[5]); 
				Attack.setInt(9, botGeneArray[i].gene[6]); 
				Attack.setInt(10,  botGeneArray[i].gene[7]);
				Attack.setInt(11, botGeneArray[i].gene[8]);
				Attack.setInt(12, botGeneArray[i].gene[9]); 
				Attack.setDouble(13,  fitnessArray[i]); 
				Attack.executeUpdate();
				attackIndex++;
			} 
			connect.close();
		}
		catch (Exception e) {
			try{
				String LogPath = "C:\\Karthik\\Simulation\\SQLExceptions.txt";
				System.out.println("SQL Exception : " + e.getMessage());
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\n");
				out.write(e.getMessage());
				out.write("\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}

		} 
		finally {
			//close();
		}
	}

	public static int geneMutation (int geneIndex) {

		switch(geneIndex) {

		case 0:
			return randInt(10,350);
		case 1:
			return randInt(10,150);
		case 2:
			return randInt(5,101);
		case 3:
			return randInt(5,80);
		case 4:
			return randInt(500,1500);
		case 5:
			return randInt(5,90);
		case 6:
			return  randInt(1,90);
		case 7:
			return  randInt(1,50);
		case 8:
			return  randInt(10,99);
		case 9:
			return randInt(100,350);
		default:
			try{
				String LogPath = "C:\\Karthik\\Simulation\\GeneMutationError.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\n");
				out.write("Invalid Input for Gene Mutation" + geneIndex);
				out.write("\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}
			return -1;

		}
	}

	public static int attackMapping(int attackArrayIndex) {

		switch(attackArrayIndex) {

		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 3;
		case 3:
			return 4;
		case 4:
			return 6;
		case 5:
			return 7;
		case 6:
			return 9;
		case 7:
			return 10;
		case 8:
			return 12;
		case 9:
			return 13;
		case 10:
			return 15;
		case 11:
			return 16;
		case 12:
			return 18;
		case 13:
			return 19;
		case 14:
			return 21;
		case 15:
			return 22;
		case 16:
			return 24;
		case 17:
			return 25;
		case 18:
			return 27;
		case 19:
			return 28;
		case 20:
			return 30;
		case 21:
			return 31;
		case 22:
			return 33;
		case 23:
			return 34;
		case 24:
			return 36;
		case 25:
			return 37;
		case 26:
			return 39;
		case 27:
			return 40;
		case 28:
			return 42;
		case 29:
			return 43;
		case 30:
			return 45;
		case 31:
			return 46;
		case 32:
			return 48;
		case 33:
			return 49;
		case 34:
			return 51;
		case 35:
			return 52;
		case 36:
			return 54;
		case 37:
			return 55;
		case 38:
			return 57;
		case 39:
			return 58;
		default :
			//Write Mapping Error File here
			try{
				String LogPath = "C:\\Karthik\\Simulation\\MappingError.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\n");
				out.write("Invalid Input for Attack Mapping " + attackArrayIndex);
				out.write("\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}

			return -1;
		}
	}

	public static int defendMapping(int defendArrayIndex) {

		switch(defendArrayIndex) {

		case 0:
			return 2;
		case 1:
			return 5;
		case 2:
			return 8;
		case 3:
			return 11;
		case 4:
			return 14;
		case 5:
			return 17;
		case 6:
			return 20;
		case 7:
			return 23;
		case 8:
			return 26;
		case 9:
			return 29;
		case 10:
			return 32;
		case 11:
			return 35;
		case 12:
			return 38;
		case 13:
			return 41;
		case 14:
			return 44;
		case 15:
			return 47;
		case 16:
			return 50;
		case 17:
			return 53;
		case 18:
			return 56;
		case 19:
			return 59;
		default :
			//Write Mapping Error File here
			try{
				String LogPath = "C:\\Karthik\\Simulation\\MappingError.txt";
				FileWriter fstream = new FileWriter(LogPath, true);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("\n");
				out.write("Invalid Input for Defend Mapping " + defendArrayIndex);
				out.write("\n");
				out.close();
			}
			catch (Exception ie) {
				throw new RuntimeException("Could not write Exception to file", ie);
			}

			return -1;
		}
	}


	//TODO: write method to implement the Q value changes or other changes as necessary
	/**
	 * He created 60 random values at the same time and inserted into the database.
	 * Should we create the same number of random policies and insert into database?
	 * or something different is need to be done?
	 * @param botGeneArray
	 */
	public static void createValuesInDB(botStats[] botGeneArray)
	{
		//Reading of all bot data completed
		//Now update to database
//		
//		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//		String DB_URL = "jdbc:mysql://localhost/unrealdb";
//
//		//  Database credentials
//		String USERNAME = "root";
//		String PASSWORD = "unrealdbpwd1";
//		Connection connect = null;
//
//		Statement statement = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		int botNumber=1;
//
//		try {
//			// this will load the MySQL driver, each DB has its own driver
//			Class.forName(JDBC_DRIVER);
//			// setup the connection with the DB.
//			connect = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
//
//			String DBQuery;
//			for(int i=0;i<60;i++) {
//				DBQuery="INSERT INTO"
//						+ " Unrealdb.bot_genes (`Generation_Num`,`Bot_Num`,`1`,`2`,`3`,`4`,`5`,`6`,`7`,`8`,`9`,`10`,`Fitness` )"
//						+" VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//
//				preparedStatement = connect
//						.prepareStatement(DBQuery);
//				preparedStatement.setInt(1, globalGenerationNumber);
//				preparedStatement.setInt(2, i+1);
//
//				botGeneArray[i].gene[0] = randInt(10,350);
//				botGeneArray[i].gene[1] = randInt(10,150);
//				botGeneArray[i].gene[2] = randInt(5,101);
//				botGeneArray[i].gene[3] = randInt(5,80);
//				botGeneArray[i].gene[4] = randInt(500,1500);
//				botGeneArray[i].gene[5] = randInt(5,90);
//				botGeneArray[i].gene[6] = randInt(1,90);
//				botGeneArray[i].gene[7] = randInt(1,50);
//				botGeneArray[i].gene[8] = randInt(10,99);
//				botGeneArray[i].gene[9] = randInt(100,350);
//				botGeneArray[i].fitness =0.00;
//
//				preparedStatement.setInt(3,botGeneArray[i].gene[0]); 
//				preparedStatement.setInt(4,  botGeneArray[i].gene[1]); 
//				preparedStatement.setInt(5, botGeneArray[i].gene[2]); 
//				preparedStatement.setInt(6, botGeneArray[i].gene[3] ); 
//				preparedStatement.setInt(7, botGeneArray[i].gene[4] ); 
//				preparedStatement.setInt(8, botGeneArray[i].gene[5]); 
//				preparedStatement.setInt(9,  botGeneArray[i].gene[6]); 
//				preparedStatement.setInt(10,  botGeneArray[i].gene[7]); 
//				preparedStatement.setInt(11,  botGeneArray[i].gene[8]); 
//				preparedStatement.setInt(12,  botGeneArray[i].gene[9]); 
//				preparedStatement.setDouble(13,  botGeneArray[i].fitness); 
//				preparedStatement.executeUpdate();
//			} 
//			connect.close();
//		}
//		catch (Exception e) {
//			try{
//				String LogPath = "C:\\Karthik\\Simulation\\SQLExceptions.txt";
//				System.out.println("SQL Exception : " + e.getMessage());
//				FileWriter fstream = new FileWriter(LogPath, true);
//				BufferedWriter out = new BufferedWriter(fstream);
//				out.write("\n");
//				out.write(e.getMessage());
//				out.write("\n");
//				out.close();
//			}
//			catch (Exception ie) {
//				throw new RuntimeException("Could not write Exception to file", ie);
//			}
//
//		} 
//		finally {
//		}
	}

	public static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}


	public static void main(String[] args) throws JSAPException {
		
		//Create and initialize the Bot Stats Array
		botStats[] botGeneArray = new botStats[60];
		for(int i=0;i<60;i++)
		{
			botGeneArray[i] = new botStats();
			botGeneArray[i].gene = new int[10];
		}

		//Create the Initial Bot Genes Values
		//Randomly

		createValuesInDB(botGeneArray);
		String botNameString = "CTFBot";
		int localBotNumber=1;
		for(int i=0;i<numberOfGenerations;i++) {
			localBotNumber=1;
			
			//TODO : Kesava
			//This method sets the paramters for the CTF game mode and sets values like bot names and other details
			//CHeck this method once
			args = getArgs_CTF_3VS_3();
			
			//TODO: this is global generation number, we need to change this to meet our requirements
			args[6] +="//Generation_" + globalGenerationNumber;
			
			String generationPATH = args[8];
			//Need to run 10 Matches per Generation
			for(int j=0;j<20;j++)
			{
				args[8] = generationPATH + (j+1);
				args[12] = gameMatch[j] + baseLineBotTeamPATH;
				
				initJSAP();

				header();

				readConfig(args);

				sanityChecks();


				switch (matchType) {
				case DM:
					executeDeathMatch();
					break;
				case TDM:
					executeTeamDeathMatch();
					break;
				case CTF:
					executeCaptureTheFlag();
					break;
				case DD:
					executeDoubleDomination();
					break;
				default:
					fail("Unsupported match type specified " + matchTypeName + " recognized as " + matchType.shortName + "[" + matchType.name + "].");
				}
			}
			CalculateFitness(botGeneArray);
			globalGenerationNumber++;
		}
	}
}

class botStats {

	int Generation_Number;
	int Bot_Number;

	String botIdStr;
	String nameStr;
	String matchIDStr;
	String BotTeamIDStr;
	String EnemyTeamIDStr;

	int botTeamScore;
	int enemyTeamScore;

	int health;
	int Armor;
	int Adrenaline;
	int NumKillsWithoutDeath;

	int ItemsCollect;
	int WeaponsCollect;
	int AmmoCollect;
	int HealthCollect;
	int ArmorCollect;
	int ShieldCollect;
	int AdrenalineCollect;
	int OtherCollect;
	int DoubleDamageCount;
	int Combo;

	int score_bot;
	int kills;
	int killedByOthers;
	int suicides_Bot;
	int deaths_Bot;
	int ScoreLimit;
	int TimeLimit;

	int FLAG_PICKEDUP;
	int FLAG_DROPPED;
	int FLAG_RETURNED;
	int FLAG_CAPTURED;
	double TimeEnd;
	String Winner;

	int BOT_KILLED;
	int ITEM_PICKEDUP;
	int[] gene;
	double fitness;

}