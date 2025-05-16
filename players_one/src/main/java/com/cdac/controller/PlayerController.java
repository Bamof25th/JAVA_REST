package com.cdac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.PlayerDto;
import com.cdac.entity.SportType;
import com.cdac.service.PlayerService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/player")
@AllArgsConstructor
public class PlayerController {

	private final PlayerService playerService;

	@PostMapping
	public ResponseEntity<?> AddPlayer(@RequestBody PlayerDto playerDto) {

		PlayerDto player = playerService.addPlayer(playerDto);

		return ResponseEntity.ok(player);
	}

	@PutMapping("/{pid}")
	public ResponseEntity<?> UpdatePlayer(@PathVariable Long pid, @RequestBody PlayerDto playerDto) {
		// TODO: process POST request

		PlayerDto player = playerService.updatePlayer(playerDto, pid);

		return ResponseEntity.ok(player);
	}

	@GetMapping("/by-category")
	public ResponseEntity<?> getPlayerByCatagory(@RequestParam SportType sportType) {
		// TODO: process POST request

		List<PlayerDto> players = playerService.getPlayersByCategory(sportType);

		return ResponseEntity.ok(players);
	}

}
