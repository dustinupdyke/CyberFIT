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
	def csa = [0,0] //Cyber Situational Awareness 2d graph array terrainid|confidentiality|integrity|availability
	def opStatus = 0 //0 = available, 1 = on training, 2 = on mission
	
	def setup() {
		
	}
	
	def step() {

		def iChance = random.nextInt(100)
		
		// every step, a defender might:
		// a. do nothing
				
		// b. interact with another defender (create InteractionFF)		
		if(iChance > 89) {
			def m = oneOf(defenders().with({team.equals(1)}))
			def i = createInteractionFFTo(m)
			i.lifetime = random.nextInt(100)
			i.color = cyan()
			m.setColor(cyan())
		}
		
		// c.interact with a terrain (create InteractionFT)
		if(iChance < 11) {
			def d = oneOf(defenders().with({team.equals(1)}))
			def workstation = oneOf(terrains().with({type.equals(99)})) //connect me to a machine
			def workstationLink = d.createInteractionFTTo(workstation)
			workstation.setColor(blue())
			d.setColor(blue())
			
			workstationLink.lifetime = random.nextInt(4)
			workstationLink.color = blue()
		}
	}
}