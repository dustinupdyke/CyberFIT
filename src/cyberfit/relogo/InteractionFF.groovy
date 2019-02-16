package cyberfit.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import cyberfit.ReLogoLink
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class InteractionFF extends ReLogoLink {

	//0 = die
	def lifetime = 0
	def type = 0 // 0 - info, 1 - misc
		
	@Setup
	def setup(){
		
	
	}
		
	def step(){
		if(lifetime <= 0) {
			//if this interaction is between a planner and a lead -> then exchange responsible terrain status update and update mission plan
			die()
		}
		else {
			lifetime--
		}
		
					
	}
}
