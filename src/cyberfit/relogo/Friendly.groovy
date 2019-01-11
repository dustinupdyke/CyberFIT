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


class Friendly extends UserTurtle {

	def missionId = 0 //mission ID of friendly agent
	
	def setup(){
	}
	
	def step() {
		/*every tick a Friendly might:
		 * interact with terrain (InteractionFT)
		 * do nothing 
		 * */
	}
}
