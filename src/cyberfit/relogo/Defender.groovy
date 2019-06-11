package cyberfit.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import javax.net.ssl.SSLEngineResult.Status

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
	def compromisedTerrain = [] //Cyber Situational Awareness array of terrains that are compromised
	def csaVulns2 = [:]
	def teamPhase = 1 //1 - survey 2 - secure 3 - protect
	def leadInt = 1
	def networkInt = 2
	def hostsInt = 3
	
	def setup() {
		
	}
	
	def step() {
		// every step, a defender might do nothing, or interact with a teammamte, or interact with terrain
		//but first check if any known compromised machines - if so, only work on that
		//print "new step I am ${who} and i have comps ${compromisedTerrain}"
		if (compromisedTerrain.size()>0) {
			if(squad == 1) {
				//team lead messages others
			}else {
				startRestoralOps()
			}
		}else {
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
				if(squad != 1) {
					interactWithTerrain()
				}
			}
		}
		}
	}
	
	def public void startRestoralOps() {
		//print "${who} is tryng restoral on ${compromisedTerrain} and my squad is ${squad}"
		//first check to seee if someone else fixed it
		
		def terrainToRestoreID = compromisedTerrain[0].toInteger()
		if(terrainToRestoreID != null) {
			//def statusOf = terrain(terrainToRestore).status
			if(terrain(terrainToRestoreID).status == 1) {
				//print "the status of ${terrainToRestoreID} is ${terrain(terrainToRestoreID).status}"
				
				def lead = oneOf(defenders().with({squad.equals(leadInt)}))
				def networkAgent = oneOf(defenders().with({squad.equals(networkInt)}))
				def hostsAgent = oneOf(defenders().with({squad.equals(hostsInt)}))
				def squadMate = oneOf(defenders().with({squad.equals(squad)}))
				
				def commWith = random.nextInt(2)
				if(commWith == 0) {
					def i0 = createInteractionFFTo(lead)
					i0.lifetime = 1
					if(!lead.hasCompromiseSA(terrainToRestoreID)) {
						lead.compromisedTerrain.add(terrainToRestoreID)
						//print "told lead###################################################"
					}
				}else {
					def i1 = createInteractionFFTo(squadMate)
					i1.lifetime = 1
					if(!squadMate.hasCompromiseSA(terrainToRestoreID)) {
						squadMate.compromisedTerrain.add(terrainToRestoreID)
						//print "told squad mate"
					}
				}
			
				//Now attempt to restore
				def workstation = oneOf(terrains().with({type.equals(99)})) //connect me to a machine
				def workstationLink = createInteractionFTTo(workstation)
				workstation.setColor(blue())
				workstationLink.lifetime = 1
				workstationLink.color = blue()
			
				//def restoralLink =
				def restoralResult = workstation.tryRestore(terrainToRestoreID, skill)
				if (restoralResult) {
					//print "restoral was a success"
					compromisedTerrain.remove(0)
				}
			}else {
				compromisedTerrain.remove(0)
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
		 
		//get random and tell team lead something or squad mate something
		def rI = random.nextInt(2)
		def whatType = random.nextInt(2)
		if (whatType == 0) {
			//print "current csa is ${compromisedTerrain} and ${csaVulns2}"
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
		
		//either FT interaction or a FT followed with TT interaction
		//info OR msg OR op
		//print "current phase is ${teamPhase}"
		
		//print "I ${who} and my csa Status is ${compromisedTerrain}"
		def iType = random.nextInt(3) //this gives 1/3 of time messaging FT and 2/3 op FT
		
		def workstation = oneOf(terrains().with({type.equals(99)})) //connect me to a machine
		def workstationLink = createInteractionFTTo(workstation)
		workstation.setColor(blue())
		workstationLink.lifetime = random.nextInt(3)
		workstationLink.color = blue()
			
		if(iType == 0) {//this is msg type Interaction FT
			workstation.sendMessage()
		}else {//this is op type Interaction FT
			if(teamPhase == 1) {//survey phase only survey terrain
				def surveyed = workstation.trySurvey(squad.toInteger())
				//print "surveyed is ${surveyed}"
				
				if(surveyed >= 0) {
					def dVulns = terrain(surveyed).vulns
					csaVulns2.put(surveyed, dVulns)
				}else {
					//found compromised machine, add to compromisedTerrain array
					def switchSign = surveyed * -1
					if(!hasCompromiseSA(switchSign)) {
						//print "adding ${switchSign} ##################################"
						compromisedTerrain.add(switchSign)
					}
				}
			}else if(teamPhase == 2) {//secure phase only secure terrain
				def secured = workstation.trySecure(squad.toInteger())
				//def nVulns = terrain(secured).vulns.size()
				//print "this terrain has number of vulns ${nVulns}"
				
				def newList = []
				
				def i = 0
				i.upto(terrain(secured).vulns.size()) {
					//print "my skill is ${skill} this is next vuln ${terrain(secured).vulns[i]}"
					
					
					if(terrain(secured).vulns[i] != null) {
						def nextVuln = terrain(secured).vulns[i]
						if(nextVuln == 0) {
							newList.add(nextVuln)
						}
					
						if(skill.toInteger() == 3 && nextVuln > 0) {
							//nothing
						}else if(skill == 2 && nextVuln > 0) {
							if(nextVuln > 80) {
								//print "I skill ${skill} and adding this vuln ${nextVuln}"
								newList.add(nextVuln)
							}
						}else if(nextVuln > 0){
							if(nextVuln > 40) {
								//print "I skill ${skill} and adding this vuln ${nextVuln}"
								newList.add(nextVuln)
							}
						}
					}
					i = i + 1
					
				}
				
				//print "currently the array is ${terrain(secured).vulns} and toRemove is ${newList}"
				terrain(secured).vulns = newList
				
				//def nVulns2 = terrain(secured).vulns.size()
				//print "this terrain has number of vulns ${nVulns2}"
				
				
				
			}else {//protect phase either survey or secure
				def pType = random.nextInt(2)
				if (pType == 0) {//survey
					def surveyed = workstation.trySurvey(squad.toInteger())
					if(surveyed >= 0) {
						def dVulns = terrain(surveyed).vulns
						csaVulns2.put(surveyed, dVulns)
					}else {
						//found compromised machine, add to compromisedTerrain array
						def switchSign = surveyed * -1
						if(!hasCompromiseSA(switchSign)) {
							//print "adding ${switchSign} ################################"
							compromisedTerrain.add(switchSign)
						}
					}
				}else{//secure
					def secured = workstation.trySecure(squad.toInteger())
					//def nVulns = terrain(secured).vulns.size()
					//print "this terrain has number of vulns ${nVulns}"
					//print "this is the terrain vulns ${terrain(secured).vulns}"
					
					def newList = []
					
					def i = 0
					i.upto(terrain(secured).vulns.size()) {
						//print "my skill is ${skill} this is next vuln ${terrain(secured).vulns[i]}"
						
						if(terrain(secured).vulns[i] != null) {
							def nextVuln = terrain(secured).vulns[i]
							if(nextVuln == 0) {
								newList.add(nextVuln)
							}
						
							if(skill.toInteger() == 3 && nextVuln > 0) {
								//nothing
							}else if(skill == 2 && nextVuln > 0) {
								print "I skill ${skill} and I'm attempting to secure this vuln ${nextVuln}"
								if(nextVuln > 80) {
									newList.add(nextVuln)
								}
							}else if(nextVuln > 0){
								if(nextVuln > 40) {
									//print "I skill ${skill} and adding this vuln ${nextVuln}"
									newList.add(nextVuln)
								}
							}
						}
						i = i + 1
						
					}
					
					//print "currently the array is ${terrain(secured).vulns} and toRemove is ${newList}"
					terrain(secured).vulns = newList
					//print "now the array is ${terrain(secured).vulns}"
					
					//def nVulns2 = terrain(secured).vulns.size()
					//print "NOW this terrain has number of vulns ${nVulns2}"
				}
			}
			
		}
	}
	
	def public boolean hasCompromiseSA(int key) {
		
		if(compromisedTerrain.size() == 0) {
			return false
		}
		
		def i = 0
		i.upto(compromisedTerrain.size()) {
			if(compromisedTerrain[i] != null) {
				//print "comparing ${compromisedTerrain[i]} and ${key}"
				if(compromisedTerrain[i] == key) {
					//print "already has that one ##############################"
					return true
				}
			}
			i = i + 1
		}
		
		return false
	}
	
}