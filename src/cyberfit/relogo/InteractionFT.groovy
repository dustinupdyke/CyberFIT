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

class InteractionFT extends ReLogoLink {
	
	//0 = die
	def lifetime = 0

	@Setup
	def setup(){
		
	
	}
		
	def step(){
		if(lifetime == 0) {
			//print "dead"
			die()
		}
		else {
			lifetime--
		}
					
	}
}
