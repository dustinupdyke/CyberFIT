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

class Defender extends UserTurtle{

	def team = 0 //which team is defender assigned? (1 - 10)
	def rank = "e1" //e1 to e9, o1 - o4
	def experienceMissions = 0 // positive integer representing a force agent's total experience from missions 
	def experienceTraining = 0 //positive integer representing a force agent's total experience from official training
	def csa = [0,0] //cyber Situational Awareness 2d graph array   terrainid|confidentiality|integrity|availability
	def opStatus = 0 //0 = available, 1 = on training, 2 = on mission
	
	def setup() {
		
	}
	
	def step() {

		/*every step, a defender might:
		 * interact with another defender (create InteractionFF)
		 * interact with a terrain (create InteractionFT)
		 * do nothing
		 * */
		
		
		def iChance = random.nextInt(100)
		if(iChance > 90) {
			def m = oneOf(defenders().with({team.equals(2)}))
			def i = createInteractionFFTo(m)
			i.lifetime = random.nextInt(4)
			i.color = blue()
		}
		

	}
	
}
