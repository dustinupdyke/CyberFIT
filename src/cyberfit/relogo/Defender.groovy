package cyberfit.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import com.jgoodies.binding.value.ConverterFactory.DoubleToIntegerConverter

import repast.simphony.essentials.RepastEssentials

import cyberfit.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class Defender extends UserTurtle{

	def team = 0 //which team is defender assigned? (1 - 10)
	def skill = 0 // value 1 - 3 representing low/medium/high from mission experience
	def squad = 0 //1 - lead, 2 - network, 3 - hosts
	def csaStatus = [0,0] //Cyber Situational Awareness 2d array terrainId|status
	def csaVulns = [0,0] //Cyber Situational Awareness 2d array terrainiId|highest vuln
	def csaVulns2 = [:]
	def teamPhase = 1
	def leadInt = 1
	def networkInt = 2
	def hostsInt = 3
	
	def setup() {
		
	}
	
	def step() {
		// every step, a defender might do nothing, or interact with a teammamte, or interact with terrain
				
		def r1 = random.nextInt(3)
		def skillChance = 3 - skill.toInteger()
		//print "r1 is ${r1}"
		//print "skill chance is ${skillChance}"
		
		//print "r1 is ${r1} and skillChance is ${skillChance}"
		
		if(r1 < skillChance.toInteger()) {
			//print "skill is ${skill} and skill chance is ${skillChance} and R1 is ${r1} do nothing this step"		
		}else {
			//print "skill is ${skill} and skill chance is ${skillChance} and R1 is ${r1} do something this step##############"
			def r2 = random.nextInt(2)
			//print "r2 is ${r2}"
			
			if(r2 < 1) {
				//print "r2 is ${r2} and will interact with force"
				interactWithForce()
			}else {
				//print "r2 is ${r2} and will interact with terrain"
				interactWithTerrain()
			}
		}
	}
	
	def public void setPhase2() {
		teamPhase = 2
	}
	
	def public void setPhase3() {
		teamPhase = 3
	}
	
	def interactWithForce() {

		def lead = oneOf(defenders().with({squad.equals(leadInt)}))	
		def networkAgent = oneOf(defenders().with({squad.equals(networkInt)}))
		def hostsAgent = oneOf(defenders().with({squad.equals(hostsInt)}))		
		def squadMate = oneOf(defenders().with({squad.equals(squad)}))
		
		//print "i ${who} and my squad ${squad} the lead is ${lead} and n dud is ${networkAgent} and h dud is ${hostsAgent} and msm is ${squadMate}"
		
		//get random and tell team lead something or squad mate something
		def rI = random.nextInt(2)
		def whatType = random.nextInt(2)
		if (whatType == 0) {
			//print "current csa is ${csaStatus} and ${csaVulns2}"
		}else {
		if(rI == 0) {
			//ri is 0 so interact with team lead
			def i = createInteractionFFTo(lead)
			i.type = whatType
			i.lifetime = 1
			//share vulns with lead
			Set<Integer> keys = csaVulns2.keySet()
			for(Integer key: keys){
				//print "Value of ${key} is: ${csaVulns2.get(key)}"
				def c = lead.csaVulns2.get(key)
				if(c == null) {
					lead.csaVulns2.put(key, csaVulns2.get(key))
				}
			}
		}else {
			//ri is 1 so interact with squad mate
			def i = createInteractionFFTo(squadMate)
			i.type = whatType
			i.lifetime = 1

			//share vulns with lead
			Set<Integer> keys = csaVulns2.keySet()
			for(Integer key: keys){
				//print "Value of ${key} is: ${csaVulns2.get(key)}"
				def c = squadMate.csaVulns2.get(key)
				if(c == null) {
					squadMate.csaVulns2.put(key, csaVulns2.get(key))
					//print "this is ${squadMate.csaVulns2}"
				}
			}
		}
		}
	}
	
	def interactWithTerrain() {
		
		//either gonna be a FT interaction or a FT followed with TT interaction
		//info OR msg OR op
		print "current phase is ${teamPhase}"
		def iType = random.nextInt(3)
		
		def workstation = oneOf(terrains().with({type.equals(99)})) //connect me to a machine
		def workstationLink = createInteractionFTTo(workstation)
		workstation.setColor(blue())
		workstationLink.lifetime = random.nextInt(3)
		workstationLink.color = blue()
			
		if(iType == 1) {//this is msg type Interaction FT
			workstation.sendMessage()
		}else {//this is op type Interaction FT
			if(teamPhase == 1) {
				def surveyed = workstation.trySurvey()
				//print "surveyed is ${surveyed}"
				
				if(surveyed >= 0) {
					def dVulns = terrain(surveyed).vulns
				
				
					csaVulns2.put(surveyed, dVulns)
				
					//print "vulns is ${dVulns}"
				
					//print "kvp is ${csaVulns2}"
				}else {
					//print "tell team lead compromise"
				}
			}else if(teamPhase == 2) {
				def secured = workstation.trySecure()
				def nVulns = terrain(secured).vulns.size()
				print "this terrain has number of vulns ${nVulns}"
				
				def i = 0
				i.upto(terrain(secured).vulns.size()) {
					print "this is next vuln ${terrain(secured).vulns[i]}"
					def nexVuln = terrain(secured).vulns[i]
					
					if(skill == 1) {
						print "check###########################"
						if (nextVuln < 41) {
							terrain(secured).vulns.remove(nextVuln)
							print "removed"
						}
						
					}else if(skill == 2) {
						
					}else {
						
					}
					
					i = i + 1
					
				}
			}else {		
				def pType = random.nextInt(2)
				if (pType == 0) {
					workstation.trySurvey()
				}else {
					workstation.trySecure()
				}
			}
			
		}
	}
}