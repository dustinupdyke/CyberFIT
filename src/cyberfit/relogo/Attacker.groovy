package cyberfit.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import cyberfit.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class Attacker extends ReLogoTurtle {
	
	def tier = 1 // 1 - 6 based on DSB
	def phase = 0 //1-7
	def attacks = [] //array of Attacks
	
	def setup(){
		
	}

	def step() {
	
	}
}
