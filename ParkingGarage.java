/**
 * 
 */
package pg;
import java.util.*;
/**
 * @author Jason Miller
 *
 */
public class ParkingGarage {
	final public int capacity = 20;					//garage capacity
	final public int maxWeight = 25000;				//max weight of all cars in garage
	private Vector<Vehicle> garageOfCars = new Vector<Vehicle>();		//all the cars in the garage
	private int currentWeight = 0;					//current weight of cars in garage
	private int numCarsInGarage = 0;				//number of cars in garage
	
	ParkingGarage()
	{
	}
	public boolean parkCar(Vehicle car)
	{
		if(refuseCar(car)) return false;  //can't add the car
		else
		{
			currentWeight += car.getWeightInPounds();
			numCarsInGarage++;
			garageOfCars.addElement(car);
			return true;
		}
	}

	public boolean exitCar(Vehicle car)
	{
		if(carExists(car)) 
		{
			garageOfCars.removeElement(car);
			numCarsInGarage--;
			currentWeight -= car.getWeightInPounds();
			return true;
		}
		else return false;
	}
	public int getNumCarsInGarage()
	{
		return(numCarsInGarage);	
	}	
	public int getWeight()
	{
		return(currentWeight);
	}
		
	private boolean refuseCar(Vehicle car)
	{
		if(isOverWeight(car) || isFull()) return true;
		else return false;
	}

	private boolean isOverWeight(Vehicle car)
	{
		if((car.getWeightInPounds()+currentWeight)>maxWeight) return true;
		else return false;
	}
	private boolean carExists(Vehicle car)
	{
		if(garageOfCars.contains(car)) return true;
		else return false;
	}
	private boolean isFull()
	{
		if((numCarsInGarage+1)>capacity) return true;
		else return false;
	}
}

interface Domestic {}
interface Import {}

interface Japanese   extends Import {}
interface German     extends Import {}
interface Detroit    extends Domestic {}
interface SpringHill extends Domestic {}

interface Vehicle {	           int getWeightInPounds(); }
interface Automobile           extends Vehicle  {}
interface LargeAutomobile      extends Vehicle {}
interface Sedan                extends Automobile{}
interface Van                  extends LargeAutomobile {}
interface Truck                extends LargeAutomobile {}
interface Compact              extends Automobile {}
interface SportsUtilityVehicle extends Truck, Van {}

abstract class AutomobileWeight implements Vehicle
{
	public int getWeightInPounds() { return 1000; }
}

abstract class LargeAutomobileWeight implements Vehicle
{
	public int getWeightInPounds() { return 2500; }
}

class SaturnSL1      extends AutomobileWeight      implements SpringHill, Sedan {}
class HondaCivic     extends AutomobileWeight      implements Japanese, Compact {}
class MercedesC230   extends AutomobileWeight      implements German, Sedan {}
class ChevyS10       extends LargeAutomobileWeight implements Detroit, Truck {}
class SubaruOutback  extends LargeAutomobileWeight implements Japanese, SportsUtilityVehicle {}


