package com.cdac.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Player;
import com.cdac.entity.SportType;

public interface PlayerDao extends JpaRepository<Player, Long> {
	Optional<Player> findByPlayerName(String playerName);

	List<Player> findAllBySportType(SportType type);
}
