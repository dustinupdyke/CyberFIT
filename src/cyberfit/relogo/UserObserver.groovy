package cyberfit.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import java.io.File
import jxl.*

import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory

import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import cyberfit.ReLogoObserver;

class UserObserver extends ReLogoObserver{

	public static final String MPATH = "./docs/campaign_01_missions.xlsx";
	public static final String CPATH = "./docs/campaign_01_CPTs.xlsx";
	
	public numTerrains = []
	
	@Setup
	def setup(){
		
		// initialize Random.uniform
		Random random = new Random()
				
		clearAll()
		
		setDefaultShape(Terrain,"box")
		setDefaultShape(Defender,"person")
		setDefaultShape(Attacker,"person")
		setDefaultShape(Friendly,"person")
		
		//loadBaseTerrain()
		//loadCPTs()		
		//loadAttackers()
		//loadTerrains()
		//loadFriendlys()
		loadMissions()

		assignCPTs()
	}
	
	@Go
	def go(){
	

		ask(interactionFTs()) {
			step()
		}
		
		ask(interactionTTs()) {
			step()
		}
		
		ask(interactionFFs()) {
			step()
		}
		
		
		//then actions
		ask(terrains()) {
			//step()
		}
		
		ask(defenders()) {
			//step()
		}
		
		ask(attackers()) {
			//step()
		}
		
		ask(friendlys()) {
			//step()
		}
		
	}
	
	def checkCPTsAssigned() {
		
		if(team1Deploy == 'N' || team2Deploy == 'N' || team3Deploy == 'N' || team4Deploy == 'N') {
			CPTsReady = 1
		}
		else {
			CPTsReady = 1
		}
	}
	
	def loadMissions() {
		
		Campaign c1 = new Campaign()
		def missions = c1.loadMissions()
		
		def y = 10
		
		print "missions:"
		for(Campaign.Mission mission : missions) {
			
			y=y+2
			def x = 40
			
			def mID = mission.missionId
			def numForces = mission.numFriendlyForces
			def numT1 = mission.numTerrainT1
			def numT2 = mission.numTerrainT2
			def numT3 = mission.numTerrainT3
			
			def n = numForces.toInteger()
			
			while(n > 0) {
				print numForces
				n = n - 1
			}
			
			//createTerrains(mission.numTerrainT1){ [setColor(brown()), type = 1] }
			print numForces
			//createTerrains(1){ [setxy(randomPxcor(),randomPycor()), setColor(orange()), type = 1] }
			
			
			//I can't figure out how to call while loop within an arraylist loop, groovy throws run time exception
			//Here - I want to call while loops that build friendly and terrain agents based on mission requirements
			
				
		}
		print "---"

	}
	
	def loadFriendlys() {
		
		Campaign c2 = new Campaign()
		def friendlys = c2.loadFriendlys()
		def x = 10
		def y = 10
		
		//print "friendlys:"
		for(Campaign.Friendly friendly : friendlys) {
			
			createFriendlys(1){ [setxy(x,y), setColor(green()), missionId = friendly.missionID] }
			x = x+1
			
			if (x%30 == 0) {
				y = y + 1
				x = 10
			}
		}
	}
	
	def loadTerrains() {
		
		Campaign c3 = new Campaign()
		def terrains = c3.loadTerrains()
		def x = -20
		def y = 10
		
		print "terrains:"
		for(Campaign.Terrain terrain : terrains) {
			
			//print terrain.missionID
			createTerrains(1){ [setxy(x,y), setColor(brown()), missionsSupported.add(terrain.missionID)]}
			x = x+1
			
			if (x%30 == 0) {
				y = y + 1
				x = -20
			}
		}
	}
	
	def assignCPTs() {
		def xu = 1
	}
	
	
	
