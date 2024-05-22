package com.example.managesport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.managesport.models.Team;

@Controller
public class WebController {

  	@GetMapping("/")
	public String index() {
		return "season/season";
	}
	@GetMapping("/season-detail")
	public String deatailSeason(){
		  return "season/detail-season";
	}
	@GetMapping("/add-season")
	public String addSeason(){
		  return "season/add-season";
	}
	@GetMapping("/add-club")
	public String createTeam() {
		return "club/add-club";
	}
	@GetMapping("/list-club")
	public String listTeam() {
		return "club/list-club";
	}
	@GetMapping("/team-details/{id}")
	public String teamDetails(@PathVariable Long id) {
  	return "club/ThongTinDoi";
	}
	@GetMapping("/lichthidau")
	public String lichThiDau() {
		return "lichthidau/lichthidau";
	}
	@GetMapping("/result")
	public String result() {
		return "result/result-detail";
	}
	@GetMapping("/rule")
	public String rule(){
		return "dieule/edit";
	}
	@GetMapping("/bxh")
	public String bxh(){
		return "baocao/bxh";
	}
	@GetMapping("/goal")
	public String goal(){
		return "baocao/ghiban";
	}
	@GetMapping("/kientao")
	public String kientao(){
		return "baocao/kientao";
	}
}