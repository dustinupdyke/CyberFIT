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

class Terrain extends ReLogoTurtle {

	def status = 0
	def type = 1 //1 - routing, 2 - server, 3 - user
	def isCompromised = false
	def vulns = [] //array of vulnerability ids
	def missionsSupported = []
	def confidentiality = -1
	def integrity = 	-1
	def availability = -1
	
	def setup(){
	
	}
	
	def step() {
		if(team1Deploy == "M1") {
			print "IS M1"
		}
		else {
			print "NONONONO"
		}
			
			
	}
	
}
