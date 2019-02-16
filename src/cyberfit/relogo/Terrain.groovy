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
	def type = 1 //1 - routing, 2 - server, 3 - client, 66 = attacker workstation, 99 = defender workstation
	def vulns = [] //array of vulnerability ids
	def payloads = []
	def missionsSupported = []

	def setup(){
	}
	
	def step() {
		generateVulns()
		setTerrainColor()
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
		 * tier 1: 80 - 99 
		 * tier 2: 60 - 99
		 * tier 3: 40 - 99
		 * tier 4: 20 - 99
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
		if(r < 20) {  
			// vuln occurred, get random r2 between 0 - 29, add to vuln array
			r = random.nextInt(100)
			
			if(!vulns.contains(r)) {
				vulns.add(r)
				//print "vuln added ${r}"
				//print "vulns are ${vulns}"
			}
		}
	
		//also, terrain might grow a zero day, at any given time		
		//get random r3 between 1 and 200, if r3 < 2, add 0 to vuln array 
		r = random.nextInt(20000)
		if(r < 1) {
			vulns.add(0)
			//print "Zero day has occured ${r}"
			this.setColor(red())
		}
	}
	
	def addZeroDay() {
		this.vulns.add(0)
		//print "Tier 6 team has deployed a zero day"
		this.setColor(red())
	}
	
	def public void sendMessage() {
		
		//print "Sending Message"
		
		def terrainToMsg = oneOf(terrains().with({type.equals(2)}))
		def messageLink = createInteractionTTTo(terrainToMsg)
		messageLink.lifetime = 1 //need to decide stochastic later
		
	}
	
	def public int trySurvey() {
		
		//print "trying Survey"
				
		def terrainToSurvey = oneOf(terrains().with({type.equals(3)}))
		def operationLink = createInteractionTTTo(terrainToSurvey)
		operationLink.lifetime = 1 //need to decide stochastic later
		
		if (terrainToSurvey.status == 1) {
			return -1
		}
		
		return terrainToSurvey.who
	}
	
	def public int trySecure() {
		
		//print "tyring secure"
		
		def terrainToSecure = oneOf(terrains().with({type.equals(3)}))
		def operationLink = createInteractionTTTo(terrainToSecure)
		operationLink.lifetime = 1 //need to decide stochastic later
		
		return terrainToSecure.who
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
						//print "terrain ${this.who} is now compromised"
						
						def u = this.who 
						
						//print "a compromise occurred on ${u} BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"
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
