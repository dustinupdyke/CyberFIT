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
	def planLevel = 2
	def missionID = 1
	
	def totalSurveySuccessOps = 0
	def totalSurveyFailOps = 0
	def totalSecureSuccessOps = 0
	def totalSecureFailOps = 0
	def totalRestoralSuccessOps = 0
	def totalRestoralFailOps = 0
	
	def totalNothings = 0
	
	def setup() {
		
	}
	
	def step() {
		//every step, a defender might do nothing, or interact with a teammamte, or interact with terrain
		//but first check if any known compromised machines - if so, only work on that
		
		//print "new step I am ${who} and i have comps ${compromisedTerrain} and my squad is ${squad}"
		if (compromisedTerrain.size()>0) {
			if(squad.toInteger() == 1) {
				msgCompromisedTerrain()
			}else {
				//print "starting restoral ops"
				startRestoralOps()
			}
		}else {
		def r1 = random.nextInt(100)
		def skillChance = 0
		
		if(skill.toInteger() == 3) {
			skillChance = 1
		}else if(skill.toInteger() == 2) {
			skillChance = 4
		}else {
			skillChance = 16
		}
		
		skillChance = skillChance * planLevel.toInteger()

		// 64 32 16
		// 16 8 4
		// 4 2 1
			
				
		if(r1 < skillChance.toInteger()) {
			//print "skill is ${skill} and skill chance is ${skillChance} and R1 is ${r1} do nothing this step"
			totalNothings = totalNothings + 1
		}else {
			//print "skill is ${skill} and skill chance is ${skillChance} and R1 is ${r1} do something this step##############"
			def r2 = random.nextInt(2)
			
			if(r2 < 1) {
				//print "r2 is ${r2} and will interact with force"
				interactWithForce()
			}else {
				//print "r2 is ${r2} and will interact with terrain"
				if(squad.toInteger() != 1) {
					//print "${who} is and my squad is ${squad}"
					interactWithTerrain()
				}
			}
		}
		
		}
	}
	
	def step_arch() {
		//every step, a defender might do nothing, or interact with a teammamte, or interact with terrain
		//but first check if any known compromised machines - if so, only work on that
		
		//print "new step I am ${who} and i have comps ${compromisedTerrain} and my squad is ${squad}"
		if (compromisedTerrain.size()>0) {
			if(squad.toInteger() == 1) {
				msgCompromisedTerrain()
			}else {
				//print "starting restoral ops"
				startRestoralOps()
			}
		}else {
		def r1 = random.nextInt(3)
		def skillChance = 3 - skill.toInteger()
				
		if(r1 < skillChance.toInteger()) {
			//print "skill is ${skill} and skill chance is ${skillChance} and R1 is ${r1} do nothing this step"
			totalNothings = totalNothings + 1
		}else {
			//print "skill is ${skill} and skill chance is ${skillChance} and R1 is ${r1} do something this step##############"
			def r2 = random.nextInt(2)
			
			if(r2 < 1) {
				//print "r2 is ${r2} and will interact with force"
				interactWithForce()
			}else {
				//print "r2 is ${r2} and will interact with terrain"
				if(squad.toInteger() != 1) {
					//print "${who} is and my squad is ${squad}"
					interactWithTerrain()
				}
			}
		}
		
		}
	}
	
	def public void startRestoralOps() {
		//print "${who} is tryng restoral on ${compromisedTerrain} and my squad is ${squad}"
		
		def lead = oneOf(defenders().with({squad.toInteger() == 1}))
		def networkAgent = oneOf(defenders().with({squad.toInteger() == 2}))
		def hostsAgent = oneOf(defenders().with({squad.toInteger() == 3}))
		def squadMate = oneOf(defenders().with({squad.toInteger() == squad.toInteger()}))
		
		def terrainToRestoreID = compromisedTerrain[0].toInteger()
		//print "the status of ${terrainToRestoreID} is ${terrain(terrainToRestoreID).status}"
		if(terrainToRestoreID != null) {
			if(terrain(terrainToRestoreID).status == 1) {
				//print "the status of ${terrainToRestoreID} is ${terrain(terrainToRestoreID).status}"			
				
				def commWith = random.nextInt(2)
				if(commWith == 0) {
					def i0 = createInteractionFFTo(lead)
					i0.lifetime = 1
					//print "i am ${who} and currently I know of these compromised terrain ${compromisedTerrain}"
					if(!lead.hasCompromiseSA(terrainToRestoreID)) {
						//print "returned true so I'am adding ${terrainToRestoreID}"
						//print "now my list is compromised terrain ${compromisedTerrain}"
						lead.compromisedTerrain.add(terrainToRestoreID)
						//print "told lead###################################################"
						//print "and adding ${terrainToRestoreID}"
					}
				}else {
					def i1 = createInteractionFFTo(squadMate)
					i1.lifetime = 1
					if(!squadMate.hasCompromiseSA(terrainToRestoreID)) {
						squadMate.compromisedTerrain.add(terrainToRestoreID)
						//print "told squad mate"
						//print "and adding ${terrainToRestoreID}"
					}
				}
			
				//Now attempt to restore
				def workstation = oneOf(terrains().with({t_type.equals(99)})) //connect me to a machine
				def workstationLink = createInteractionFTTo(workstation)
				workstation.setColor(blue())
				workstationLink.lifetime = 1
				workstationLink.color = blue()
			
				def restoralResult = workstation.tryRestore(terrainToRestoreID, skill.toInteger())
				if (restoralResult) {
					//print "restoral was a success so i'll remove compromised terrain"
					totalRestoralSuccessOps = totalRestoralSuccessOps + 1
					//print "this is before remove ${compromisedTerrain}"
					compromisedTerrain.remove(0)
					//print "this is after remove ${compromisedTerrain}"
					//msgTeamLeadRemove(terrainToRestoreID, teamLead)
					//print "this is the team lead's comp sa ${lead.compromisedTerrain}"
					def ind = lead.compromisedTerrain.findIndexOf {terrainToRestoreID}
					if(ind >= 0) {
						lead.compromisedTerrain.remove(ind.toInteger())
					}
					//lead.compromisedTerrain.remove(0)
					//print "this is the team lead's comp sa ${lead.compromisedTerrain}"
				}else {
					//print "restoral was a fail"
					totalRestoralFailOps = totalRestoralFailOps + 1
				}
			}else {
				compromisedTerrain.remove(0)	
				//print"i removed since i checked and its fine *********************************"
				//print "before is ${lead.compromisedTerrain}"
				//lead.compromisedTerrain.remove(terrainToRestoreID)
				
				def ind = lead.compromisedTerrain.findIndexOf {terrainToRestoreID}
				//print "ind is ${ind}"
				//print "to prove it I'm looking for ${terrainToRestoreID} and team lead has this ${lead.compromisedTerrain}"
				
				if(ind >= 0) {
					lead.compromisedTerrain.remove(ind.toInteger())
				}
			}
		}
	}
	
	def msgTeamLeadRemove(int terrain, int teamLead) {
		ask(defender(teamLead)){
			print "going to remove ${terrain} from ${compromisedTerrain}"
		}
	}

	def public void setPhase2() {
		teamPhase = 2
	}
	
	def public void setPhase3() {
		teamPhase = 3
	}
	
	def msgCompromisedTerrain() {
		
		def iteam = team
		def teammate = oneOf(defenders().with({team.toInteger() == iteam.toInteger()}))
		def terrainToRestoreID = compromisedTerrain[0].toInteger()
		
//		print "i am ${who} and currently I know of these compromised terrain ${compromisedTerrain}"
		
		def i0 = createInteractionFFTo(teammate)
		i0.lifetime = 1
		//print "i am ${who} and currently I know of these compromised terrain ${compromisedTerrain}"
		if(!teammate.hasCompromiseSA(terrainToRestoreID)) {
			//print "returned false so I'am adding ${terrainToRestoreID}"
			//print "now my list is compromised terrain ${compromisedTerrain}"
			teammate.compromisedTerrain.add(terrainToRestoreID)
			//print "told lead###################################################"
			//print "and adding ${terrainToRestoreID}"
		}
		
	
	}
	
	def interactWithForce() {

		def lead = oneOf(defenders().with({squad.toInteger() == 1}))
		def networkAgent = oneOf(defenders().with({squad.toInteger() == 2}))
		def hostsAgent = oneOf(defenders().with({squad.toInteger() == 3}))
		def squadMate = oneOf(defenders().with({squad.toInteger() == squad.toInteger()}))
		
		//get random and share vulsn with team lead or squad mate
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
			//share vulns 
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

			//share vulns 
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
		//print "I ${who} and my csa Status is ${compromisedTerrain}"
		def iType = random.nextInt(3) //this gives 1/3 of time messaging FT and 2/3 op FT
		def i = 0
		def survMult = 5*skill.toInteger()
			
		if(iType == 0) {//this is msg type Interaction FT
			sendMsg() 
		}else {//this is op type Interaction FT
			if(teamPhase == 1) {//survey phase only survey terrain
				i.upto(survMult.toInteger()) {  
					trySurveyOp()
				}
			}else if(teamPhase == 2) {//secure phase only secure terrain
				trySecureOp()
			}else {//protect phase either survey or secure
				def pType = random.nextInt(2)
				if (pType == 0) {
					i.upto(survMult.toInteger()) {
						trySurveyOp()
					}
				}else{
					trySecureOp()	
				}
			}
		}
	}
	
	def public boolean hasCompromiseSA(int key) {
		
		if(compromisedTerrain.size() == 0) {
			//print "has compromisedTerrain size of 0 so return false"
			return false
		}
		
		def i = 0
		i.upto(compromisedTerrain.size()) {
			if(compromisedTerrain[i] != null) {
				//print "comparing ${compromisedTerrain[i]} and ${key}"
				if(compromisedTerrain[i] == key) {
					//print "already has that one ############################## and will return true"
					return true
				}
			}
			i = i + 1
		}
		
		//print "we got to end so we will return false"
		//print "I'm looking for ${key} and it wasnt in the ${compromisedTerrain}"
		return false
	}
	
	def sendMsg() {
		
		def workstation = oneOf(terrains().with({t_type.equals(99)})) //connect me to a machine
		def workstationLink = createInteractionFTTo(workstation)
		workstation.setColor(blue())
		workstationLink.lifetime = random.nextInt(3)
		workstationLink.color = blue()
		
		workstation.sendMessage()
	}
	
	def trySurveyOp() {
		
		def workstation = oneOf(terrains().with({t_type.equals(99)})) //connect me to a machine
		def workstationLink = createInteractionFTTo(workstation)
		workstation.setColor(blue())
		workstationLink.lifetime = random.nextInt(3)
		workstationLink.color = blue()
		
		def surveyed = workstation.trySurveyWithPlan(squad.toInteger(), planLevel.toInteger(), missionID.toInteger())
		if(surveyed >= 0) {
			def dVulns = terrain(surveyed).vulns
			csaVulns2.put(surveyed, dVulns)
		}else {
			//found compromised machine, add to compromisedTerrain array
			def switchSign = surveyed * -1
			if(!hasCompromiseSA(switchSign)) {
				//print "adding ${switchSign} ################################ to my compromised list"
				compromisedTerrain.add(switchSign)
			}
		}
	}
	
	def trySurveyOp_arch() {
		
		def workstation = oneOf(terrains().with({t_type.equals(99)})) //connect me to a machine
		def workstationLink = createInteractionFTTo(workstation)
		workstation.setColor(blue())
		workstationLink.lifetime = random.nextInt(3)
		workstationLink.color = blue()
		
		def surveyed = workstation.trySurvey(squad.toInteger())
		if(surveyed >= 0) {
			def dVulns = terrain(surveyed).vulns
			csaVulns2.put(surveyed, dVulns)
		}else {
			//found compromised machine, add to compromisedTerrain array
			def switchSign = surveyed * -1
			if(!hasCompromiseSA(switchSign)) {
				//print "adding ${switchSign} ################################ to my compromised list"
				compromisedTerrain.add(switchSign)
			}
		}
	}
	
	def trySecureOp() {
		
		def workstation = oneOf(terrains().with({t_type.equals(99)})) //connect me to a machine
		def workstationLink = createInteractionFTTo(workstation)
		workstation.setColor(blue())
		workstationLink.lifetime = random.nextInt(3)
		workstationLink.color = blue()
		
		def secured = workstation.trySecureWithPlan(squad.toInteger(), planLevel.toInteger(), missionID.toInteger())
		//print "I am ${who} and my skill is ${skill} and this returned ${secured}"
		def nVulns = terrain(secured).vulns.size()
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
					//do nothing bc skll 3 will not have any vulns (except zero day)
				}else if(skill.toInteger() == 2 && nextVuln > 0) {
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
		terrain(secured).vulns = newList
		
	}
	
	def trySecureOp_arch() {
		
		def workstation = oneOf(terrains().with({t_type.equals(99)})) //connect me to a machine
		def workstationLink = createInteractionFTTo(workstation)
		workstation.setColor(blue())
		workstationLink.lifetime = random.nextInt(3)
		workstationLink.color = blue()
		
		def secured = workstation.trySecure(squad.toInteger())
		//print "I am ${who} and my skill is ${skill} and this returned ${secured}"
		def nVulns = terrain(secured).vulns.size()
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
					//do nothing bc skll 3 will not have any vulns (except zero day)
				}else if(skill.toInteger() == 2 && nextVuln > 0) {
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
		terrain(secured).vulns = newList
		
	}
	
	def public void cleanUpCompromiseSA() {
	
		def currentID = compromisedTerrain[0]
		//print f
		//print compromisedTerrain
		
		if(currentID != null) {
	
		def newList = []
		newList.add(currentID)
		
		def i = 1
		i.upto(compromisedTerrain.size()) {
						
			if(compromisedTerrain[i] != null) {
				def nextID = compromisedTerrain[i]
				//print "the next is ${nextID} and the current is ${currentID} and index is ${i}"
				if(currentID != nextID) {
					//print "they dont match so adding ${nextID} to ${newList}"
					newList.add(nextID)
					//print "now new list is ${newList}"
				}
			}
			
			i = i + 1
		}	
		
		compromisedTerrain = newList
		
		def newList2 = []
		if(newList.size() > 2) {
			currentID = newList[1]
			newList2[0] = newList[0]
			newList2[1] = newList[1]
		
			i = 2	
			i.upto(newList.size()) {
				//print "new list is greater than 2"
				if(newList[i] != null) {
					def nextID = newList[i]
					//print "the next is ${nextID} and the current is ${currentID} and index is ${i}"
					if(currentID != nextID) {
						//print "they dont match so adding ${nextID} to ${newList2}"
						newList2.add(nextID)
						//print "now new list is ${newList2}"
					}
				}
				//print "new list is ${newList} and new list 2 is ${newList2}"
				i = i + 1
			}
			//print "before cleaning the comp terr is ${compromisedTerrain}"
			//print "the new list is ${newList}"
			compromisedTerrain = newList2
		}
		
			
		}
	}

	
}