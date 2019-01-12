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
	def rank = 0 //e1 to e9, o1 - o4
	def expMissions = 0 // positive integer representing a force agent's total experience from industrial missions
	def expTraining = 0 // positive integer representing a force agent's total experience from tactical missions
	def lead = 0
	def squad = 0 //1 - mp, 1 - network, 2 - hunt, 3 - hosts
	def csa = [0,0] //Cyber Situational Awareness 2d array terrainid|status
	def opStatus = 0 //0 = available, 1 = on training, 2 = on mission
	
	def setup() {
		
	}
	
	def step() {

		def iChance = random.nextInt(100)
		
		// every step, a defender might:
		// a. do nothing -> ichance between 11 and 89
				
		// b. interact with another defender (create InteractionFF)
		//during this interaction they might exchange CSA		
		if(iChance > 89) {
			def m = oneOf(defenders())
			def i = createInteractionFFTo(m)
			i.lifetime = random.nextInt(10)
			i.color = cyan()
			m.setColor(cyan())
		}
		
		
		
		if(iChance < 11) {
			
			// c.interact with a terrain (create InteractionFT)
			// during this FT interaction, it will be one of following type:
			// Information Read, Information Write
			// Operation Survey, Operation Edit, Operation Execute, Operation Develop, Operation Access
			// Message Chat, Message Email, Message Report, Message Direct, Message Read
			
			def workstation = oneOf(terrains().with({type.equals(99)})) //connect me to a machine
			def workstationLink = createInteractionFTTo(workstation)
			workstation.setColor(blue())			
			workstationLink.lifetime = random.nextInt(4)
			workstationLink.color = blue()
			
			if(squad == 1) {
				def terrainToSurvey = oneOf(terrains().with({type.equals(3)}))
			}

		
		
		/*if(iChance < 11) {
			def d = oneOf(defenders())
			def workstation = oneOf(terrains().with({type.equals(99)})) //connect me to a machine
			def workstationLink = d.createInteractionFTTo(workstation)
			workstation.setColor(blue())
			d.setColor(blue())
			
			workstationLink.lifetime = random.nextInt(4)
			workstationLink.color = blue()
		*/}
	}
}