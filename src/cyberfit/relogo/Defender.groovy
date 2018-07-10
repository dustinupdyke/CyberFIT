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

class Defender extends ReLogoTurtle{

	def team = 0 //which team is defender assigned? (1 - 10)
	def specialty = "32A" //this is MOS, AFSC

	def experienceYears = 0 //number of years experience in military cyber
	def experienceMissions = 0 // positive integer representing a force agent's total experience from missions 
	def experienceTraining = 0 //positive integer representing a force agent's total experience from official training
	
	def rank = "e1" //e1 to e9, o1 - o4
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
		
			def m = oneOf(defenders())
			def i = createInteractionFFTo(m)
			i.lifetime = 2
			i.color = blue()
		
	}
	
}
