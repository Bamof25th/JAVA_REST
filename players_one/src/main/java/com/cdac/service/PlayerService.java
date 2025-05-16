package com.cdac.service;

import java.util.List;

import com.cdac.dto.PlayerDto;
import com.cdac.entity.SportType;

public interface PlayerService {
	PlayerDto addPlayer(PlayerDto playerDto);

	PlayerDto updatePlayer(PlayerDto playerDto, Long pid);

	List<PlayerDto> getPlayersByCategory(SportType type);
}
