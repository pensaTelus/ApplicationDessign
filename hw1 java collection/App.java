
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import java.util.LinkedList;
import java.util.HashMap;

import java.util.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			boolean parar = false;
			while (!parar) {
				print("Choose a class of the collection interface.");
				print("1 array List Example");
				print("2 linked List Example");
				print("3 hash Set Example");
				print("4 tree Set Example");
				print("5 hash Map Example");
				print("6 tree Map Example");
				print("7 vector Example");
				print("8 hash Table Example");
				print("9 priority Queue Example");
				print("10 linked Hash Set Example");
				print("11 linked Hash map Example");
				print("Other = exit");

				String option = br.readLine();

				switch (option) {
					case "1":
						arrayListExample();
						break;
					case "2":
						linkedListExample();
						break;
					case "3":
						hashSetExample();
						break;
					case "4":
						treeSetExample();
						break;
					case "5":
						hashMapExample();
						break;
					case "6":
						treeMapExample();
						break;
					case "7":
						vectorExample();
						break;
					case "8":
						hashTableExample();
						break;
					case "9":
						priorityQueueExample();
						break;
					case "10":
						linkedHashSetExample();
						break;
					case "11":
						linkedHashMapExample();
						break;
					default:
						parar = true;
						break;
				}

				if (!parar) {
					System.out.println("Press Enter key to continue...");
					br.readLine();

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("da error");
		}

	}

	public static void linkedHashSetExample() {
		print("-------------------------------------------");
		print("----------linked hash set example----------");
		print("-------------------------------------------");

		print("You can declare a LinkedHashSet with the following code.");
		LinkedHashSet<Animal> lhs = new LinkedHashSet<>();
		print("LinkedHashSet<Animal> lhs = new LinkedHashSet<>();");

		print("you can add elements to an linkedHashSet with add and addAll here is some examples");
		print("lhs.add(new Animal(1, \"Cat\"));");

		lhs.add(new Animal(1, "Cat"));
		lhs.add(new Animal(2, "Dog"));
		lhs.add(new Animal(3, "Duck"));
		print("lhs.addAll(Arrays.asList(new Animal[] { new Animal(5, \"Turtle\"), new Animal(6, \"Tiger\") }));");
		lhs.addAll(Arrays.asList(new Animal[] { new Animal(5, "Turtle"), new Animal(6, "Tiger") }));

		print("The hashset looks like: " + lhs);

		print("You can remove with remove");
		lhs.remove(new Animal(2, "Dog"));

		print("linkedhashset after remove the dog animal " + lhs);
		print("You also have methods like print or isEmpty");
		print("Show if you have a duck " + lhs.contains(new Animal(3, "Duck")));
		print("Show if you have a dog " + lhs.contains(new Animal(2, "Dog")));

		print("updating");
		print("To update you have to iterate, find the object and change it. if your hash is non object like a hash of integers or strings you have to remove and add again other item");
		print("opcinal you can use the contains method to ensure the list have that object. and then use the iterator to find it.");
		Animal myDuc = new Animal(3, "Duck");
		if (lhs.contains(myDuc)) {
			Iterator iterator = lhs.iterator();

			while (iterator.hasNext()) {
				Animal toFind = (Animal) iterator.next();
				// System.out.print(iterator.next() + " ");
				if (toFind.equals(myDuc)) {
					toFind.name = "Dragon";
					break;
				}
			}
		}

		print(lhs);
		print("as you can see the second element change to dragon");
	}

	public static void priorityQueueExample() {

		print("-------------------------------------------");
		print("-----------priority queve example----------");
		print("-------------------------------------------");

		print("First you have to declare the priority queve");
		PriorityQueue<Animal> pq = new PriorityQueue<>();
		print("PriorityQueue<Animal> pq = new PriorityQueue<>();");

		print("you can add elements in two ways");

		print("pq.add(new Animal(1, \"Cat\")");
		pq.add(new Animal(3, "Duck"));
		pq.add(new Animal(1, "Cat"));
		pq.add(new Animal(2, "Dog"));
		print("pq.addAll(Arrays.asList(new Animal[] { new Animal(5, \"Turtle\"), new Animal(6, \"Tiger\") }));");
		pq.addAll(Arrays.asList(new Animal[] { new Animal(5, "Turtle"), new Animal(6, "Tiger") }));

		print("Here is as the priority queue looks like" + pq);

		print("removing");

		print("pq.remove(new Animal(3, \"Duck\"));");
		pq.remove(new Animal(3, "Duck"));

		print("queue after remove " + pq);
		print(pq.peek()); // get the last element
		print(pq);
		print(pq.poll()); // get and remove the last element;

		print("you have the peek and poll method, peek obtain the last element and poll get and remove the last element");
		print(pq);

		print(pq.isEmpty());

		print("updating");
		print("To update you have to iterate or if you want to change the last object you can use peek and change it");
		Animal myDuc = new Animal(6, "Duck");
		if (pq.contains(myDuc)) {
			Iterator iterator = pq.iterator();

			while (iterator.hasNext()) {
				Animal toFind = (Animal) iterator.next();
				// System.out.print(iterator.next() + " ");
				if (toFind.equals(myDuc)) {
					toFind.name = "Dragon";
					break;
				}
			}
		}

		print("list after update " + pq);
	}

	public static void hashTableExample() {

		print("-------------------------------------------");
		print("--------------Hash table example---------------");
		print("-------------------------------------------");

		print("First you have to declare your hash table");

		Hashtable<Integer, Animal> hT = new Hashtable<>();
		print("Hashtable<Integer, Animal> hT = new Hashtable<>();");

		print("To add element you use the puth method");

		print("hT.put(1, new Animal(1, \"Cat\"));");
		hT.put(1, new Animal(1, "Cat"));
		hT.put(2, new Animal(2, "Duck"));

		print("hash after add two elements " + hT);

		print("to get and remove elements you have to find then by the key");
		print("Animal nm = hT.get(2); // get a duck");
		Animal nm = hT.get(2); // get a duck

		print("and then you can update that object");
		print("nm.setName(\"Dragon\");");
		nm.setName("Dragon");
		print(hT);

		print("to remove you have to use the key");
		print("hT.remove(2); // remove the dragon (before it was the duck); ");
		hT.remove(2); // remove the duck;

		print(hT);

		hT.put(3, new Animal(3, "Dog"));
		hT.put(4, new Animal(4, "Duck"));

		print("to iterate a hash table you can iterate the keys and then use the get method.");
		// Iterator
		for (int i : hT.keySet()) {
			System.out.println("key: " + i + " value: " + hT.get(i));
		}

		hT.clear();
		print(hT.isEmpty());
	}

	public static void vectorExample() {

		print("-------------------------------------------");
		print("--------------Vector example---------------");
		print("-------------------------------------------");

		print("First you have to declarate the object");
		Vector<Animal> vc = new Vector<>();
		print("you can add elements using add or addall and you can also use addElement ho is an method only for vector but work as add");
		print("vc.add(new Animal(1, \"Cat\"));");
		vc.add(new Animal(1, "Cat"));
		vc.add(new Animal(2, "Dog"));
		vc.add(new Animal(3, "Duck"));
		vc.addElement(new Animal(4, "Pig"));
		print("vc.addAll(Arrays.asList(new Animal[] { new Animal(5, \"Turtle\"), new Animal(6, \"Tiger\") }));");
		vc.addAll(Arrays.asList(new Animal[] { new Animal(5, "Turtle"), new Animal(6, "Tiger") }));

		print("Removing   \nYou can remove using an integer to use the index or an object to remove that especific object.");
		print("vc.remove(1);");
		vc.remove(1);
		// vc.remove(new Animal(3, "Duck"));

		print(vc);

		print("Updating, you can iterate as the other cases or you can use index of and then elementAt and change the object or use set to replace one object");
		int nCat = vc.indexOf(new Animal(1, "Cat"));
		print("Animal cat = vc.elementAt(0);");
		Animal cat = vc.elementAt(0);
		print(cat);

		print("cat.setName(\"Dragon\");");
		cat.setName("Dragon");

		print(vc);

		print("You also have methods as isEmpty or size ");
		print(vc.isEmpty());

	}

	public static void treeMapExample() {

		print("-------------------------------------------");
		print("------------Tree map example---------------");
		print("-------------------------------------------");

		print("First you have to declare the map");
		print("TreeMap<Integer, Animal> tm = new TreeMap<>();");
		TreeMap<Integer, Animal> tm = new TreeMap<>();

		print("To insert use the put method, you have a key and the object");
		tm.put(1, new Animal(1, "Cat"));
		tm.put(2, new Animal(2, "Duck"));

		print(tm);

		print("To update you have to use get and then change it, with get you use find by the key");
		Animal nm = tm.get(2); // get a duck
		nm.setName("dragon");

		print(tm);
		tm.remove(2); // remove the duck;

		print(tm);

		tm.put(3, new Animal(3, "Dog"));
		tm.put(4, new Animal(4, "Duck"));

		// Iterator
		print("To iterate you should iterate by the key value and use that to get the value of the objects storage in the tree map");
		for (int i : tm.keySet()) {
			System.out.println("key: " + i + " value: " + tm.get(i));
		}

		tm.clear();
		print(tm.isEmpty());
	}

	public static void hashMapExample() {
		print("-------------------------------------------");
		print("------------Hash map example---------------");
		print("-------------------------------------------");

		print("First you have to declare the map");
		print("HashMap<Integer, Animal> hm = new HashMap<>();");

		HashMap<Integer, Animal> hm = new HashMap<>();

		print("To insert use the put method, you have a key and the object");

		hm.put(1, new Animal(1, "Cat"));
		hm.put(2, new Animal(2, "Duck"));

		print(hm);

		print("To update you have to use get and then change it, with get you use find by the key");
		print("Animal duck = hm.get(2); // get the duck");
		Animal duck = hm.get(2); // get a duck

		print("duck.setName(\"dragon\");");
		duck.setName("dragon");
		print("hash map after update" + hm);
		print("To remove use the key as well");
		hm.remove(2); // remove the duck;

		print("after removing " + hm);

		hm.put(3, new Animal(3, "Dog"));

		hm.put(4, new Animal(4, "Duck"));

		// Iterator
		print("To iterate you should iterate by the key value and use that to get the value of the objects storage in the hash map");

		for (int i : hm.keySet()) {
			System.out.println("key: " + i + " value: " + hm.get(i));
		}

		hm.clear();
		print(hm.isEmpty());

	}

	public static void linkedHashMapExample() {
		print("-------------------------------------------");
		print("--------linked Hash map example------------");
		print("-------------------------------------------");

		print("First you have to declare the map");
		print("LinkedHashMap<Integer, Animal> lhm = new LinkedHashMap<>();");

		LinkedHashMap<Integer, Animal> lhm = new LinkedHashMap<>();

		print("To insert use the put method, you have a key and the object");

		lhm.put(1, new Animal(1, "Cat"));
		lhm.put(2, new Animal(2, "Duck"));

		print(lhm);

		print("To update you have to use get and then change it, with get you use find by the key");
		print("Animal duck = lhm.get(2); // get the duck");
		Animal duck = lhm.get(2); // get a duck

		print("duck.setName(\"dragon\");");
		duck.setName("dragon");
		print("hash map after update" + lhm);
		print("To remove use the key as well");
		lhm.remove(2); // remove the duck;

		print("after removing " + lhm);

		lhm.put(3, new Animal(3, "Dog"));

		lhm.put(4, new Animal(4, "Duck"));

		// Iterator
		print("To iterate you should iterate by the key value and use that to get the value of the objects storage in the hash map");

		for (int i : lhm.keySet()) {
			System.out.println("key: " + i + " value: " + lhm.get(i));
		}

		lhm.clear();
		print(lhm.isEmpty());

	}

	public static void treeSetExample() {
		print("-------------------------------------------");
		print("-----------Tree set example--------------");
		print("-------------------------------------------");

		print("Fist you have to declare the tree set");

		print("TreeSet<Animal> ts = new TreeSet<>();");
		TreeSet<Animal> ts = new TreeSet<>();

		print("you can add elements with add or multiple elements with add all");
		print("ts.add(new Animal(1, \"Cat\"));");
		ts.add(new Animal(1, "Cat"));
		ts.add(new Animal(2, "Dog"));

		print("ts.addAll(Arrays.asList(new Animal[] { new Animal(3, \"Pig\"), new Animal(4, \"Tiger\") }));");
		ts.addAll(Arrays.asList(new Animal[] { new Animal(3, "Pig"), new Animal(4, "Tiger") }));

		print("Tree set after insert 4 elements " + ts);

		print("you can remove with the remove method");
		print("ts.remove(new Animal(2, \"Dog\"));");
		ts.remove(new Animal(2, "Dog"));

		print("Tree set before remove the dog " + ts);
		print("you can also use remove all to remove multiple elements");
		ts.removeAll(Arrays.asList(new Animal[] { new Animal(3, "Pig"), new Animal(4, "Tiger") }));
		print(ts);

		ts.isEmpty();
		ts.addAll(Arrays.asList(new Animal[] { new Animal(3, "Pig"), new Animal(4, "Tiger") }));

		print("tree set before updating " + ts);
		print("updating");
		print("To update you have to iterate, find the object and change it. if your hash is non object like a hash of integers or strings you have to remove and add again other item");
		print("opcinal you can use the contains method to ensure the list have that object. and then use the iterator to find it.");
		Animal myDuc = new Animal(3, "Pig");
		if (ts.contains(myDuc)) {
			Iterator iterator = ts.iterator();

			while (iterator.hasNext()) {
				Animal toFind = (Animal) iterator.next();
				// System.out.print(iterator.next() + " ");
				if (toFind.equals(myDuc)) {
					toFind.name = "Dragon";
					break;
				}
			}
		}

		print("tree set after updating " + ts);

		print("you also have method as pollFirst to remove the first element");
		print("and pollLast to remove the last element");
		ts.pollFirst(); // remove the first element
		ts.pollLast(); // remove the last element

		print(ts);
	}

	public static void linkedListExample() {
		print("-------------------------------------------");
		print("-----------linked list example--------------");
		print("-------------------------------------------");

		print("first you have to declare the linked list");
		print("LinkedList<Animal> linkList = new LinkedList<>();");
		LinkedList<Animal> linkList = new LinkedList<>();

		print("To add you have methods as add, addFirst and addLast and also addAll");
		print("linkList.add(new Animal(1,   \"Cat\"));");
		print("linkList.addFirst(new Animal(3,   \"Dog\"));");
		print("linkList.addLast(new Animal(2,   \"Cat\"));");
		linkList.add(new Animal(1, "Cat"));
		linkList.add(new Animal(2, "Dog"));

		linkList.addLast(new Animal(3, "Ant"));
		linkList.addFirst(new Animal(4, "Chicken"));

		print("you can remove by the index value or using the object");

		print("linkList.remove(1); // Is going to remove the cat");
		linkList.remove(1); // Is going to remove the cat
		linkList.remove(new Animal(2, "Dog")); // Is going to remove the dog :D

		print("you can also sort a linked list but only if your class implement Comparable class and override the compareTo method");
		print("linked list before sort " + linkList);

		print("linkList.sort(null);");
		linkList.sort(null); // To make an array sortable we have to impement Comparable and override the
								// compareTo Method.
		print("linkList after sort " + linkList);

		print("and you can clear the list with linkList.clear(); and ask if the list is clear with isEmpty()");
		linkList.clear();
		print("is the   list  clear " + linkList.isEmpty());

	}

	public static void arrayListExample() {

		print("-------------------------------------------");
		print("-----------Array list example--------------");
		print("-------------------------------------------");

		print("First you have to declare a variable");
		print("ArrayList<Animal> arr = new ArrayList<>();");
		ArrayList<Animal> arr = new ArrayList<>();

		print("You can add elements with add or addall");
		print("arr.add(new Animal(1, \"Cat\")); ");
		arr.add(new Animal(1, "Cat"));
		arr.add(new Animal(2, "Dog"));
		arr.add(new Animal(2, "Dog"));
		System.out.println("You can use arr.size to get the size value " + arr.size()); // ArrayList doesn't matter if
																						// you insert twice the same
																						// object.

		print("The array looks like: " + arr);
		print("You can also add an element in a specific position ");
		print("arr.add(2, new Animal(3, \"pig\")); // It is going to be inserted between the Dogs");
		arr.add(2, new Animal(3, "pig")); // It is going to be inserted between the Dogs
		print(arr);
		Iterator<Animal> iterator = arr.iterator();
		int i = 0;
		print("You can use an iterator to get all the elements one by one");
		while (iterator.hasNext()) {
			Animal an = iterator.next();
			System.out.println("Animal " + (++i) + " " + an.toString() + " hascode: " + an.hashCode());
		}

		print("you can remove an element by the position or sending the object");
		print("arr.remove(3); // It's going to remove the second Dog");
		arr.remove(3); // It's going to remove the second Dog
		print(arr);
		arr.remove(new Animal(1, "Cat")); // Search the object (this works because we change the hashCode and the equals
											// methods) in other way we can iterate the array and search one by one
		Animal myPig = new Animal(3, "pig");

		if (arr.contains(myPig)) {
			print("to update an object you can use contains first to ensure the array contains the elment");
			print("then you can use indexof to get the postion and get to obtain the element. ");

			print("Animal getPig = arr.get(arr.indexOf(new Animal(3, \"pit\")));");
			Animal getPig = arr.get(arr.indexOf(myPig));
			print("now you can update the animal with: getPig.setName(\"The pig\");");
			getPig.setName("The pig");
			myPig.setName("new pig"); // the object in the array is going to take the value of The pig.
		}

		arr.add(new Animal(1, "Fish"));

		print(arr);
		arr.sort(null); // To make an array sortable we have to impement Comparable and override the
						// compareTo Method.
		print(arr);
	}

	public static void hashSetExample() {

		print("-------------------------------------------");
		print("-----------Hash Set example----------------");
		print("-------------------------------------------");

		print("First you have to declare a hash set");

		print("Set<Animal> animalsSet = new HashSet<>();");
		HashSet<Animal> animalsSet = new HashSet<>();
		// add example
		print("you can insert elements with the add and addAll methods");
		print("animalsSet.add(new Animal(1, \"Cat\"));");
		animalsSet.add(new Animal(1, "Cat"));
		animalsSet.add(new Animal(2, "Dog"));
		System.out.println(animalsSet.size());
		animalsSet.add(new Animal(2, "Dog")); // We cant insert twice the same object (thats because we change the
												// hashCode() method in the class Animal both object have the same hash
												// code so they can't insert the second one)
		print("because is a hash you can't insert the same object twice.");
		Animal myCat = new Animal(1, "Cat");
		// Iterator example
		Iterator<Animal> iterator = animalsSet.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Animal an = iterator.next();
			System.out.println("Animal " + (++i) + " " + an.toString() + " hascode: " + an.hashCode());
		}
		System.out.println(animalsSet);
		// contains example
		System.out.println("animalsSet contains Cat = " + animalsSet.contains(myCat));
		// remove example
		System.out.println("Cat  removed from animalsSet set = " + animalsSet.remove(myCat));
		// Update example
		Animal myDog = new Animal(2, "Dog");
		if (animalsSet.contains(myDog)) {
			animalsSet.remove(myDog);
			myDog.setName("Leon");
			animalsSet.add(myDog);
		}
		System.out.println(animalsSet);
		// size example
		System.out.println("animalsSet set size = " + animalsSet.size());
		// Adding multiple elements
		animalsSet.addAll(Arrays.asList(new Animal[] { new Animal(3, "Pig"), new Animal(4, "Tiger") }));
		System.out.println(animalsSet);
		animalsSet.clear();
		System.out.println("animalsSet set is empty = " + animalsSet.isEmpty());
	}

	public static void print(Object st) {
		System.out.println(st);
	}

}
