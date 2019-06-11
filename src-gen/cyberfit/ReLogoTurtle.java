package cyberfit;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoTurtle extends BaseTurtle{

	/**
	 * Makes a number of new attackers and then executes a set of commands on the
	 * created attackers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created attackers
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> hatchAttackers(int number, Closure closure) {
		AgentSet<cyberfit.relogo.Attacker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Attacker");
		for (Turtle t : createResult){
			if (t instanceof cyberfit.relogo.Attacker){
				result.add((cyberfit.relogo.Attacker)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new attackers and then executes a set of commands on the
	 * created attackers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created attackers
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> hatchAttackers(int number) {
		return hatchAttackers(number,null);
	}

	/**
	 * Returns an agentset of attackers from the patch of the caller.
	 * 
	 * @return agentset of attackers from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> attackersHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<cyberfit.relogo.Attacker> result = new AgentSet<cyberfit.relogo.Attacker>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"attacker")){
			if (t instanceof cyberfit.relogo.Attacker)
			result.add((cyberfit.relogo.Attacker)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of attackers on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of attackers at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> attackersAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<cyberfit.relogo.Attacker> result = new AgentSet<cyberfit.relogo.Attacker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"attacker")){
			if (t instanceof cyberfit.relogo.Attacker)
			result.add((cyberfit.relogo.Attacker)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<cyberfit.relogo.Attacker>();
		}
	}

	/**
	 * Returns an agentset of attackers on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of attackers on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> attackersOn(Patch p){
		AgentSet<cyberfit.relogo.Attacker> result = new AgentSet<cyberfit.relogo.Attacker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"attacker")){
			if (t instanceof cyberfit.relogo.Attacker)
			result.add((cyberfit.relogo.Attacker)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of attackers on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of attackers on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> attackersOn(Turtle t){
		AgentSet<cyberfit.relogo.Attacker> result = new AgentSet<cyberfit.relogo.Attacker>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"attacker")){
			if (tt instanceof cyberfit.relogo.Attacker)
			result.add((cyberfit.relogo.Attacker)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of attackers on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of attackers on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> attackersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.Attacker>();
		}

		Set<cyberfit.relogo.Attacker> total = new HashSet<cyberfit.relogo.Attacker>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(attackersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(attackersOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.Attacker>(total);
	}

	/**
	 * Queries if object is a attacker.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a attacker
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public boolean isAttackerQ(Object o){
		return (o instanceof cyberfit.relogo.Attacker);
	}

	/**
	 * Returns an agentset containing all attackers.
	 * 
	 * @return agentset of all attackers
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> attackers(){
		AgentSet<cyberfit.relogo.Attacker> a = new AgentSet<cyberfit.relogo.Attacker>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.Attacker.class)) {
			if (e instanceof cyberfit.relogo.Attacker){
				a.add((cyberfit.relogo.Attacker)e);
			}
		}
		return a;
	}

	/**
	 * Returns the attacker with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public cyberfit.relogo.Attacker attacker(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.Attacker)
			return (cyberfit.relogo.Attacker) turtle;
		return null;
	}

	/**
	 * Makes a number of new defenders and then executes a set of commands on the
	 * created defenders.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created defenders
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> hatchDefenders(int number, Closure closure) {
		AgentSet<cyberfit.relogo.Defender> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Defender");
		for (Turtle t : createResult){
			if (t instanceof cyberfit.relogo.Defender){
				result.add((cyberfit.relogo.Defender)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new defenders and then executes a set of commands on the
	 * created defenders.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created defenders
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> hatchDefenders(int number) {
		return hatchDefenders(number,null);
	}

	/**
	 * Returns an agentset of defenders from the patch of the caller.
	 * 
	 * @return agentset of defenders from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> defendersHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<cyberfit.relogo.Defender> result = new AgentSet<cyberfit.relogo.Defender>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"defender")){
			if (t instanceof cyberfit.relogo.Defender)
			result.add((cyberfit.relogo.Defender)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of defenders on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of defenders at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> defendersAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<cyberfit.relogo.Defender> result = new AgentSet<cyberfit.relogo.Defender>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"defender")){
			if (t instanceof cyberfit.relogo.Defender)
			result.add((cyberfit.relogo.Defender)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<cyberfit.relogo.Defender>();
		}
	}

	/**
	 * Returns an agentset of defenders on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of defenders on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> defendersOn(Patch p){
		AgentSet<cyberfit.relogo.Defender> result = new AgentSet<cyberfit.relogo.Defender>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"defender")){
			if (t instanceof cyberfit.relogo.Defender)
			result.add((cyberfit.relogo.Defender)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of defenders on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of defenders on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> defendersOn(Turtle t){
		AgentSet<cyberfit.relogo.Defender> result = new AgentSet<cyberfit.relogo.Defender>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"defender")){
			if (tt instanceof cyberfit.relogo.Defender)
			result.add((cyberfit.relogo.Defender)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of defenders on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of defenders on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> defendersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.Defender>();
		}

		Set<cyberfit.relogo.Defender> total = new HashSet<cyberfit.relogo.Defender>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(defendersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(defendersOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.Defender>(total);
	}

	/**
	 * Queries if object is a defender.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a defender
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public boolean isDefenderQ(Object o){
		return (o instanceof cyberfit.relogo.Defender);
	}

	/**
	 * Returns an agentset containing all defenders.
	 * 
	 * @return agentset of all defenders
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> defenders(){
		AgentSet<cyberfit.relogo.Defender> a = new AgentSet<cyberfit.relogo.Defender>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.Defender.class)) {
			if (e instanceof cyberfit.relogo.Defender){
				a.add((cyberfit.relogo.Defender)e);
			}
		}
		return a;
	}

	/**
	 * Returns the defender with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public cyberfit.relogo.Defender defender(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.Defender)
			return (cyberfit.relogo.Defender) turtle;
		return null;
	}

	/**
	 * Makes a number of new friendlys and then executes a set of commands on the
	 * created friendlys.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created friendlys
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> hatchFriendlys(int number, Closure closure) {
		AgentSet<cyberfit.relogo.Friendly> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Friendly");
		for (Turtle t : createResult){
			if (t instanceof cyberfit.relogo.Friendly){
				result.add((cyberfit.relogo.Friendly)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new friendlys and then executes a set of commands on the
	 * created friendlys.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created friendlys
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> hatchFriendlys(int number) {
		return hatchFriendlys(number,null);
	}

	/**
	 * Returns an agentset of friendlys from the patch of the caller.
	 * 
	 * @return agentset of friendlys from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> friendlysHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<cyberfit.relogo.Friendly> result = new AgentSet<cyberfit.relogo.Friendly>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"friendly")){
			if (t instanceof cyberfit.relogo.Friendly)
			result.add((cyberfit.relogo.Friendly)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of friendlys on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of friendlys at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> friendlysAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<cyberfit.relogo.Friendly> result = new AgentSet<cyberfit.relogo.Friendly>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"friendly")){
			if (t instanceof cyberfit.relogo.Friendly)
			result.add((cyberfit.relogo.Friendly)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<cyberfit.relogo.Friendly>();
		}
	}

	/**
	 * Returns an agentset of friendlys on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of friendlys on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> friendlysOn(Patch p){
		AgentSet<cyberfit.relogo.Friendly> result = new AgentSet<cyberfit.relogo.Friendly>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"friendly")){
			if (t instanceof cyberfit.relogo.Friendly)
			result.add((cyberfit.relogo.Friendly)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of friendlys on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of friendlys on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> friendlysOn(Turtle t){
		AgentSet<cyberfit.relogo.Friendly> result = new AgentSet<cyberfit.relogo.Friendly>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"friendly")){
			if (tt instanceof cyberfit.relogo.Friendly)
			result.add((cyberfit.relogo.Friendly)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of friendlys on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of friendlys on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> friendlysOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.Friendly>();
		}

		Set<cyberfit.relogo.Friendly> total = new HashSet<cyberfit.relogo.Friendly>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(friendlysOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(friendlysOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.Friendly>(total);
	}

	/**
	 * Queries if object is a friendly.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a friendly
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public boolean isFriendlyQ(Object o){
		return (o instanceof cyberfit.relogo.Friendly);
	}

	/**
	 * Returns an agentset containing all friendlys.
	 * 
	 * @return agentset of all friendlys
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> friendlys(){
		AgentSet<cyberfit.relogo.Friendly> a = new AgentSet<cyberfit.relogo.Friendly>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.Friendly.class)) {
			if (e instanceof cyberfit.relogo.Friendly){
				a.add((cyberfit.relogo.Friendly)e);
			}
		}
		return a;
	}

	/**
	 * Returns the friendly with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public cyberfit.relogo.Friendly friendly(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.Friendly)
			return (cyberfit.relogo.Friendly) turtle;
		return null;
	}

	/**
	 * Makes a number of new planners and then executes a set of commands on the
	 * created planners.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created planners
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> hatchPlanners(int number, Closure closure) {
		AgentSet<cyberfit.relogo.Planner> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Planner");
		for (Turtle t : createResult){
			if (t instanceof cyberfit.relogo.Planner){
				result.add((cyberfit.relogo.Planner)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new planners and then executes a set of commands on the
	 * created planners.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created planners
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> hatchPlanners(int number) {
		return hatchPlanners(number,null);
	}

	/**
	 * Returns an agentset of planners from the patch of the caller.
	 * 
	 * @return agentset of planners from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> plannersHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<cyberfit.relogo.Planner> result = new AgentSet<cyberfit.relogo.Planner>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"planner")){
			if (t instanceof cyberfit.relogo.Planner)
			result.add((cyberfit.relogo.Planner)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of planners on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of planners at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> plannersAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<cyberfit.relogo.Planner> result = new AgentSet<cyberfit.relogo.Planner>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"planner")){
			if (t instanceof cyberfit.relogo.Planner)
			result.add((cyberfit.relogo.Planner)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<cyberfit.relogo.Planner>();
		}
	}

	/**
	 * Returns an agentset of planners on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of planners on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> plannersOn(Patch p){
		AgentSet<cyberfit.relogo.Planner> result = new AgentSet<cyberfit.relogo.Planner>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"planner")){
			if (t instanceof cyberfit.relogo.Planner)
			result.add((cyberfit.relogo.Planner)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of planners on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of planners on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> plannersOn(Turtle t){
		AgentSet<cyberfit.relogo.Planner> result = new AgentSet<cyberfit.relogo.Planner>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"planner")){
			if (tt instanceof cyberfit.relogo.Planner)
			result.add((cyberfit.relogo.Planner)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of planners on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of planners on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> plannersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.Planner>();
		}

		Set<cyberfit.relogo.Planner> total = new HashSet<cyberfit.relogo.Planner>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(plannersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(plannersOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.Planner>(total);
	}

	/**
	 * Queries if object is a planner.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a planner
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public boolean isPlannerQ(Object o){
		return (o instanceof cyberfit.relogo.Planner);
	}

	/**
	 * Returns an agentset containing all planners.
	 * 
	 * @return agentset of all planners
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> planners(){
		AgentSet<cyberfit.relogo.Planner> a = new AgentSet<cyberfit.relogo.Planner>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.Planner.class)) {
			if (e instanceof cyberfit.relogo.Planner){
				a.add((cyberfit.relogo.Planner)e);
			}
		}
		return a;
	}

	/**
	 * Returns the planner with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public cyberfit.relogo.Planner planner(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.Planner)
			return (cyberfit.relogo.Planner) turtle;
		return null;
	}

	/**
	 * Makes a number of new terrains and then executes a set of commands on the
	 * created terrains.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created terrains
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> hatchTerrains(int number, Closure closure) {
		AgentSet<cyberfit.relogo.Terrain> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Terrain");
		for (Turtle t : createResult){
			if (t instanceof cyberfit.relogo.Terrain){
				result.add((cyberfit.relogo.Terrain)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new terrains and then executes a set of commands on the
	 * created terrains.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created terrains
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> hatchTerrains(int number) {
		return hatchTerrains(number,null);
	}

	/**
	 * Returns an agentset of terrains from the patch of the caller.
	 * 
	 * @return agentset of terrains from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> terrainsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<cyberfit.relogo.Terrain> result = new AgentSet<cyberfit.relogo.Terrain>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"terrain")){
			if (t instanceof cyberfit.relogo.Terrain)
			result.add((cyberfit.relogo.Terrain)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of terrains on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of terrains at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> terrainsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<cyberfit.relogo.Terrain> result = new AgentSet<cyberfit.relogo.Terrain>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"terrain")){
			if (t instanceof cyberfit.relogo.Terrain)
			result.add((cyberfit.relogo.Terrain)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<cyberfit.relogo.Terrain>();
		}
	}

	/**
	 * Returns an agentset of terrains on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of terrains on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> terrainsOn(Patch p){
		AgentSet<cyberfit.relogo.Terrain> result = new AgentSet<cyberfit.relogo.Terrain>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"terrain")){
			if (t instanceof cyberfit.relogo.Terrain)
			result.add((cyberfit.relogo.Terrain)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of terrains on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of terrains on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> terrainsOn(Turtle t){
		AgentSet<cyberfit.relogo.Terrain> result = new AgentSet<cyberfit.relogo.Terrain>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"terrain")){
			if (tt instanceof cyberfit.relogo.Terrain)
			result.add((cyberfit.relogo.Terrain)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of terrains on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of terrains on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> terrainsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.Terrain>();
		}

		Set<cyberfit.relogo.Terrain> total = new HashSet<cyberfit.relogo.Terrain>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(terrainsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(terrainsOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.Terrain>(total);
	}

	/**
	 * Queries if object is a terrain.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a terrain
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public boolean isTerrainQ(Object o){
		return (o instanceof cyberfit.relogo.Terrain);
	}

	/**
	 * Returns an agentset containing all terrains.
	 * 
	 * @return agentset of all terrains
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> terrains(){
		AgentSet<cyberfit.relogo.Terrain> a = new AgentSet<cyberfit.relogo.Terrain>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.Terrain.class)) {
			if (e instanceof cyberfit.relogo.Terrain){
				a.add((cyberfit.relogo.Terrain)e);
			}
		}
		return a;
	}

	/**
	 * Returns the terrain with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public cyberfit.relogo.Terrain terrain(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.Terrain)
			return (cyberfit.relogo.Terrain) turtle;
		return null;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> hatchUserTurtles(int number, Closure closure) {
		AgentSet<cyberfit.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof cyberfit.relogo.UserTurtle){
				result.add((cyberfit.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> hatchUserTurtles(int number) {
		return hatchUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<cyberfit.relogo.UserTurtle> result = new AgentSet<cyberfit.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof cyberfit.relogo.UserTurtle)
			result.add((cyberfit.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<cyberfit.relogo.UserTurtle> result = new AgentSet<cyberfit.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof cyberfit.relogo.UserTurtle)
			result.add((cyberfit.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<cyberfit.relogo.UserTurtle>();
		}
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<cyberfit.relogo.UserTurtle> result = new AgentSet<cyberfit.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof cyberfit.relogo.UserTurtle)
			result.add((cyberfit.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<cyberfit.relogo.UserTurtle> result = new AgentSet<cyberfit.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof cyberfit.relogo.UserTurtle)
			result.add((cyberfit.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.UserTurtle>();
		}

		Set<cyberfit.relogo.UserTurtle> total = new HashSet<cyberfit.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof cyberfit.relogo.UserTurtle);
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> userTurtles(){
		AgentSet<cyberfit.relogo.UserTurtle> a = new AgentSet<cyberfit.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.UserTurtle.class)) {
			if (e instanceof cyberfit.relogo.UserTurtle){
				a.add((cyberfit.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public cyberfit.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.UserTurtle)
			return (cyberfit.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Makes a directed interactionFF from a turtle to the caller then executes a set of
	 * commands on the created interactionFF.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created interactionFF
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public cyberfit.relogo.InteractionFF createInteractionFFFrom(Turtle t, Closure closure){
		cyberfit.relogo.InteractionFF link = (cyberfit.relogo.InteractionFF)this.getMyObserver().getNetwork("InteractionFF").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed interactionFF from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created interactionFF
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public cyberfit.relogo.InteractionFF createInteractionFFFrom(Turtle t){
			return createInteractionFFFrom(t,null);
	}

	/**
	 * Makes directed interactionFFs from a collection to the caller then executes a set
	 * of commands on the created interactionFFs.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created interactionFFs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet<cyberfit.relogo.InteractionFF> createInteractionFFsFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<cyberfit.relogo.InteractionFF> links = new AgentSet<cyberfit.relogo.InteractionFF>();
		for(Turtle t : a){
			links.add((cyberfit.relogo.InteractionFF)this.getMyObserver().getNetwork("InteractionFF").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed interactionFFs from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created interactionFFs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet<cyberfit.relogo.InteractionFF> createInteractionFFsFrom(Collection<? extends Turtle> a){
		return createInteractionFFsFrom(a,null);
	}

	/**
	 * Makes a directed interactionFF to a turtle from the caller then executes a set of
	 * commands on the created interactionFF.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created interactionFF
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public cyberfit.relogo.InteractionFF createInteractionFFTo(Turtle t, Closure closure){
		cyberfit.relogo.InteractionFF link = (cyberfit.relogo.InteractionFF)this.getMyObserver().getNetwork("InteractionFF").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed interactionFF to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created interactionFF
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public cyberfit.relogo.InteractionFF createInteractionFFTo(Turtle t){
			return createInteractionFFTo(t,null);
	}

	/**
	 * Makes directed interactionFFs to a collection from the caller then executes a set
	 * of commands on the created interactionFFs.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created interactionFFs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet<cyberfit.relogo.InteractionFF> createInteractionFFsTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<cyberfit.relogo.InteractionFF> links = new AgentSet<cyberfit.relogo.InteractionFF>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((cyberfit.relogo.InteractionFF)this.getMyObserver().getNetwork("InteractionFF").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed interactionFFs to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created interactionFFs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet<cyberfit.relogo.InteractionFF> createInteractionFFsTo(Collection<? extends Turtle> a){
		return createInteractionFFsTo(a,null);
	}

	/**
	 * Queries if there is a directed interactionFF from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed interactionFF from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public boolean inInteractionFFNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("InteractionFF").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed interactionFFs to the caller.
	 * 
	 * @return agentset with directed interactionFFs to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet inInteractionFFNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("InteractionFF").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed interactionFF from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed interactionFF from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public cyberfit.relogo.InteractionFF inInteractionFFFrom(Turtle t){
		return (cyberfit.relogo.InteractionFF)this.getMyObserver().getNetwork("InteractionFF").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed interactionFFs from other turtles to the caller.
	 * 
	 * @return agentset of directed interactionFFs from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet<cyberfit.relogo.InteractionFF> myInInteractionFFs(){
		AgentSet<cyberfit.relogo.InteractionFF> result = new AgentSet<cyberfit.relogo.InteractionFF>();
		for(Object o :  this.getMyObserver().getNetwork("InteractionFF").getInEdges(this)){
			if (o instanceof cyberfit.relogo.InteractionFF){
				result.add((cyberfit.relogo.InteractionFF) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed interactionFFs to other turtles from the caller.
	 * 
	 * @return agentset of directed interactionFFs to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet<cyberfit.relogo.InteractionFF> myOutInteractionFFs(){
		AgentSet<cyberfit.relogo.InteractionFF> result = new AgentSet<cyberfit.relogo.InteractionFF>();
		for(Object o :  this.getMyObserver().getNetwork("InteractionFF").getOutEdges(this)){
			if (o instanceof cyberfit.relogo.InteractionFF){
				result.add((cyberfit.relogo.InteractionFF) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed interactionFF to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed interactionFF to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public boolean outInteractionFFNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("InteractionFF").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed interactionFFs from the caller.
	 * 
	 * @return agentset with directed interactionFFs from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet outInteractionFFNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("InteractionFF").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed interactionFF to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed interactionFF to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public cyberfit.relogo.InteractionFF outInteractionFFTo(Turtle t){
		return (cyberfit.relogo.InteractionFF)this.getMyObserver().getNetwork("InteractionFF").getEdge(this, t);
	}

	/**
	 * Reports true if there is a interactionFF connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public boolean interactionFFNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("InteractionFF").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * interactionFFs connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet interactionFFNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("InteractionFF").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's interactionFFs.
	 * 
	 * @return agentset of the caller's interactionFFs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet<cyberfit.relogo.InteractionFF> myInteractionFFs(){
		AgentSet<cyberfit.relogo.InteractionFF> result = new AgentSet<cyberfit.relogo.InteractionFF>();
		for(Object o : this.getMyObserver().getNetwork("InteractionFF").getEdges(this)){
			if (o instanceof cyberfit.relogo.InteractionFF){
				result.add((cyberfit.relogo.InteractionFF)o);
			}
		}
		return result;
	}

	/**
	 * Queries if object is a interactionFF.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a interactionFF
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public boolean isInteractionFFQ(Object o){
		return (o instanceof cyberfit.relogo.InteractionFF);
	}

	/**
	 * Returns an agentset containing all interactionFFs.
	 * 
	 * @return agentset of all interactionFFs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet<cyberfit.relogo.InteractionFF> interactionFFs(){
		AgentSet<cyberfit.relogo.InteractionFF> a = new AgentSet<cyberfit.relogo.InteractionFF>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.InteractionFF.class)) {
			if (e instanceof cyberfit.relogo.InteractionFF){
				a.add((cyberfit.relogo.InteractionFF)e);
			}
		}
		return a;
	}

	/**
	 * Returns the interactionFF between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return interactionFF between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public cyberfit.relogo.InteractionFF interactionFF(Number oneEnd, Number otherEnd) {
		return (cyberfit.relogo.InteractionFF)(this.getMyObserver().getNetwork("InteractionFF").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the interactionFF between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return interactionFF between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public cyberfit.relogo.InteractionFF interactionFF(Turtle oneEnd, Turtle otherEnd) {
		return interactionFF(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Makes a directed interactionFT from a turtle to the caller then executes a set of
	 * commands on the created interactionFT.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created interactionFT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public cyberfit.relogo.InteractionFT createInteractionFTFrom(Turtle t, Closure closure){
		cyberfit.relogo.InteractionFT link = (cyberfit.relogo.InteractionFT)this.getMyObserver().getNetwork("InteractionFT").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed interactionFT from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created interactionFT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public cyberfit.relogo.InteractionFT createInteractionFTFrom(Turtle t){
			return createInteractionFTFrom(t,null);
	}

	/**
	 * Makes directed interactionFTs from a collection to the caller then executes a set
	 * of commands on the created interactionFTs.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created interactionFTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet<cyberfit.relogo.InteractionFT> createInteractionFTsFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<cyberfit.relogo.InteractionFT> links = new AgentSet<cyberfit.relogo.InteractionFT>();
		for(Turtle t : a){
			links.add((cyberfit.relogo.InteractionFT)this.getMyObserver().getNetwork("InteractionFT").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed interactionFTs from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created interactionFTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet<cyberfit.relogo.InteractionFT> createInteractionFTsFrom(Collection<? extends Turtle> a){
		return createInteractionFTsFrom(a,null);
	}

	/**
	 * Makes a directed interactionFT to a turtle from the caller then executes a set of
	 * commands on the created interactionFT.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created interactionFT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public cyberfit.relogo.InteractionFT createInteractionFTTo(Turtle t, Closure closure){
		cyberfit.relogo.InteractionFT link = (cyberfit.relogo.InteractionFT)this.getMyObserver().getNetwork("InteractionFT").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed interactionFT to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created interactionFT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public cyberfit.relogo.InteractionFT createInteractionFTTo(Turtle t){
			return createInteractionFTTo(t,null);
	}

	/**
	 * Makes directed interactionFTs to a collection from the caller then executes a set
	 * of commands on the created interactionFTs.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created interactionFTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet<cyberfit.relogo.InteractionFT> createInteractionFTsTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<cyberfit.relogo.InteractionFT> links = new AgentSet<cyberfit.relogo.InteractionFT>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((cyberfit.relogo.InteractionFT)this.getMyObserver().getNetwork("InteractionFT").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed interactionFTs to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created interactionFTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet<cyberfit.relogo.InteractionFT> createInteractionFTsTo(Collection<? extends Turtle> a){
		return createInteractionFTsTo(a,null);
	}

	/**
	 * Queries if there is a directed interactionFT from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed interactionFT from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public boolean inInteractionFTNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("InteractionFT").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed interactionFTs to the caller.
	 * 
	 * @return agentset with directed interactionFTs to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet inInteractionFTNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("InteractionFT").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed interactionFT from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed interactionFT from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public cyberfit.relogo.InteractionFT inInteractionFTFrom(Turtle t){
		return (cyberfit.relogo.InteractionFT)this.getMyObserver().getNetwork("InteractionFT").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed interactionFTs from other turtles to the caller.
	 * 
	 * @return agentset of directed interactionFTs from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet<cyberfit.relogo.InteractionFT> myInInteractionFTs(){
		AgentSet<cyberfit.relogo.InteractionFT> result = new AgentSet<cyberfit.relogo.InteractionFT>();
		for(Object o :  this.getMyObserver().getNetwork("InteractionFT").getInEdges(this)){
			if (o instanceof cyberfit.relogo.InteractionFT){
				result.add((cyberfit.relogo.InteractionFT) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed interactionFTs to other turtles from the caller.
	 * 
	 * @return agentset of directed interactionFTs to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet<cyberfit.relogo.InteractionFT> myOutInteractionFTs(){
		AgentSet<cyberfit.relogo.InteractionFT> result = new AgentSet<cyberfit.relogo.InteractionFT>();
		for(Object o :  this.getMyObserver().getNetwork("InteractionFT").getOutEdges(this)){
			if (o instanceof cyberfit.relogo.InteractionFT){
				result.add((cyberfit.relogo.InteractionFT) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed interactionFT to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed interactionFT to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public boolean outInteractionFTNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("InteractionFT").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed interactionFTs from the caller.
	 * 
	 * @return agentset with directed interactionFTs from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet outInteractionFTNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("InteractionFT").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed interactionFT to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed interactionFT to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public cyberfit.relogo.InteractionFT outInteractionFTTo(Turtle t){
		return (cyberfit.relogo.InteractionFT)this.getMyObserver().getNetwork("InteractionFT").getEdge(this, t);
	}

	/**
	 * Reports true if there is a interactionFT connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public boolean interactionFTNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("InteractionFT").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * interactionFTs connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet interactionFTNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("InteractionFT").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's interactionFTs.
	 * 
	 * @return agentset of the caller's interactionFTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet<cyberfit.relogo.InteractionFT> myInteractionFTs(){
		AgentSet<cyberfit.relogo.InteractionFT> result = new AgentSet<cyberfit.relogo.InteractionFT>();
		for(Object o : this.getMyObserver().getNetwork("InteractionFT").getEdges(this)){
			if (o instanceof cyberfit.relogo.InteractionFT){
				result.add((cyberfit.relogo.InteractionFT)o);
			}
		}
		return result;
	}

	/**
	 * Queries if object is a interactionFT.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a interactionFT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public boolean isInteractionFTQ(Object o){
		return (o instanceof cyberfit.relogo.InteractionFT);
	}

	/**
	 * Returns an agentset containing all interactionFTs.
	 * 
	 * @return agentset of all interactionFTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet<cyberfit.relogo.InteractionFT> interactionFTs(){
		AgentSet<cyberfit.relogo.InteractionFT> a = new AgentSet<cyberfit.relogo.InteractionFT>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.InteractionFT.class)) {
			if (e instanceof cyberfit.relogo.InteractionFT){
				a.add((cyberfit.relogo.InteractionFT)e);
			}
		}
		return a;
	}

	/**
	 * Returns the interactionFT between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return interactionFT between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public cyberfit.relogo.InteractionFT interactionFT(Number oneEnd, Number otherEnd) {
		return (cyberfit.relogo.InteractionFT)(this.getMyObserver().getNetwork("InteractionFT").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the interactionFT between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return interactionFT between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public cyberfit.relogo.InteractionFT interactionFT(Turtle oneEnd, Turtle otherEnd) {
		return interactionFT(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Makes a directed interactionTT from a turtle to the caller then executes a set of
	 * commands on the created interactionTT.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created interactionTT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public cyberfit.relogo.InteractionTT createInteractionTTFrom(Turtle t, Closure closure){
		cyberfit.relogo.InteractionTT link = (cyberfit.relogo.InteractionTT)this.getMyObserver().getNetwork("InteractionTT").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed interactionTT from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created interactionTT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public cyberfit.relogo.InteractionTT createInteractionTTFrom(Turtle t){
			return createInteractionTTFrom(t,null);
	}

	/**
	 * Makes directed interactionTTs from a collection to the caller then executes a set
	 * of commands on the created interactionTTs.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created interactionTTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet<cyberfit.relogo.InteractionTT> createInteractionTTsFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<cyberfit.relogo.InteractionTT> links = new AgentSet<cyberfit.relogo.InteractionTT>();
		for(Turtle t : a){
			links.add((cyberfit.relogo.InteractionTT)this.getMyObserver().getNetwork("InteractionTT").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed interactionTTs from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created interactionTTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet<cyberfit.relogo.InteractionTT> createInteractionTTsFrom(Collection<? extends Turtle> a){
		return createInteractionTTsFrom(a,null);
	}

	/**
	 * Makes a directed interactionTT to a turtle from the caller then executes a set of
	 * commands on the created interactionTT.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created interactionTT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public cyberfit.relogo.InteractionTT createInteractionTTTo(Turtle t, Closure closure){
		cyberfit.relogo.InteractionTT link = (cyberfit.relogo.InteractionTT)this.getMyObserver().getNetwork("InteractionTT").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed interactionTT to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created interactionTT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public cyberfit.relogo.InteractionTT createInteractionTTTo(Turtle t){
			return createInteractionTTTo(t,null);
	}

	/**
	 * Makes directed interactionTTs to a collection from the caller then executes a set
	 * of commands on the created interactionTTs.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created interactionTTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet<cyberfit.relogo.InteractionTT> createInteractionTTsTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<cyberfit.relogo.InteractionTT> links = new AgentSet<cyberfit.relogo.InteractionTT>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((cyberfit.relogo.InteractionTT)this.getMyObserver().getNetwork("InteractionTT").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed interactionTTs to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created interactionTTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet<cyberfit.relogo.InteractionTT> createInteractionTTsTo(Collection<? extends Turtle> a){
		return createInteractionTTsTo(a,null);
	}

	/**
	 * Queries if there is a directed interactionTT from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed interactionTT from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public boolean inInteractionTTNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("InteractionTT").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed interactionTTs to the caller.
	 * 
	 * @return agentset with directed interactionTTs to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet inInteractionTTNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("InteractionTT").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed interactionTT from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed interactionTT from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public cyberfit.relogo.InteractionTT inInteractionTTFrom(Turtle t){
		return (cyberfit.relogo.InteractionTT)this.getMyObserver().getNetwork("InteractionTT").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed interactionTTs from other turtles to the caller.
	 * 
	 * @return agentset of directed interactionTTs from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet<cyberfit.relogo.InteractionTT> myInInteractionTTs(){
		AgentSet<cyberfit.relogo.InteractionTT> result = new AgentSet<cyberfit.relogo.InteractionTT>();
		for(Object o :  this.getMyObserver().getNetwork("InteractionTT").getInEdges(this)){
			if (o instanceof cyberfit.relogo.InteractionTT){
				result.add((cyberfit.relogo.InteractionTT) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed interactionTTs to other turtles from the caller.
	 * 
	 * @return agentset of directed interactionTTs to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet<cyberfit.relogo.InteractionTT> myOutInteractionTTs(){
		AgentSet<cyberfit.relogo.InteractionTT> result = new AgentSet<cyberfit.relogo.InteractionTT>();
		for(Object o :  this.getMyObserver().getNetwork("InteractionTT").getOutEdges(this)){
			if (o instanceof cyberfit.relogo.InteractionTT){
				result.add((cyberfit.relogo.InteractionTT) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed interactionTT to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed interactionTT to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public boolean outInteractionTTNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("InteractionTT").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed interactionTTs from the caller.
	 * 
	 * @return agentset with directed interactionTTs from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet outInteractionTTNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("InteractionTT").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed interactionTT to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed interactionTT to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public cyberfit.relogo.InteractionTT outInteractionTTTo(Turtle t){
		return (cyberfit.relogo.InteractionTT)this.getMyObserver().getNetwork("InteractionTT").getEdge(this, t);
	}

	/**
	 * Reports true if there is a interactionTT connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public boolean interactionTTNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("InteractionTT").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * interactionTTs connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet interactionTTNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("InteractionTT").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's interactionTTs.
	 * 
	 * @return agentset of the caller's interactionTTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet<cyberfit.relogo.InteractionTT> myInteractionTTs(){
		AgentSet<cyberfit.relogo.InteractionTT> result = new AgentSet<cyberfit.relogo.InteractionTT>();
		for(Object o : this.getMyObserver().getNetwork("InteractionTT").getEdges(this)){
			if (o instanceof cyberfit.relogo.InteractionTT){
				result.add((cyberfit.relogo.InteractionTT)o);
			}
		}
		return result;
	}

	/**
	 * Queries if object is a interactionTT.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a interactionTT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public boolean isInteractionTTQ(Object o){
		return (o instanceof cyberfit.relogo.InteractionTT);
	}

	/**
	 * Returns an agentset containing all interactionTTs.
	 * 
	 * @return agentset of all interactionTTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet<cyberfit.relogo.InteractionTT> interactionTTs(){
		AgentSet<cyberfit.relogo.InteractionTT> a = new AgentSet<cyberfit.relogo.InteractionTT>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.InteractionTT.class)) {
			if (e instanceof cyberfit.relogo.InteractionTT){
				a.add((cyberfit.relogo.InteractionTT)e);
			}
		}
		return a;
	}

	/**
	 * Returns the interactionTT between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return interactionTT between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public cyberfit.relogo.InteractionTT interactionTT(Number oneEnd, Number otherEnd) {
		return (cyberfit.relogo.InteractionTT)(this.getMyObserver().getNetwork("InteractionTT").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the interactionTT between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return interactionTT between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public cyberfit.relogo.InteractionTT interactionTT(Turtle oneEnd, Turtle otherEnd) {
		return interactionTT(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Makes a directed userLink from a turtle to the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public cyberfit.relogo.UserLink createUserLinkFrom(Turtle t, Closure closure){
		cyberfit.relogo.UserLink link = (cyberfit.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public cyberfit.relogo.UserLink createUserLinkFrom(Turtle t){
			return createUserLinkFrom(t,null);
	}

	/**
	 * Makes directed userLinks from a collection to the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet<cyberfit.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<cyberfit.relogo.UserLink> links = new AgentSet<cyberfit.relogo.UserLink>();
		for(Turtle t : a){
			links.add((cyberfit.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet<cyberfit.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a){
		return createUserLinksFrom(a,null);
	}

	/**
	 * Makes a directed userLink to a turtle from the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public cyberfit.relogo.UserLink createUserLinkTo(Turtle t, Closure closure){
		cyberfit.relogo.UserLink link = (cyberfit.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public cyberfit.relogo.UserLink createUserLinkTo(Turtle t){
			return createUserLinkTo(t,null);
	}

	/**
	 * Makes directed userLinks to a collection from the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet<cyberfit.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<cyberfit.relogo.UserLink> links = new AgentSet<cyberfit.relogo.UserLink>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((cyberfit.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet<cyberfit.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a){
		return createUserLinksTo(a,null);
	}

	/**
	 * Queries if there is a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public boolean inUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed userLinks to the caller.
	 * 
	 * @return agentset with directed userLinks to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet inUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public cyberfit.relogo.UserLink inUserLinkFrom(Turtle t){
		return (cyberfit.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed userLinks from other turtles to the caller.
	 * 
	 * @return agentset of directed userLinks from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet<cyberfit.relogo.UserLink> myInUserLinks(){
		AgentSet<cyberfit.relogo.UserLink> result = new AgentSet<cyberfit.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getInEdges(this)){
			if (o instanceof cyberfit.relogo.UserLink){
				result.add((cyberfit.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed userLinks to other turtles from the caller.
	 * 
	 * @return agentset of directed userLinks to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet<cyberfit.relogo.UserLink> myOutUserLinks(){
		AgentSet<cyberfit.relogo.UserLink> result = new AgentSet<cyberfit.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getOutEdges(this)){
			if (o instanceof cyberfit.relogo.UserLink){
				result.add((cyberfit.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public boolean outUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed userLinks from the caller.
	 * 
	 * @return agentset with directed userLinks from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet outUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public cyberfit.relogo.UserLink outUserLinkTo(Turtle t){
		return (cyberfit.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(this, t);
	}

	/**
	 * Reports true if there is a userLink connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public boolean userLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * userLinks connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet userLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's userLinks.
	 * 
	 * @return agentset of the caller's userLinks
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet<cyberfit.relogo.UserLink> myUserLinks(){
		AgentSet<cyberfit.relogo.UserLink> result = new AgentSet<cyberfit.relogo.UserLink>();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getEdges(this)){
			if (o instanceof cyberfit.relogo.UserLink){
				result.add((cyberfit.relogo.UserLink)o);
			}
		}
		return result;
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof cyberfit.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet<cyberfit.relogo.UserLink> userLinks(){
		AgentSet<cyberfit.relogo.UserLink> a = new AgentSet<cyberfit.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.UserLink.class)) {
			if (e instanceof cyberfit.relogo.UserLink){
				a.add((cyberfit.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public cyberfit.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (cyberfit.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public cyberfit.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}


}