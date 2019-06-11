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

class Terrain extends UserTurtle {

	def status = 0 // 0 - ok, 1 - compromised
	def type = 1 //1 - routing, 2 - server, 3 - client
	def vulns = [] //array of vulnerability ids
	def payloads = []
	def missionsSupported = []
	def compromisePayload = 0
	
	def totalComps = 0
	def totalCompTime = 0

	def setup(){
		
		totalComps = 0
		totalCompTime = 0
	}
	
	def step() {
		generateVulns()
		setTerrainColor()
		updateTerrainStats()
	}
	
	def getTerrainStatus() {
		return status
	}

	def updateTerrainStats() {
		if(status == 1){
			//print "this is ${who} and has total comp time ${totalCompTime} and total comps ${totalComps}###################################"
			totalCompTime = totalCompTime + 1
		}
		
	}
	def setTerrainColor() {
		
		this.color = green()
		if(status == 1) {
			this.color = red()
		}
	}
	
	def generateVulns() {
		
		/*
		 * every step, terrain might grow a vulnerability, all possible vulnerabilities represented by integers 1 - 100
		 * the vulnerability id represents how serious it is - ie 1 is the simplest and 100 the most complicated/severe
		 * vulnerabilities can be exploited by attacker tier:
		 *
		 * tier 1: 1 - 20
		 * tier 2: 1 - 40
		 * tier 3: 1 - 60
		 * tier 4: 1 - 80
		 * tier 5: 1 - 99
		 * tier 6: 0 - 99
		 *
		 * vulnerabilities grow at a rate relative to their tier level,
		 * so tier 1 vulnerabilities are much more likely to occur than tier 2, 3, etc
		 *
		 */
		
		def r = 0
		r = random.nextInt(1000)
		
		//??% of the time, there is a new vuln
		if(r < 10) {
			// vuln occurred, get random r2 between 0 - 29, add to vuln array
			r = random.nextInt(100)
			
			if(!vulns.contains(r)) {
				vulns.add(r)
				//print "vuln added ${r}"
				//print "vulns are ${vulns}"
			}
		}
	
	}
	
	def addZeroDay() {
		this.vulns.add(0)
		//print "Tier 6 team has deployed a zero day"
		//this.setColor(red())
	}
	
	def public void sendMessage() {
		
		//print "Sending Message"
		
		def terrainToMsg = oneOf(terrains().with({type.equals(2)}))
		def messageLink = createInteractionTTTo(terrainToMsg)
		messageLink.lifetime = 1 //need to decide stochastic later
		
	}
	
	def public int trySurvey(int squad) {
		def terrainToSurvey
		//print "trying Survey"
		if(squad == 2) {
			terrainToSurvey = oneOf(terrains().with({type.equals(1) || type.equals(2)}))
			def operationLink = createInteractionTTTo(terrainToSurvey)
			operationLink.lifetime = 1 //need to decide stochastic later
		}else {
			terrainToSurvey = oneOf(terrains().with({type.equals(2) || type.equals(3)}))
			def operationLink = createInteractionTTTo(terrainToSurvey)
			operationLink.lifetime = 1 //need to decide stochastic later
		}
		if (terrainToSurvey.status == 1) {
			return -1*terrainToSurvey.who
		}
		
		return terrainToSurvey.who
	}
	
	def public int trySecure(int squad) {
		
		//print "tyring secure"
		if(squad == 2) {
			def terrainToSecure = oneOf(terrains().with({type.equals(1) || type.equals(2)}))
			def operationLink = createInteractionTTTo(terrainToSecure)
			operationLink.lifetime = 1 //need to decide stochastic later
			return terrainToSecure.who
		}else {
			def terrainToSecure = oneOf(terrains().with({type.equals(2) || type.equals(3)}))
			def operationLink = createInteractionTTTo(terrainToSecure)
			operationLink.lifetime = 1 //need to decide stochastic later
		}

	}
	
	def public boolean tryRestore(int id, String skill) {
		
		def terrainToRestore = terrain(id)
		def operationLink = createInteractionTTTo(terrainToRestore)
		operationLink.lifetime = 1 //need to decide stochastic later
		//print "try restore on ${terrainToRestore}"
		
		def restoralChance = random.nextInt(100)
		if (skill == 1) {
			if(restoralChance == 0) {
				terrainToRestore.status = 0
				//print "terrain restored"
				return true
			}
		}else if(skill == 2) {
			if(restoralChance < 5) {
				terrainToRestore.status = 0
				//print "terrain restored"
				return true
			}
		}else {
			if(restoralChance < 10) {
				terrainToRestore.status = 0
				//print "terrain restored"
				return true
			}
		}
		
		return false
	}
	
	def public void tryAttack() {
	
		//print "this machine vulns ${vulns}"
		//print "this machine payloads ${payloads}"
		def i = 0
				
		i.upto(vulns.size()){
			if(vulns[i] != null) {
			def j = 0
			
			//print "the vuln is ${vulns[i]}"
			
			j.upto(payloads.size()){
				if(payloads[j] != null) {
					if(payloads[j].toInteger() == vulns[i].toInteger()) {
						status = 1
						compromisePayload = payloads[j].toInteger()
						//print "terrain ${this.who} is now compromised"
						
						def u = this.who
						totalComps = totalComps + 1
						//print "this terrain ${who} has total of ${totalComps} BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"
						//print "a compromise occurred on ${u}"
					}
					//print "this is current payload ${payloads[j]} and current vuln ${vulns[i]}"
					
				}
				j = j + 1
			}
				
			}
			i = i + 1
		}
	}
	
	def public void removeVuln(int v) {
		
		//def newVulns =
	}
}
