package com.krakentouch.server.tools;

public class ServerConstants {
	
	/**
	 * 性别 ：不确定
	 */
	public static final int playerInfo_gender_unknown = 0;
	
	/***
	 * 性别：男
	 */
	public static final int playerInfo_gender_male = 1;
	
	/**
	 * 性别：女
	 */
	public static final int playerInfo_gender_female = 2;
	
	/**
	 * 物理房间数据,工作模式：单桌
	 */
	public static final int roomInfo_mode_single = 0;

	/**
	 * 物理房间数据,工作模式：多桌
	 */
	public static final int roomInfo_mode_more = 1;
	
	/**
	 * 游戏数据,工作模式:单人
	 */
	public static final int gameInfo_mode_onePerson = 0;
	
	/**
	 * 游戏数据,工作模式:双人
	 */
	public static final int gameInfo_mode_twoPerson = 1;
	
	/**
	 * 游戏数据,工作模式:三人
	 */
	public static final int gameInfo_mode_threePerson = 2;
	
	/**
	 * 游戏数据,工作模式:四人
	 */
	public static final int gameInfo_mode_fourPerson = 3;
	
	/**
	 * 游戏数据,工作模式:六人
	 */
	public static final int gameInfo_mode_sixPerson = 4;
	
	/**
	 * 游戏数据,工作模式:多人
	 */
	public static final int gameInfo_mode_manyPerson = 5;
	
	/**
	 * 游戏桌,工作状态：关闭
	 */
	public static final int stageMap_status_shutDown = -1;
	
	/**
	 * 游戏桌,工作状态：待机
	 */
	public static final int stageMap_status_standby = 0;
	
	/**
	 * 游戏桌,工作状态：游戏
	 */
	public static final int stageMap_status_play = 1;
	
	/**
	 * 用户,工作状态：离开
	 */
	public static final int playerMap_status_leave = -1;
	
	/**
	 * 用户,工作状态：待机
	 */
	public static final int playerMap_status_standby = 0;

	/**
	 * 用户,工作状态：询众
	 */
	public static final int playerMap_status_queryPlayers = 1;

	/**
	 * 用户,工作状态：查厅
	 */
	public static final int playerMap_status_queryHall = 2;
	
	/**
	 * 用户,工作状态：游戏
	 */
	public static final int playerMap_status_play = 3;
	
	/**
	 * 终端映射,工作模式：单人独占
	 */
	public static final int deskMap_mode_oneMonopolize = 0;

	/**
	 * 终端映射,工作模式：多人独占
	 */
	public static final int deskMap_mode_manyMonopolize = 1;
	
	/**
	 * 终端映射,工作模式：多人分占
	 */
	public static final int deskMap_mode_manyShare = 2;
	
}
