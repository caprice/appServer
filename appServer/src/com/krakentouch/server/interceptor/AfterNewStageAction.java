package com.krakentouch.server.interceptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.mina.core.session.IoSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.krakentouch.server.bean.PlayerOnline;
import com.krakentouch.server.bean.PlayerOnlineBean;
import com.krakentouch.server.domain.PlayerMap;
import com.krakentouch.server.service.LoginService;
import com.krakentouch.server.tools.JaxbUtil;
import com.krakentouch.server.tools.ServerConstants;

/****
 * 对所有处于本游戏查厅态的用户（通过查询PlayerMap表获知）进行下行通知：
 * 	<TCP>
 * 		<action>NewStage</action>
 * 		<value>
 * 			<StageSN>1</StageSN>
 * 			<Status>0</Status>
 * 			<HostIndex>2</HostIndex>
 * 			<GameID>abcdef</GameID>
 * 			<PlayerID>ABCDEFGHIJ</PlayerID>
 * 		</value>
 * 	</TCP>
 * 
 * 对该用户以及所有处于询众态的用户（通过查询PlayerMap获知）进行下行通知：
 * <TCP>
 * 		<action>NewStage</action>
 * 		<value>
 * 			<PlayerID>ABCDEFGHIJ</PlayerID>
 * 			<Status>2</Status>
 * 		</value>
 * </TCP>
 * @author 21829
 *
 */
@Aspect
public class AfterNewStageAction {
	
	private LoginService loginService;
	
	@Pointcut("execution(* com.krakentouch.server.action.NewStageAction.*(..))")  
    private void anyMethod(){}//定义一个切入点
	
	@AfterReturning("anyMethod()")  
	public void afterReturning(JoinPoint point) {
		Object[] args = point.getArgs();
		IoSession session = (IoSession) args[0];
		@SuppressWarnings("unchecked")
		Map<String,String> commandMap = (Map<String, String>) args[1];
		String playerId = commandMap.get("PlayerID");
		//String deskId = commandMap.get("DeskID");
		String command = commandMap.get("action");
		
		List<String> playerIdList = new ArrayList<String>();
		List<PlayerMap> otherUsers = loginService.selectPlayerByStatus(ServerConstants.playerMap_status_queryPlayers);
		for(PlayerMap player:otherUsers){
			playerIdList.add(player.getPlayerID());
		}
		
		PlayerOnlineBean playerOnlineBean = new PlayerOnlineBean();
		playerOnlineBean.setCommand(command);
		playerOnlineBean.setResult("1");
		playerOnlineBean.setNote("success");
		
		PlayerOnline playerOnline = new PlayerOnline();
		//playerOnline.setDeskId(deskId);
		//playerOnline.setGameId("null");
		playerOnline.setPlayerId(playerId);
		playerOnline.setStatus("2");
		
		playerOnlineBean.setPlayerOnline(playerOnline);
		
		String notify = JaxbUtil.convertToXml(playerOnlineBean, "utf-8");
		
		Collection<IoSession> sessions = session.getService().getManagedSessions().values();
		for(IoSession s : sessions){
			String tempPlayerId = (String) s.getAttribute("playerId");
			if(playerIdList.contains(tempPlayerId)){
				s.write(notify);
			}
		}
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
