package com.cdac.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.cdac.Application;
import com.cdac.dto.PlayerDto;
import com.cdac.entity.Player;
import com.cdac.entity.SportType;
import com.cdac.exception.ResourceNotFound;
import com.cdac.repository.PlayerDao;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {

	private final ModelMapper modelMapper;
	private final PlayerDao playerDao;

	@Override
	public PlayerDto addPlayer(PlayerDto playerDto) {
		if (!playerDao.findByPlayerName(playerDto.getPlayerName()).isEmpty()) {
			throw new ResourceNotFound("A player is already registered with this name!");
		}
		Player player = modelMapper.map(playerDto, Player.class);
		return modelMapper.map(playerDao.save(player), PlayerDto.class);
	}

	@Override
	public PlayerDto updatePlayer(PlayerDto playerDto, Long pid) {
		Player player = playerDao.findById(pid)
				.orElseThrow(() -> new IllegalArgumentException("No player available with this id"));

		player.setPlayerName(playerDto.getPlayerName());
		player.setEmail(playerDto.getEmail());
		player.setContact(playerDto.getContact());
		player.setAddress(playerDto.getAddress());
		player.setSportType(playerDto.getSportType());
		player.setSportsPoints(playerDto.getSportsPoints());

		return modelMapper.map(playerDao.save(player), PlayerDto.class);

	}

	@Override
	public List<PlayerDto> getPlayersByCategory(SportType type) {
		List<PlayerDto> playerList = playerDao.findAllBySportType(type).stream()
				.map(p -> modelMapper.map(p, PlayerDto.class)).toList();
		return playerList;
	}

}