	def loadCPTs() {
		
		Campaign c2 = new Campaign()
		
		print "soldiers:"
		def soldiers = c2.loadSoldiers()
		def x = -50
		def y = 0
		
		for(Campaign.Soldier soldier : soldiers) {
			print soldier.team
			x = x+ 2
			if(x == -30) {
				x = -50
				y = y -2
			}
			createDefenders(1){ [setxy(x,y), setColor(green()), team = soldier.team, rank = soldier.rank, 
				expMissions = soldier.expMissions, expTraining = soldier.expTraining ] }
			createTerrains(1){ [setxy(x+1,y+1), setColor(orange()), type = 99] }
		}
				
	}
	
	def loadAttackers() {
		createAttackers(1){ [setxy(5, -30), setColor(red()), tier = 1] }
		createAttackers(1){ [setxy(0, -30), setColor(red()), tier = 1] }
		createAttackers(1){ [setxy(-5,-30), setColor(red()), tier = 1] }
		
		//create attacker workstations
		createTerrains(1){ [setxy(-5, -28), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(-3, -28), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(0, -28), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(1, -28), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(1, -28), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(5, -28), setColor(pink()), type = 66] }
		
	}
	
	def loadBaseTerrain(){
		
		//Create Routers (type 1)
		createTerrains(1){ [setxy(-10,1), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-10,2), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-10,3), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-10,4), setColor(brown()), type = 1] }
		
		//Create Routers (type 1)
		createTerrains(1){ [setxy(-9,1), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-9,2), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-9,3), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-9,4), setColor(brown()), type = 1] }
				
		//Create Routers (type 1)
		createTerrains(1){ [setxy(-8,1), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-8,2), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-8,3), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-8,4), setColor(brown()), type = 1] }
		
		//Create Servers (type 2)
		createTerrains(1){ [setxy(-7,-6), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,-5), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,-4), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,-3), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,-2), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,-1), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,0), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,1), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,2), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,3), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,4), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,5), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,6), setColor(brown()), type = 2] }
		
		//Create Clients (type 3)
		createTerrains(1){ [setxy(-6,-6), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,-5), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,-4), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,-3), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,-2), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,-1), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,0), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,1), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,2), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,3), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,4), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,5), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,6), setColor(brown()), type = 3] }
		
		//Create Clients (type 3)
		createTerrains(1){ [setxy(-5,-6), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,-5), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,-4), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,-3), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,-2), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,-1), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,0), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,1), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,2), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,3), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,4), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,5), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,6), setColor(brown()), type = 3] }
		
	}
	
	def loadBaseTerrain_Loop(){
		
		def i = 10
		while(i>0) {
			i = i -1
			createTerrains(1){ [setxy(-20,i), setColor(brown()), type = 1] }
		}
		
		//Create Routers (type 1)
		createTerrains(1){ [setxy(-10,1), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-10,2), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-10,3), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-10,4), setColor(brown()), type = 1] }
		
		//Create Routers (type 1)
		createTerrains(1){ [setxy(-9,1), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-9,2), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-9,3), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-9,4), setColor(brown()), type = 1] }
				
		//Create Routers (type 1)
		createTerrains(1){ [setxy(-8,1), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-8,2), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-8,3), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-8,4), setColor(brown()), type = 1] }
		
		//Create Servers (type 2)
		createTerrains(1){ [setxy(-7,-6), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,-5), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,-4), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,-3), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,-2), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,-1), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,0), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,1), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,2), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,3), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,4), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,5), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-7,6), setColor(brown()), type = 2] }
		
		//Create Clients (type 3)
		createTerrains(1){ [setxy(-6,-6), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,-5), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,-4), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,-3), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,-2), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,-1), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,0), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,1), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,2), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,3), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,4), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,5), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-6,6), setColor(brown()), type = 3] }
		
		//Create Clients (type 3)
		createTerrains(1){ [setxy(-5,-6), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,-5), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,-4), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,-3), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,-2), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,-1), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,0), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,1), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,2), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,3), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,4), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,5), setColor(brown()), type = 3] }
		createTerrains(1){ [setxy(-5,6), setColor(brown()), type = 3] }
		
	}
	
}

	