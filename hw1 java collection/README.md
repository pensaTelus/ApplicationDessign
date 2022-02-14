# Application Design
## Homework 1, JAVA Collections


We call java collections are all the collections, classes and interface in it. The Collection interface (java.util.Collection) and Map interface (java.util.Map) are the two main “root” interfaces of Java collection classes.


### Index 
* [Collection interface](#Collection-interface)
  * [HashSet](#HashSet)
  * [LinkedHashSet](#LinkedHashSet)
  * [TreeSet](#TreeSet)
  * [ArrayList](#ArrayList)
  * [Vector](#Vector)
  * [LinkedList](#LinkedList)
  * [PriorityQueue](#PriorityQueue)
* [Map interface](#Map-interface)
  * [HashTable](#HashTable)
  * [HashMap](#HashMap)
  * [LinkedHashMap](#LinkedHashMap)
  * [TreeMap](#TreeMap)



#### Some advantages of java collections 
1. You have a consistent api 
2. Reduce the program effort 
3. Increase the program speed and quality 


## About this project 
This project was made in java only using javac to compile the proyect with `javac *.java` and then you can run the project with java App
Then the project display you a menu and you can choose about the collection you want to learn. 

![image](https://user-images.githubusercontent.com/98837103/153910410-d24e4555-d931-4dcc-88fa-a47795cadb9c.png)
tipe one number and thats it. 


We use a java class as auxiliary  name Animal, this class implement Comparable interface to can be sort by some methods. 

### Elmenents and constructor 

```r
    public int id;
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public Animal(int id, String Name) {
        this.id = id;
        this.name = Name;
    }
```

To use some methods like indexOf you have to use the same object you insert or you can override the hashCode method, and you have to override the equals method also 

toString method help us to print in an easier way the collection. 
and compareTo helps to sort the objects. 

```r
   @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            Animal pp = (Animal) obj;
            return (pp.getId() == this.id
            // && pp.getName().equals(this.name)
            );
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "{ id:" + id + " , name: \"" + name + "\" }";
    }

    @Override
    public int compareTo(Object o) {
        int compareage = ((Animal) o).getId();
        return this.id - compareage;
    }
```


And also we create a method name print because is easier to type print than System.out.println 
I mention this because i use print a lot

### Collection interface 
![image](https://user-images.githubusercontent.com/98837103/153906983-516558f0-87e5-4f4f-bfb0-73b258a4896b.png)

#### HashSet
HashSet is commonly used if you want to access elements randomly or store a list of items which cannot contain duplicate values.

```r
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
```
output of the console: 

![image](https://user-images.githubusercontent.com/98837103/153916853-d49537cb-0130-40b0-aac5-89e4a628a2de.png)

#### LinkedHashSet
The LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked List across all elements. When the iteration order is needed to be maintained this class is used.

```r
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
```
console output: 

![image](https://user-images.githubusercontent.com/98837103/153917185-1eae0d69-3374-463c-868f-23298a1970f2.png)


#### ArrayList 	   
ArrayList in Java is used to store dynamically sized collection of elements. Contrary to Arrays that are fixed in size, an ArrayList grows its size automatically when new elements are added to it.

With arraylist you can have more than one time the same element

```r 
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
```

Console output: 

![image](https://user-images.githubusercontent.com/98837103/153918620-cd607cbc-28e5-4e32-ac61-abca63517be6.png)


#### Vector        
The Vector class implements a growable array of objects. Vectors fall in legacy classes, but now it is fully compatible with collections. It is found in java.util package and implement the List interface, so we can use all the methods of List interface as shown below as follows:

![image](https://user-images.githubusercontent.com/98837103/153920644-3861330f-23a5-40f2-ad5b-bd207d04447e.png)


```r 
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
```

Console output: 
![image](https://user-images.githubusercontent.com/98837103/153919068-5fdd8aa3-c8db-460a-a581-00e3ca77a050.png)

### Diference between arraylist and vector 
![image](https://user-images.githubusercontent.com/98837103/153920775-583eaf0a-873d-4a69-b323-9f48a6f036a0.png)

Vector is synchronized, which means only one thread at a time can access the code, while ArrayList is not synchronized, which means multiple threads can work on ArrayList at the same time.

![image](https://user-images.githubusercontent.com/98837103/153921075-2a5d5d0f-2560-4a9e-ad44-53ec2fb2f0f0.png)


#### LinkedList    
Linked List is a part of the Collection framework present in java.util package. This class is an implementation of the LinkedList data structure which is a linear data structure where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part.



```r  
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
```  

Console output:

![image](https://user-images.githubusercontent.com/98837103/153921559-793479b6-efa7-4fb3-a32d-81fe40ce76b1.png)


### ArrayList vs linkedlist 
![image](https://user-images.githubusercontent.com/98837103/153922562-13fab755-23d2-4215-8f98-0618dab3a195.png)


#### PriorityQueue 
A PriorityQueue is used when the objects are supposed to be processed based on the priority. It is known that a Queue follows the First-In-First-Out algorithm, but sometimes the elements of the queue are needed to be processed according to the priority, that’s when the PriorityQueue comes into play.

```r  
print("-------------------------------------------");
print("-----------priority queve example----------");
print("-------------------------------------------");

print("First you have to declare the priority queve");
PriorityQueue<Animal> pq = new PriorityQueue<>();
print("PriorityQueue<Animal> pq = new PriorityQueue<>();");

print("you can add elements in two ways");

print("pq.add(new Animal(1, \"Cat\")");
pq.add(new Animal(1, "Cat"));
pq.add(new Animal(2, "Dog"));
pq.add(new Animal(3, "Duck"));
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
```  

Console output:

![image](https://user-images.githubusercontent.com/98837103/153922762-868e8253-f84e-4483-afca-13810d873ece.png)




### Map interface 
![image](https://user-images.githubusercontent.com/98837103/153907609-088d58cd-eb19-4126-aacf-25ece113320b.png)

#### HashTable 	  
The Hashtable class implements a hash table, which maps keys to values. Any non-null object can be used as a key or as a value. To successfully store and retrieve objects from a hashtable, the objects used as keys must implement the hashCode method and the equals method.  

```r 
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
```   

Console output: 

![image](https://user-images.githubusercontent.com/98837103/153924798-d5d6147b-5675-4050-bbbb-5bec5dd73ad1.png)


#### HashMap 	   
 It provides the basic implementation of the Map interface of Java. It stores the data in (Key, Value) pairs, and you can access them by an index of another type (e.g. an Integer). One object is used as a key (index) to another object (value). If you try to insert the duplicate key, it will replace the element of the corresponding key.

HashMap is similar to HashTable, but it is unsynchronized. It allows to store the null keys as well, but there should be only one null key object and there can be any number of null values.  This class makes no guarantees as to the order of the map. To use this class and its methods, you need to import java.util.HashMap package or its superclass.

```r 
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
```   

Console output:

![image](https://user-images.githubusercontent.com/98837103/153924697-677aa947-5b7e-46a1-a7a6-7e200e2846be.png)

#### LinkedHashMap 	 
```r 
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
```   

Console output:

![image](https://user-images.githubusercontent.com/98837103/153925794-1176fef2-cfe1-49c3-affa-232328aee11b.png)


#### TreeMap  	 

```r 
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
```   

Console output:

![image](https://user-images.githubusercontent.com/98837103/153924959-edb8f309-c1f3-44e6-b81a-8242658a7ec9.png)

## Table of basic details of commonly used collection classes.

![image](https://user-images.githubusercontent.com/98837103/153906759-5a7049b3-56bf-41a0-84f3-05b0fff7b8b4.png)
