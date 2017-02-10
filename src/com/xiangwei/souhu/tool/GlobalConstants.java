package com.xiangwei.souhu.tool;

public class GlobalConstants {
	// public static final String SERVER_URL
	// =http://api.avatardata.cn/GuoNeiNews/Query?key=dff2c66e6bc9401aaec7ab2a592596d7&page=1&rows=10
	// "http://zhihuibj.sinaapp.com/zhbj";//服务器线上前缀地址

	public static final String SERVER_URL = "http://v.juhe.cn/toutiao/index?";// 服务器主域名
	public static final String SERVER_KEY_URL = "&key=c7c7a0a207c11e686cfe8ac62e54fbe2";// 访问服务器KEY
	public static final String SERVER_TOP_URL = SERVER_URL+"type=top"+SERVER_KEY_URL;// 头条板块
	public static final String SERVER_SHEHUI_URL = SERVER_URL+"type=shehui"+SERVER_KEY_URL;// 社会板块
	public static final String SERVER_GUONEI_URL = SERVER_URL+"type=guonei"+SERVER_KEY_URL;// 国内板块
	public static final String SERVER_GUOJI_URL = SERVER_URL+"type=guoji"+SERVER_KEY_URL;// 国际板块
	public static final String SERVER_YULE_URL = SERVER_URL+"type=yule"+SERVER_KEY_URL;// 娱乐板块
	public static final String SERVER_TIYU_URL = SERVER_URL+"type=tiyu"+SERVER_KEY_URL;// 体育板块
	public static final String SERVER_JUNSHI_URL = SERVER_URL+"type=junshi"+SERVER_KEY_URL;// 军事板块
	public static final String SERVER_KEJI_URL = SERVER_URL+"type=keji"+SERVER_KEY_URL;// 科技板块
	public static final String SERVER_CAIJING_URL = SERVER_URL+"type=caijing"+SERVER_KEY_URL;// 军事板块
	public static final String SERVER_SHISHANG_URL = SERVER_URL+"type=shishang"+SERVER_KEY_URL;// 科技板块
	
}
