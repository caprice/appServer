package com.krakentouch.server.action;

import java.util.Map;

import org.apache.mina.core.session.IoSession;

public interface GiveGiftAction {
	public String doCommand(IoSession session, Map<String,String> commandMap);
}
