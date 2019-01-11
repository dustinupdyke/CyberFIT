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
	def type = 1 //1 - routing, 2 - server, 3 - user, 66 = attacker workstation, 99 = defender workstation
	def vulns = [] //array of vulnerability ids
	def missionsSupported = []

	def setup(){
	}
	
	def step() {
		generateVulns()
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
		 * tier 5: 00 - 99
		 * 
		 * vulnerabilities grow at a rate relative to their tier level, 
		 * so tier 1 vulnerabilities are much more likely to occur than tier 2, 3, etc
		 *
		 */
		
		def r = random.nextInt(10000) - 1
		
		//20% of the time, there is a new vuln
		if(r < 20) {  
			// vuln occurred, get random r2 between 0 - 29, add to vuln array
			r = random.nextInt(10000) - 1
			vulns.add(r)
			print "vuln added ${r}"
			this.setColor(getColor()+1)
		}
	
		//also, terrain might grow a zero day, at any given time		
		//get random r3 between 1 and 200, if r3 < 2, add 0 to vuln array 
		r = random.nextInt(20000)
		if(r < 1) {
			vulns.add(0)
			print "Zero day has occured ${r}"
			this.setColor(red())
		}
	}
	
	def addZeroDay() {
		this.vulns.add(0)
		print "Tier 5 team has deployed a zero day"
		this.setColor(red())
	}
}
