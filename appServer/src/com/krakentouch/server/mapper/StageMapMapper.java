package com.krakentouch.server.mapper;

import java.util.List;

import com.krakentouch.server.domain.StageMap;

public interface StageMapMapper {
	
	public void insertStageMap(StageMap stageMap);
	
	public List<StageMap> queryStageMapByGameId(String gameId);
	
	public StageMap queryStageMapByStageSN(String stageSN);
	
	public void deleteStageMap(StageMap stageMap);
	
	public void updateStageMap(StageMap stageMap);
}
